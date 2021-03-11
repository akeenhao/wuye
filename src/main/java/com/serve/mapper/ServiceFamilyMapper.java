package com.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.serve.pojo.model.ServiceFamilyModel;
import com.serve.pojo.resp.ServiceFamilyQueryResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component("serviceFamilyMapper")
public interface ServiceFamilyMapper extends BaseMapper<ServiceFamilyModel> {
    List<ServiceFamilyQueryResp> getList(@Param("applyManId") int applyManId,
                                         @Param("repariManId") int repariManId,
                                         @Param("status") String status,
                                         @Param("keyword") String keyword);
}
