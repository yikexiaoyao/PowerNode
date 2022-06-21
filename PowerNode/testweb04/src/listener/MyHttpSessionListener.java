package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author cty
 * @date 2021/9/23 11:34
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //当新的session对象创建后执行这个方法
        System.out.println(se.getSession().getId() + "对象创建了.......");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //当session对象销毁的时候执行这个方法
        System.out.println(se.getSession().getId() + "对象销毁了.......");
    }
}
