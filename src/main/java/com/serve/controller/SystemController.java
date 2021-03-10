package com.serve.controller;

import com.alibaba.fastjson.JSONObject;
import com.serve.pojo.common.Result;
import com.serve.pojo.req.LoginReq;
import com.serve.pojo.req.RegisterReq;
import com.serve.pojo.resp.LoginResp;
import com.serve.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "系统服务")
public class SystemController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SystemService systemService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public Result<JSONObject> login(@ApiParam("登录信息") @RequestBody LoginReq req){
        logger.info("调用登录");
        return systemService.login(req.getType(),req.getAccount(),req.getPassword());
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public Result<LoginResp> register(@ApiParam("注册信息") @RequestBody RegisterReq req){
        return systemService.register(req);
    }

    @GetMapping("/accountExist")
    @ApiOperation("是否已注册")
    public Result accountExist(@ApiParam("账号/openid") @RequestParam String account){
        return new Result(systemService.accountExist(account));
    }

}
