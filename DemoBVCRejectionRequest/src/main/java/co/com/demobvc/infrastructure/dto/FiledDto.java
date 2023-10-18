package co.com.demobvc.infrastructure.dto;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class FiledDto {

	private Long sequencial;
	private String detail;
	private Date creationDate;
	private String requestId;
	private List<InvoiceDto> invoices;
}
