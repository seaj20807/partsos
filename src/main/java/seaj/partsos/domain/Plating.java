package seaj.partsos.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Plating {

    @Id
    private String platingId;
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
