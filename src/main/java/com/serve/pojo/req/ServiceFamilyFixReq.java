package com.serve.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("家庭维修类")
public class ServiceFamilyFixReq {
    @ApiModelProperty("数据id")
    private int applyId;

}
