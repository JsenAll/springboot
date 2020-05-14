package com.jsen.springboot_web.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器 登陆检查
 *
 * @author Jsen on 2020/5/13
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            request.setAttribute("msg", "未登录 请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else
            return true;//放行
    }
}
