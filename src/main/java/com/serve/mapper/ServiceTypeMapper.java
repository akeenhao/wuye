package com.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.serve.pojo.model.ServiceTypeModel;
import org.springframework.stereotype.Component;

@Component("serviceTypeMapper")
public interface ServiceTypeMapper extends BaseMapper<ServiceTypeModel> {
}
