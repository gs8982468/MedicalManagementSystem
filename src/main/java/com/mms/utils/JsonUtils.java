package com.mms.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JsonUtils {
    @Autowired
    private ObjectMapper objectMapper;

    public <T> T convertJsonToObject(String json, Class<T> className) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, className);
        } catch (JsonProcessingException e) {
            log.info("Error parsing while converting message into the specified class : " + className.toString());
            throw new RuntimeException(e);
        }
    }

    public <T> String convertObjectToJson(T object) {
        if (null == object) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.info("Error parsing while converting object value into the json: ");
            throw new RuntimeException(e);
        }
    }
}
