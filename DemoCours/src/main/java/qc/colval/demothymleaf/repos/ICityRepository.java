package qc.colval.demothymleaf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.demothymleaf.models.entities.City;

public interface ICityRepository extends JpaRepository<City, Long> {
}
