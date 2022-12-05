package com.mms.pojo.model.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.PropertyName;
import lombok.*;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserEntity {
    @Id
    private String documentId;

    @Getter(onMethod_ = @PropertyName("User name"))
    @Setter(onMethod_ = @PropertyName("User name"))
    private String userName;

    @Getter(onMethod_ = @PropertyName("Primary mobile number"))
    @Setter(onMethod_ = @PropertyName("Primary mobile number"))
    private String primaryMobileNumber;

    @Getter(onMethod_ = @PropertyName("Primary email address"))
    @Setter(onMethod_ = @PropertyName("Primary email address"))
    private String primaryEmailAddress;

    @Getter(onMethod_ = @PropertyName("IsUserNameChanged"))
    @Setter(onMethod_ = @PropertyName("IsUserNameChanged"))
    private boolean isUserNameChanged;

    @Getter(onMethod_ = @PropertyName("Registration details"))
    @Setter(onMethod_ = @PropertyName("Registration details"))
    private RegistrationInfoEntity registrationInfo;

    @Getter(onMethod_ = @PropertyName("Login details"))
    @Setter(onMethod_ = @PropertyName("Login details"))
    private LoginDataEntity loginData;

    @Getter(onMethod_ = @PropertyName("Personal details"))
    @Setter(onMethod_ = @PropertyName("Personal details"))
    private PersonalDetailsEntity personalDetails;

    @Getter(onMethod_ = @PropertyName("IsUsersAllDetailsSaved"))
    @Setter(onMethod_ = @PropertyName("IsUsersAllDetailsSaved"))
    private boolean isUsersAllDetailsSaved;
}
