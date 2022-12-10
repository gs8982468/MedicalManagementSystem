package com.mms.pubsub.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerRegistrationConsumer {


//    @ServiceActivator(inputChannel = "customerRegChannel")
    public void messageReceiver(Message<byte[]> receivedMessage){

    }
}
