package com.mms.service;

import com.mms.model.Book;
import com.mms.repository.CustomerLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationImpl implements ApplicationIF {
    @Override
    public String welcomeMessage() {
        return "Hi user! Welcome to our Medical Management System Portal";
    }

    @Autowired
    private CustomerLoginRepository customerLoginRepository;
    @Override
    public String checkFS(Book model) {

        return customerLoginRepository.abc(model);
    }
}
