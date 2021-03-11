package com.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.serve.pojo.model.ServiceCommunityModel;
import com.serve.pojo.resp.ServiceCommunityResp;
import com.serve.pojo.resp.ServiceFamilyQueryResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("serviceCommunityMapper")
public interface ServiceCommunityMapper extends BaseMapper<ServiceCommunityModel> {
    List<ServiceCommunityResp> getList(@Param("applyManId") int applyManId,
                                       @Param("status") String status,
                                       @Param("keyword") String keyword);
}
