package com.laiyl.study.aliyun.controller;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsMessageGetByKeyResponse;
import com.aliyuncs.ons.model.v20190214.OnsMessageGetByMsgIdResponse;
import com.aliyuncs.ons.model.v20190214.OnsMessagePageQueryByTopicResponse;
import com.aliyuncs.ons.model.v20190214.OnsMessageTraceResponse;
import com.laiyl.study.aliyun.common.Result;
import com.laiyl.study.aliyun.param.MessageKeyParam;
import com.laiyl.study.aliyun.param.MessageMsgIdParam;
import com.laiyl.study.aliyun.param.MessagePageParam;
import com.laiyl.study.aliyun.service.AliyunOnsService;
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
@Slf4j
@RestController
@Api(tags = "消息相关接口")
public class AliyunOnsMessageController {

    @Resource
    private AliyunOnsService aliyunOnsService;

    @ApiOperation("根据message key 查询消息")
    @GetMapping("/api/aliyun/getMessageByKey")
    public Result<OnsMessageGetByKeyResponse> getMessageByKey(MessageKeyParam param) {
        try {
            return Result.success(aliyunOnsService.getMessageByKey(param));
        } catch (ClientException e) {
            log.error("根据key查询消息失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }

    @ApiOperation("根据message id 查询消息")
    @GetMapping("/api/aliyun/getMessageByMsgId")
    public Result<OnsMessageGetByMsgIdResponse> getMessageByMsgId(MessageMsgIdParam param) {
        try {
            return Result.success(aliyunOnsService.getMessageByMsgId(param));
        } catch (ClientException e) {
            log.error("根据msgId查询消息失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }

    @ApiOperation("分页查询消息")
    @GetMapping("/api/aliyun/queryMessagePage")
    public Result<OnsMessagePageQueryByTopicResponse> queryMessagePage(MessagePageParam param) {
        try {
            return Result.success(aliyunOnsService.queryMessageByPage(param));
        } catch (ClientException e) {
            log.error("分页查询消息失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }

    @ApiOperation("根据message id 查询消息轨迹")
    @GetMapping("/api/aliyun/queryMessageTrace")
    public Result<OnsMessageTraceResponse> queryMessageTrace(MessageMsgIdParam param) {
        try {
            return Result.success(aliyunOnsService.queryMessageTrace(param));
        } catch (ClientException e) {
            log.error("根据msgId查询消息轨迹失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }
}
