package seaj.partsos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long processId;

    @ManyToOne
    @JoinColumn(name = "partId")
    Part part;

    @ManyToOne
    @JoinColumn(name = "platingId")
    Plating plating;

    private Double thickness;

    public Process() {
    }

    public Process(Long processId, Part part, Plating plating, Double thickness) {
        this.processId = processId;
        this.part = part;
        this.plating = plating;
        this.thickness = thickness;
    }

    public Long getProcessId() {
        return processId;
    }

    public Part getPart() {
        return part;
    }

    public Plating getPlating() {
        return plating;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public void setPlating(Plating plating) {
        this.plating = plating;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "Process [processId=" + processId + ", part=" + part + ", plating=" + plating + ", thickness="
                + thickness + "]";
    }

}
