package co.com.demobvc.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusChangeJPARepository extends JpaRepository<InvoiceEntity, String> {

}
