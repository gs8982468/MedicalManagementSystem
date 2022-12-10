package com.mms.controller;

import com.mms.config.MockDataRetriever;
import com.mms.constant.ResourceConstant;
import com.mms.constant.UrlConstant;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.repository.Customer.CustomerRegistrationRepository;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

@ActiveProfiles({"integrationTest"})
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class CustomerManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MockDataRetriever mockDataRetriever;

    @Autowired
    private CustomerRegistrationRepository customerRegistrationRepository;

//    @Test
    public void testCustomerRegistration() throws Exception {


        this.mockMvc
                .perform(MockMvcRequestBuilders.post(UrlConstant.CUSTOMER_REGISTRATION_URL)
                        .contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype()))
                        .content(mockDataRetriever.getResponseString(ResourceConstant.CUST_REG_PAYLOAD)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

//    @Test
    public void fetchUserDetailsTest() throws Exception{
        UserEntity existingUserEntity =mockDataRetriever.getResponseObject(ResourceConstant.CUST_FS_COLLECTION, UserEntity.class);
        Mockito.doReturn(existingUserEntity).when(customerRegistrationRepository).findByIndexFields(Mockito.any(Map.class));
//                customerRegistrationRepository.findByIndexFields(fieldValuePair);



        this.mockMvc
                .perform(MockMvcRequestBuilders.get(UrlConstant.FETCH_USER_URL))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
