package com.gomezrondon.kafka.testkafkastreamconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "pvs")
    public void consume(Message<PageViewEvent> message){
        //message.getHeaders().entrySet().forEach(x -> System.out.println("x: "+x.getKey()+" y "+x.getValue()));
       // MessageHeaders headers = message.getHeaders();

        System.out.println("menesje :"+message.getPayload().getPage());

    }

}
