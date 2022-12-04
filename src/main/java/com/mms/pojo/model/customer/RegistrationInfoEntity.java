package com.mms.pojo.model.customer;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegistrationInfoEntity {
    private String emailAddress;
    private String mobileNumber;
    private String password;
    private String registrationDate;
}
