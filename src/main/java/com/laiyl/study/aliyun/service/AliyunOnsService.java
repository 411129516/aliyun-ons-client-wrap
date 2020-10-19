package com.laiyl.study.aliyun.service;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsMessageGetByKeyResponse;
import com.aliyuncs.ons.model.v20190214.OnsMessageGetByMsgIdResponse;
import com.aliyuncs.ons.model.v20190214.OnsMessagePageQueryByTopicResponse;
import com.aliyuncs.ons.model.v20190214.OnsMessageTraceResponse;
import com.laiyl.study.aliyun.param.MessageKeyParam;
import com.laiyl.study.aliyun.param.MessageMsgIdParam;
import com.laiyl.study.aliyun.param.MessagePageParam;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
public interface AliyunOnsService {

    /**
     * 根据message key 查询消息
     * @param param
     * @return
     */
    OnsMessageGetByKeyResponse getMessageByKey(MessageKeyParam param) throws ClientException;

    /**
     * 根据message id 查询消息
     * @param param
     * @return
     * @throws ClientException
     */
    OnsMessageGetByMsgIdResponse getMessageByMsgId(MessageMsgIdParam param) throws ClientException;

    /**
     * 分页查询消息
     * @param param
     * @return
     * @throws ClientException
     */
    OnsMessagePageQueryByTopicResponse queryMessageByPage(MessagePageParam param) throws ClientException;

    /**
     * 根据message id查询消息轨迹
     * @param param
     * @return
     * @throws ClientException
     */
    OnsMessageTraceResponse queryMessageTrace(MessageMsgIdParam param) throws ClientException;
}
