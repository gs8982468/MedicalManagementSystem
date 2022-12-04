package com.mms.pojo.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ContactDetailsEntity {
    private String primaryPhoneCode;
    private String primaryMobileNumber;

    private String secondaryPhoneCode;
    private String secondaryMobileNumber;

    private String primaryEmailAddress;
    private String secondaryEmailAddress;
}
