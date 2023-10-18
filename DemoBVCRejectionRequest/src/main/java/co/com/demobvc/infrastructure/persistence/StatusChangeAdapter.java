package co.com.demobvc.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.demobvc.domain.adapter.IStausChangeRepository;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.util.MapperStatusChange;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class StatusChangeAdapter implements IStausChangeRepository {

	@Autowired
	private IStatusChangeJPARepository statuChangeJPARepository;
	@Autowired
	private IFiledJPARepository filedJPARepository;

	@Override
	public List<Invoice> updateAll(List<Invoice> invoices) {
		List<String> ids = invoices.stream().map(Invoice::getInvoiceCode).toList();
		List<InvoiceEntity> data = statuChangeJPARepository.findAllById(ids);
		updateStatus(data, invoices);
		statuChangeJPARepository.saveAll(data);
		FiledEntity filed = new FiledEntity();
		filed.build();
		List<InvoiceRefusedEntity> transaction = new ArrayList<>();
		MapperStatusChange.mapRefusedInvoices(filed,
				data.stream().filter(in -> in.getState().equals(Invoice.REFUSE)).toList(), transaction);
		filed.setInvoices(transaction);
		filedJPARepository.save(filed);
		return MapperStatusChange.toDomain(data);
	}

	private void updateStatus(List<InvoiceEntity> resultset, List<Invoice> invoices) {
		for (int i = 0; i < invoices.size(); i++) {
			if (resultset.get(i).getInvoiceCode().equals(invoices.get(i).getInvoiceCode())) {
				resultset.get(i).setState(invoices.get(i).getState());
			}
		}
	}

}
