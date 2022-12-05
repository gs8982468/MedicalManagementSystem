package com.mms.pojo.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.PropertyName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoginDataEntity {
    @Getter(onMethod_ = @PropertyName("User name"))
    @Setter(onMethod_ = @PropertyName("User name"))
    private String userName;

    @Getter(onMethod_ = @PropertyName("Previous user name"))
    @Setter(onMethod_ = @PropertyName("Previous user name"))
    private String previousUserName;

    @Getter(onMethod_ = @PropertyName("IsUserActive"))
    @Setter(onMethod_ = @PropertyName("IsUserActive"))
    private boolean isUserActive;

    @Getter(onMethod_ = @PropertyName("IsUserLocked"))
    @Setter(onMethod_ = @PropertyName("IsUserLocked"))
    private boolean isUserLocked;

    @Getter(onMethod_ = @PropertyName("Current password"))
    @Setter(onMethod_ = @PropertyName("Current password"))
    private String currentPassword;

    @Getter(onMethod_ = @PropertyName("IsPasswordChange"))
    @Setter(onMethod_ = @PropertyName("IsPasswordChange"))
    private boolean isPasswordChange;

    @Getter(onMethod_ = @PropertyName("Previous password"))
    @Setter(onMethod_ = @PropertyName("Previous password"))
    private String previousPassword;

    @Getter(onMethod_ = @PropertyName("Last password change date"))
    @Setter(onMethod_ = @PropertyName("Last password change date"))
    private String lastPasswordChangeDate;

    @Getter(onMethod_ = @PropertyName("IsPasswordExpired"))
    @Setter(onMethod_ = @PropertyName("IsPasswordExpired"))
    private boolean isPasswordExpired;
}
