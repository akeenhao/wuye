package com.serve.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 家庭服务，设置维修人员
 */
@Data
public class ServiceFamilySetRepairManReq {
    @ApiModelProperty("数据的id")
    private int applyId;//申请服务的id

    @ApiModelProperty("人员id")
    private int userId;//人员id
}
