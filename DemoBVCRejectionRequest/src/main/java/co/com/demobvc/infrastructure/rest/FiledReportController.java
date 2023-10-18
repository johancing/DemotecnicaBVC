package co.com.demobvc.infrastructure.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.demobvc.domain.service.IReportService;
import co.com.demobvc.infrastructure.dto.FiledDto;
import co.com.demobvc.infrastructure.persistence.FiledEntity;
import co.com.demobvc.infrastructure.util.AppInformation;
import co.com.demobvc.infrastructure.util.MapperStatusChange;

@RestController
@RequestMapping(AppInformation.BASE_URL)
public class FiledReportController {
	
	@Autowired
	private IReportService reportService;

	@GetMapping("/report")
	public ResponseEntity<List<FiledDto>> getAllFiledReport() {
		List<FiledEntity> result = reportService.findAllFiledreported();
		if (result ==  null || result.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(MapperStatusChange.entityToDto(result));
	}
}
