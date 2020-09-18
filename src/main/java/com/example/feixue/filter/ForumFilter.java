package com.example.feixue.filter;

import com.example.feixue.bean.User;
import com.example.feixue.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 总过滤器
 * Created by 浅忆 on 2019/5/21.
 */

//@WebFilter(filterName = "forumFilter",urlPatterns = "/*")
public class ForumFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter:"+servletRequest);
        User user = userService.ifUser();
        if(user != null && !"".equals(user) && user.getUsername() != null && !"".equals(user.getUsername())) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String uri = request.getRequestURI().startsWith("/") ? request.getRequestURI().substring(1) : request.getRequestURI();
            logger.info("uri:"+uri);
            logger.info("正常请求");
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            logger.info("拦截请求");
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String uri = request.getRequestURI().startsWith("/") ? request.getRequestURI().substring(1) : request.getRequestURI();
            logger.info("uri:"+uri);
            if("index".equals(uri)||"indexView/user".equals(uri)||"indexView/set".equals(uri)||"indexView/setUser".equals(uri)||"favicon.ico".equals(uri)||"indexView/indexService".equals(uri)||uri.startsWith("js")||uri.startsWith("test")){
                logger.info("放行");
                filterChain.doFilter(request, response);
                return;
            }
            response.sendRedirect(request.getContextPath()+"/indexView/indexService");
        }
    }

    @Override
    public void destroy() {
        logger.info("destroy");
    }
}
