package com.mms.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ErrorResponseMessages {
    @JsonProperty("Error Code")
    private String errorCode;

    @JsonProperty("Error Message")
    private String errorMessage;
}
