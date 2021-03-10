package com.serve.util;

import com.serve.pojo.model.UserModel;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *  为用户保留session
 */
public class ContextUtil {

    public static UserModel getUserView() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (UserModel) request.getSession().getAttribute("user");
    }

    public static void setUserView(UserModel user) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute("user", user);
    }


}
