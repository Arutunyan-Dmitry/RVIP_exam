package ru.ulstu.publisher.conf;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.exchange}")
    private String exchangeName;
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }
}
