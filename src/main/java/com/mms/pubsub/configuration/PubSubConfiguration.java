package com.mms.pubsub.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.core.publisher.PubSubPublisherTemplate;
import com.google.cloud.spring.pubsub.core.subscriber.PubSubSubscriberTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubMessageSource;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import com.google.cloud.spring.pubsub.support.converter.SimplePubSubMessageConverter;
import com.google.pubsub.v1.ProjectSubscriptionName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class PubSubConfiguration {

    private final PubSubProperties pubSubProperties;

    @Bean
    public JacksonPubSubMessageConverter jacksonPubSubMessageConverter(ObjectMapper objectMapper) {
        return new JacksonPubSubMessageConverter(objectMapper);
    }

    @Bean
    public PubSubTemplate simplPubSubTemplate(PubSubPublisherTemplate pubSubPublisherTemplate, PubSubSubscriberTemplate pubSubSubscriberTemplate) {
        PubSubTemplate simplePubSubTemplate = new PubSubTemplate(pubSubPublisherTemplate, pubSubSubscriberTemplate);
        simplePubSubTemplate.setMessageConverter(new SimplePubSubMessageConverter());
        return simplePubSubTemplate;
    }

  /*  @Bean
    public PubSubTemplate jacksonPubSubTemplate(PubSubPublisherTemplate pubSubPublisherTemplate, PubSubSubscriberTemplate pubSubSubscriberTemplate, JacksonPubSubMessageConverter jacksonPubSubMessageConverter) {
        PubSubTemplate jacksonPubSubTemplate = new PubSubTemplate(pubSubPublisherTemplate, pubSubSubscriberTemplate);
        jacksonPubSubTemplate.setMessageConverter(jacksonPubSubMessageConverter);
        return jacksonPubSubTemplate;
    }*/

    @Bean
    public MessageChannel customerRegChannel() {
        return new DirectChannel();
    }

    @Bean
//    @InboundChannelAdapter(channel = "customerRegChannel", poller = @Poller(fixedDelay = "100"))
    public MessageSource<Object> statusMessageChannelAdapter(PubSubTemplate simplePubSubTemplate) {
        final String subscriptionName = ProjectSubscriptionName
                .format(pubSubProperties.getGcpProjectId(), pubSubProperties.getCustRegSubscriber());
        PubSubMessageSource messageSource = new PubSubMessageSource(simplePubSubTemplate, subscriptionName);
        messageSource.setAckMode(AckMode.MANUAL);
        messageSource.setBlockOnPull(true);
        messageSource.setMaxFetchSize(100);
        return messageSource;
    }
}
