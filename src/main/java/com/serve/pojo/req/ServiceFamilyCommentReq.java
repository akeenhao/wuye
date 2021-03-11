package com.serve.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("家庭维修评论类")
public class ServiceFamilyCommentReq {
    @ApiModelProperty("数据id")
    private int applyId;
    @ApiModelProperty("评论内容")
    private String comment;

}
