package com.laiyl.study.aliyun.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Data
public class GroupListParam {

    @ApiModelProperty(value = "GID", required = true)
    private String groupId;
    @ApiModelProperty("tags")
    private List<Tag> tags;
}
