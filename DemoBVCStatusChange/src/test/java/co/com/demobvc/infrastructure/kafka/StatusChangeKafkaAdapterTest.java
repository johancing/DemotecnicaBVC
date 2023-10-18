package co.com.demobvc.infrastructure.kafka;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import co.com.demobvc.domain.vo.Invoice;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class StatusChangeKafkaAdapterTest {
		
	@Autowired
	private StatusChangeKafkaAdapter statusAdapter = new StatusChangeKafkaAdapter();

	@Test
	void testPublishRequest() {
		List<Invoice> send = new ArrayList<>();
		Invoice in1 = new Invoice();
		in1.setInvoiceCode("AWS987654");
		in1.setState(Invoice.APPROVED);
		Invoice in2 = new Invoice();
		in2.setInvoiceCode("AWS987654");
		in2.setState(Invoice.APPROVED);
		send.add(in1);
		send.add(in2);
		assertDoesNotThrow(() -> statusAdapter.publishRequest(send));
	}

}
