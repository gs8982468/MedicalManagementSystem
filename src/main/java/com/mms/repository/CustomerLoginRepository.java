package com.mms.repository;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.mms.configuration.FirestoreCollection;
import com.mms.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Repository
@RequiredArgsConstructor
public class CustomerLoginRepository {
    private final FirestoreCollection firestoreCollection;

    @Autowired
    Firestore firestore;

    public String abc(Book model){
        WriteResult writeResult = null;
        try {
            writeResult = this.firestore.collection(firestoreCollection.getCustomerLoginData()).document(model.getId() != null ? model.getId() : UUID.randomUUID().toString()).set(model).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return writeResult.getUpdateTime().toString();
    }
}
