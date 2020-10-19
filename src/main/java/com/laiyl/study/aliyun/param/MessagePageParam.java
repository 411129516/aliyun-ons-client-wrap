package com.laiyl.study.aliyun.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Data
public class MessagePageParam {

    @ApiModelProperty(value = "开始时间", required = true)
    private String beginTime;
    @ApiModelProperty(value = "结束时间", required = true)
    private String endTime;
    @ApiModelProperty(value = "当前页号", required = true)
    private Integer currentPage;
    @ApiModelProperty("每页大小")
    private Integer pageSize;
    @ApiModelProperty(value = "消息主题", required = true)
    private String topic;
    @ApiModelProperty("任务id")
    private String taskId;
}
