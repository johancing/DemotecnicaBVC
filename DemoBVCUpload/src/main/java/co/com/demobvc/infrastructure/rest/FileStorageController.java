package co.com.demobvc.infrastructure.rest;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import co.com.demobvc.domain.service.IFileStorageService;
import co.com.demobvc.domain.vo.Invoice;
import co.com.demobvc.infrastructure.util.AppInformation;

@RestController
@RequestMapping(AppInformation.BASE_URL)
public class FileStorageController {

	@Autowired
	private IFileStorageService fileStorageService;

	@GetMapping("/{id}")
	public ResponseEntity<List<Invoice>> findInvoicesByHeaderId(@PathVariable("id") long id) {
		List<Invoice> response = fileStorageService.findAllByHeaderId(id);
		if (response == null || response.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(response);
	}

	@PostMapping("/upload")
	public ResponseEntity<String> handleFileStorage(@RequestParam("file") MultipartFile file) throws Exception {
		AppInformation.getInstance().setFileName(file.getOriginalFilename());
		Long resultId = fileStorageService.storeFile(file.getInputStream());
		return ResponseEntity.created(new URI(AppInformation.BASE_URL + "/" + resultId)).build();
	}
}
