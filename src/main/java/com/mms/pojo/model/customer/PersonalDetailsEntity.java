package com.mms.pojo.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.PropertyName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PersonalDetailsEntity {
    @Getter(onMethod_ = @PropertyName("First name"))
    @Setter(onMethod_ = @PropertyName("First name"))
    private String firstName;

    @Getter(onMethod_ = @PropertyName("Last name"))
    @Setter(onMethod_ = @PropertyName("Last name"))
    private String lastName;

    @Getter(onMethod_ = @PropertyName("Age"))
    @Setter(onMethod_ = @PropertyName("Age"))
    private int age;

    @Getter(onMethod_ = @PropertyName("Date of birth"))
    @Setter(onMethod_ = @PropertyName("Date of birth"))
    private String dob;

    @Getter(onMethod_ = @PropertyName("Address details"))
    @Setter(onMethod_ = @PropertyName("Address details"))
    private AddressEntity address;

    @Getter(onMethod_ = @PropertyName("Contact details"))
    @Setter(onMethod_ = @PropertyName("Contact details"))
    private ContactDetailsEntity contactDetails;
}
