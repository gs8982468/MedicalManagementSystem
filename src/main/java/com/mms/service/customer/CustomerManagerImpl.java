package com.mms.service.customer;

import com.mms.mapper.customer.CustomerMapper;
import com.mms.pojo.dto.ErrorResponseMessages;
import com.mms.pojo.dto.customer.request.RegistrationInfo;
import com.mms.pojo.dto.customer.response.RegistrationInfoResponse;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.pubsub.configuration.PubSubProperties;
import com.mms.pubsub.publishers.PubSubService;
import com.mms.repository.Customer.CustomerRegistrationRepository;
import com.mms.utils.MailSendService;
import com.mms.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerManagerImpl implements CustomerManagerIF {
    private final CustomerRegistrationRepository customerRegistrationRepository;

    @Autowired
    private ValidationUtils validationUtils;

    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private PubSubService pubSubService;

    @Autowired
    private PubSubProperties pubSubProperties;

    @Override
    public RegistrationInfoResponse doCustomerRegistration(RegistrationInfo registrationInfoRequest) {
        String registrationDate = getCurrentDate();
        boolean isEmailSentWithLoginDetails = false;
        boolean isRegistrationSuccessful = false;
        List<ErrorResponseMessages> errorResponseMessages = new ArrayList<>();
        if (!Objects.isNull(registrationInfoRequest)) {
            validationUtils.validateRegistrationDetails(errorResponseMessages, registrationInfoRequest);

            //save user details to firestore
            if (CollectionUtils.isEmpty(errorResponseMessages)) {
                UserEntity userEntity = CustomerMapper.INSTANCE.mapRegistrationDetailsToUserEntity(registrationInfoRequest);
                userEntity.getRegistrationInfo().setRegistrationDate(registrationDate);
                customerRegistrationRepository.saveOrUpdate(userEntity);

                isRegistrationSuccessful = true;
                pubSubService.publishMessageToTopic(
                        pubSubProperties.getGcpProjectId(), pubSubProperties.getMmsTopic(),
                        userEntity, getHeaders("CustomerRegistration"));

//            implementation to sent mail
                try{
//                    pubSubService.publishMessageToTopic(pubSubProperties.getGcpProjectId(), pubSubProperties.getMmsTopic(), userEntity, getHeaders("CustomerRegistration"));
                    mailSendService.sendSimpleEmail(userEntity.getPrimaryEmailAddress(),"Welcome to Medical Management System", "Hi "+registrationInfoRequest.getFirstName()+",\n\n Thank you for registration in our portal.\n\nyour mail id is not yet verified. Please click the below link for verification. \n http://localhost:80/internal/mms-portal/medicalManagementSystem/v1/customer/mail/verification \n \nThanks & Regards,\nSubhankar's Team");
//                    isEmailSentWithLoginDetails= true;
                }catch(Exception ex){
                    log.info("Mail sent failed");
                }
            } else {
                return RegistrationInfoResponse.builder()
                        .isRegistrationSuccessful(isRegistrationSuccessful)
                        .registrationStatus(isRegistrationSuccessful ? "SUCCESS" : "FAILED")
                        .errorResponseMessages(errorResponseMessages)
                        .build();
            }
        }
        return RegistrationInfoResponse.builder()
                .isRegistrationSuccessful(isRegistrationSuccessful)
                .registrationStatus(isRegistrationSuccessful ? "SUCCESS" : "FAILED")
                .createdDate(isRegistrationSuccessful ? registrationDate : null)
                .isEmailSentWithLoginDetails(isEmailSentWithLoginDetails)
                .build();
    }

    private Map<String, String> getHeaders(String purpose){
        Map<String, String> headers= new HashMap<>();
        headers.put("purpose", purpose);
        return headers;
    }


    private void validateUserExistancy(RegistrationInfo registrationInfoRequest, List<ErrorResponseMessages> errorResponseMessages) {
        Map<String, Object> fieldValuePair = new HashMap<>();
        fieldValuePair.put("userName", registrationInfoRequest.getUserName());
//            fieldValuePair.put("");
        UserEntity existingUserEntity = customerRegistrationRepository.findByIndexFields(fieldValuePair);
        if(null != existingUserEntity){
            errorResponseMessages.add(
                    ErrorResponseMessages.builder()
                            .errorCode("U-102")
                            .errorMessage("User already registered")
                            .build());
        }
    }


    private static String calculateOfferExpireDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 7);
        String offerExipreDate = sdf.format(c.getTime());
        return offerExipreDate;
    }

    private static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        String currentDate = sdf.format(c.getTime());
        return currentDate;
    }


    @Override
    public UserEntity fetchUserDetails(String userName){
        Map<String, Object> fieldValuePair = new HashMap<>();
        fieldValuePair.put("User name", userName);
//            fieldValuePair.put("");
        UserEntity existingUserEntity = customerRegistrationRepository.findByIndexFields(fieldValuePair);

        return existingUserEntity;
    }
}
