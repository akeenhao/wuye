package com.serve.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录类")
public class LoginReq {
//    @ApiModelProperty(value = "登录类型。1：微信登录 2：电脑登录" ,allowableValues = "1,2")
//    private String type;
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("密码")
    private String password;
}
