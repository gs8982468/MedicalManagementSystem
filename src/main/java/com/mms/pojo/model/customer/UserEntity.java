package com.mms.pojo.model.customer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserEntity {
    @Id
    private String documentId;
    private String userName;
    private boolean isUserNameChanged;
    private RegistrationInfoEntity registrationInfo;
    private LoginDataEntity loginData;
    private PersonalDetailsEntity personalDetails;
    private boolean isUsersAllDetailsSaved;
}
