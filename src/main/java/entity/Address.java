package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@TableGenerator(name = "Address", allocationSize = 1)
@NamedQuery(name = Address.FIND_ALL, query = "Select a From Address a")
public class Address implements Serializable {

    public final static String FIND_ALL = "FIND_ALL_ADDRESS";
    private static final long serialVersionUID = -2604610351743251554L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Address")
    private Long id;

    private String streetAddress;

    private Short zipCode;

    private String city;

    private String province;

    private String country;

    private Short floor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Short getZipCode() {
        return zipCode;
    }

    public void setZipCode(Short zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Short getFloor() {
        return floor;
    }

    public void setFloor(Short floor) {
        this.floor = floor;
    }
}
