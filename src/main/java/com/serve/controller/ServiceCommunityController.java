package com.serve.controller;

import com.serve.pojo.common.Result;
import com.serve.pojo.req.ServiceCommunityCreateReq;
import com.serve.pojo.req.ServiceCommunityReplyReq;
import com.serve.pojo.resp.ServiceCommunityResp;
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
import java.util.List;

@RestController
@RequestMapping("/serviceCommunity")
@Api(tags = "社区服务")
public class ServiceCommunityController {
    @Autowired
    ServiceCommunityService serviceCommunityService;

    @PostMapping("/apply")
    @ApiOperation("申请社区服务")
    public Result apply(@ApiParam("申请内容") ServiceCommunityCreateReq req) throws IOException {
        return serviceCommunityService.apply(req);
    }

    @GetMapping("/getList")
    @ApiOperation("查询社区服务")
    public Result<List<ServiceCommunityResp>> getList(@ApiParam(value = "status 状态 已申请（APPLY） 已回复（REPLY）") String status,
                                                      @ApiParam(value = "keyword 模糊查询") String keyword) {
        return new Result<>(serviceCommunityService.getList(status, keyword));
    }

    @PostMapping("/reply")
    @ApiOperation("社区服务答复")
    public Result reply(@ApiParam("答复数据") ServiceCommunityReplyReq req) {
        return serviceCommunityService.reply(req.getApplyId(), req.getComment());
    }
}
