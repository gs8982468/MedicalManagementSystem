package com.mms.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationUtils {

    public boolean emailValidation(String emailAddress){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(emailAddress);
        return pattern.matcher(emailAddress).matches();

    }

}
