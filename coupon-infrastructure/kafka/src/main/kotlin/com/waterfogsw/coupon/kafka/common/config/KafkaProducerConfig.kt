package com.waterfogsw.coupon.kafka.common.config

import com.waterfogsw.coupon.kafka.common.properties.KafkaProducerProperties
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.serializer.JsonSerializer


@Configuration
@ComponentScan(basePackages = ["com.waterfogsw.coupon.kafka"])
@ConfigurationPropertiesScan(basePackages = ["com.waterfogsw.coupon.kafka.common.properties"])
class KafkaProducerConfig(
    private val kafkaProducerProperties: KafkaProducerProperties
) {

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Any> {
        val factory = DefaultKafkaProducerFactory<String, Any>(producerProps())
        validateKafkaConnection(factory)
        return KafkaTemplate(factory)
    }

    private fun producerProps(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProducerProperties.bootstrapServers
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        props[JsonSerializer.ADD_TYPE_INFO_HEADERS] = true
        return props
    }

    private fun validateKafkaConnection(factory: DefaultKafkaProducerFactory<String, Any>) {
        try {
            val producer = factory.createProducer()
            producer.close()
        } catch (e: Exception) {
            println("Kafka Producer is not available: ${e.printStackTrace()}")
        }
    }

}
