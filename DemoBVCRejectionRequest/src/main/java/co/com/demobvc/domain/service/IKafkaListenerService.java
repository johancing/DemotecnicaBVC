package co.com.demobvc.domain.service;

import java.util.List;
import co.com.demobvc.domain.vo.Invoice;

public interface IKafkaListenerService {
	
	public void consume(List<Invoice> invoices);

}
