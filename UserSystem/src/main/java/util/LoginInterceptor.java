package util;

import controller.LoginController;
import entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cty
 * @date 2021/10/21 9:35
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 检查用户是否登录
         */
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(LoginController.LOGIN_USER);
        if (user == null) { //用户未登录
            //引导用户去登录
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;    //false表示，不放流程进入控制器，true表示流程可以进入控制器
    }
}
