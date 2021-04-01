package qc.colval.demothymleaf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.demothymleaf.models.entities.Staff;

public interface IStaffRepository extends JpaRepository<Staff, Long> {
}
