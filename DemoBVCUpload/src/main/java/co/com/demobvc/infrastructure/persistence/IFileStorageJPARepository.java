package co.com.demobvc.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileStorageJPARepository extends JpaRepository<FileEntity, Long> {

}
