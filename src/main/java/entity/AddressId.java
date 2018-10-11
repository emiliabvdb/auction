package entity;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

@Embeddable
class AddressId implements Serializable {

    @XmlAttribute
    private Long id;

    @XmlAttribute
    private String email;

}
