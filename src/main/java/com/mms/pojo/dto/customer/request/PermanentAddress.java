package com.mms.pojo.dto.customer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PermanentAddress {
    private String address1;
    private String address2;
    private String postOffice;
    private String policeStation;
    private String city;
    private String district;
    private String state;
    private String pinCode;
}
