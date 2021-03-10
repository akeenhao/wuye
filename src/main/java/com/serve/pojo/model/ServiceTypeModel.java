package com.serve.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("service_type")
public class ServiceTypeModel {
    @TableId(type = IdType.AUTO)
    private String id;
    private String type;
    private String name;
}
