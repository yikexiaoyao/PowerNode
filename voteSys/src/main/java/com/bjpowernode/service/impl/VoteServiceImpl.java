package com.bjpowernode.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.bjpowernode.bean.Article;
import com.bjpowernode.bean.User;
import com.bjpowernode.service.VoteService;
import com.bjpowernode.util.RedisUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author cty
 * @date 2021/11/27 19:30
 */
@Service
public class VoteServiceImpl implements VoteService {

    Jedis jedis = RedisUtil.getJedis();

    //发布文章
    @Override
    public void push(Article article, User user) {
        long time = System.currentTimeMillis();
        String pubTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //发布时间
        article.setPubTime(pubTime);
        //发布者
        article.setUid(user.getUid());
        //设置投票数为0
        article.setVotes("0");
        //选址Redis 14数据库
        jedis.select(14);
        Long index = jedis.incr("articleIndex");
        article.setAid(index + "");
        String keyPattern = "article:" + index;
        //保存文章
        RedisUtil.dbToRedis(jedis, 14, keyPattern, article);
        //用户发布文章
        jedis.hincrBy(keyPattern, "vote", 0);
        /*//用户发布文章，默认给自己的文章投一票
        jedis.hincrBy(keyPattern, "vote", 1);*/
        //文章票数排序，把当前发布的文章放入排行榜
        jedis.zadd("votes:info", Long.parseLong(jedis.hget(keyPattern, "votes")), keyPattern);
        //按发布时间排序，发布时间排序排行榜
        jedis.zadd("pub:time", time, keyPattern);
        //统计投票者，防止重复投票
        jedis.sadd("voted:" + keyPattern, "user:" + user.getUid());
    }

    //查询列表
    @Override
    public List<Article> list(String type,int pageSize, int page, String ascOrDesc) {
        //选中Redis 14数据库
        jedis.select(14);
        //创建集合
        List<Article> articles = new ArrayList<>();
        Set<String> members = null;
        //第几条数据 ~ 第几条数据
        int start = pageSize * (page - 1);
        int end = start + pageSize - 1;
        //按票数排序
        if ("votes".equals(type)) {
            //升序
            if ("asc".equals(ascOrDesc)) {
                //获取所有成员
                members = jedis.zrange("votes:info", start, end);
            } else {
                members = jedis.zrevrange("votes:info", start, end);
            }
        } else {    //按发布时间排序
            //升序
            if ("asc".equals(ascOrDesc)) {
                //获取所有成员
                members = jedis.zrange("pub:time", start, end);
            } else {
                members = jedis.zrevrange("pub:time", start, end);
            }
        }

        for (String member : members) {
            Map<String, String> map = jedis.hgetAll(member);

            Article article = BeanUtil.mapToBean(map, Article.class, false, new CopyOptions().ignoreNullValue());
            //取出用户主键
            String uid = article.getUid();
            //根据用户主键查询用户
            User user = queryUserByUid(uid);
            article.setUid(user.getUsername());
            //将查询到的文章放入集合
            articles.add(article);
        }

        return articles;
    }

    private User queryUserByUid(String uid) {
        //选中Redis 14数据库
        jedis.select(14);

        Set<String> keys = jedis.keys("user:*");

        for (String key : keys) {
            Map<String, String> map = jedis.hgetAll(key);
            User user = BeanUtil.mapToBean(map, User.class, false, new CopyOptions().ignoreNullValue());
            if (user.getUid().equals(uid)) {
                return user;
            }
        }
        return null;
    }

    //总记录数
    @Override
    public int count() {
        return jedis.keys("article:*").size();
    }

    //异步点赞
    @Override
    public boolean vote(String id, User user) {
        //选中Redis 14数据库
        jedis.select(14);
        //文章发布超过7天不能投票
        long now = System.currentTimeMillis();

        //查询文章信息
        String key = "article:" + id;
        Map<String, String> map = jedis.hgetAll(key);
        Article article = BeanUtil.mapToBean(map, Article.class, false, new CopyOptions().ignoreNullValue());
        long pubTime = 0;
        try {
            //getTime:举例1970时间毫秒值
            pubTime = new SimpleDateFormat("yyyy-MM-dd").parse(article.getPubTime()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if ((now - pubTime) > 7 * 24 * 3600 * 1000) {
            return false;
        }
        String keyPattern = "voted:" + key;
        //重复投票
        /**
         * 如果=0，不投票
         * 如果!=0,表达式肯定会被执行
         */
        /*if(jedis.sadd(keyPattern,"user:" + user.getUid()) == 0){
            return false;
        }*/

        //开始投票
        //对应文章的投票数+1
        jedis.hincrBy(key, "votes", 1);

        //票数的排行榜票数更新
        jedis.zincrby("votes:info", 1, key);
        return true;
    }

    @Override
    public List<Article> search(String keyword) {
        //选中Redis 14数据库
        jedis.select(14);
        Set<String> keys = jedis.keys("article:*");
        //创建集合
        ArrayList<Article> articles = new ArrayList<>();
        for (String key : keys) {
            Map<String, String> map = jedis.hgetAll(key);
            Article article = BeanUtil.mapToBean(map, Article.class, false, new CopyOptions().ignoreNullValue());
            //判断title是否包含keyword
            if (article.getTitle().contains(keyword)) {
                //将查询到的文章放入集合
                articles.add(article);
            }
        }
        return articles;
    }
}
