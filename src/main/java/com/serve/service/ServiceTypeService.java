package com.serve.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.serve.mapper.ServiceTypeMapper;
import com.serve.pojo.model.ServiceTypeModel;
import com.serve.pojo.resp.ServiceTypeResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTypeService {
    @Autowired
    ServiceTypeMapper serviceTypeMapper;

    //根据服务类型查询服务
    public List<ServiceTypeResp> getServiceTypeList(String type){
        LambdaQueryWrapper<ServiceTypeModel> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(ServiceTypeModel::getType,type);
        List<ServiceTypeModel> serviceTypeModelList = serviceTypeMapper.selectList(wrapper);
        List<ServiceTypeResp> serviceTypeRespList = new ArrayList<>();
        serviceTypeModelList.forEach(model->{
            ServiceTypeResp resp = new ServiceTypeResp();
            BeanUtils.copyProperties(model,resp);
            serviceTypeRespList.add(resp);
        });
        return serviceTypeRespList;
    }
}
