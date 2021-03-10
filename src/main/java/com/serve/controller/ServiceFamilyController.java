package com.serve.controller;

import com.serve.pojo.common.Result;
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
     * @param serviceType
     * @param title
     * @param context
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/apply")
    @ApiOperation(value = "申请家庭服务")
    public Result apply(@ApiParam(value = "服务类型") @RequestParam("serviceType") int serviceType,
                        @ApiParam(value = "标题") @RequestParam("title") String title,
                        @ApiParam(value = "内容") @RequestParam("context") String context,
                        @ApiParam(value = "图片") @RequestParam("file") MultipartFile file) throws IOException {
        String filePath = FileUtil.upload(file);
        serviceFamilyService.apply(serviceType,title,context,filePath);
        return new Result();
    }

    /**
     * 查询家庭服务
     * @param req
     * @return
     */
    @GetMapping("/getList")
    @ApiOperation(value = "查询家庭服务")
    public Result<List<ServiceFamilyQueryResp>> getList(ServiceFamilyQueryReq req){
        return new Result<>(serviceFamilyService.getList(req.getStatus(),req.getKeyword()));
    }

    /**
     * 管理员处理，设置维修人员
     * @param req
     * @return
     */
    @PostMapping("/setRepairMan")
    @ApiOperation(value = "设置维修人员")
    public Result setRepairMan(@RequestBody ServiceFamilySetRepairManReq req){
        logger.info("设置维修人员参数:req:{}",req);
        serviceFamilyService.setRepairMan(req.getApplyId(),req.getUserId());
        return new Result();
    }

    @PostMapping("/commentService")
    @ApiOperation(value = "业主评论")
    public Result commentService(int applyId, String comment){
        logger.info("业主评论参数:applyId:{},comment:{}",applyId,comment);
        return serviceFamilyService.commentService(applyId, comment);
    }

}
