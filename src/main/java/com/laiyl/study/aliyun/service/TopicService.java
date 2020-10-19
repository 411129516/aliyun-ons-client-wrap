package com.laiyl.study.aliyun.service;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsTopicListResponse;
import com.aliyuncs.ons.model.v20190214.OnsTopicSubDetailResponse;
import com.laiyl.study.aliyun.param.TopicListParam;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
public interface TopicService {

    /**
     * 根据条件查询所有topic列表
     * @param param 查询参数
     * @return
     * @throws ClientException
     */
    OnsTopicListResponse queryTopicList(TopicListParam param) throws ClientException;

    /**
     * 根据topic查询订阅详情
     * @param topic 主题
     * @return
     * @throws ClientException
     */
    OnsTopicSubDetailResponse queryTopicSubDetail(String topic) throws ClientException;
}
