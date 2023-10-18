package co.com.demobvc.domain.adapter;

import java.util.List;

import co.com.demobvc.domain.vo.Invoice;

public interface IStatusChangeMessage {
	
	public void publishRequest(List<Invoice> invoices);
}
