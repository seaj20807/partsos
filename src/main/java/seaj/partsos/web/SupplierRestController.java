package seaj.partsos.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import seaj.partsos.domain.Supplier;
import seaj.partsos.domain.SupplierRepository;

@CrossOrigin
@RestController
public class SupplierRestController {

    // Suppliers database
    @Autowired
    private SupplierRepository supplierRepository;

    // Find a supplier by its Id, RESTful service
    @GetMapping("/suppliers/{supplierId}")
    public Optional<Supplier> findSupplierRest(@PathVariable("supplierId") Long supplierId) {
        return supplierRepository.findById(supplierId);
    }

    // Suppliers listing, RESTful service
    @GetMapping("/suppliers")
    public List<Supplier> supplierListRest() {
        return (List<Supplier>) supplierRepository.findAll();
    }

}
