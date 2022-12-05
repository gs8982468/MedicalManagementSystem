package com.mms.configuration;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class FirestoreUtils {
    @Autowired
    private Firestore firestore;

    public static<T> T unwrapFuture(Future<T> future){
        try {
            return future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> QuerySnapshot findByIndexFields(String collectionName, Map<String, Object> fieldValuePair, T className) {

        Query query = buildQuery(collectionName, fieldValuePair);
        ApiFuture<QuerySnapshot> apiQuerySnapShot = query.get();
        try {
           return null != apiQuerySnapShot? apiQuerySnapShot.get(): null;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private Query buildQuery(String collectionName, Map<String, Object> fieldValuePair) {
        Query query = firestore.collection(collectionName);
        if(!fieldValuePair.isEmpty()){
            for(Map.Entry<String, Object> entry : fieldValuePair.entrySet()){
                query.whereEqualTo(entry.getKey(), entry.getValue());
            }
        }
        return query;
    }

}
