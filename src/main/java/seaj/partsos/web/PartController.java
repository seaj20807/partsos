package seaj.partsos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import seaj.partsos.domain.Part;
import seaj.partsos.domain.PartRepository;

@Controller
public class PartController {

    // Parts database
    @Autowired
    private PartRepository partRepository;

    // Front page
    @GetMapping("/index")
    public String index() {
        return "index"; // index.html
    }

    // Parts listing
    @GetMapping("/partlist")
    public String partList(Model model) {
        model.addAttribute("parts", partRepository.findAll());
        return "partlist"; // partlist.html
    }

    // Add a part
    @GetMapping("/addpart")
    public String addPart(Model model) {
        model.addAttribute("part", new Part());
        return "addpart"; // addpart.html
    }

    // Edit a part
    @GetMapping("/editpart/{partId}")
    public String editPart(@PathVariable("partId") String partId, Model model) {
        model.addAttribute("part", partRepository.findById(partId));
        return "editpart"; // editpart.html
    }

    // Save a new or edited part to the database
    @PostMapping("/savepart")
    public String savePart(Part part) {
        partRepository.save(part);
        return "redirect:/partlist"; // Redirect to endpoint /partlist.html
    }

    // Delete an existing part from the database
    @GetMapping("/deletepart/{partId}")
    public String deletePart(@PathVariable("partId") String partId, Model model) {
        partRepository.deleteById(partId);
        return "redirect:/partlist"; // partlist.html
    }

}
