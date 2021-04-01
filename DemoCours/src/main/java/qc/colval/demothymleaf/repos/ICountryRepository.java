package qc.colval.demothymleaf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.demothymleaf.models.entities.Country;

public interface ICountryRepository extends JpaRepository<Country, Long> {
}
