package seaj.partsos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import seaj.partsos.domain.Coating;
import seaj.partsos.domain.CoatingRepository;

@Controller
public class CoatingController {

    // Coatings database
    @Autowired
    private CoatingRepository coatingRepository;

    // Coatings listing
    @GetMapping("/coatinglist")
    public String coatingList(Model model) {
        model.addAttribute("coatings", coatingRepository.findAll());
        return "coatinglist"; // coatinglist.html
    }

    // Add a coating
    @GetMapping("/addcoating")
    public String addCoating(Model model) {
        model.addAttribute("coating", new Coating());
        return "addcoating"; // addcoating.html
    }

    // Edit a coating
    @GetMapping("/editcoating/{coatingId}")
    public String editCoating(@PathVariable("coatingId") Long coatingId, Model model) {
        model.addAttribute("coating", coatingRepository.findById(coatingId));
        return "editcoating.html"; // editcoating.html
    }

    // Save a new or edited coating to the database
    @PostMapping("/savecoating")
    public String saveCoating(Coating coating) {
        coatingRepository.save(coating);
        return "redirect:/coatinglist"; // Redirect to endpoint /coatinglist.html
    }

}
