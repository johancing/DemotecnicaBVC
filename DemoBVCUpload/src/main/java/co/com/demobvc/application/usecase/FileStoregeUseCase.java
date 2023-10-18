package co.com.demobvc.application.usecase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import co.com.demobvc.application.exception.FileStoregeException;
import co.com.demobvc.domain.repository.IFileStorageRepository;
import co.com.demobvc.domain.service.IFileStorageService;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.util.DateUtil;

@Service
public class FileStoregeUseCase implements IFileStorageService {

	@Autowired
	private IFileStorageRepository repository;

	public Long storeFile(InputStream stream) {
		return repository.save(processStreamToBills(stream));
	}

	private List<Invoice> processStreamToBills(InputStream stream) {
		List<Invoice> data = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, Charset.defaultCharset()));
				CSVParser parse = new CSVParser(reader, CSVFormat.DEFAULT)) {
			for (CSVRecord csvData : parse) {
				Invoice invoice = new Invoice();
				invoice.setInvoiceCode(csvData.get(0));
				invoice.setNames(csvData.get(1));
				invoice.setLastNames(csvData.get(2));
				invoice.setAddress(csvData.get(3));
				invoice.setAmount(Double.parseDouble(csvData.get(4)));
				invoice.setExpirationDate(DateUtil.dateFromString(csvData.get(5)));
				invoice.setTimelyPaymentDate(DateUtil.dateFromString(csvData.get(6)));
				invoice.setState(Invoice.PENDING);
				data.add(invoice);
			}
		} catch (Exception e) {
			throw new FileStoregeException((e.getMessage() == null) ? "Document stream error." : e.getMessage(),
					"/upload", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return data;
	}

	@Override
	public List<Invoice> findAllByHeaderId(long id) {
		return repository.getAllbyHeaderId(id);
	}

}
