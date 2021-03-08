package qc.colval.demothymleaf.services;

import qc.colval.demothymleaf.models.entities.Staff;

import java.util.List;
import java.util.Optional;

public interface IStaffService {
    Staff create(Staff staff);

    Optional<Staff> readOne(Long staffId);

    List<Staff> readAll();

    void delete(Long staffId);

    List<Staff> getAllTenRandomStaff();

}
