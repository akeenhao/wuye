package com.serve.pojo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("服务类型")
public class ServiceTypeResp {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("服务名称")
    private String name;
}
