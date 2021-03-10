package com.serve.pojo.req;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ServiceCommunityApplyReq {
    private int serviceType;
    private String title;
    private String context;
    private MultipartFile file;//图片
}
