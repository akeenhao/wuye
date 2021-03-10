package com.serve.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.serve.mapper.UserMapper;
import com.serve.pojo.common.Result;
import com.serve.pojo.model.UserModel;
import com.serve.pojo.req.UserInfoReq;
import com.serve.pojo.resp.ResidentResp;
import com.serve.pojo.resp.UserResp;
import com.serve.util.ContextUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据角色查询用户
     * @param role
     * @return
     */
    public List<UserResp> getUserList(String role){
        QueryWrapper<UserModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserModel::getRole,role);
        List<UserModel> userList = userMapper.selectList(queryWrapper);
        List<UserResp> userRespList = new ArrayList<>();
        for (UserModel user : userList){
            UserResp userResp = new UserResp();
            BeanUtils.copyProperties(user, userResp);
            userRespList.add(userResp);
        }
        return userRespList;
    }

    /**
     * 更新业主资料
     * @param userInfoReq
     * @return
     */
    public Result updateResidentInfo(UserInfoReq userInfoReq){
        int userId = ContextUtil.getUserView().getId();
        UserModel userModel = userMapper.selectById(userId);
        if (userModel == null){
            return new Result(Result.FAILURE_CODE,"当前用户不存在！");
        }
        BeanUtils.copyProperties(userInfoReq,userModel);
        userMapper.updateById(userModel);
        return new Result();
    }

    /**
     * 查询当前业主资料
     * @return
     */
    public ResidentResp getCurrentUserInfo(){
        int userId = ContextUtil.getUserView().getId();
        UserModel userModel = userMapper.selectById(userId);
        ResidentResp resp = new ResidentResp();
        BeanUtils.copyProperties(userModel, resp);
        return resp;
    }
}
