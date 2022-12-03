package com.mms.service;

import com.mms.model.Book;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface ApplicationIF {
    public String welcomeMessage();

    public String checkFS(Book model);
}
