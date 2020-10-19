package com.laiyl.study.aliyun.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Data
public class MessageTraceByMsgIdParam {

    @ApiModelProperty(value = "开始时间", required = true)
    private String beginTime;
    @ApiModelProperty(value = "结束时间", required = true)
    private String endTime;
    @ApiModelProperty(value = "消息id", required = true)
    private String msgId;
    @ApiModelProperty(value = "消息主题", required = true)
    private String topic;
}
