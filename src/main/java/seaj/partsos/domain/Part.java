package seaj.partsos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Part {

    @Id
    private String partId;
    private String name;
    private Double surfaceArea;
    private String baseMaterial;

    public Part() {
    }

    public Part(String partId, String name, Double surfaceArea, String baseMaterial) {
        this.partId = partId;
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.baseMaterial = baseMaterial;
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

    @Override
    public String toString() {
        return "Part [partId=" + partId + ", name=" + name + ", surfaceArea=" + surfaceArea + ", baseMaterial="
                + baseMaterial + "]";
    }

}
