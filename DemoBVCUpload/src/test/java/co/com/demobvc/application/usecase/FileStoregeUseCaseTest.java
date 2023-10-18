package co.com.demobvc.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import co.com.demobvc.application.exception.FileStoregeException;
import co.com.demobvc.domain.service.IFileStorageService;
import co.com.demobvc.infrastructure.util.AppInformation;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileStoregeUseCaseTest {

	@Autowired
	private IFileStorageService service;
	private static final String data = "98764,Johan,Castro,Carrera 92,150000,01/01/2024,01/12/2023,PENDING\r\n"
			+ "98765,Monica,Reyes,Carrera 92,250000,01/01/2024,01/15/2023,PENDING";

	@Test
	@Order(1)
	void testStoreFile_NoInputStreamError() {
		Exception ex = assertThrows(FileStoregeException.class, () -> service.storeFile(null));
		String message = "Document stream error.";
		String actualMessage = ex.getMessage();
		assertEquals(actualMessage, message);
	}

	@Test
	@Order(2)
	void testStoreFile_successInsert() {
		AppInformation.getInstance().setFileName("test.csv");
		AppInformation.getInstance().setCreationdate(new Date(System.currentTimeMillis()));
		AppInformation.getInstance().setUid("654654-65241645-654654");
		InputStream stream = new ByteArrayInputStream(data.getBytes());
		assertTrue(service.storeFile(stream) > 0);
	}

	@Test
	@Order(3)
	void testStoreFile_failedInsert() {
		InputStream stream = new ByteArrayInputStream(data.getBytes());
		Exception ex = assertThrows(DataIntegrityViolationException.class, () -> service.storeFile(stream));
		assertTrue(ex.getMessage().contains("could not execute statement"));
	}

}
