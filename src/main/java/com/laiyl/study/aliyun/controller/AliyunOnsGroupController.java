package com.laiyl.study.aliyun.controller;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsGroupListResponse;
import com.aliyuncs.ons.model.v20190214.OnsGroupSubDetailResponse;
import com.laiyl.study.aliyun.common.Result;
import com.laiyl.study.aliyun.param.GroupListParam;
import com.laiyl.study.aliyun.service.GroupService;
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
@Api(tags = "groupId 相关接口")
@Slf4j
@RestController
public class AliyunOnsGroupController {

    @Resource
    private GroupService groupService;

    @ApiOperation("查询groupId列表")
    @GetMapping("/api/aliyun/queryGroupList")
    public Result<OnsGroupListResponse> queryGroupList(GroupListParam param) {
        try {
            return Result.success(groupService.queryGroupList(param));
        } catch (ClientException e) {
            log.error("查询groupId列表失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }

    @ApiOperation("根据groupId 查询订阅详情")
    @GetMapping("/api/aliyun/queryGroupSubDetail")
    public Result<OnsGroupSubDetailResponse> queryGroupSubDetail(String groupId) {
        try {
            return Result.success(groupService.queryGroupSubDetail(groupId));
        } catch (ClientException e) {
            log.error("根据groupId 查询订阅详情失败，errorMsg = 【{}】", e.getErrMsg());
            return Result.fail(e.getErrCode(), e.getErrMsg());
        }
    }
}
