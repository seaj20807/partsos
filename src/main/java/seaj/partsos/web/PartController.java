package seaj.partsos.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import seaj.partsos.domain.SupplierRepository;
import seaj.partsos.domain.Part;
import seaj.partsos.domain.PartRepository;
import seaj.partsos.domain.Process;
import seaj.partsos.domain.ProcessRepository;

@Controller
public class PartController {

    // Parts database
    @Autowired
    private PartRepository partRepository;

    // Processes database
    @Autowired
    private ProcessRepository processRepository;

    // Suppliers database
    @Autowired
    private SupplierRepository supplierRepository;

    // Parts listing
    @GetMapping("/listparts")
    public String listParts(Model model) {
        model.addAttribute("parts", partRepository.findAll());
        return "listparts"; // listparts.html
    }

    // Search page
    @GetMapping("/searchparts")
    public String searchParts() {
        return "searchparts"; // searchparts.html
    }

    // Search parts by Part ID
    @GetMapping("/searchpart/id")
    public String searchPartsById(@RequestParam(name = "partId") String partId, Model model) {
        model.addAttribute("parts", partRepository.findById(partId).orElse(null));
        return "searchresults"; // listparts.html
    }

    // Search parts by Part Name
    @GetMapping("/searchpart/name")
    public String searchPartsByName(@RequestParam(name = "name") String partName, Model model) {
        List<Part> results = new ArrayList<>();
        for (Part part : partRepository.findAll()) {
            if (part.getName().contains(partName)) {
                results.add(part);
            }
        }
        model.addAttribute("parts", results);
        return "searchresults"; // listparts.html
    }

    // Search parts by Part Surface Area
    @GetMapping("/searchpart/surfacearea")
    public String searchPartsBySurfaceArea(@RequestParam(name = "surfaceArea") Double surfaceArea, Model model) {
        List<Part> results = new ArrayList<>();
        for (Part part : partRepository.findAll()) {
            if (part.getSurfaceArea() > Math.floor(surfaceArea) && part.getSurfaceArea() < Math.ceil(surfaceArea)) {
                results.add(part);
            }
        }
        model.addAttribute("parts", results);
        return "searchresults"; // listparts.html
    }

    // Search parts by Part Supplier
    @GetMapping("/searchpart/supplier")
    public String searchPartsBySupplier(@RequestParam(name = "supplier") String supplierName, Model model) {
        List<Part> results = new ArrayList<>();
        for (Part part : partRepository.findAll()) {
            if (part.getSupplier().getName().contains(supplierName)) {
                results.add(part);
            }
        }
        model.addAttribute("parts", results);
        return "searchresults"; // listparts.html
    }

    // Form for adding a part
    @GetMapping("/addpart")
    public String addPartForm(Model model) {
        model.addAttribute("part", new Part());
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "addpart"; // addpart.html
    }

    // Save a new part to the database
    @PostMapping("/addpart")
    public String addPart(@Valid @ModelAttribute Part part, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("suppliers", supplierRepository.findAll());
            return "addpart"; // addpart.html
        }
        partRepository.save(part);
        return "redirect:/listparts"; // Redirect to endpoint /listparts.html
    }

    // Edit a part
    @GetMapping("/editpart/{partId}")
    public String editPart(@PathVariable("partId") String partId, Model model) {
        model.addAttribute("part", partRepository.findById(partId));
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "editpart"; // editpart.html
    }

    // Save an edited part to the database
    @PostMapping("/savepart")
    public String savePart(@Valid @ModelAttribute Part part, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("suppliers", supplierRepository.findAll());
            return "editpart"; // editpart.html
        }
        partRepository.save(part);
        return "redirect:/listparts"; // Redirect to endpoint /listparts.html
    }

    // Delete an existing, unassociated part from the database
    @GetMapping("/deletepart/{partId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deletePart(@PathVariable("partId") String partId, Model model) {
        int matches = 0;
        for (Process process : processRepository.findAll()) {
            if (process.getPart().getPartId().equals(partId)) {
                matches += 1;
            }
        }
        if (matches == 0) {
            partRepository.deleteById(partId);
        } else {
            System.err.println("Cannot delete, a process is associated with this plating!");
        }
        return "redirect:/listparts"; // Redirect to endpoint /listparts.html
    }

}
