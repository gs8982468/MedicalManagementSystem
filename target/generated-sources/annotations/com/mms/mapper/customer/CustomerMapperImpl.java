package com.mms.mapper.customer;

import com.mms.pojo.dto.customer.request.RegistrationInfo;
import com.mms.pojo.model.customer.RegistrationInfoEntity;
import com.mms.pojo.model.customer.RegistrationInfoEntity.RegistrationInfoEntityBuilder;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.pojo.model.customer.UserEntity.UserEntityBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-04T15:22:18+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public UserEntity mapRegistrationDetailsToUserEntity(RegistrationInfo registrationInfo) {
        if ( registrationInfo == null ) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userName( registrationInfo.getMobileNumber() );
        userEntity.registrationInfo( registrationInfoToRegistrationInfoEntity( registrationInfo ) );

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

        return registrationInfoEntity.build();
    }
}
