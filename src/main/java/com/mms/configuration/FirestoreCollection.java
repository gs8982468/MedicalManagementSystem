package com.mms.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Delegate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//@Configuration
@Getter
@AllArgsConstructor
@Validated
@ConstructorBinding
@ConfigurationProperties(prefix = "gcp.firestore.collections")
public class FirestoreCollection {
    private static final String slash="/";

    @Valid
    @NotNull
    @Delegate
    private final Parent parent;

    @Getter
    public static class Parent{



        @NotBlank
        private final String prefix;

        @NotBlank
        private final String customerLoginData;


        public Parent(String prefix, String customerLoginData) {
            this.prefix = prefix;
            this.customerLoginData = prefix.concat(slash).concat(customerLoginData);
        }
    }


}
