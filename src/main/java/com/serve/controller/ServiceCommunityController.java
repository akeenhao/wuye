package com.serve.controller;

import com.serve.pojo.common.Result;
import com.serve.pojo.req.ServiceCommunityApplyReq;
import com.serve.service.ServiceCommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/serviceCommunity")
@Api(tags = "社区服务")
public class ServiceCommunityController {
    @Autowired
    ServiceCommunityService serviceCommunityService;

    @PostMapping("/apply")
    @ApiOperation("申请社区服务")
    public Result apply(@ApiParam("申请内容") ServiceCommunityApplyReq req) throws IOException {
        return serviceCommunityService.apply(req);
    }

    @GetMapping("/getList")
    @ApiOperation("查询社区服务")
    public Result getList(){
        return null;
    }

    @PostMapping("/reply")
    @ApiOperation("社区服务答复")
    public Result reply(){
        return null;
    }
}
