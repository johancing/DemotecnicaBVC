package co.com.demobvc.domain.service;

import java.io.InputStream;
import java.util.List;

import co.com.demobvc.domain.vo.Invoice;

public interface IFileStorageService {
	
	public Long storeFile(InputStream stream);
	public List<Invoice> findAllByHeaderId(long id);

}
