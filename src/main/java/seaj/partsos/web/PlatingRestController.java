package seaj.partsos.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import seaj.partsos.domain.Plating;
import seaj.partsos.domain.PlatingRepository;

@CrossOrigin
@RestController
public class PlatingRestController {

    // Platings database
    @Autowired
    private PlatingRepository platingRepository;

    // Find a Plating by its Id, RESTful service
    @GetMapping("/platings/{platingId}")
    public Optional<Plating> findPlatingRest(@PathVariable("platingId") String platingId) {
        return platingRepository.findById(platingId);
    }

    // Platings listing, RESTful service
    @GetMapping("/platings")
    public List<Plating> platingListRest() {
        return (List<Plating>) platingRepository.findAll();
    }

}
