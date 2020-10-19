package com.laiyl.study.aliyun.service;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsTraceGetResultResponse;
import com.aliyuncs.ons.model.v20190214.OnsTraceQueryByMsgIdResponse;
import com.aliyuncs.ons.model.v20190214.OnsTraceQueryByMsgKeyResponse;
import com.laiyl.study.aliyun.param.MessageTraceByKeyParam;
import com.laiyl.study.aliyun.param.MessageTraceByMsgIdParam;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
public interface MessageTraceService {

    /**
     * 根据消息key查询消息轨迹
     * @param param
     * @return
     * @throws ClientException
     */
    OnsTraceQueryByMsgKeyResponse queryTraceByMsgKey(MessageTraceByKeyParam param) throws ClientException;

    /**
     * 根据消息id查询消息轨迹
     * @param param
     * @return
     * @throws ClientException
     */
    OnsTraceQueryByMsgIdResponse queryTraceByMsgId(MessageTraceByMsgIdParam param) throws ClientException;

    /**
     * 根据queryId查询消息轨迹
     * @param queryId 查询id
     * @return
     * @throws ClientException
     */
    OnsTraceGetResultResponse queryTraceByQueryId(String queryId) throws ClientException;
}
