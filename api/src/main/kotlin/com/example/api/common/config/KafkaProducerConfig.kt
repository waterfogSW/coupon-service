package com.example.api.common.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.common.serialization.LongSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
class KafkaProducerConfig (
    private val kafkaProducerProperties: KafkaProducerProperties
){

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Long> {
        val factory = DefaultKafkaProducerFactory<String, Long>(producerProps())
        checkKafkaConnection(factory)
        return KafkaTemplate(factory)
    }

    private fun producerProps(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProducerProperties.bootstrapServers
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = LongSerializer::class.java
        props[JsonSerializer.ADD_TYPE_INFO_HEADERS] = true
        return props
    }

    private fun checkKafkaConnection(factory: DefaultKafkaProducerFactory<String, Long>) {
        try {
            val producer = factory.createProducer()
            producer.close()
        } catch (e: Exception) {
            println("Kafka Producer is not available: ${e.printStackTrace()}")
        }
    }

}
