package com.serve.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("业主资料")
public class UserInfoReq {
    @ApiModelProperty(value = "姓名",allowEmptyValue = false)
    private String name;
    @ApiModelProperty(value = "身份证",allowEmptyValue = false)
    private String idCard;
    @ApiModelProperty(value = "性别", allowableValues = "男,女",allowEmptyValue = false)
    private String sex;
    @ApiModelProperty(value = "楼号",allowEmptyValue = false)
    private String building;
    @ApiModelProperty(value = "单元号",allowEmptyValue = false)
    private String part;
    @ApiModelProperty(value ="房号",allowEmptyValue = false)
    private String room;
    @ApiModelProperty(value = "手机号",allowEmptyValue = false)
    private String phone;
}
