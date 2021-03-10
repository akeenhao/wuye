package com.serve.pojo.resp;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

@Data
@ApiModel("家庭服务返回类")
public class ServiceCommunityResp {
    @ApiModelProperty("主键")
    private int id;
    @ApiModelProperty("服务类型")
    private String serviceType;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("内容")
    private String context;
    @ApiModelProperty("图片")
    private String pictureUrl;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("申请人")
    private String applyMan;
    @ApiModelProperty("申请时间")
    private String applyTime;
    @ApiModelProperty("回复人")
    private String replyMan;
    @ApiModelProperty("回复时间")
    @TableField(jdbcType = JdbcType.TIMESTAMP)
    private String replyTime;
    @ApiModelProperty("回复内容")
    private String replyContext;

}
