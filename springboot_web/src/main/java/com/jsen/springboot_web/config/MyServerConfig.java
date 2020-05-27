package com.jsen.springboot_web.config;

import com.jsen.springboot_web.filter.Myfilter;
import com.jsen.springboot_web.listener.MyListener;
import com.jsen.springboot_web.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 这是个配置类
 */
@Configuration
public class MyServerConfig {

    //注册三大组件 --注册Servlet
    @Bean
    public ServletRegistrationBean myServlet() {
        return new ServletRegistrationBean(new MyServlet(), "/myServlet");
    }

    //注册三大组件 --注册filter
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new Myfilter());
        bean.setUrlPatterns(Arrays.asList("/hello", "/jhs"));
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        return new ServletListenerRegistrationBean(new MyListener());
    }

}
