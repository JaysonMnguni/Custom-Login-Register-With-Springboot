package com.application_demo.springmvc_custom_authentication.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("In Pre Handle Interceptor!");

        // Check For URI Attributes:
        if(request.getRequestURI().startsWith("/admin") || request.getRequestURI().startsWith("/user")){
            // Init Session:
            HttpSession session = request.getSession();

            // Check For Session Attributes:
            if (session.getAttribute("SessionToken") == null && session.getAttribute("user") == null){
                response.sendRedirect("/login");
                return false;
            }
            // End Of Check For Session Attributes.
        }
        // End Of Check For URI Attributes.
        return true;
    }
    // End Of Pre Handled Method.


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("In Post Handle Interceptor!");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("In After CompletionInterceptor!");
    }
}
