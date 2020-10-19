package com.laiyl.study.aliyun.service.impl;

import cn.hutool.core.date.DateUtil;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsMessageGetByKeyRequest;
import com.aliyuncs.ons.model.v20190214.OnsMessageGetByKeyResponse;
import com.aliyuncs.ons.model.v20190214.OnsMessageGetByMsgIdRequest;
import com.aliyuncs.ons.model.v20190214.OnsMessageGetByMsgIdResponse;
import com.aliyuncs.ons.model.v20190214.OnsMessagePageQueryByTopicRequest;
import com.aliyuncs.ons.model.v20190214.OnsMessagePageQueryByTopicResponse;
import com.aliyuncs.ons.model.v20190214.OnsMessageTraceRequest;
import com.aliyuncs.ons.model.v20190214.OnsMessageTraceResponse;
import com.laiyl.study.aliyun.client.AliyunClient;
import com.laiyl.study.aliyun.param.MessageKeyParam;
import com.laiyl.study.aliyun.param.MessageMsgIdParam;
import com.laiyl.study.aliyun.param.MessagePageParam;
import com.laiyl.study.aliyun.properties.AliyunProperties;
import com.laiyl.study.aliyun.service.AliyunOnsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Service
public class AliyunOnsServiceImpl implements AliyunOnsService {

    @Resource
    private AliyunProperties aliyunProperties;

    @Resource
    private AliyunClient aliyunClient;

    @Override
    public OnsMessageGetByKeyResponse getMessageByKey(MessageKeyParam param) throws ClientException {
        OnsMessageGetByKeyRequest request = new OnsMessageGetByKeyRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setInstanceId(aliyunProperties.getInstanceId());
        request.setTopic(param.getTopic());
        request.setKey(param.getKey());

        return aliyunClient.getAcsResponseEntity(request);
    }

    @Override
    public OnsMessageGetByMsgIdResponse getMessageByMsgId(MessageMsgIdParam param) throws ClientException {
        OnsMessageGetByMsgIdRequest request = new OnsMessageGetByMsgIdRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setInstanceId(aliyunProperties.getInstanceId());
        request.setTopic(param.getTopic());
        request.setMsgId(param.getMsgId());

        return aliyunClient.getAcsResponseEntity(request);

    }

    @Override
    public OnsMessagePageQueryByTopicResponse queryMessageByPage(MessagePageParam param) throws ClientException {
        OnsMessagePageQueryByTopicRequest request = new OnsMessagePageQueryByTopicRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setInstanceId(aliyunProperties.getInstanceId());
        request.setBeginTime(DateUtil.parse(param.getBeginTime()).getTime());
        request.setEndTime(DateUtil.parse(param.getEndTime()).getTime());
        request.setCurrentPage(param.getCurrentPage());
        request.setTopic(param.getTopic());
        request.setPageSize(param.getPageSize());

        return aliyunClient.getAcsResponseEntity(request);
    }

    @Override
    public OnsMessageTraceResponse queryMessageTrace(MessageMsgIdParam param) throws ClientException {
        OnsMessageTraceRequest request = new OnsMessageTraceRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setInstanceId(aliyunProperties.getInstanceId());
        request.setMsgId(param.getMsgId());
        request.setTopic(param.getTopic());

        return aliyunClient.getAcsResponseEntity(request);
    }
}
