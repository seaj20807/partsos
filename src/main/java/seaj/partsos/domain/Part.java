package seaj.partsos.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Part {

    @Id
    @NotBlank(message = "Part ID is mandatory")
    @Size(min = 2, max = 15, message = "Part ID must be between 2 and 15 characters")
    private String partId;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Part ID must be between 2 and 50 characters")
    private String name;
    private Double surfaceArea;
    private String baseMaterial;

    @ManyToOne
    @JsonIgnoreProperties("parts")
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @OneToMany(mappedBy = "part")
    List<Process> processes;

    // private Plating plating;

    public Part() {
    }

    public Part(String partId, String name, Double surfaceArea, String baseMaterial) {
        this.partId = partId;
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.baseMaterial = baseMaterial;
    }

    public Part(String partId, String name, Double surfaceArea, String baseMaterial, Supplier supplier) {
        this.partId = partId;
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.baseMaterial = baseMaterial;
        this.supplier = supplier;
    }

    // public Part(String partId, String name, Double surfaceArea, String
    // baseMaterial, Plating plating) {
    // this.partId = partId;
    // this.name = name;
    // this.surfaceArea = surfaceArea;
    // this.baseMaterial = baseMaterial;
    // this.plating = plating;
    // }

    public String getPartId() {
        return partId;
    }

    public String getName() {
        return name;
    }

    public Double getSurfaceArea() {
        return surfaceArea;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    // public Plating getPlating() {
    // return plating;
    // }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurfaceArea(Double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    // public void setPlating(Plating plating) {
    // this.plating = plating;
    // }

    @Override
    public String toString() {
        return "Part [partId=" + partId + ", name=" + name + ", surfaceArea=" + surfaceArea + ", baseMaterial="
                + baseMaterial + "]";
    }

}
