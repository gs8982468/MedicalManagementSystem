package com.mms.pojo.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoginDataEntity {
    private String userName;
    private String previousUserName;
    private boolean isUserActive;
    private boolean isUserLocked;

    private String currentPassword;
    private boolean isPasswordChange;
    private String previousPassword;
    private String lastPasswordChangeDate;
    private boolean isPasswordExpired;
}
