package seaj.partsos.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Plating {

    @Id
    private String platingId;
    private String platingMaterial;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plating")
    @JsonIgnoreProperties("parts")
    private List<Part> parts;

    public Plating() {
    }

    public Plating(String platingId, String platingMaterial) {
        this.platingId = platingId;
        this.platingMaterial = platingMaterial;
    }

    public Plating(String platingId, String platingMaterial, List<Part> parts) {
        this.platingId = platingId;
        this.platingMaterial = platingMaterial;
        this.parts = parts;
    }

    public String getPlatingId() {
        return platingId;
    }

    public String getPlatingMaterial() {
        return platingMaterial;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setPlatingId(String platingId) {
        this.platingId = platingId;
    }

    public void setPlatingMaterial(String platingMaterial) {
        this.platingMaterial = platingMaterial;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Plating [platingId=" + platingId + ", platingMaterial=" + platingMaterial + ", parts=" + parts + "]";
    }

}
