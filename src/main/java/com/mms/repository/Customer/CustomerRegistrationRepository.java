package com.mms.repository.Customer;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.mms.configuration.FirestoreCollection;
import com.mms.configuration.FirestoreReader;
import com.mms.configuration.FirestoreUtils;
import com.mms.pojo.model.customer.UserEntity;
import com.mms.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Repository
@RequiredArgsConstructor
public class CustomerRegistrationRepository implements BaseRepository<UserEntity> {
    private final  Firestore firestore;

    private final FirestoreCollection firestoreCollection;

    @Autowired
    private FirestoreReader firestoreReader;

    @Override
    public UserEntity saveOrUpdate(UserEntity userEntity) {
        FirestoreUtils.unwrapFuture(
                firestore.collection(
                        firestoreCollection.getUserData()).document(userEntity.getUserName()).set(userEntity));
        return userEntity;
    }

    @Override
    public UserEntity findById(String id) {
        return null;
    }

    @Override
    public UserEntity findByIndexFields(Map<String, Object> fieldValuePair) {
        QuerySnapshot querySnapshot = firestoreReader.findByIndexFields(firestoreCollection.getUserData(), fieldValuePair);
        Optional<UserEntity> userEntityOptional= null != querySnapshot? querySnapshot.toObjects(UserEntity.class).stream().findFirst(): Optional.empty();
        return userEntityOptional.isPresent()? userEntityOptional.get():null;
    }
}
