package co.com.demobvc.infrastructure.persistence;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "invoice_refuse")
public class InvoiceRefusedEntity {

	@Id
	private String invoiceCode;
	private String names;
	private String lastNames;
	private String address;
	@PositiveOrZero
	private double amount;
	private Date expirationDate;
	private Date timelyPaymentDate;
	@NotBlank
	private String state;
	@ManyToOne
	@JoinColumn(name = "filed")
	private FiledEntity filed;

	public InvoiceRefusedEntity() {
	}

	public InvoiceRefusedEntity(String invoiceCode, String address, @PositiveOrZero double amount,
			@NotBlank Date expirationDate, @NotBlank Date timelyPaymentDate, @NotBlank String state,
			@NotNull FiledEntity filed) {
		super();
		this.invoiceCode = invoiceCode;
		this.address = address;
		this.amount = amount;
		this.expirationDate = expirationDate;
		this.timelyPaymentDate = timelyPaymentDate;
		this.state = state;
		this.filed = filed;
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getTimelyPaymentDate() {
		return timelyPaymentDate;
	}

	public void setTimelyPaymentDate(Date timelyPaymentDate) {
		this.timelyPaymentDate = timelyPaymentDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public FiledEntity getSequencial() {
		return filed;
	}

	public void setSequencial(FiledEntity filed) {
		this.filed = filed;
	}

}
