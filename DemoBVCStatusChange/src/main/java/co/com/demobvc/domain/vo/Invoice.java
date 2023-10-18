package co.com.demobvc.domain.vo;

import co.com.demobvc.domain.exception.BusinessException;

public class Invoice {

	public static final String APPROVED = "APPROVED";
	public static final String REFUSE = "REFUSE";
	public static final String PENDING = "PENDING";

	private String invoiceCode;
	private String state;

	public Invoice() {
	}

	public Invoice(String invoiceCode, String state) throws BusinessException {
		super();
		setInvoiceCode(invoiceCode);
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
		return "Invoice [invoiceCode=" + invoiceCode + ", state=" + state + "]";
	}

}
