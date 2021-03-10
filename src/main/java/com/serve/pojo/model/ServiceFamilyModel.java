package com.serve.pojo.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("service_family")
public class ServiceFamilyModel {

    @TableId(type = IdType.AUTO)
    private int id;
    private int serviceType;
    private String title;
    private String context;
    private String picture;
    private String status;
    private int applyMan;
    @TableField(jdbcType = JdbcType.TIMESTAMP)
    private String applyTime;
    private int acceptMan;
    @TableField(jdbcType = JdbcType.TIMESTAMP)
    private String acceptTime;
    private int repairMan;
    @TableField(jdbcType = JdbcType.TIMESTAMP)
    private String repairTime;
    private String comment;
    @TableField(jdbcType = JdbcType.TIMESTAMP)
    private String commentTime;
}
