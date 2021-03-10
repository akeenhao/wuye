package com.serve.pojo.req;

import lombok.Data;

/**
 * 家庭服务，设置维修人员
 */
@Data
public class ServiceFamilySetRepairManReq {
    private int applyId;//申请服务的id
    private int userId;//人员id
}
