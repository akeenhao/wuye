package com.serve.controller;

import com.serve.pojo.common.Result;
import com.serve.pojo.req.ResidentReq;
import com.serve.pojo.resp.ResidentResp;
import com.serve.pojo.resp.UserResp;
import com.serve.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户服务")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserByRole")
    @ApiOperation("根据角色查询用户")
    public Result<List<UserResp>> getUserByRole(String role){
        return new Result<>(userService.getUserList(role));
    }

    @PostMapping("/updateResidentInfo")
    @ApiOperation("更新业主资料")
    public Result updateResidentInfo(@ApiParam(value = "更新业主资料") @RequestBody ResidentReq req){
        return userService.updateResidentInfo(req);
    }

    @GetMapping("/getResidentInfo")
    @ApiOperation("查询业主资料")
    public Result<ResidentResp> getResidentInfo(){
        return new Result<>(userService.getResidentInfo());
    }


}
