package com.car.demo.interceptor;

import com.car.demo.entity.User;
import com.car.demo.util.ConstantUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ConstantUtil.CLIENT_ID);
        return user != null;
    }
}
