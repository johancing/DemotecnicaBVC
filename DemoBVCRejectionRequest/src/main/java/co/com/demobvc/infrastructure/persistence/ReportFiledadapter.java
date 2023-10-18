package co.com.demobvc.infrastructure.persistence;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.demobvc.domain.adapter.IReportedFiledRepository;

@Component
public class ReportFiledadapter implements IReportedFiledRepository {
	
	@Autowired
	private IFiledJPARepository filedJPARepository;

	@Override
	public List<FiledEntity> findAllReports() {
		return filedJPARepository.findAll();
	}

}
