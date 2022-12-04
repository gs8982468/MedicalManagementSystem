package com.mms.mapper.customer;

import com.mms.pojo.dto.customer.request.RegistrationInfo;
import com.mms.pojo.model.customer.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    @Mapping(target = "userName", source = "registrationInfo.mobileNumber")
    @Mapping(target = "registrationInfo", source = "registrationInfo")
    UserEntity mapRegistrationDetailsToUserEntity(RegistrationInfo registrationInfo);
}
