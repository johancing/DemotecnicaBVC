package co.com.demobvc.infrastructure.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import co.com.demobvc.domain.vo.Invoice;

@Configuration
public class KafkaProducer {
	
	private static final String BOOSTRAP_ADDRESS = "localhost:9092";
	
	@Bean
	ProducerFactory<String, Event<List<Invoice>>> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOSTRAP_ADDRESS);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		config.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 10000);
		config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 4000);
		config.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, 6000);
		config.put(ProducerConfig.RETRIES_CONFIG, 0);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	KafkaTemplate<String, Event<List<Invoice>>> kafkaTemplete() {
		return new KafkaTemplate<>(producerFactory());
	}

}
