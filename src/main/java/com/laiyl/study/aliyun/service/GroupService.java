package com.laiyl.study.aliyun.service;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsGroupListResponse;
import com.aliyuncs.ons.model.v20190214.OnsGroupSubDetailResponse;
import com.laiyl.study.aliyun.param.GroupListParam;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
public interface GroupService {

    /**
     * 查询GID 列表
     * @param param 查询参数
     * @return
     * @throws ClientException
     */
    OnsGroupListResponse queryGroupList(GroupListParam param) throws ClientException;

    /**
     * 根据GID 查询订阅详情
     * @param groupId GID
     * @return
     * @throws ClientException
     */
    OnsGroupSubDetailResponse queryGroupSubDetail(String groupId) throws ClientException;
}
