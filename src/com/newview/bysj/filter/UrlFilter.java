//package com.newview.bysj.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by Administrator on 2016/12/7.
// */
//@WebFilter(filterName = "urlFilter",urlPatterns = {"/*"})
//public class UrlFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp,
//                         FilterChain chain)   throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest)req;
//        HttpServletResponse response = (HttpServletResponse)resp;
//        //得到请求的整个路径(包含项目名在内的,
//        // 如/bysj/pages/login/login.jsp或/bysj/loginController)
//        String requestUri = request.getRequestURI();
//        System.out.println("URL="+requestUri);
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
