package com.mms.service.customer;

import com.mms.mapper.customer.CustomerMapper;
import com.mms.pojo.dto.ErrorResponseMessages;
import com.mms.pojo.dto.customer.request.RegistrationInfo;
import com.mms.pojo.dto.customer.response.RegistrationInfoResponse;
import com.mms.pojo.model.customer.RegistrationInfoEntity;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.repository.Customer.CustomerRegistrationRepository;
import com.mms.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CustomerManagerImpl implements CustomerManagerIF {
    private final CustomerRegistrationRepository customerRegistrationRepository;

    @Autowired
    private ValidationUtils validationUtils;

    @Override
    public RegistrationInfoResponse doCustomerRegistration(RegistrationInfo registrationInfoRequest) {
        String registrationDate= getCurrentDate();
        boolean isEmailSentWithLoginDetails= false;
        boolean isRegistrationSuccessful = false;
        List<ErrorResponseMessages> errorResponseMessages = new ArrayList<>();
        if(!Objects.isNull(registrationInfoRequest)) {


            //validate registration details
            boolean isMailValid= validationUtils.emailValidation(registrationInfoRequest.getEmailAddress());
            if(!isMailValid){
                errorResponseMessages.add(
                        ErrorResponseMessages.builder()
                        .errorCode("U-101")
                        .errorMessage("Invalid email Address")
                        .build());

            }
            if( CollectionUtils.isEmpty(errorResponseMessages)){


                UserEntity userEntity= CustomerMapper.INSTANCE.mapRegistrationDetailsToUserEntity(registrationInfoRequest);
                userEntity.getRegistrationInfo().setRegistrationDate(registrationDate);
//            customerRegistrationRepository.saveOrUpdate(userEntity);

                isRegistrationSuccessful=true;

//            implementation to sent mail
            }else{
               return  RegistrationInfoResponse.builder()
                        .isRegistrationSuccessful(isRegistrationSuccessful)
                        .registrationStatus(isRegistrationSuccessful? "SUCCESS" : "FAILED")
                        .errorResponseMessages(errorResponseMessages)
                        .build();
            }
        }
        return RegistrationInfoResponse.builder()
                .isRegistrationSuccessful(isRegistrationSuccessful)
                .registrationStatus(isRegistrationSuccessful? "SUCCESS" : "FAILED")
                .createdDate(isRegistrationSuccessful ? registrationDate : null)
                .isEmailSentWithLoginDetails(isEmailSentWithLoginDetails)
                .build();
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
}
