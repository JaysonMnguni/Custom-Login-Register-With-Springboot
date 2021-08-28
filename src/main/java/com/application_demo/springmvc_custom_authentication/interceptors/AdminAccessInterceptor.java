package com.application_demo.springmvc_custom_authentication.interceptors;

import com.application_demo.springmvc_custom_authentication.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AdminAccessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("In Pre Handle Admin Access Interceptor!");

        // Check For Request URI:
        if(request.getRequestURI().startsWith("/admin")){
            // Init Session:
            HttpSession session = request.getSession();

            // Get User Session Attributes:
            User user = (User)session.getAttribute("user");

            // Check for user type:
            if(!user.getUser_type().equals("admin")){
                response.sendRedirect("/user/dashboard");
                return false;
            }
            // End Of Check for user type.
        }
        // End Of Check For Request URI.

        return true;
    }
    // End Of Pre Handle Method.


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("In Post Handle Admin Access Interceptor!");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("In After Completion Admin Access Interceptor!");
    }
}
