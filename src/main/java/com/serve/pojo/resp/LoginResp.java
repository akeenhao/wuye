package com.serve.pojo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录返回")
public class LoginResp {
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("角色用数字 1：业主 2：管理 3：维修人员")
    private String role;
    @ApiModelProperty("令牌")
    private String token;
}
