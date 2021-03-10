package com.serve.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("注册类")
public class RegisterReq {
    @ApiModelProperty("账号。即微信openid")
    private String account;
//    private String name;
}
