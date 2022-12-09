package com.mms.pubsub.publishers;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

//@MessagingGateway(name="myPubSubGateway", defaultRequestChannel = "outboundMsgChanel")
@Service
public class PubSubServiceImpl implements PubSubService {

	@Autowired
	private JacksonPubSubMessageConverter jacksonPubSubMessageConverte;
	
	@Autowired
	private PubSubTemplate pubSubTemplate;


	@Override
	public <T> void publishMessageToTopic(String projectId, String topic, T payload, Map<String, String> headers) {
		String topicName= ProjectTopicName.format(projectId, topic);
//		headers.putIfAbsent("","");//needs to be configured
		PubsubMessage pubSubMessage = jacksonPubSubMessageConverte.toPubSubMessage(payload, headers);
		pubSubTemplate.publish(topicName, pubSubMessage);
	}

}
