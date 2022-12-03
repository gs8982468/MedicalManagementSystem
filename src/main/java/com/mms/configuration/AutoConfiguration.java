package com.mms.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EntityScan(basePackageClasses = { Book.class })
@EnableAutoConfiguration
@ConditionalOnProperty(value = "spring.cloud.gcp.firestore.enabled", matchIfMissing = true)
public class AutoConfiguration {

}
