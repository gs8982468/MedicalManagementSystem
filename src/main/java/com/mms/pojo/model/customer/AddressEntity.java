package com.mms.pojo.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AddressEntity {
    private CurrentAddressEntity currentAddress;
    private PermanentAddressEntity permanentAddress;
}
