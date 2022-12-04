package com.mms.service.customer;

import com.mms.pojo.dto.customer.request.RegistrationInfo;
import com.mms.pojo.dto.customer.response.RegistrationInfoResponse;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface CustomerManagerIF {

    /**
     * This method is used to register the customers
     * @param registrationInfo : this method will take this request payload to process for the registration
     * @return the registration details whether registration is successfull or not
     */
    public RegistrationInfoResponse doCustomerRegistration(RegistrationInfo registrationInfo);
}
