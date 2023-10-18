package co.com.demobvc.application.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.com.demobvc.domain.service.IReportService;

@SpringBootTest
class ReportsServiceTest {

	@Autowired
	private IReportService reportsService;
	
	@Test
	void testFindAllFiledreported() {
		assertNotNull(reportsService.findAllFiledreported());
		assertTrue(reportsService.findAllFiledreported().isEmpty());
	}

}
