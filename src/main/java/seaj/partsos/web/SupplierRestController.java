package seaj.partsos.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import seaj.partsos.domain.Supplier;
import seaj.partsos.domain.SupplierRepository;

@CrossOrigin
@RestController
public class SupplierRestController {

    // suppliers database
    @Autowired
    private SupplierRepository supplierRepository;

    // Find a supplier by its Id, RESTful service
    @GetMapping("/suppliers/{supplierId}")
    public Optional<Supplier> findsupplierRest(@PathVariable("supplierId") Long supplierId) {
        return supplierRepository.findById(supplierId);
    }

    // suppliers listing, RESTful service
    @GetMapping("/suppliers")
    public List<Supplier> supplierListRest() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    // Add a supplier, RESTful service
    @PostMapping("/suppliers")
    public Supplier addsupplierRest(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // // Edit a supplier, RESTful service
    // @PutMapping("/suppliers/{supplierId}")
    // public @ResponseBody Optional<supplier>
    // editsupplierRest(@PathVariable("supplierId")
    // String supplierId, @RequestBody supplier supplier) {
    // Optional<supplier> updatesupplier = findsupplierRest(supplierId);
    // return supplierRepository.save(updatesupplier);
    // }

    // Delete an existing supplier from the database, RESTful service
    @DeleteMapping("/suppliers/{supplierId}")
    public String deletesupplierRest(@PathVariable("supplierId") Long supplierId, Model model) {
        supplierRepository.deleteById(supplierId);
        return "redirect:/platinglist"; // Redirect to endpoint /Platinglist.html
    }

}
