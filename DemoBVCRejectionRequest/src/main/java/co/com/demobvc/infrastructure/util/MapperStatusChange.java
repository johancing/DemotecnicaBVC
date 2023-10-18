package co.com.demobvc.infrastructure.util;

import java.util.ArrayList;
import java.util.List;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.dto.FiledDto;
import co.com.demobvc.infrastructure.dto.InvoiceDto;
import co.com.demobvc.infrastructure.persistence.FiledEntity;
import co.com.demobvc.infrastructure.persistence.InvoiceEntity;
import co.com.demobvc.infrastructure.persistence.InvoiceRefusedEntity;

public class MapperStatusChange {

	private MapperStatusChange() {
		throw new IllegalStateException("Utility class");
	}

	public static List<InvoiceEntity> toEntity(List<Invoice> invoices) {
		List<InvoiceEntity> result = new ArrayList<>();
		invoices.forEach(in -> {
			InvoiceEntity en = new InvoiceEntity();
			en.setInvoiceCode(in.getInvoiceCode());
			en.setState(in.getState());
			result.add(en);
		});
		return result;
	}

	public static List<Invoice> toDomain(List<InvoiceEntity> invoices) {
		List<Invoice> result = new ArrayList<>();
		invoices.forEach(in -> {
			Invoice en = new Invoice();
			en.setInvoiceCode(in.getInvoiceCode());
			en.setNames(in.getNames());
			en.setLastNames(in.getLastNames());
			en.setAddress(in.getAddress());
			en.setAmount(in.getAmount());
			en.setExpirationDate(in.getExpirationDate());
			en.setTimelyPaymentDate(en.getTimelyPaymentDate());
			en.setState(in.getState());
			result.add(en);
		});
		return result;
	}

	public static void mapRefusedInvoices(FiledEntity filed, List<InvoiceEntity> data, List<InvoiceRefusedEntity> transaction) {
		data.stream().forEach(in -> {
			InvoiceRefusedEntity refuse = new InvoiceRefusedEntity();
			refuse.setAddress(in.getAddress());
			refuse.setAmount(in.getAmount());
			refuse.setExpirationDate(in.getExpirationDate());
			refuse.setInvoiceCode(in.getInvoiceCode());
			refuse.setLastNames(in.getLastNames());
			refuse.setNames(in.getNames());
			refuse.setState(Invoice.REFUSE);
			refuse.setSequencial(filed);
			refuse.setTimelyPaymentDate(in.getTimelyPaymentDate());
			transaction.add(refuse);
		});
	}

	public static List<FiledDto> entityToDto(List<FiledEntity> result) {
		List<FiledDto> dtos = new ArrayList<>();
		result.forEach(r -> {
			FiledDto dto = new FiledDto();
			dto.setDetail(r.getDetail());
			dto.setInvoices(MapperStatusChange.toDto(r.getInvoices()));
			dto.setRequestId(r.getRequestId());
			dto.setSequencial(r.getSequencial());
			dto.setCreationDate(r.getCreationDate());
			dtos.add(dto);
		});
		return dtos;
	}

	public static List<InvoiceDto> toDto(List<InvoiceRefusedEntity> invoices) {
		List<InvoiceDto> result = new ArrayList<>();
		invoices.forEach(in -> {
			InvoiceDto dto = new InvoiceDto();
			dto.setAddress(in.getAddress());
			dto.setAmount(in.getAmount());
			dto.setExpirationDate(in.getExpirationDate());
			dto.setInvoiceCode(in.getInvoiceCode());
			dto.setLastNames(in.getLastNames());
			dto.setNames(in.getNames());
			dto.setState(in.getState());
			dto.setTimelyPaymentDate(in.getTimelyPaymentDate());
			result.add(dto);
		});
		return result;
	}

}
