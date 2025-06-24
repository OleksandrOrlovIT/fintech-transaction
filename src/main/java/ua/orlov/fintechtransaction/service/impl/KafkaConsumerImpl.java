package ua.orlov.fintechtransaction.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ua.orlov.fintechtransaction.service.KafkaConsumer;

@Service
@Log4j2
public class KafkaConsumerImpl implements KafkaConsumer {

    @Override
    @KafkaListener(topics = "transaction.create")
    public void printCreatedTransaction(String message) {
        log.info(message);
    }
}
