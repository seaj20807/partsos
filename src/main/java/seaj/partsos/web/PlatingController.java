package seaj.partsos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import seaj.partsos.domain.Plating;
import seaj.partsos.domain.PlatingRepository;
import seaj.partsos.domain.Process;
import seaj.partsos.domain.ProcessRepository;

@Controller
public class PlatingController {

    // Platings database
    @Autowired
    private PlatingRepository platingRepository;

    @Autowired
    private ProcessRepository processRepository;

    // Platings listing
    @GetMapping("/listplatings")
    public String listplatings(Model model) {
        model.addAttribute("platings", platingRepository.findAll());
        return "listplatings"; // listplatings.html
    }

    // From for adding a plating
    @GetMapping("/addplating")
    public String addPlatingForm(Model model) {
        model.addAttribute("plating", new Plating());
        return "addplating"; // addplating.html
    }

    // Save a new plating to the database
    @PostMapping("/addplating")
    public String addPlating(@Valid @ModelAttribute Plating plating, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addplating"; // addplating.html
        }
        platingRepository.save(plating);
        return "redirect:/listplatings"; // Redirect to endpoint /listplatings.html
    }

    // Edit a plating
    @GetMapping("/editplating/{platingId}")
    public String editPlating(@PathVariable("platingId") String platingId, Model model) {
        model.addAttribute("plating", platingRepository.findById(platingId));
        return "editplating"; // editplating.html
    }

    // Save an edited plating to the database
    @PostMapping("/saveplating")
    public String savePlating(@Valid @ModelAttribute Plating plating, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editplating"; // editplating.html
        }
        platingRepository.save(plating);
        return "redirect:/listplatings"; // Redirect to endpoint /listplatings.html
    }

    // Delete an existing, unassociated plating from the database
    @GetMapping("/deleteplating/{platingId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deletePlating(@PathVariable("platingId") String platingId, Model model) {
        int matches = 0;
        for (Process process : processRepository.findAll()) {
            if (process.getPlating().getPlatingId().equals(platingId)) {
                matches += 1;
            }
        }
        if (matches == 0) {
            platingRepository.deleteById(platingId);
        } else {
            System.err.println("Cannot delete, a process is associated with this plating!");
        }
        return "redirect:/listplatings"; // Redirect to endpoint /listplatings.html
    }

}
