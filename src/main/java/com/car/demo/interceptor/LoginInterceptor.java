package com.car.demo.interceptor;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.util.ConstantUtil;
import com.car.demo.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ConstantUtil.CLIENT_ID);
        if (user == null) {
            response2Client(response);
            return false;
        }else{
            session.setMaxInactiveInterval(30*60);//以秒为单位，即在没有活动30分钟后，session将失效.
        }
        return true;
    }

    private void response2Client(HttpServletResponse response) {
        ResultInfo resultInfo = new ResultInfo(0, "need login");
        PrintWriter out;
        try {
            out = response.getWriter();
            out.write(JsonUtil.object2Json(resultInfo));
        } catch (IOException e) {
            log.error("fail to return client", e);
        }
    }

}
