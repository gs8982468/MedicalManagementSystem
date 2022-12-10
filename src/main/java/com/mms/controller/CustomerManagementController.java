package com.mms.controller;

import com.google.cloud.firestore.Firestore;
import com.mms.pojo.dto.customer.request.RegistrationInfo;
import com.mms.pojo.dto.customer.response.RegistrationInfoResponse;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.service.customer.CustomerManagerIF;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/mms-portal/medicalManagementSystem/v1/customer")
public class CustomerManagementController {
    private static final String BOOKS = "books";

    @Autowired
    private CustomerManagerIF customerManagerIF;


    @Autowired
    Firestore firestore;

    /**
     * This method is used to register the customers
     * @param registrationInfo : this method will take this request payload to process for the registration
     * @return the registration details whether registration is successfull or not
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public RegistrationInfoResponse customerRegistration(@RequestBody RegistrationInfo registrationInfo){
        return customerManagerIF.doCustomerRegistration(registrationInfo);
    }



    //will be deleted later

    @RequestMapping(value = "/fetchUser/{userName}", method = RequestMethod.GET)

    public UserEntity fetchUserDetails(@PathVariable String userName){
        return customerManagerIF.fetchUserDetails(userName);
    }

}
