package seaj.partsos.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Plating {

    @Id
    @NotBlank(message = "Element Symbol is mandatory")
    @Size(min = 2, max = 3, message = "Element Symbol must be between 2 and 3 characters")
    private String platingId;

    @NotBlank(message = "Plating Material is mandatory")
    @Size(min = 2, max = 20, message = "Plating Material must be between 2 and 20 characters")
    private String platingMaterial;

    @OneToMany(mappedBy = "plating")
    List<Process> processes;

    public Plating() {
    }

    public Plating(String platingId, String platingMaterial) {
        this.platingId = platingId;
        this.platingMaterial = platingMaterial;
    }

    public Plating(String platingId, String platingMaterial, List<Process> processes) {
        this.platingId = platingId;
        this.platingMaterial = platingMaterial;
        this.processes = processes;
    }

    public String getPlatingId() {
        return platingId;
    }

    public String getPlatingMaterial() {
        return platingMaterial;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setPlatingId(String platingId) {
        this.platingId = platingId;
    }

    public void setPlatingMaterial(String platingMaterial) {
        this.platingMaterial = platingMaterial;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    @Override
    public String toString() {
        return "Plating [platingId=" + platingId + ", platingMaterial=" + platingMaterial + "]";
    }

}
