package com.serve.pojo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录返回")
public class LoginResp {
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("令牌")
    private String token;
}
