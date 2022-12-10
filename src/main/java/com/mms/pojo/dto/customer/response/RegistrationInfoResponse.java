package com.mms.pojo.dto.customer.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("Registration status")
    private String registrationStatus;

    @JsonProperty("IsEmailSentWithLoginDetails")
    private boolean isEmailSentWithLoginDetails;

    @JsonProperty("Creation date")
    private String createdDate;

    @JsonProperty("IsRegistrationSuccessful")
    private boolean isRegistrationSuccessful;

    @JsonProperty("Error Messages")
    private List<ErrorResponseMessages> errorResponseMessages;
}
