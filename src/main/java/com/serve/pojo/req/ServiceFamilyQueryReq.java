package com.serve.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("家庭服务查询类")
public class ServiceFamilyQueryReq {
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("关键字")
    private String keyword;
}
