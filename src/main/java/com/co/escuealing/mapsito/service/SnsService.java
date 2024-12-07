package com.co.escuealing.mapsito.service;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import org.springframework.stereotype.Service;

@Service
public class SnsService {

    private final SnsClient snsClient;


    public SnsService(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    public void sendEmail(String topicArn, String subject, String message) throws Exception {
        // Suscribir el correo electrónico al Topic SNS solo si no está ya suscrito
        try {
            PublishRequest request = PublishRequest.builder()
                 .message(message)
                 .subject(subject)
                 .topicArn(topicArn) // ARN del topic SNS
                 .build();
            PublishResponse response = snsClient.publish(request);
            System.out.println("Email sent! MessageId: " + response.messageId());
        } catch (Exception e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
        }
    }
}
