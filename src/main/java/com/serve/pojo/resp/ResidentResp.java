package com.serve.pojo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("居民信息")
public class ResidentResp {
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("身份证")
    private String idCard;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("楼号")
    private String building;
    @ApiModelProperty("单元")
    private String part;
    @ApiModelProperty("房号")
    private String room;
    @ApiModelProperty("电话")
    private String phone;
}
