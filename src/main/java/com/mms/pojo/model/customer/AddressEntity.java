package com.mms.pojo.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.PropertyName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AddressEntity {
    @Getter(onMethod_ = @PropertyName("Current address"))
    @Setter(onMethod_ = @PropertyName("Current address"))
    private CurrentAddressEntity currentAddress;

    @Getter(onMethod_ =  @PropertyName("Permanent address"))
    @Setter(onMethod_ =  @PropertyName("Permanent address"))
    private PermanentAddressEntity permanentAddress;
}
