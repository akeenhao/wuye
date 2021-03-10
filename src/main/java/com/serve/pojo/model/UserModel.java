package com.serve.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("system_user")
public class UserModel {

    @TableId(type = IdType.AUTO)
    private int id;
    private String type;
    private String account;
    private String password;
    private String role;
    private String name;
    private String idCard;
    private String sex;
    private String building;
    private String part;
    private String room;
    private String phone;
}
