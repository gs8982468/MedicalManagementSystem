package com.mms.Service;

import org.springframework.stereotype.Service;

@Service
public class ApplicationImpl implements ApplicationIF {
    @Override
    public String welcomeMessage() {
        return "Hi user! Welcome to our Medical Management System Portal";
    }
}
