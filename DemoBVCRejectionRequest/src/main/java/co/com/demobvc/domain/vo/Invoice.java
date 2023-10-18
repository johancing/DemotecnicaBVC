package co.com.demobvc.domain.vo;

import java.util.Date;
import co.com.demobvc.domain.exception.BusinessException;

public class Invoice {

	public static final String APPROVED = "APPROVED";
	public static final String REFUSE = "REFUSE";
	public static final String PENDING = "PENDING";

	private String invoiceCode;
	private String names;
	private String lastNames;
	private String address;
	private double amount;
	private Date expirationDate;
	private Date timelyPaymentDate;
	private String state;

	public Invoice() {
	}

	public Invoice(String invoiceCode, String names, double amount, Date expirationDate, Date timelyPaymentDate,
			String state) throws BusinessException {
		super();
		setInvoiceCode(invoiceCode);
		setNames(names);
		setAmount(amount);
		setExpirationDate(expirationDate);
		setTimelyPaymentDate(timelyPaymentDate);
		setState(state);
	}

	private boolean isBlank(String data) {
		return (data == null || data.trim().isEmpty());
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) throws BusinessException {
		if (invoiceCode == null || isBlank(invoiceCode))
			throw new BusinessException("Invalid value for invoice code.");
		this.invoiceCode = invoiceCode;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) throws BusinessException {
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

	public void setAmount(double amount) throws BusinessException {
		this.amount = amount;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) throws BusinessException {
		this.expirationDate = expirationDate;
	}

	public Date getTimelyPaymentDate() {
		return timelyPaymentDate;
	}

	public void setTimelyPaymentDate(Date timelyPaymentDate) throws BusinessException {
		this.timelyPaymentDate = timelyPaymentDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) throws BusinessException {
		if (isBlank(state) || (!PENDING.equals(state) && !REFUSE.equals(state) && !APPROVED.equals(state)))
			throw new BusinessException("Invalid state.");
		this.state = state;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceCode=" + invoiceCode + ", names=" + names + ", lastNames=" + lastNames + ", address="
				+ address + ", amount=" + amount + ", expirationDate=" + expirationDate + ", timelyPaymentDate="
				+ timelyPaymentDate + ", state=" + state + "]";
	}

}
