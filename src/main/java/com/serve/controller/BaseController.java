package com.serve.controller;

import com.serve.pojo.common.Result;
import com.serve.pojo.model.ServiceTypeModel;
import com.serve.pojo.resp.ServiceTypeResp;
import com.serve.service.ServiceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/base")
@Api(tags = "基础信息")
public class BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ServiceTypeService serviceTypeService;

    @GetMapping("getServiceTypeList")
    @ApiOperation("查询服务类型列表")
    public Result<List<ServiceTypeResp>> getServiceTypeList(@ApiParam(value = "服务类型。家庭服务：family 社区服务：community") String type){
        return new Result<>(serviceTypeService.getServiceTypeList(type));
    }
}
