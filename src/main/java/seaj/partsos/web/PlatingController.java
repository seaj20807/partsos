package seaj.partsos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    // Add a plating
    @GetMapping("/addplating")
    public String addPlating(Model model) {
        model.addAttribute("plating", new Plating());
        return "addplating"; // addplating.html
    }

    // Edit a plating
    @GetMapping("/editplating/{platingId}")
    public String editPlating(@PathVariable("platingId") String platingId, Model model) {
        model.addAttribute("plating", platingRepository.findById(platingId));
        return "editplating.html"; // editplating.html
    }

    // Save a new or edited plating to the database
    @PostMapping("/saveplating")
    public String savePlating(Plating plating) {
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
