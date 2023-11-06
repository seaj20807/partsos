package seaj.partsos.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Part {

    @Id
    private String partId;
    private String name;
    private Double surfaceArea;
    private String baseMaterial;

    @ManyToOne
    @JsonIgnoreProperties("parts")
    @JoinColumn(name = "platingId")
    private Plating plating;

    public Part() {
    }

    public Part(String partId, String name, Double surfaceArea, String baseMaterial) {
        this.partId = partId;
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.baseMaterial = baseMaterial;
    }

    public Part(String partId, String name, Double surfaceArea, String baseMaterial, Plating plating) {
        this.partId = partId;
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.baseMaterial = baseMaterial;
        this.plating = plating;
    }

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

    public Plating getPlating() {
        return plating;
    }

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

    public void setPlating(Plating plating) {
        this.plating = plating;
    }

    @Override
    public String toString() {
        return "Part [partId=" + partId + ", name=" + name + ", surfaceArea=" + surfaceArea + ", baseMaterial="
                + baseMaterial + "]";
    }

}
