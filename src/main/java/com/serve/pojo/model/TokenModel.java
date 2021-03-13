package com.serve.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("service_token")
public class TokenModel {

    @TableId(type = IdType.AUTO)
    private int id;
    private int userId;
    private String token;
}
