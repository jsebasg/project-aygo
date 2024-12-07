package com.co.escuealing.mapsito.service;

/**
 * @author sebastian.garciah
 * @created 06/12/2024
 * @project project-aygo
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.CreateTopicRequest;
import software.amazon.awssdk.services.sns.model.CreateTopicResponse;
import software.amazon.awssdk.services.sns.model.SnsException;
import software.amazon.awssdk.regions.Region;

@Configuration
public class AwsSnsConfig {

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
             .region(Region.US_EAST_1) // Ajusta la región según tu configuración
             .build();
    }

    public String createNewTopic(String nombre) {
        try (SnsClient snsClient = SnsClient.builder()
             .region(Region.US_EAST_1) // Define la región de AWS
             .build()) {
            // Crear la solicitud para crear el topic
            CreateTopicRequest createTopicRequest = CreateTopicRequest.builder()
                 .name(nombre)
                 .build();
            // Crear el Topic
            CreateTopicResponse createTopicResponse = snsClient.createTopic(createTopicRequest);
            // Imprimir el ARN del Topic creado
            System.out.println("Topic creado con ARN: " + createTopicResponse.topicArn());
            return  createTopicResponse.topicArn();
        } catch (SnsException e) {
            System.err.println("Error de SNS: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}

