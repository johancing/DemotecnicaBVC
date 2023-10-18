package co.com.demobvc.infrastructure.kafka;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import co.com.demobvc.domain.adapter.IStatusChangeMessage;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.config.Event;
import co.com.demobvc.infrastructure.config.EventType;
import co.com.demobvc.infrastructure.util.AppInformation;

@Component
public class StatusChangeKafkaAdapter implements IStatusChangeMessage {

	private static final Logger LOG = LoggerFactory.getLogger(StatusChangeKafkaAdapter.class);
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	@Value("${topic.name}")
	private String topic;

	@Override
	public void publishRequest(List<Invoice> invoices) {
		Event<List<Invoice>> event = new StatusChangeEvent();
		event.setId(AppInformation.getInstance().getUid());
		event.setUser(AppInformation.getInstance().getUser());
		event.setDate(new Date(System.currentTimeMillis()));
		event.setType(EventType.UPDATE);
		event.setData(invoices);
		LOG.info("requestId: {}: user: {} {}", AppInformation.getInstance().getUid(),
				AppInformation.getInstance().getUser(), event);
		producer.send(topic, event);
	}
}
