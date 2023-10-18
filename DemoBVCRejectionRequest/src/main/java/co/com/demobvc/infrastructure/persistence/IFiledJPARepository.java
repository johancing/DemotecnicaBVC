package co.com.demobvc.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFiledJPARepository extends JpaRepository<FiledEntity, String> {

}
