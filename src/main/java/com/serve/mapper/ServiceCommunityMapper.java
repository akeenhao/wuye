package com.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.serve.pojo.model.ServiceCommunityModel;
import com.serve.pojo.resp.ServiceCommunityResp;
import com.serve.pojo.resp.ServiceFamilyQueryResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServiceCommunityMapper extends BaseMapper<ServiceCommunityModel> {
    List<ServiceCommunityResp> getList(@Param("applyManId") int applyManId,
                                       @Param("status") String status,
                                       @Param("keyword") String keyword);
}
