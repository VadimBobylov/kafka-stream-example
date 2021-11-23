package com.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class DomainKafkaConsumer {

    @Bean
    public Consumer<KStream<String, Domain>> domainService() {
        return kstream -> kstream.foreach((key, domain) -> {
            log.info("Domain consumed {} Status {}", domain.getDomain(), domain.isDead());
        });
    }
}
