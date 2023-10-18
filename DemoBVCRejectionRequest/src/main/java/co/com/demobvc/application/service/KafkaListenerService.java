package co.com.demobvc.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.demobvc.domain.adapter.IStausChangeRepository;
import co.com.demobvc.domain.service.IKafkaListenerService;
import co.com.demobvc.domain.vo.Invoice;

@Service
public class KafkaListenerService implements IKafkaListenerService {
	
	@Autowired
	private IStausChangeRepository stausChangeRepository;

	@Override
	public void consume(List<Invoice> invoices) {
		stausChangeRepository.updateAll(invoices);
	}

}
