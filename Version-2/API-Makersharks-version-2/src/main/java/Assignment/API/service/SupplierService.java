package Assignment.API.service;



import Assignment.API.entity.ManufacturingProcess;
import Assignment.API.entity.NatureOfBusiness;
import Assignment.API.entity.Supplier;
import Assignment.API.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    public Page<Supplier> searchSuppliers(
            String location,
            NatureOfBusiness natureOfBusiness,
            Set<ManufacturingProcess> manufacturingProcesses,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
                location, natureOfBusiness, manufacturingProcesses, pageable);
    }
}

