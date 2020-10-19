package com.laiyl.study.aliyun.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsGroupListRequest;
import com.aliyuncs.ons.model.v20190214.OnsGroupListResponse;
import com.aliyuncs.ons.model.v20190214.OnsGroupSubDetailRequest;
import com.aliyuncs.ons.model.v20190214.OnsGroupSubDetailResponse;
import com.laiyl.study.aliyun.client.AliyunClient;
import com.laiyl.study.aliyun.param.GroupListParam;
import com.laiyl.study.aliyun.properties.AliyunProperties;
import com.laiyl.study.aliyun.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Resource
    private AliyunProperties aliyunProperties;

    @Resource
    private AliyunClient aliyunClient;

    @Override
    public OnsGroupListResponse queryGroupList(GroupListParam param) throws ClientException {
        OnsGroupListRequest request = new OnsGroupListRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setInstanceId(aliyunProperties.getInstanceId());
        request.setGroupId(param.getGroupId());

        if (CollectionUtil.isNotEmpty(param.getTags())) {
            List<OnsGroupListRequest.Tag> tags = new ArrayList<>();
            param.getTags().forEach(tag -> {
                OnsGroupListRequest.Tag onsTag = new OnsGroupListRequest.Tag();
                onsTag.setKey(tag.getKey());
                onsTag.setValue(tag.getValue());
                tags.add(onsTag);
            });
            request.setTags(tags);
        }

        return aliyunClient.getAcsResponseEntity(request);
    }

    @Override
    public OnsGroupSubDetailResponse queryGroupSubDetail(String groupId) throws ClientException {
        OnsGroupSubDetailRequest request = new OnsGroupSubDetailRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setInstanceId(aliyunProperties.getInstanceId());
        request.setGroupId(groupId);

        return aliyunClient.getAcsResponseEntity(request);
    }
}
