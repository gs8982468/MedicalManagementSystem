package com.mms.pojo.dto.customer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Address {
    private CurrentAddress currentAddress;
    private PermanentAddress permanentAddress;
}
