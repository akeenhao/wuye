package com.serve.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ServiceCommunityReplyReq {
    @ApiModelProperty(value = "数据id")
    private int applyId;
    @ApiModelProperty(value = "答复内容")
    private String comment;
}
