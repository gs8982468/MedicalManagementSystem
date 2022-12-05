package com.mms.pojo.dto.customer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegistrationInfo {
    private String firstName;
    private String lastName;
    private String userName;

    private String emailAddress;
    private String phoneCode;
    private String mobileNumber;

    private String password;
    private String confirmPassword;
}
