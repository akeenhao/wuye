package com.serve.filter;

import com.serve.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       // boolean checkFlag = true;
        boolean checkFlag = false;
        try {
            if (!isProtectedUrl(request) && checkFlag) {
                //检查session
                if (request.getSession() == null) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "连接已断开，请重新登录！");
                    return;
                }

                //验证token
                //检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
                String token = request.getHeader("Authorization");
                JwtUtil.validateToken(token);
                boolean flag = false;
//                Cookie[] cookies = request.getCookies();
//                for (Cookie cookie : cookies) {
////                    System.out.println(cookie.getName() + "--" + cookie.getValue());
//                    if ("token".equals(cookie.getName()) || "JSESSIONID".equals(cookie.getName())) {
//                        flag = true;
//                    }
//                }
                if (request.getSession().getAttribute("user") != null){
                    flag = true;
                }
                if (!flag) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "连接已断开，请重新登录！");
                    return;
                }


            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
        filterChain.doFilter(request, response);
    }


    //我们只对地址 /api 开头的api检查jwt. 不然的话登录/login也需要jwt
//    private boolean isProtectedUrl(HttpServletRequest request) {
//        return pathMatcher.match("/**", request.getServletPath());
//    }

    //设置不过滤的url
    private boolean isProtectedUrl(HttpServletRequest request) {
        return pathMatcher.match("/login", request.getServletPath())
                || pathMatcher.match("/register", request.getServletPath())
                || !pathMatcher.isPattern(request.getServletPath());
    }

}