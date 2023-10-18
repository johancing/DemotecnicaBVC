package co.com.demobvc.infrastructure.persistence;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "header")
public class FileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sequencial;
	@NotNull
	@NotEmpty
	private String fileName;
	@NotNull
	private Date uploadDate;
	private String requestId;
	@OneToMany(mappedBy = "header", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<InvoiceEntity> invoices;

	public FileEntity() {
	}

	public FileEntity(@NotNull @NotEmpty String fileName, @NotNull Date uploadDate) {
		super();
		this.fileName = fileName;
		this.uploadDate = uploadDate;
	}

	public Long getSequencial() {
		return sequencial;
	}

	public void setSequencial(Long sequencial) {
		this.sequencial = sequencial;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public List<InvoiceEntity> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<InvoiceEntity> invoices) {
		this.invoices = invoices;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "FileEntity [sequencial=" + sequencial + ", fileName=" + fileName + ", uploadDate=" + uploadDate
				+ ", invoices=" + invoices + "]";
	}

}
