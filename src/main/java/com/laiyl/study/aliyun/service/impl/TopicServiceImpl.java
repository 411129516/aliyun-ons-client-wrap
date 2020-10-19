package com.laiyl.study.aliyun.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsTopicListRequest;
import com.aliyuncs.ons.model.v20190214.OnsTopicListResponse;
import com.aliyuncs.ons.model.v20190214.OnsTopicSubDetailRequest;
import com.aliyuncs.ons.model.v20190214.OnsTopicSubDetailResponse;
import com.laiyl.study.aliyun.client.AliyunClient;
import com.laiyl.study.aliyun.param.TopicListParam;
import com.laiyl.study.aliyun.properties.AliyunProperties;
import com.laiyl.study.aliyun.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Resource
    private AliyunProperties aliyunProperties;

    @Resource
    private AliyunClient aliyunClient;

    @Override
    public OnsTopicListResponse queryTopicList(TopicListParam param) throws ClientException {
        OnsTopicListRequest request = new OnsTopicListRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setTopic(param.getTopic());

        if (CollectionUtil.isNotEmpty(param.getTags())) {
            List<OnsTopicListRequest.Tag> tags = new ArrayList<>();
            param.getTags().forEach(tag -> {
                OnsTopicListRequest.Tag onsTag = new OnsTopicListRequest.Tag();
                onsTag.setKey(tag.getKey());
                onsTag.setValue(tag.getValue());
                tags.add(onsTag);
            });
            request.setTags(tags);
        }

        return aliyunClient.getAcsResponseEntity(request);
    }

    @Override
    public OnsTopicSubDetailResponse queryTopicSubDetail(String topic) throws ClientException {
        OnsTopicSubDetailRequest request = new OnsTopicSubDetailRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setTopic(topic);

        return aliyunClient.getAcsResponseEntity(request);
    }
}
