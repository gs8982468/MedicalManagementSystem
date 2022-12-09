package com.mms.pubsub.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class PubSubProperties {

    @Value("${gcp.pubsub.project-id}")
    private String gcpProjectId;

    @Value("${gcp.pubsub.topic.mms}")
    private String mmsTopic;

    @Value("${gcp.pubsub.subscription.customer_reg}")
    private String custRegSubscriber;
}
