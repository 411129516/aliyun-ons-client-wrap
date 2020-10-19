package com.laiyl.study.aliyun.service.impl;

import cn.hutool.core.date.DateUtil;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsTraceGetResultRequest;
import com.aliyuncs.ons.model.v20190214.OnsTraceGetResultResponse;
import com.aliyuncs.ons.model.v20190214.OnsTraceQueryByMsgIdRequest;
import com.aliyuncs.ons.model.v20190214.OnsTraceQueryByMsgIdResponse;
import com.aliyuncs.ons.model.v20190214.OnsTraceQueryByMsgKeyRequest;
import com.aliyuncs.ons.model.v20190214.OnsTraceQueryByMsgKeyResponse;
import com.laiyl.study.aliyun.client.AliyunClient;
import com.laiyl.study.aliyun.param.MessageTraceByKeyParam;
import com.laiyl.study.aliyun.param.MessageTraceByMsgIdParam;
import com.laiyl.study.aliyun.properties.AliyunProperties;
import com.laiyl.study.aliyun.service.MessageTraceService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Service
public class MessageTraceServiceImpl implements MessageTraceService {

    @Resource
    private AliyunProperties aliyunProperties;

    @Resource
    private AliyunClient aliyunClient;

    @Override
    public OnsTraceQueryByMsgKeyResponse queryTraceByMsgKey(MessageTraceByKeyParam param) throws ClientException {
        OnsTraceQueryByMsgKeyRequest request = new OnsTraceQueryByMsgKeyRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setInstanceId(aliyunProperties.getInstanceId());
        request.setBeginTime(DateUtil.parse(param.getBeginTime()).getTime());
        request.setEndTime(DateUtil.parse(param.getEndTime()).getTime());
        request.setMsgKey(param.getMsgKey());
        request.setTopic(param.getTopic());

        return aliyunClient.getAcsResponseEntity(request);
    }

    @Override
    public OnsTraceQueryByMsgIdResponse queryTraceByMsgId(MessageTraceByMsgIdParam param) throws ClientException {
        OnsTraceQueryByMsgIdRequest request = new OnsTraceQueryByMsgIdRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setInstanceId(aliyunProperties.getInstanceId());
        if (StringUtils.hasText(param.getBeginTime())) {
            request.setBeginTime(DateUtil.parse(param.getBeginTime()).getTime());
        }
        if (StringUtils.hasText(param.getEndTime())) {
            request.setEndTime(DateUtil.parse(param.getEndTime()).getTime());
        }
        request.setMsgId(param.getMsgId());
        request.setTopic(param.getTopic());

        return aliyunClient.getAcsResponseEntity(request);
    }

    @Override
    public OnsTraceGetResultResponse queryTraceByQueryId(String queryId) throws ClientException {
        OnsTraceGetResultRequest request = new OnsTraceGetResultRequest();
        request.setSysRegionId(aliyunProperties.getRegionId());
        request.setQueryId(queryId);

        return aliyunClient.getAcsResponseEntity(request);
    }

}
