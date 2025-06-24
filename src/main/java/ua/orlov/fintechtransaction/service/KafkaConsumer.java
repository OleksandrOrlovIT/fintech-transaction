package ua.orlov.fintechtransaction.service;

public interface KafkaConsumer {
    void printCreatedTransaction(String message);
}
