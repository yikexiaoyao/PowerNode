package com.bjpowernode.bean;

/**
 * @author cty
 * @date 2021/11/27 15:28
 */
public class Article {
    private String aid;//主键
    private String title;//标题
    private String link;//链接
    private String pubTime;//发布时间
    private String content;//文章内容
    private String uid;//发布者
    private String votes;//文章投票数

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid='" + aid + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", pubTime='" + pubTime + '\'' +
                ", content='" + content + '\'' +
                ", uid='" + uid + '\'' +
                ", votes='" + votes + '\'' +
                '}';
    }
}
