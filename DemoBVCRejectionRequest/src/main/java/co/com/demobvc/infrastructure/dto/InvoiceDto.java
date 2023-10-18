package co.com.demobvc.infrastructure.dto;

import java.util.Date;
import lombok.Data;

@Data
public class InvoiceDto {

	private String invoiceCode;
	private String names;
	private String lastNames;
	private String address;
	private double amount;
	private Date expirationDate;
	private Date timelyPaymentDate;
	private String state;

}
