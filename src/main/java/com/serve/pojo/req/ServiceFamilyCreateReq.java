package com.serve.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("家庭维修创建类")
public class ServiceFamilyCreateReq {
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("维修内容")
    private String context;
}
