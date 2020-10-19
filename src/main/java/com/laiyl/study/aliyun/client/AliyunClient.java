package com.laiyl.study.aliyun.client;

import com.aliyuncs.AcsRequest;
import com.aliyuncs.AcsResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.laiyl.study.aliyun.properties.AliyunProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Component
public class AliyunClient implements InitializingBean {

    @Autowired
    private AliyunProperties aliyunProperties;

    private IAcsClient client;

    public <T extends AcsResponse> String getAcsResponse(AcsRequest<T> request) throws ClientException {
        T acsResponse = client.getAcsResponse(request);
        return new Gson().toJson(acsResponse);
    }

    public <T extends AcsResponse> T getAcsResponseEntity(AcsRequest<T> request) throws ClientException {
        return client.getAcsResponse(request);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (client == null) {
            DefaultProfile profile = DefaultProfile.getProfile(aliyunProperties.getRegionId(), aliyunProperties.getAccessKey(), aliyunProperties.getAccessSecret());
            client = new DefaultAcsClient(profile);
        }
    }

}
