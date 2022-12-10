package com.mms.pojo.model.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.PropertyName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CurrentAddressEntity {
    @Getter(onMethod_ = @PropertyName("Address 1"))
    @Setter(onMethod_ = @PropertyName("Address 1"))
    private String address1;

    @Getter(onMethod_ = @PropertyName("Address 2"))
    @Setter(onMethod_ = @PropertyName("Address 2"))
    private String address2;

    @Getter(onMethod_ = @PropertyName("Post office"))
    @Setter(onMethod_ = @PropertyName("Post office"))
    private String postOffice;

    @Getter(onMethod_ = @PropertyName("Police station"))
    @Setter(onMethod_ = @PropertyName("Police station"))
    private String policeStation;

    @Getter(onMethod_ = @PropertyName("City"))
    @Setter(onMethod_ = @PropertyName("City"))
    private String city;

    @Getter(onMethod_ = @PropertyName("District"))
    @Setter(onMethod_ = @PropertyName("District"))
    private String district;

    @Getter(onMethod_ = @PropertyName("State"))
    @Setter(onMethod_ = @PropertyName("State"))
    private String state;

    @Getter(onMethod_ = @PropertyName("Pin code"))
    @Setter(onMethod_ = @PropertyName("Pin code"))
    private String pinCode;
}
