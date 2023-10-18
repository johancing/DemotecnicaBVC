package co.com.demobvc.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.com.demobvc.domain.repository.IFileStorageRepository;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.util.AppInformation;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileStorageAdapterTest {
	
	@Autowired
	private IFileStorageRepository repository;

	@Test
	@Order(1)
	void testSave() {
		AppInformation.getInstance().setFileName("test.csv");
		AppInformation.getInstance().setCreationdate(new Date(System.currentTimeMillis()));
		AppInformation.getInstance().setUid(UUID.randomUUID().toString());
		List<Invoice> request = new ArrayList<>();
		request.add(new Invoice("Q234234","Johan",25000,new Date(), new Date(), Invoice.PENDING));
		long id = repository.save(request);
		assertEquals(id, 1);
		assertTrue(id > 0);
	}

	@Test
	@Order(2)
	void testGetAllbyHeaderId() {
		List<Invoice> result = repository.getAllbyHeaderId(1);
		assertNotNull(result);
		assertTrue(!result.isEmpty());
	}

}
