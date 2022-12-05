package com.mms.mapper.customer;

import com.mms.pojo.dto.customer.request.RegistrationInfo;
import com.mms.pojo.model.customer.RegistrationInfoEntity;
import com.mms.pojo.model.customer.RegistrationInfoEntity.RegistrationInfoEntityBuilder;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.pojo.model.customer.UserEntity.UserEntityBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-05T19:05:15+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public UserEntity mapRegistrationDetailsToUserEntity(RegistrationInfo registrationInfo) {
        if ( registrationInfo == null ) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userName( registrationInfo.getUserName() );
        userEntity.primaryMobileNumber( registrationInfo.getMobileNumber() );
        userEntity.primaryEmailAddress( registrationInfo.getEmailAddress() );
        userEntity.registrationInfo( registrationInfoToRegistrationInfoEntity( registrationInfo ) );
        userEntity.personalDetails( mapRegInfoToPersonalDetails( registrationInfo ) );
        userEntity.loginData( mapRegInfoToLoginData( registrationInfo ) );

        return userEntity.build();
    }

    protected RegistrationInfoEntity registrationInfoToRegistrationInfoEntity(RegistrationInfo registrationInfo) {
        if ( registrationInfo == null ) {
            return null;
        }

        RegistrationInfoEntityBuilder registrationInfoEntity = RegistrationInfoEntity.builder();

        registrationInfoEntity.emailAddress( registrationInfo.getEmailAddress() );
        registrationInfoEntity.mobileNumber( registrationInfo.getMobileNumber() );
        registrationInfoEntity.password( registrationInfo.getPassword() );
        registrationInfoEntity.userName( registrationInfo.getUserName() );

        return registrationInfoEntity.build();
    }
}
