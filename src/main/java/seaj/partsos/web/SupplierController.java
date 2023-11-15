package seaj.partsos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import seaj.partsos.domain.Part;
import seaj.partsos.domain.PartRepository;
import seaj.partsos.domain.Supplier;
import seaj.partsos.domain.SupplierRepository;

@Controller
public class SupplierController {

    // Suppliers database
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private PartRepository partRepository;

    // Suppliers listing
    @GetMapping("listsuppliers")
    public String listSuppliers(Model model) {
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

    // Delete an existing, unassociated supplier from the database
    @GetMapping("/deletesupplier/{supplierId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteSupplier(@PathVariable("supplierId") Long supplierId, Model model) {
        int matches = 0;
        for (Part part : partRepository.findAll()) {
            if (part.getSupplier().getSupplierId() == supplierId) {
                matches += 1;
            }
        }
        if (matches == 0) {
            supplierRepository.deleteById(supplierId);
        } else {
            System.err.println("Cannot delete, a part is associated with this supplier!");
        }
        return "redirect:/listsuppliers"; // Redirect to endpoint /listsuppliers.html
    }

}
