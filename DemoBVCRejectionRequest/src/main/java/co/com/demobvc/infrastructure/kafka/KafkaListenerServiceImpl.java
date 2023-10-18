package co.com.demobvc.infrastructure.kafka;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import co.com.demobvc.domain.service.IKafkaListenerService;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.config.Event;
import co.com.demobvc.infrastructure.util.AppInformation;
import co.com.demobvc.infrastructure.util.DateUtil;

@Service
public class KafkaListenerServiceImpl {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaListenerServiceImpl.class);
	@Autowired
	private IKafkaListenerService kafkaListenerService;

	@KafkaListener(topics = "${topic.name}", containerFactory = "kafkaTemplete", groupId = "group1")
	public void consume(Event<List<Invoice>> event) {
		if (event.getClass().isAssignableFrom(StatusChangeEvent.class)) {
			setAppInformation(event);
			StatusChangeEvent status = (StatusChangeEvent) event;
			LOG.info("StatusChangeEvent: {}", status);
			kafkaListenerService.consume(status.getData());
		}
	}

	private void setAppInformation(Event<List<Invoice>> event) {
		AppInformation.getInstance().setCreationdate(new Date(System.currentTimeMillis()));
		AppInformation.getInstance().setUid(event.getId());
		AppInformation.getInstance().setFileName(event.getUser() + "_" + DateUtil.actualDateString());
		AppInformation.getInstance().setUser(event.getUser());
	}
}
