package seaj.partsos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import seaj.partsos.domain.PartRepository;
import seaj.partsos.domain.PlatingRepository;
import seaj.partsos.domain.Process;
import seaj.partsos.domain.ProcessRepository;

@Controller
public class ProcessController {

    // Parts database
    @Autowired
    PartRepository partRepository;

    // Platings database
    @Autowired
    PlatingRepository platingRepository;

    // Processes database
    @Autowired
    ProcessRepository processRepository;

    // Processes listing
    @GetMapping("/listprocesses")
    public String listProcesses(Model model) {
        model.addAttribute("processes", processRepository.findAll());
        return "listprocesses"; // listprocesses.html
    }

    // Add a process
    @GetMapping("/addprocess")
    public String addProcess(Model model) {
        model.addAttribute("process", new Process());
        model.addAttribute("parts", partRepository.findAll());
        model.addAttribute("platings", platingRepository.findAll());
        return "addprocess"; // addprocess.html
    }

    // Edit a process
    @GetMapping("/editprocess/{processId}")
    public String editProcess(@PathVariable("processId") Long processId, Model model) {
        model.addAttribute("process", processRepository.findById(processId));
        model.addAttribute("parts", partRepository.findAll());
        model.addAttribute("platings", platingRepository.findAll());
        return "editprocess"; // editprocess.html
    }

    // Save a new or edited process to the database
    @PostMapping("/saveprocess")
    public String saveProcess(Process process) {
        processRepository.save(process);
        return "redirect:/listprocesses"; // Redirect to endpoint /listprocesses.html
    }

    @GetMapping("/deleteprocess/{processId}")
    public String deleteProcess(@PathVariable("processId") Long processId, Model model) {
        processRepository.deleteById(processId);
        return "redirect:/listprocesses"; // Redirect to endpoint /listprocesses.html
    }

}
