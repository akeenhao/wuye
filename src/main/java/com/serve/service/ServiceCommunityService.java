package com.serve.service;

import com.serve.mapper.ServiceCommunityMapper;
import com.serve.pojo.common.Const;
import com.serve.pojo.common.Result;
import com.serve.pojo.model.ServiceCommunityModel;
import com.serve.pojo.model.UserModel;
import com.serve.pojo.req.ServiceCommunityCreateReq;
import com.serve.pojo.resp.ServiceCommunityResp;
import com.serve.util.ContextUtil;
import com.serve.util.FileUtil;
import com.serve.util.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ServiceCommunityService {
    @Autowired
    ServiceCommunityMapper serviceCommunityMapper;
    @Autowired
    ContextUtil contextUtil;

    /**
     * 申请
     *
     * @param req
     * @return
     * @throws IOException
     */
    public Result apply(ServiceCommunityCreateReq req) throws Exception {
        ServiceCommunityModel model = new ServiceCommunityModel();
        BeanUtils.copyProperties(req, model);

//        String filePath = FileUtil.upload(req.getFile());
//        model.setPicture(filePath);
        model.setStatus(Const.SERVICE_COMMUNITY_APPLY);
        model.setApplyMan(contextUtil.getUserView().getId());
        model.setApplyTime(Util.getCurrentTime());
        serviceCommunityMapper.insert(model);
        return Result.ok();
    }

    public List<ServiceCommunityResp> getList(String status, String keyword) throws Exception {
        UserModel currentUser = contextUtil.getUserView();
        //当前用户为业主
        if (Const.ROLE_RESIDENT.equals(currentUser.getRole())) {
            return serviceCommunityMapper.getList(currentUser.getId(), status, keyword);
        }
        //否则，当前用户为管理员
        return serviceCommunityMapper.getList(0, status, keyword);
    }


    public Result reply(int applyId, String comment) throws Exception {
        ServiceCommunityModel serviceCommunityModel = serviceCommunityMapper.selectById(applyId);
        if (serviceCommunityModel == null) {
            return new Result(Result.FAILURE_CODE, "此申请不存在，刷新后再试！");
        }
        UserModel currentUser = contextUtil.getUserView();
        serviceCommunityModel.setReplyMan(currentUser.getId());
        serviceCommunityModel.setReplyContext(comment);
        serviceCommunityModel.setReplyTime(Util.getCurrentTime());
        serviceCommunityModel.setStatus(Const.SERVICE_COMMUNITY_REPLY);
        serviceCommunityMapper.updateById(serviceCommunityModel);
        return new Result();
    }

    public void delete(int applyId) {
        serviceCommunityMapper.deleteById(applyId);
    }
}
