package com.waterfogsw.coupon.worker.common.config

import com.waterfogsw.coupon.worker.common.properties.KafkaConsumerProperties
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@Configuration
class KafkaConsumerConfig(
    private val kafkaConsumerProperties: KafkaConsumerProperties
) {

    @Bean
    fun kafkaConsumerFactory(): DefaultKafkaConsumerFactory<String, Long> {
        val props = HashMap<String, Any>()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaConsumerProperties.bootstrapServers
        props[ConsumerConfig.GROUP_ID_CONFIG] = kafkaConsumerProperties.groupId
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        return DefaultKafkaConsumerFactory(props)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Long> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Long>()
        factory.consumerFactory = kafkaConsumerFactory()
        return factory
    }


}
