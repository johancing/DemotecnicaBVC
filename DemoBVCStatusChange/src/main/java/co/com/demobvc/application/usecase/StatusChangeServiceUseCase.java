package co.com.demobvc.application.usecase;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.demobvc.domain.adapter.IStatusChangeMessage;
import co.com.demobvc.domain.service.IStatusChangeService;
import co.com.demobvc.domain.vo.Invoice;

@Service
public class StatusChangeServiceUseCase implements IStatusChangeService {
	
	@Autowired
	private IStatusChangeMessage statusChangeMessage;

	@Override
	public void changeStatus(List<Invoice> invoices) {
		statusChangeMessage.publishRequest(invoices);
	}



}
