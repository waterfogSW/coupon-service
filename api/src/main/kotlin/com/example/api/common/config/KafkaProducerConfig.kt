package com.example.api.common.config

import com.fasterxml.jackson.databind.ser.std.StringSerializer
import org.apache.kafka.common.serialization.LongSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate

@Configuration
class KafkaProducerConfig {

    @Bean
    fun producerFactory(): DefaultKafkaProducerFactory<String, Long> {
        val configMap: Map<String, Any> = mapOf(
            "bootstrap.servers" to "localhost:9092",
            "key.serializer" to StringSerializer::class.java,
            "value.serializer" to LongSerializer::class.java
        )

        return DefaultKafkaProducerFactory(configMap)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Long> {
        return KafkaTemplate(producerFactory())
    }

}
