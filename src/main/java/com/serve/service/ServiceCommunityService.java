package com.serve.service;

import com.serve.mapper.ServiceCommunityMapper;
import com.serve.pojo.common.Const;
import com.serve.pojo.common.Result;
import com.serve.pojo.model.ServiceCommunityModel;
import com.serve.pojo.req.ServiceCommunityApplyReq;
import com.serve.util.ContextUtil;
import com.serve.util.FileUtil;
import com.serve.util.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ServiceCommunityService {
    @Autowired
    ServiceCommunityMapper serviceCommunityMapper;

    /**
     * 申请
     * @param req
     * @return
     * @throws IOException
     */
    public Result apply(ServiceCommunityApplyReq req) throws IOException {
        ServiceCommunityModel model = new ServiceCommunityModel();
        BeanUtils.copyProperties(req, model);

        String filePath = FileUtil.upload(req.getFile());
        model.setPicture(filePath);
        model.setStatus(Const.SERVICE_COMMUNITY_APPLY);
        model.setApplyMan(ContextUtil.getUserView().getId());
        model.setApplyTime(Util.getCurrentTime());
        serviceCommunityMapper.insert(model);
        return Result.ok();
    }
}
