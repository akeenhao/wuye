package com.serve.controller;

import com.alibaba.fastjson.JSONObject;
import com.serve.pojo.common.Const;
import com.serve.pojo.common.Result;
import com.serve.pojo.req.LoginReq;
import com.serve.pojo.req.RegisterReq;
import com.serve.pojo.req.UserInfoReq;
import com.serve.pojo.resp.LoginResp;
import com.serve.pojo.resp.ResidentResp;
import com.serve.pojo.resp.UserResp;
import com.serve.service.SystemService;
import com.serve.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户服务")
public class UserController {
    @Autowired
    UserService userService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SystemService systemService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public Result<JSONObject> login(@ApiParam("登录信息") @RequestBody LoginReq req) {
        logger.info("调用登录");
        return systemService.login(req.getType(), req.getAccount(), req.getPassword());
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public Result<LoginResp> register(@ApiParam("注册信息") @RequestBody RegisterReq req) {
        return systemService.register(req);
    }

    @GetMapping("/getUserByRole")
    @ApiOperation("查询物业列表")
    public Result<List<UserResp>> getUserByRole() {
        return new Result<>(userService.getUserList(Const.ROLE_REPAIRMAN));
    }

    @PostMapping("/updateResidentInfo")
    @ApiOperation("更新用户信息")
    public Result updateUser(@ApiParam(value = "更新业主资料") @RequestBody UserInfoReq req) {
        return userService.updateResidentInfo(req);
    }

    @GetMapping("/getCurrentUserInfo")
    @ApiOperation("查询当前用户信息")
    public Result<ResidentResp> getCurrentUserInfo() {
        return new Result<>(userService.getCurrentUserInfo());
    }


}
