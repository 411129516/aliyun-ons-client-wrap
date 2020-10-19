package com.laiyl.study.aliyun.param;

import lombok.Data;

import java.util.List;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Data
public class TopicListParam {

    private String topic;

    private List<Tag> tags;
}
