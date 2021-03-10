package com.serve.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("注册实体")
public class RegisterReq {
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("角色用数字 1：业主 2：管理 3：维修人员")
    private String role;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("身份证号")
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
//    private String name;
}
