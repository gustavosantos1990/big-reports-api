package org.gdas.bigreportsapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Value("${kafka.reports.topic}")
    private String reportsTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;


    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToReportsTopic(String message) {
        kafkaTemplate.send(reportsTopic, message);
    }

}
