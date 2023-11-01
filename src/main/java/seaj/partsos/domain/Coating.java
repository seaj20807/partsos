package seaj.partsos.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Coating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coatingId;
    private String material;
    private Double thickness;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coating")
    @JsonIgnoreProperties("coating")
    private List<Part> parts;

    public Coating() {
    }

    public Coating(String material, Double thickness) {
        this.material = material;
        this.thickness = thickness;
    }

    public Coating(Long coatingId, String material, Double thickness) {
        this.coatingId = coatingId;
        this.material = material;
        this.thickness = thickness;
    }

    public Long getCoatingId() {
        return coatingId;
    }

    public String getMaterial() {
        return material;
    }

    public Double getThickness() {
        return thickness;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setCoatingId(Long coatingId) {
        this.coatingId = coatingId;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Coating [coatingId=" + coatingId + ", material=" + material + ", thickness=" + thickness + "]";
    }

}
