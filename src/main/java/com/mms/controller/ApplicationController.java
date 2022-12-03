package com.mms.controller;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.mms.model.Book;
import com.mms.service.ApplicationIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
public class ApplicationController {
    private static final String BOOKS = "books";

    @Autowired
    private ApplicationIF applicationIF;


    @Autowired
    Firestore firestore;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcomeMessage(){
        return applicationIF.welcomeMessage();
    }

    @RequestMapping(value = "/home/fs", method = RequestMethod.GET)
    public String checkFirestoreConnection(){
        WriteResult writeResult = null;
        try {
            writeResult = this.firestore.collection(BOOKS).document(UUID.randomUUID().toString()).set("Subhankar Guchhait".getBytes(StandardCharsets.UTF_8)).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
//        return new ResponseEntity(writeResult, new HttpHeaders(), HttpStatus.OK);
        return writeResult.getUpdateTime().toString();
    }

    @RequestMapping(value = "/home/fss", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Book model) {

        try {
            WriteResult writeResult = this.firestore.collection(BOOKS).document(model.getId() != null ? model.getId() : UUID.randomUUID().toString()).set(model).get();
            return new ResponseEntity(writeResult, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
