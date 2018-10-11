package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@SequenceGenerator(
    name="address_sequence",
    sequenceName="address_sequence"
)
@NamedQuery(name = Address.FIND_ALL, query = "Select a From Address a")
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address implements Serializable {

    public final static String FIND_ALL = "FIND_ALL_ADDRESS";
    private static final long serialVersionUID = -2604610351743251554L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Long id; // TODO  - @EmbeddedId AddresId -> Marshalling values to attributes

    @XmlAttribute(required = true)
    private Short zipCode;

    @XmlAttribute(required = true)
    private String country;

    @XmlAttribute(required = true)
    private String streetAddress;

    @XmlAttribute
    private String city;

    @XmlAttribute
    private String province;

    @XmlAttribute
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
