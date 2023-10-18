package co.com.demobvc.domain.service;

import java.util.List;

import co.com.demobvc.infrastructure.persistence.FiledEntity;

public interface IReportService {
	
	public List<FiledEntity> findAllFiledreported();

}
