package com.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.serve.pojo.model.TokenModel;
import com.serve.pojo.model.UserModel;
import org.springframework.stereotype.Component;

@Component("tokenMapper")
public interface TokenMapper extends BaseMapper<TokenModel> {
}
