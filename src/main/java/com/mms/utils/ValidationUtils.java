package com.mms.utils;

import com.mms.pojo.dto.ErrorResponseMessages;
import com.mms.pojo.dto.customer.request.RegistrationInfo;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.repository.Customer.CustomerRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class ValidationUtils {
    private final CustomerRegistrationRepository customerRegistrationRepository;

    public void validateRegistrationDetails(List<ErrorResponseMessages> errorResponseMessages, RegistrationInfo registrationInfoRequest) {
        validateUserExistancy(registrationInfoRequest, errorResponseMessages);
        validateMobileNumberExistancy(registrationInfoRequest, errorResponseMessages);
        validateEmailIdExistancy(registrationInfoRequest, errorResponseMessages);
        validatePassword(errorResponseMessages, registrationInfoRequest);
        addMailValidationError(errorResponseMessages, registrationInfoRequest);
        addPhoneValidationError(errorResponseMessages, registrationInfoRequest);
        addUserNameValidation(errorResponseMessages, registrationInfoRequest);

    }

    private void validateMobileNumberExistancy(RegistrationInfo registrationInfoRequest, List<ErrorResponseMessages> errorResponseMessages) {
        Map<String, Object> fieldValuePair = new HashMap<>();
        fieldValuePair.put("Primary mobile number", registrationInfoRequest.getMobileNumber());
//            fieldValuePair.put("");
        UserEntity existingUserEntity = customerRegistrationRepository.findByIndexFields(fieldValuePair);
        if(null != existingUserEntity){
            errorResponseMessages.add(
                    ErrorResponseMessages.builder()
                            .errorCode("U-102")
                            .errorMessage("This mobile number ("+ registrationInfoRequest.getMobileNumber()+") is already associated with the following username : "+ existingUserEntity.getUserName())
                            .build());
        }
    }

    private void validateEmailIdExistancy(RegistrationInfo registrationInfoRequest, List<ErrorResponseMessages> errorResponseMessages) {
        Map<String, Object> fieldValuePair = new HashMap<>();
        fieldValuePair.put("Primary email address", registrationInfoRequest.getEmailAddress());
//            fieldValuePair.put("");
        UserEntity existingUserEntity = customerRegistrationRepository.findByIndexFields(fieldValuePair);
        if(null != existingUserEntity){
            errorResponseMessages.add(
                    ErrorResponseMessages.builder()
                            .errorCode("U-102")
                            .errorMessage("This mail id ("+ registrationInfoRequest.getEmailAddress()+") is already associated with the following username : "+ existingUserEntity.getUserName())
                            .build());
        }
    }

    private void validateUserExistancy(RegistrationInfo registrationInfoRequest, List<ErrorResponseMessages> errorResponseMessages) {
        Map<String, Object> fieldValuePair = new HashMap<>();
        fieldValuePair.put("User name", registrationInfoRequest.getUserName());
//            fieldValuePair.put("");
        UserEntity existingUserEntity = customerRegistrationRepository.findByIndexFields(fieldValuePair);
        if(null != existingUserEntity){
            errorResponseMessages.add(
                    ErrorResponseMessages.builder()
                            .errorCode("U-102")
                            .errorMessage("This user ("+registrationInfoRequest.getUserName()+") already registered")
                            .build());
        }
    }

    private void validatePassword(List<ErrorResponseMessages> errorResponseMessages, RegistrationInfo registrationInfoRequest) {
        if(null == registrationInfoRequest.getPassword() || null == registrationInfoRequest.getConfirmPassword()){
            errorResponseMessages.add(
                    ErrorResponseMessages.builder()
                            .errorCode("U-106")
                            .errorMessage("Password or confirm password field is empty")
                            .build());
        }else{
            if(!registrationInfoRequest.getPassword().equals(registrationInfoRequest.getConfirmPassword())){
                errorResponseMessages.add(
                        ErrorResponseMessages.builder()
                                .errorCode("U-107")
                                .errorMessage("Password not matched")
                                .build());
            }
        }
    }


    private void addMailValidationError(List<ErrorResponseMessages> errorResponseMessages, RegistrationInfo registrationInfoRequest) {
        boolean isMailValid = emailValidation(registrationInfoRequest.getEmailAddress());
        if (!isMailValid) {
            errorResponseMessages.add(
                    ErrorResponseMessages.builder()
                            .errorCode("U-101")
                            .errorMessage("Invalid email Address")
                            .build());

        }
    }

    public void addPhoneValidationError(List<ErrorResponseMessages> errorResponseMessages, RegistrationInfo registrationInfoRequest) {
        addPhoneCodeValidation(errorResponseMessages, registrationInfoRequest);
        addMobileNumberValidation(errorResponseMessages, registrationInfoRequest);
    }

    private static void addMobileNumberValidation(List<ErrorResponseMessages> errorResponseMessages, RegistrationInfo registrationInfoRequest) {
        if (null == registrationInfoRequest.getMobileNumber()) {
            errorResponseMessages.add(
                    ErrorResponseMessages.builder()
                            .errorCode("PEC-103")
                            .errorMessage("please enter mobile number")
                            .build());
        } else {
            if (registrationInfoRequest.getMobileNumber().length() <10 ) {
                errorResponseMessages.add(
                        ErrorResponseMessages.builder()
                                .errorCode("PEC-104")
                                .errorMessage("Mobile number length can not be less that 10")
                                .build());
            }
            if (registrationInfoRequest.getMobileNumber().length() > 10 ) {
                errorResponseMessages.add(
                        ErrorResponseMessages.builder()
                                .errorCode("PEC-104")
                                .errorMessage("Mobile number length can not be more that 10")
                                .build());
            }
        }
    }

    private static void addPhoneCodeValidation(List<ErrorResponseMessages> errorResponseMessages, RegistrationInfo registrationInfoRequest) {
        if (null == registrationInfoRequest.getPhoneCode()) {
            errorResponseMessages.add(
                    ErrorResponseMessages.builder()
                            .errorCode("PEC- 101")
                            .errorMessage("Please enter phone code")
                            .build());
        } else {
            if (!registrationInfoRequest.getPhoneCode().equals("+91")) {
                errorResponseMessages.add(
                        ErrorResponseMessages.builder()
                                .errorCode("PEC-102")
                                .errorMessage("Only indian user is allowed to register")
                                .build());
            }
        }
    }

    private void addUserNameValidation(List<ErrorResponseMessages> errorResponseMessages, RegistrationInfo registrationInfoRequest) {
       if(null == registrationInfoRequest.getUserName()){
           errorResponseMessages.add(
                   ErrorResponseMessages.builder()
                           .errorCode("U-103")
                           .errorMessage("Please enter an username")
                           .build());
       }else{
           if(registrationInfoRequest.getUserName().contains(" ")){
               errorResponseMessages.add(
                       ErrorResponseMessages.builder()
                               .errorCode("U-102")
                               .errorMessage("User name shouldn't contains space")
                               .build());
           }
       }
    }


    private boolean emailValidation(String emailAddress){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(emailAddress);
        return pattern.matcher(emailAddress).matches();

    }


}
