package com.gomezrondon.kafka.testkafkastreamconsumer;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaconfig {

    @Bean
    public ConsumerFactory<String, PageViewEvent> consumerFactory(){
        Map<String, Object> config = new HashMap<>();
       config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.99.100:9092");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,PageViewEventDeserial.class);


        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PageViewEvent> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, PageViewEvent> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


}
