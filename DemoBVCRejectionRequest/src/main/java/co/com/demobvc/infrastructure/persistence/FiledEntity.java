package co.com.demobvc.infrastructure.persistence;

import java.util.Date;
import java.util.List;

import co.com.demobvc.infrastructure.util.AppInformation;
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
import lombok.Data;

@Data
@Entity
@Table(name = "filed")
public class FiledEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sequencial;
	@NotNull
	@NotEmpty
	private String detail;
	@NotNull
	private Date creationDate;
	private String requestId;
	@OneToMany(mappedBy = "filed", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<InvoiceRefusedEntity> invoices;
	
	public void build() {
		this.setDetail(AppInformation.getInstance().getFileName());
		this.setRequestId(AppInformation.getInstance().getUid());
		this.setCreationDate(AppInformation.getInstance().getCreationdate());
	}

}
