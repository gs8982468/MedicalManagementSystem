package com.mms;

import com.mms.configuration.FirestoreCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({FirestoreCollection.class})
@SpringBootApplication
public class MedicalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalManagementSystemApplication.class, args);
	}

}
