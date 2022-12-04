package com.mms.repository;

public interface BaseRepository<T> {
    /**
     * This methos is used to save or update an entity into firestore collection
     * @param entity : accept entity (model) class
     * @return the whole entity after saving or updating data
     */
    T saveOrUpdate(T entity);

    /**
     * This method is used to fetch data from firestore collection
     * @param id
     * @return
     */
    T findById(String id);
}
