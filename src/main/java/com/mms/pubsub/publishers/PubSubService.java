package com.mms.pubsub.publishers;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public interface PubSubService {
    /**
     * This methos is used to publish message into GCP topic
     * @param projectId : please provide Project id to connect into the gcp account
     * @param topic : please provide topic name to configure the GCP topic path where the data will be published
     * @param payload : please provide the payload. This payload will be published into the topic
     * @param headers : please specify filters name into the headers.
     * @param <T>
     */
    <T> void publishMessageToTopic(String projectId, String topic, T payload, Map<String, String> headers);
}
