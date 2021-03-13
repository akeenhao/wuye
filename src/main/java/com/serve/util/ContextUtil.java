package com.serve.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.serve.mapper.TokenMapper;
import com.serve.mapper.UserMapper;
import com.serve.pojo.model.TokenModel;
import com.serve.pojo.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 为用户保留session
 */
@Service
public class ContextUtil {
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenMapper tokenMapper;

    public UserModel getUserView() throws Exception {
        logger.info("getToken");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.info("getToken request:{}", request);
        String token = request.getHeader("Authorization");
        logger.info("token:{}", token);

        QueryWrapper<TokenModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TokenModel::getToken, token);
        List<TokenModel> tokenModels = tokenMapper.selectList(queryWrapper);
        if (tokenModels.isEmpty())
            throw new Exception("token 错误");
        else
            return userMapper.selectById(tokenModels.get(0).getUserId());
    }

    public void setUserView(UserModel user, String token) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        Object sessionUser = request.getSession().getAttribute("user");
//        if (null != sessionUser) {
//            Map<String, UserModel> userInfo = (Map<String, UserModel>) sessionUser;
//            userInfo.put(token, user);
//            request.getSession().setAttribute("user", userInfo);
//        } else {
//            Map<String, UserModel> userInfo = new HashMap<>();
//            userInfo.put(token, user);
//            request.getSession().setAttribute("user", userInfo);
//        }
//        logger.info("user:{} token:{}",user.getAccount(),token);
//        Map<String, UserModel> userMap = (Map<String, UserModel>)request.getSession().getAttribute("user");
//        logger.info("userMap:{}",userMap);

        QueryWrapper<TokenModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TokenModel::getUserId, user.getId());
        List<TokenModel> tokenModels = tokenMapper.selectList(queryWrapper);
        if (tokenModels.isEmpty()) {
            TokenModel tokenModel = new TokenModel();
            tokenModel.setToken(token);
            tokenModel.setUserId(user.getId());
            tokenMapper.insert(tokenModel);
        } else {
            TokenModel tokenModel = tokenModels.get(0);
            tokenModel.setToken(token);
            tokenMapper.updateById(tokenModel);
        }

    }

    public void logout() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        QueryWrapper<TokenModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TokenModel::getToken, token);
        List<TokenModel> tokenModels = tokenMapper.selectList(queryWrapper);

        for (TokenModel tokenModel : tokenModels) {
            queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(TokenModel::getUserId, tokenModel.getUserId());
            tokenMapper.delete(queryWrapper);
        }


//        Map<String, UserModel> userMap = (Map<String, UserModel>)request.getSession().getAttribute("user");
//        userMap.remove(token);
//        request.getSession().setAttribute("user", userMap);
    }


}
