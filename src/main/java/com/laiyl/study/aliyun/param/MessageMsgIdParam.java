package com.laiyl.study.aliyun.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Data
public class MessageMsgIdParam {

    @ApiModelProperty(value = "消息id", required = true)
    private String msgId;
    @ApiModelProperty(value = "消息topic", required = true)
    private String topic;
}
