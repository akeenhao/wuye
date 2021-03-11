package com.serve.util;

import com.serve.pojo.model.UserModel;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 为用户保留session
 */
public class ContextUtil {

    public static UserModel getUserView() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, UserModel> userMap = (Map<String, UserModel>)request.getSession().getAttribute("user");
        return userMap.get(token);
    }

    public static void setUserView(UserModel user, String token) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object sessionUser = request.getSession().getAttribute("user");
        if (null != sessionUser) {
            Map<String, UserModel> userInfo = (Map<String, UserModel>) sessionUser;
            userInfo.put(token, user);
            request.getSession().setAttribute("user", userInfo);
        } else {
            Map<String, UserModel> userInfo = new HashMap<>();
            userInfo.put(token, user);
            request.getSession().setAttribute("user", userInfo);
        }

    }

    public static void logout() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, UserModel> userMap = (Map<String, UserModel>)request.getSession().getAttribute("user");
        userMap.remove(token);
        request.getSession().setAttribute("user", userMap);
    }


}
