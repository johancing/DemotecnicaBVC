package co.com.demobvc.domain.adapter;

import java.util.List;
import co.com.demobvc.domain.vo.Invoice;

public interface IStausChangeRepository {
	
	public List<Invoice> updateAll(List<Invoice> invoices);

}
