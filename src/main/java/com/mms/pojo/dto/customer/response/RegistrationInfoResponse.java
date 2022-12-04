package com.mms.pojo.dto.customer.response;

import com.mms.pojo.dto.ErrorResponseMessages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegistrationInfoResponse {
    private String registrationStatus;
    private boolean isEmailSentWithLoginDetails;
    private String createdDate;
    private boolean isRegistrationSuccessful;
    private List<ErrorResponseMessages> errorResponseMessages;
}
