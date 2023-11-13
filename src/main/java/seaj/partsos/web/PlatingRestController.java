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

    // Add a Plating, RESTful service
    @PostMapping("/platings")
    public Plating addPlatingRest(@RequestBody Plating plating) {
        return platingRepository.save(plating);
    }

    // // Edit a Plating, RESTful service
    // @PutMapping("/Platings/{PlatingId}")
    // public @ResponseBody Optional<Plating>
    // editPlatingRest(@PathVariable("PlatingId")
    // String PlatingId, @RequestBody Plating Plating) {
    // Optional<Plating> updatePlating = findPlatingRest(PlatingId);
    // return PlatingRepository.save(updatePlating);
    // }

    // Delete an existing Plating from the database, RESTful service
    @DeleteMapping("/platings/{platingId}")
    public String deletePlatingRest(@PathVariable("platingId") String platingId, Model model) {
        platingRepository.deleteById(platingId);
        return "redirect:/platinglist"; // Redirect to endpoint /Platinglist.html
    }

}
