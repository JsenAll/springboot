package com.jsen.springboot_web.filter;


import javax.servlet.*;
import java.io.IOException;

//自己的 filter 过滤器
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//初始化
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//过滤请求
        System.out.println("MyFilter process.....");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
//销毁
    }
}
