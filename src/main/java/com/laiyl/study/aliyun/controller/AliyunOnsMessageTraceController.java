package com.laiyl.study.aliyun.controller;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsTraceGetResultResponse;
import com.aliyuncs.ons.model.v20190214.OnsTraceQueryByMsgIdResponse;
import com.aliyuncs.ons.model.v20190214.OnsTraceQueryByMsgKeyResponse;
import com.laiyl.study.aliyun.common.Result;
import com.laiyl.study.aliyun.param.MessageTraceByKeyParam;
import com.laiyl.study.aliyun.param.MessageTraceByMsgIdParam;
import com.laiyl.study.aliyun.service.MessageTraceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Api(tags = "消息轨迹相关接口")
@Slf4j
@RestController
public class AliyunOnsMessageTraceController {

    @Resource
    private MessageTraceService messageTraceService;

    @ApiOperation("根据message key 查询消息轨迹")
    @GetMapping("/api/aliyun/queryTraceByMsgKey")
    public Result<OnsTraceQueryByMsgKeyResponse> queryTraceByMsgKey(MessageTraceByKeyParam param) {
        try {
            return Result.success(messageTraceService.queryTraceByMsgKey(param));
        } catch (ClientException e) {
            log.error("根据key查询消息轨迹失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }

    @ApiOperation("根据message id 查询消息轨迹")
    @GetMapping("/api/aliyun/queryTraceByMsgId")
    public Result<OnsTraceQueryByMsgIdResponse> queryTraceByMsgId(MessageTraceByMsgIdParam param) {
        try {
            return Result.success(messageTraceService.queryTraceByMsgId(param));
        } catch (ClientException e) {
            log.error("根据msgId查询消息轨迹失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }

    @ApiOperation("根据queryId查询消息轨迹")
    @GetMapping("/api/aliyun/queryTraceByQueryId")
    public Result<OnsTraceGetResultResponse> queryTraceByQueryId(String queryId) {
        try {
            return Result.success(messageTraceService.queryTraceByQueryId(queryId));
        } catch (ClientException e) {
            log.error("根据queryId查询消息轨迹失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }

}
