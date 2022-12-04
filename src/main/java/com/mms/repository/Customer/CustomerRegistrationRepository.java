package com.mms.repository.Customer;

import com.google.cloud.firestore.Firestore;
import com.mms.configuration.FirestoreCollection;
import com.mms.configuration.FirestoreUtils;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRegistrationRepository implements BaseRepository<UserEntity> {
    private final  Firestore firestore;

    private final FirestoreCollection firestoreCollection;

    @Override
    public UserEntity saveOrUpdate(UserEntity userEntity) {

        userEntity.setDocumentId(UUID.randomUUID().toString());

        FirestoreUtils.unwrapFuture(
                firestore.collection(
                        firestoreCollection.getUserData()).document(userEntity.getDocumentId()).set(userEntity));
        return userEntity;
    }

    @Override
    public UserEntity findById(String id) {
        return null;
    }
}
