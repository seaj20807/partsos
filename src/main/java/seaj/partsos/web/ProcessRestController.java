package seaj.partsos.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import seaj.partsos.domain.Process;
import seaj.partsos.domain.ProcessRepository;

@CrossOrigin
@RestController
public class ProcessRestController {

    // Processes database
    @Autowired
    private ProcessRepository processRepository;

    // Find a process by its Id, RESTful service
    @GetMapping("/processes/{processId}")
    public Optional<Process> findProcessRest(@PathVariable("processId") Long processId) {
        return processRepository.findById(processId);
    }

    // Processes listing, RESTful service
    @GetMapping("/processes")
    public List<Process> processListRest() {
        return (List<Process>) processRepository.findAll();
    }

    // Add a process, RESTful service
    @PostMapping("/processes")
    public Process addProcessRest(@RequestBody Process process) {
        return processRepository.save(process);
    }

}
