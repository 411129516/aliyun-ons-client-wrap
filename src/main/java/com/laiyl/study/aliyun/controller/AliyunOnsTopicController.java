package com.laiyl.study.aliyun.controller;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsTopicListResponse;
import com.aliyuncs.ons.model.v20190214.OnsTopicSubDetailResponse;
import com.laiyl.study.aliyun.common.Result;
import com.laiyl.study.aliyun.param.TopicListParam;
import com.laiyl.study.aliyun.service.TopicService;
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
@Api(tags = "topic 相关接口")
@Slf4j
@RestController
public class AliyunOnsTopicController {

    @Resource
    private TopicService topicService;

    @ApiOperation("根据条件查询所有topic列表")
    @GetMapping("/api/aliyun/queryTopicList")
    public Result<OnsTopicListResponse> queryTopicList(TopicListParam param) {
        try {
            return Result.success(topicService.queryTopicList(param));
        } catch (ClientException e) {
            log.error("根据条件查询所有topic列表失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }

    @ApiOperation("根据topic查询订阅详情")
    @GetMapping("/api/aliyun/queryTopicSubDetail")
    public Result<OnsTopicSubDetailResponse> queryTopicSubDetail(String topic) {
        try {
            return Result.success(topicService.queryTopicSubDetail(topic));
        } catch (ClientException e) {
            log.error("根据topic查询订阅详情失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }
}
