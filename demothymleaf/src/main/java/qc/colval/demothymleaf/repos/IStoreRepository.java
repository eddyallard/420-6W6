package qc.colval.demothymleaf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.demothymleaf.models.entities.Store;

public interface IStoreRepository extends JpaRepository<Store, Long> {
}
