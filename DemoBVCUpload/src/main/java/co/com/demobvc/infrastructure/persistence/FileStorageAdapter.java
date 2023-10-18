package co.com.demobvc.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.demobvc.domain.repository.IFileStorageRepository;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.util.AppInformation;
import co.com.demobvc.infrastructure.util.InvoiceMapper;

@Component
public class FileStorageAdapter implements IFileStorageRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileStorageAdapter.class);

	@Autowired
	private IFileStorageJPARepository repository;
	@Autowired
	private InvoiceMapper mapper;

	@Override
	public Long save(List<Invoice> invoices) {
		FileEntity file = new FileEntity(AppInformation.getInstance().getFileName(),
				AppInformation.getInstance().getCreationdate());
		file.setInvoices(mapper.toEntity(invoices, file));
		file.setRequestId(AppInformation.getInstance().getUid());
		LOGGER.info("requestId: {} : Save file information for: {}", file.getRequestId(), file);
		long id = repository.save(file).getSequencial();
		LOGGER.info("requestId: {} : Save file id: {}", file.getRequestId(), file.getSequencial());
		return id;
	}

	@Override
	public List<Invoice> getAllbyHeaderId(long id) {
		Optional<FileEntity> file = repository.findById(id);
		if (!file.isPresent())
			return new ArrayList<>();
		return mapper.toDomain(file.get().getInvoices());
	}

}
