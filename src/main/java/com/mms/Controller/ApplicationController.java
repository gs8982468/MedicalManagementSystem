package com.mms.Controller;

import com.mms.Service.ApplicationIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationIF applicationIF;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcomeMessage(){
        return applicationIF.welcomeMessage();
    }
}
