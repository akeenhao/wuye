package com.serve.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.serve.mapper.UserMapper;
import com.serve.pojo.common.Const;
import com.serve.pojo.common.Result;
import com.serve.pojo.model.UserModel;
import com.serve.pojo.req.RegisterReq;
import com.serve.pojo.resp.LoginResp;
import com.serve.util.ContextUtil;
import com.serve.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private  UserMapper userMapper;

    public Result<LoginResp> login(String type, String account, String password){
        logger.info("调用登录service");
        QueryWrapper<UserModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserModel::getAccount,account);
        UserModel userModel = userMapper.selectOne(queryWrapper);

        if (userModel == null){
            return new Result(Result.FAILURE_CODE,"账号不存在！");
        }
        if (Const.LOGIN_PC.equals(type)) {
            if (!password.equals(userModel.getPassword())){
                return new Result(Result.FAILURE_CODE,"密码错误！");
            }
        }

        //设置session

        String token = JwtUtil.generateToken(account);
        ContextUtil.setUserView(userModel,token);

        LoginResp resp = new LoginResp();
        resp.setAccount(userModel.getAccount());
        resp.setName(userModel.getName());
        resp.setToken(token);
        resp.setRole(userModel.getRole());
        return new Result(resp);
    }

    public Result logout() {
        logger.info("logout");
        ContextUtil.logout();
        return new Result();
    }

    public Result<LoginResp> register(RegisterReq req) {
        boolean existFlag = accountExist(req.getAccount());
        if (existFlag){
            return new Result(Result.FAILURE_CODE,"账号已存在！");
        }

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(req, userModel);
        userMapper.insert(userModel);

        //设置session并返回
        String token = JwtUtil.generateToken(req.getAccount());
        ContextUtil.setUserView(userModel,token);
        LoginResp resp = new LoginResp();
        resp.setAccount(userModel.getAccount());
        resp.setName(userModel.getName());
        resp.setToken(token);
        resp.setRole(userModel.getRole());
        return new Result(resp);
    }


    /**
     * 判断账号是否存在
     * @param account
     * @return Y：存在 N：不存在
     */
    public boolean accountExist(String account){
        QueryWrapper<UserModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserModel::getAccount,account);
        UserModel user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            return true;
        }
        return false;
    }
}
