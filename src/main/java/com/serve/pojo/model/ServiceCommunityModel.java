package com.serve.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("service_community")
public class ServiceCommunityModel {
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
    private int replyMan;
    @TableField(jdbcType = JdbcType.TIMESTAMP)
    private String replyTime;
    private String replyContext;

}
