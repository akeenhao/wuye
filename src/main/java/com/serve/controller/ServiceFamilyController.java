package com.serve.controller;

import com.serve.pojo.common.Result;
import com.serve.pojo.req.ServiceFamilyCommentReq;
import com.serve.pojo.req.ServiceFamilyCreateReq;
import com.serve.pojo.req.ServiceFamilyQueryReq;
import com.serve.pojo.req.ServiceFamilySetRepairManReq;
import com.serve.pojo.resp.ServiceFamilyQueryResp;
import com.serve.service.ServiceFamilyService;
import com.serve.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/serviceFamily")
@Api(tags = "家庭服务")
public class ServiceFamilyController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ServiceFamilyService serviceFamilyService;

    /**
     * 申请家庭服务
     *
     * @param req
     * @return
     */
    @PostMapping("/apply")
    @ApiOperation(value = "申请家庭服务")
    public Result apply(@RequestBody ServiceFamilyCreateReq req) {
//        String filePath = FileUtil.upload(file);
        serviceFamilyService.apply(req.getTitle(), req.getContext());
        return new Result();
    }

    /**
     * 查询家庭服务
     *
     * @return
     */
    @GetMapping("/getList")
    @ApiOperation(value = "查询家庭服务")
    public Result<List<ServiceFamilyQueryResp>> getList(@ApiParam(value = "status 状态 已申请（APPLY） 已受理（RECEIVE） 已维修（REPAIR）") String status,
                                                        @ApiParam(value = "keyword 模糊查询") String keyword) {
        return new Result<>(serviceFamilyService.getList(status, keyword));
    }

    /**
     * 管理员处理，设置维修人员
     *
     * @param req
     * @return
     */
    @PostMapping("/setRepairMan")
    @ApiOperation(value = "设置维修人员")
    public Result setRepairMan(@RequestBody ServiceFamilySetRepairManReq req) {
        logger.info("设置维修人员参数:req:{}", req);
        serviceFamilyService.setRepairMan(req.getApplyId(), req.getUserId());
        return new Result();
    }

    @PostMapping("/commentService")
    @ApiOperation(value = "业主评论")
    public Result commentService(@RequestBody ServiceFamilyCommentReq req) {
        logger.info("业主评论参数:applyId:{},comment:{}", req.getApplyId(), req.getComment());
        return serviceFamilyService.commentService(req.getApplyId(), req.getComment());
    }

}
