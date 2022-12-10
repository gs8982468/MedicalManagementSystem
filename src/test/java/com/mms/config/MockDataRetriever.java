package com.mms.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

@Component
public class MockDataRetriever {
    private static final Logger log = LoggerFactory.getLogger(MockDataRetriever.class);

    @Autowired
    private ObjectMapper objectMapper;

    public <T> T getResponseObject(String fileName, Class<T> responseType) throws IOException {
        InputStream inJson = getClass().getClassLoader().getResourceAsStream(fileName);
        return this.objectMapper.readValue(inJson, responseType);
    }


    public String getResponseString(String fileName) {

        try {
            InputStream inJson = getClass().getClassLoader().getResourceAsStream(fileName);
            Throwable var3 = null;

            Object var6;
            try {
                Scanner s = (new Scanner(inJson)).useDelimiter("\\A");
                Throwable var5 = null;
                try {
                    var6 = s.hasNext() ? s.next() : "";

                } catch (Throwable var31) {
                    var6 = var31;
                    var5 = var31;
                    throw var31;
                } finally {
                    if (s != null) {
                        if (var5 != null) {
                            try {
                                s.close();
                            } catch (Throwable var30) {
                                var5.addSuppressed(var30);
                            }
                        } else {
                            s.close();
                        }
                    }
                }

            } catch (Throwable var33) {
                var3 = var33;
                throw var33;
            } finally {
                if (inJson != null) {
                    if (var3 != null) {
                        try {
                            inJson.close();
                        } catch (Throwable var29) {
                            var3.addSuppressed(var29);
                        }
                    } else {
                        inJson.close();
                    }
                }
            }
            return (String) var6;
        } catch (Throwable var35) {
            log.error("Exception in getResponseString method");
            return null;
        }
    }
}
