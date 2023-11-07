package seaj.partsos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import seaj.partsos.domain.Supplier;
import seaj.partsos.domain.SupplierRepository;

@Controller
public class SupplierController {

    // Suppliers database
    @Autowired
    private SupplierRepository supplierRepository;

    // Suppliers listing
    @GetMapping("listsuppliers")
    public String listsuppliers(Model model) {
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "listsuppliers"; // listsuppliers.html
    }

    // Add a supplier
    @GetMapping("/addsupplier")
    public String addSupplier(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "addsupplier"; // addsupplier.html
    }

    // Edit a supplier
    @GetMapping("/editsupplier/{supplierId}")
    public String editSupplier(@PathVariable("supplierId") Long supplierId, Model model) {
        model.addAttribute("supplier", supplierRepository.findById(supplierId));
        return "editsupplier.html";
    }

    // Save a new or edited supplier to the database
    @PostMapping("/savesupplier")
    public String saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
        return "redirect:/listsuppliers"; // Redirect to endpoint /listsuppliers.html
    }

}
