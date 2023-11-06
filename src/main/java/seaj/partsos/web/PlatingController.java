package seaj.partsos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import seaj.partsos.domain.Plating;
import seaj.partsos.domain.PlatingRepository;

@Controller
public class PlatingController {

    // platings database
    @Autowired
    private PlatingRepository platingRepository;

    // platings listing
    @GetMapping("/platinglist")
    public String platingList(Model model) {
        model.addAttribute("platings", platingRepository.findAll());
        return "platinglist"; // platinglist.html
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
        return "redirect:/platinglist"; // Redirect to endpoint /platinglist.html
    }

}