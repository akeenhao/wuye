package com.serve.pojo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("家庭服务返回类")
public class ServiceFamilyQueryResp {
    @ApiModelProperty("家庭服务主键")
    private int id;
    @ApiModelProperty("服务类型")
    private String type;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("内容")
    private String context;
    @ApiModelProperty("图片")
    private String pictureUrl;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("申请人")
    private String applyMan;
    @ApiModelProperty("申请时间")
    private String applyTime;
    @ApiModelProperty("受理人")
    private String acceptMan;
    @ApiModelProperty("受理时间")
    private String acceptTime;
    @ApiModelProperty("维修人")
    private String repairMan;
    @ApiModelProperty("维修时间")
    private String repairTime;
    @ApiModelProperty("评价内容")
    private String comment;
    @ApiModelProperty("评价时间")
    private String commentTime;

}
