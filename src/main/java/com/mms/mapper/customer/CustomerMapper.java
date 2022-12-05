package com.mms.mapper.customer;

import com.mms.pojo.dto.customer.request.RegistrationInfo;
import com.mms.pojo.model.customer.ContactDetailsEntity;
import com.mms.pojo.model.customer.LoginDataEntity;
import com.mms.pojo.model.customer.PersonalDetailsEntity;
import com.mms.pojo.model.customer.UserEntity;
import lombok.extern.java.Log;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "registrationInfo", source = "registrationInfo")
    @Mapping(target = "personalDetails", source = "registrationInfo", qualifiedByName = "mapRegInfoToPersonalDetails")
    @Mapping(target = "loginData", source = "registrationInfo", qualifiedByName = "mapRegInfoToLoginData")
    UserEntity mapRegistrationDetailsToUserEntity(RegistrationInfo registrationInfo);



    @Named("mapRegInfoToPersonalDetails")
    default PersonalDetailsEntity mapRegInfoToPersonalDetails(RegistrationInfo registrationInfo){
        if (null == registrationInfo){
            return null;
        }
        return PersonalDetailsEntity.builder()
                .firstName(registrationInfo.getFirstName())
                .lastName(registrationInfo.getLastName())
                .contactDetails(ContactDetailsEntity.builder()
                        .primaryEmailAddress(registrationInfo.getEmailAddress())
                        .primaryPhoneCode(registrationInfo.getPhoneCode())
                        .primaryMobileNumber(registrationInfo.getMobileNumber())
                        .build())
                .build();
    }

    @Named("mapRegInfoToLoginData")
    default LoginDataEntity mapRegInfoToLoginData(RegistrationInfo registrationInfo){

        if (null == registrationInfo){
            return null;
        }
        return LoginDataEntity.builder()
                .userName(registrationInfo.getUserName())
                .currentPassword(registrationInfo.getPassword())
                .build();
    }

}
