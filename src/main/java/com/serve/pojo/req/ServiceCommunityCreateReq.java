package com.serve.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ServiceCommunityCreateReq {
//    @ApiModelProperty(value = "当前所在经销商")
//    private int serviceType;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "内容")
    private String context;
//    @ApiModelProperty(value = "图片文件")
//    private MultipartFile file;//图片
}
