package co.com.demobvc.domain.repository;

import java.util.List;

import co.com.demobvc.domain.vo.Invoice;

public interface IFileStorageRepository {
	
	public Long save(List<Invoice> invoices);
	public List<Invoice> getAllbyHeaderId(long id);

}
