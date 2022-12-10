package com.mms.configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(new JavaTimeModule())
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.setDefaultPropertyInclusion(Include.NON_NULL);
	}

	
	/*	@Bean
	public JacksonPubSubMessageConverter jacksonPubSubMessageConverter() {
		return new JacksonPubSubMessageConverter(new ObjectMapper());
	}
	*/
	
	/*	@Bean
	public PubSubTemplate simplePubSubTemplate(PubSubPublisherTemplate pubSubPublisherTemplate,
			PubSubSubscriberTemplate pubSubSubscriberTemplate) {
		PubSubTemplate simplePubSubTemplate = new PubSubTemplate(pubSubPublisherTemplate, pubSubSubscriberTemplate);
		simplePubSubTemplate.setMessageConverter(new SimplePubSubMessageConverter());
		return simplePubSubTemplate;
	}

	@Bean
	public PubSubTemplate jacksonPubSubTemplate(PubSubPublisherTemplate pubSubPublisherTemplate,
			PubSubSubscriberTemplate pubSubSubscriberTemplate,
			JacksonPubSubMessageConverter jacksonPubSubMessageConverter) {
		PubSubTemplate jacksonPubSubTemplate = new PubSubTemplate(pubSubPublisherTemplate, pubSubSubscriberTemplate);
		jacksonPubSubTemplate.setMessageConverter(jacksonPubSubMessageConverter);
		return jacksonPubSubTemplate;
	}
	*/

}
