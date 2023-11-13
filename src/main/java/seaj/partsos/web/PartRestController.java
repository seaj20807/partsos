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

import seaj.partsos.domain.Part;
import seaj.partsos.domain.PartRepository;

@CrossOrigin
@RestController
public class PartRestController {

    // Parts database
    @Autowired
    private PartRepository partRepository;

    // Find a part by its Id, RESTful service
    @GetMapping("/parts/{partId}")
    public Optional<Part> findPartRest(@PathVariable("partId") String partId) {
        return partRepository.findById(partId);
    }

    // Parts listing, RESTful service
    @GetMapping("/parts")
    public List<Part> partListRest() {
        return (List<Part>) partRepository.findAll();
    }

    // Add a part, RESTful service
    @PostMapping("/parts")
    public Part addPartRest(@RequestBody Part part) {
        return partRepository.save(part);
    }

    // // Edit a part, RESTful service
    // @PutMapping("/parts/{partId}")
    // public @ResponseBody Optional<Part> editPartRest(@PathVariable("partId")
    // String partId, @RequestBody Part part) {
    // Optional<Part> updatePart = findPartRest(partId);
    // return partRepository.save(updatePart);
    // }

    // Delete an existing part from the database, RESTful service
    @DeleteMapping("/parts/{partId}")
    public String deletePartRest(@PathVariable("partId") String partId, Model model) {
        partRepository.deleteById(partId);
        return "redirect:/partlist"; // Redirect to endpoint /partlist.html
    }

}
