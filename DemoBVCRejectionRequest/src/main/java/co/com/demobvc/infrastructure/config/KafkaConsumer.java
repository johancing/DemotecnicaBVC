package co.com.demobvc.infrastructure.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import co.com.demobvc.domain.vo.Invoice;

@Configuration
public class KafkaConsumer {

	private static final String BOOSTRAP_ADDRESS = "localhost:9092";

	@Bean
	ConsumerFactory<String, Event<List<Invoice>>> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOSTRAP_ADDRESS);
		config.put(JsonSerializer.TYPE_MAPPINGS, "co.com.demobvc:co.com.demobvc.infrastructure.kafka.StatusChangeEvent");
		final JsonDeserializer<Event<List<Invoice>>> jsonDeserializer = new JsonDeserializer<>();
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), jsonDeserializer);
	}

	@Bean
	ConcurrentKafkaListenerContainerFactory<String, Event<List<Invoice>>> kafkaTemplete() {
		ConcurrentKafkaListenerContainerFactory<String, Event<List<Invoice>>> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
