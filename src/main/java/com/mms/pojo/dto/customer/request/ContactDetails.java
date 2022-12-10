package com.mms.pojo.dto.customer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ContactDetails {
    private String primaryPhoneCode;
    private String primaryMobileNumber;

    private String secondaryPhoneCode;
    private String secondaryMobileNumber;

    private String primaryEmailAddress;
    private String secondaryEmailAddress;
}
