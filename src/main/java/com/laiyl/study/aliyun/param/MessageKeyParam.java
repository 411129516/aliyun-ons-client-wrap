package com.laiyl.study.aliyun.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Data
public class MessageKeyParam {

    @ApiModelProperty(value = "消息topic", required = true)
    private String topic;
    @ApiModelProperty(value = "消息key", required = true)
    private String key;

}
