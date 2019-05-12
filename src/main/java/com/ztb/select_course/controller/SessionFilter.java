package com.ztb.select_course.controller;

import com.ztb.select_course.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: 16201533
 * @Date: 2019/5/12 14:39
 * @Version 1.0
 */
@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class SessionFilter implements Filter {


    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/","/login"};
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String uri = request.getRequestURI();//请求的页面
        //String uri = request.getRequestURI();

        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            User user = (User) session.getAttribute("user");
            if (user==null||!uri.matches(".*/("+user.getUserType()+"|static).*")){
                response.sendRedirect("/");
            }else {
                System.out.println(uri+" 可以进入");
                filterChain.doFilter(request, response);
            }
        }
    }
    private boolean isNeedFilter(String uri) {
        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void init(FilterConfig filterConfig){

    }

    @Override
    public void destroy() {

    }
}
