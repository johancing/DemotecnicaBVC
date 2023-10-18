package co.com.demobvc.domain.vo;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.demobvc.domain.exception.BusinessException;

@SpringBootTest
class InvoiceTest {

	@Test
	void testInvoice() {
		Invoice invoice = new Invoice("A32425", "Johan", 25000, new Date(), new Date(), Invoice.PENDING);
		assertNotNull(invoice.getInvoiceCode());
		assertTrue(invoice.getAmount() > 0);
		assertNotNull(invoice.getNames());
		assertNotNull(invoice.getExpirationDate());
		assertNotNull(invoice.getTimelyPaymentDate());
		assertNotNull(invoice.getState());
	}

	@Test
	void testInvoiceCodeError() {
		RuntimeException ex = assertThrows(BusinessException.class,
				() -> new Invoice(null, "Johan", 25000, new Date(), new Date(), Invoice.PENDING));
		String message = "Invalid value for invoice code.";
		String actualMessage = ex.getMessage();
		assertEquals(message, actualMessage);
	}

	@Test
	void testInvoiceNameError() {
		RuntimeException ex = assertThrows(BusinessException.class,
				() -> new Invoice("A123", null, 25000, new Date(), new Date(), Invoice.PENDING));
		String message = "Names is invalid.";
		String actualMessage = ex.getMessage();
		assertEquals(message, actualMessage);
	}

	@Test
	void testInvoiceAmountError() {
		RuntimeException ex = assertThrows(BusinessException.class,
				() -> new Invoice("A123", "Johan", -1, new Date(), new Date(), Invoice.PENDING));
		String message = "Invalid amout.";
		String actualMessage = ex.getMessage();
		assertEquals(message, actualMessage);
	}

	@Test
	void testInvoiceExpectedDateError() {
		RuntimeException ex = assertThrows(BusinessException.class,
				() -> new Invoice("A123", "Johan", 25000, null, new Date(), Invoice.PENDING));
		String message = "Invalid expiration date.";
		String actualMessage = ex.getMessage();
		assertEquals(message, actualMessage);
	}

	@Test
	void testInvoiceTimelyPaymentDateError() {
		RuntimeException ex = assertThrows(BusinessException.class,
				() -> new Invoice("A123", "Johan", 25000, new Date(), null, Invoice.PENDING));
		String message = "Invalid timely payment date.";
		String actualMessage = ex.getMessage();
		assertEquals(message, actualMessage);
	}
	@Test
	void testInvoiceStatusError() {
		RuntimeException ex = assertThrows(BusinessException.class,
				() -> new Invoice("A123", "Johan", 25000, new Date(), new Date(), null));
		String message = "Invalid state.";
		String actualMessage = ex.getMessage();
		assertEquals(message, actualMessage);
	}
}
