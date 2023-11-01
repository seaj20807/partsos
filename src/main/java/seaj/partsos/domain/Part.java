package seaj.partsos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Part {

    @Id
    private String partId;
    private String name;
    private Double surfaceArea;
    private String baseMaterial;

    @ManyToOne
    @JoinColumn(name = "coatingId")
    private Coating coating;

    public Part() {
    }

    public Part(String partId, String name, Double surfaceArea, String baseMaterial) {
        this.partId = partId;
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.baseMaterial = baseMaterial;
    }

    public Part(String partId, String name, Double surfaceArea, String baseMaterial, Coating coating) {
        this.partId = partId;
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.baseMaterial = baseMaterial;
        this.coating = coating;
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

    public Coating getCoating() {
        return coating;
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

    public void setCoating(Coating coating) {
        this.coating = coating;
    }

    @Override
    public String toString() {
        return "Part [partId=" + partId + ", name=" + name + ", surfaceArea=" + surfaceArea + ", baseMaterial="
                + baseMaterial + "]";
    }

}
