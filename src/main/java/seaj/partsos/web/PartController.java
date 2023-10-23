package seaj.partsos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
