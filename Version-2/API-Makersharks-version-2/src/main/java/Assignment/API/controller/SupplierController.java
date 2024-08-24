package Assignment.API.controller;

import Assignment.API.dto.SupplierSearchRequest;
import Assignment.API.entity.Supplier;
import Assignment.API.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> searchSuppliers(
            @Validated @RequestBody SupplierSearchRequest searchRequest,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Supplier> suppliers = supplierService.searchSuppliers(
                searchRequest.getLocation(),
                searchRequest.getNatureOfBusiness(),
                searchRequest.getManufacturingProcesses(),
                page,
                size
        );

        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }
}
