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
    @ApiModelProperty("角色用数字 1：业主 2：管理员 3：维修人员")
    private String role;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("身份证号")
    private String idCard;
    @ApiModelProperty("令牌")
    private String token;
    @ApiModelProperty("楼号（业主）")
    private String building;
    @ApiModelProperty("单元（业主）")
    private String part;
    @ApiModelProperty("房号（业主）")
    private String room;
}
