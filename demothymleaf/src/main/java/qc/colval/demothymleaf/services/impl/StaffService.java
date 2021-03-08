package qc.colval.demothymleaf.services.impl;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.Staff;
import qc.colval.demothymleaf.repos.IStaffRepository;
import qc.colval.demothymleaf.services.IStaffService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffService implements IStaffService {
    private final IStaffRepository staffRepository;

    public StaffService(IStaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff create(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Optional<Staff> readOne(Long staffId) {
        return staffRepository.findById(staffId);
    }

    @Override
    public List<Staff> readAll() {
        return staffRepository.findAll();
    }

    @Override
    public void delete(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public List<Staff> getAllTenRandomStaff() {
        List<Staff> staff = staffRepository.findAll();
        Collections.shuffle(staff);
        return staff.stream().limit(10).collect(Collectors.toList());

    }
}
