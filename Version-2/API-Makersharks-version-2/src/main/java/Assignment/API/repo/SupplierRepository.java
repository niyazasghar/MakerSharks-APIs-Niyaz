package Assignment.API.repo;


import Assignment.API.entity.ManufacturingProcess;
import Assignment.API.entity.NatureOfBusiness;
import Assignment.API.entity.Supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
            String location,
            NatureOfBusiness natureOfBusiness,
            Set<ManufacturingProcess> manufacturingProcesses,
            Pageable pageable
    );
}