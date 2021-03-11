package com.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.serve.pojo.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component("userMapper")
public interface UserMapper extends BaseMapper<UserModel> {
}
