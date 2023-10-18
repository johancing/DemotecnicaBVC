package co.com.demobvc.infrastructure.util;

import java.util.ArrayList;
import java.util.List;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.dto.StatusChangeDto;

public class MapperStatusChange {
	
	private MapperStatusChange() {
	}
	
	public static List<Invoice> toDomain(List<StatusChangeDto> dtos) {
		List<Invoice> result = new ArrayList<>();
		dtos.forEach(dto -> {
			Invoice invoice = new Invoice();
			invoice.setInvoiceCode(dto.getInvoiceCode());
			invoice.setState(dto.getStatus());
			result.add(invoice);
		});
		return result;
	}

}
