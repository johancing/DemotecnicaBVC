package co.com.demobvc.infrastructure.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.demobvc.domain.service.IStatusChangeService;
import co.com.demobvc.infrastructure.dto.StatusChangeDto;
import co.com.demobvc.infrastructure.util.AppInformation;
import co.com.demobvc.infrastructure.util.MapperStatusChange;

@RestController
@RequestMapping(AppInformation.BASE_URL )
public class StatusChangeController {

	@Autowired
	private IStatusChangeService statusChangeService;

	@PutMapping("/status/change")
	public ResponseEntity<Object> changeStatus(@RequestBody List<StatusChangeDto> dtos) {
		statusChangeService.changeStatus(MapperStatusChange.toDomain(dtos));
		return ResponseEntity.accepted().build();
	}

}
