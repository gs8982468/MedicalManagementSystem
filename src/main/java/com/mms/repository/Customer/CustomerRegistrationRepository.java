package com.mms.repository.Customer;

import com.google.cloud.firestore.Firestore;
import com.mms.configuration.FirestoreCollection;
import com.mms.configuration.FirestoreUtils;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerRegistrationRepository implements BaseRepository<UserEntity> {
    private final  Firestore firestore;

    private final FirestoreCollection firestoreCollection;

    @Override
    public UserEntity saveOrUpdate(UserEntity entity) {

        FirestoreUtils.unwrapFuture(
                firestore.collection(
                        firestoreCollection.getCustomerLoginData()).document(entity.getDocumentId()).set(entity));
        return entity;

    }

    @Override
    public UserEntity findById(String id) {
        return null;
    }
}
