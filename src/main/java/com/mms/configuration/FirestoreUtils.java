package com.mms.configuration;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class FirestoreUtils {

    public static<T> T unwrapFuture(Future<T> future){
        try {
            return future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
