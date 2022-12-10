package com.mms.pojo.model.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.PropertyName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegistrationInfoEntity {
    @Getter(onMethod_ = @PropertyName("Email address"))
    @Setter(onMethod_ = @PropertyName("Email address"))
    private String emailAddress;

    @Getter(onMethod_ = @PropertyName("Mobile number"))
    @Setter(onMethod_ = @PropertyName("Mobile number"))
    private String mobileNumber;

    @Getter(onMethod_ = @PropertyName("Password"))
    @Setter(onMethod_ = @PropertyName("Password"))
    private String password;

    @Getter(onMethod_ = @PropertyName("Registration date"))
    @Setter(onMethod_ = @PropertyName("Registration date"))
    private String registrationDate;

    @Getter(onMethod_ = @PropertyName("User name"))
    @Setter(onMethod_ = @PropertyName("User name"))
    private String userName;
}
