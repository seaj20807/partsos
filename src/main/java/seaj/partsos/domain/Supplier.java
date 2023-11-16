package seaj.partsos.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;

    @NotBlank(message = "Address is mandatory")
    @Size(min = 2, max = 100, message = "Address must be between 2 and 100 characters")
    private String address;

    @NotBlank(message = "Phone is mandatory")
    @Size(min = 2, max = 30, message = "Phone must be between 2 and 30 characters")
    private String phone;

    @NotBlank(message = "E-Mail is mandatory")
    @Email(message = "Invalid E-Mail address")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    @JsonIgnoreProperties("supplier")
    private List<Part> parts;

    public Supplier() {
    }

    public Supplier(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Supplier(Long supplierId, String name, String address, String phone, String email) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Supplier(Long supplierId, String name, String address, String phone, String email, List<Part> parts) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.parts = parts;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Supplier [supplierId=" + supplierId + ", name=" + name + ", address=" + address + ", phone=" + phone
                + ", email=" + email + ", parts=" + parts + "]";
    }

}
