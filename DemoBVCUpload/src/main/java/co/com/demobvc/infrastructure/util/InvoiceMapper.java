package co.com.demobvc.infrastructure.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import co.com.demobvc.application.exception.FileStoregeException;
import co.com.demobvc.domain.exception.BusinessException;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.persistence.FileEntity;
import co.com.demobvc.infrastructure.persistence.InvoiceEntity;

@Component
public class InvoiceMapper {

	public List<InvoiceEntity> toEntity(List<Invoice> invoices, FileEntity fileEntity) {
		List<InvoiceEntity> response = new ArrayList<>();
		if (invoices != null && !invoices.isEmpty()) {
			invoices.forEach(invoice -> {
				InvoiceEntity in = new InvoiceEntity();
				in.setAddress(invoice.getAddress());
				in.setAmount(invoice.getAmount());
				in.setExpirationDate(invoice.getExpirationDate());
				in.setInvoiceCode(invoice.getInvoiceCode());
				in.setLastNames(invoice.getLastNames());
				in.setNames(invoice.getNames());
				in.setState(invoice.getState());
				in.setTimelyPaymentDate(invoice.getTimelyPaymentDate());
				in.setSequencial(fileEntity);
				response.add(in);
			});
		}
		return response;
	}

	public List<Invoice> toDomain(List<InvoiceEntity> invoces) {
		List<Invoice> response = new ArrayList<>();
		if (invoces != null && !invoces.isEmpty()) {
			invoces.forEach(invoice -> {
				try {
					Invoice in = new Invoice();
					in.setAddress(invoice.getAddress());
					in.setAmount(invoice.getAmount());
					in.setExpirationDate(invoice.getExpirationDate());
					in.setInvoiceCode(invoice.getInvoiceCode());
					in.setLastNames(invoice.getLastNames());
					in.setNames(invoice.getNames());
					in.setState(invoice.getState());
					in.setTimelyPaymentDate(invoice.getTimelyPaymentDate());
					response.add(in);
				} catch (BusinessException be) {
					throw new FileStoregeException(be.getMessage(), "/upload", HttpStatus.UNPROCESSABLE_ENTITY);
				}
			});
		}
		return response;
	}

}
