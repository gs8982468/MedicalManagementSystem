package com.mms.pojo.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.PropertyName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ContactDetailsEntity {
    @Getter(onMethod_ = @PropertyName("Primary phone code"))
    @Setter(onMethod_ = @PropertyName("Primary phone code"))
    private String primaryPhoneCode;

    @Getter(onMethod_ = @PropertyName("Primary mobile number"))
    @Setter(onMethod_ = @PropertyName("Primary mobile number"))
    private String primaryMobileNumber;

    @Getter(onMethod_ = @PropertyName("Secondary phone code"))
    @Setter(onMethod_ = @PropertyName("Secondary phone code"))
    private String secondaryPhoneCode;

    @Getter(onMethod_ = @PropertyName("Secondary mobile number"))
    @Setter(onMethod_ = @PropertyName("Secondary mobile number"))
    private String secondaryMobileNumber;

    @Getter(onMethod_ = @PropertyName("Primary email address"))
    @Setter(onMethod_ = @PropertyName("Primary email address"))
    private String primaryEmailAddress;

    @Getter(onMethod_ = @PropertyName("Secondary email address"))
    @Setter(onMethod_ = @PropertyName("Secondary email address"))
    private String secondaryEmailAddress;
}
