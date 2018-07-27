package com.travel.dit.springwebpractice.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws
                                                                                                        Exception {

        String emailAddress = request.getParameter("emailAddress");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(emailAddress) || StringUtils.containsWhitespace(emailAddress) ||
            StringUtils.isEmpty(password) || StringUtils.containsWhitespace(password)) {
            throw new Exception("Invalid password or email address. Please try again");
        }

        return true;
    }
}
