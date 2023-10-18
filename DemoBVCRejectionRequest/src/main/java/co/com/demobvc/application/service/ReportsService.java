package co.com.demobvc.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.demobvc.domain.adapter.IReportedFiledRepository;
import co.com.demobvc.domain.service.IReportService;
import co.com.demobvc.infrastructure.persistence.FiledEntity;

@Service
public class ReportsService implements IReportService {
	
	@Autowired
	private IReportedFiledRepository reportedFiledRepository;

	@Override
	public List<FiledEntity> findAllFiledreported() {
		return reportedFiledRepository.findAllReports();
	}

}
