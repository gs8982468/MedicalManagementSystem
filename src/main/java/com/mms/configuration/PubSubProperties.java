package com.mms.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class PubSubProperties {

    @Value("${gcp.pubsub.project-id}")
    private String gcpProjectId;

    @Value("${gcp.pubsub.topic.costomer_reg}")
    private String custRegTopic;
}
