package co.com.demobvc.domain.adapter;

import java.util.List;
import co.com.demobvc.infrastructure.persistence.FiledEntity;

public interface IReportedFiledRepository {
	
	public List<FiledEntity> findAllReports();

}
