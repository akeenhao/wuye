package com.serve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.serve.mapper.ServiceFamilyMapper;
import com.serve.pojo.common.Const;
import com.serve.pojo.common.Result;
import com.serve.pojo.model.ServiceFamilyModel;
import com.serve.pojo.model.UserModel;
import com.serve.pojo.resp.ServiceFamilyQueryResp;
import com.serve.util.ContextUtil;
import com.serve.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFamilyService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ServiceFamilyMapper serviceFamilyMapper;

    public int apply(int serviceType, String title, String context, String pictureUrl){
        ServiceFamilyModel serviceFamily = new ServiceFamilyModel();
        serviceFamily.setServiceType(serviceType);
        serviceFamily.setTitle(title);
        serviceFamily.setContext(context);
        serviceFamily.setPicture(pictureUrl);
        serviceFamily.setStatus(Const.SERVICE_FAMILY_APPLY);
        serviceFamily.setApplyMan(ContextUtil.getUserView().getId());
        serviceFamily.setApplyTime(Util.getCurrentTime());
        return serviceFamilyMapper.insert(serviceFamily);
    }

    /**
     * 查询家庭服务列表
     * @param status
     * @param keyword
     * @return
     */
    public List<ServiceFamilyQueryResp> getList(String status, String keyword){
        UserModel currentUser = ContextUtil.getUserView();
        return serviceFamilyMapper.getList(0,0,"", "");

       /*
        //当前用户为业主
        if (Const.ROLE_RESIDENT.equals(currentUser.getRole())){
            return serviceFamilyMapper.getList(currentUser.getId(),0,status, keyword);
        }
        //当前用户为维修人员
        if (Const.ROLE_REPAIRMAN.equals(currentUser.getRole())){
            return serviceFamilyMapper.getList(0,currentUser.getId(),status, keyword);
        }
        //否则，当前用户为管理员
        return serviceFamilyMapper.getList(0,0,status, keyword);*/
    }

    /**
     * 设置维修人员
     * @param applyId
     * @param userId
     * @return
     */
    public Result setRepairMan(int applyId, int userId){
        ServiceFamilyModel serviceFamily = serviceFamilyMapper.selectById(applyId);
        if (serviceFamily == null){
            return new Result(Result.FAILURE_CODE,"此申请不存在，刷新后再试！");
        }
        if (Const.SERVICE_FAMILY_REPAIR.equals(serviceFamily.getStatus())){
            return new Result(Result.FAILURE_CODE,"此申请的状态为“已维修”，不需要再设置维修人员！");
        }
        serviceFamily.setStatus(Const.SERVICE_FAMILY_RECEIVE);
        serviceFamily.setAcceptMan(ContextUtil.getUserView().getId());
        serviceFamily.setAcceptTime(Util.getCurrentTime());
        serviceFamily.setRepairMan(userId);
        serviceFamilyMapper.updateById(serviceFamily);
        return new Result();
    }

    //评论
    public Result commentService(int applyId, String comment){
        ServiceFamilyModel serviceFamily = serviceFamilyMapper.selectById(applyId);
        if (serviceFamily == null){
            return new Result(Result.FAILURE_CODE,"此申请不存在，刷新后再试！");
        }
        if (!Const.SERVICE_FAMILY_REPAIR.equals(serviceFamily.getStatus())){
            return new Result(Result.FAILURE_CODE,"维修后才能发表评论！");
        }
        serviceFamily.setComment(comment);
        serviceFamily.setCommentTime(Util.getCurrentTime());
        serviceFamilyMapper.updateById(serviceFamily);

        return new Result();
    }

}
