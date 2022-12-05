package com.mms.pojo.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PersonalDetailsEntity {
    private String firstName;
    private String lastName;
    private int age;
    private String dob;

    private AddressEntity address;
    private ContactDetailsEntity contactDetails;
}
