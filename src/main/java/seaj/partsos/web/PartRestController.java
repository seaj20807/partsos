package seaj.partsos.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
