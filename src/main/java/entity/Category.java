package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@TableGenerator(name = "category", allocationSize = 1)
@NamedQuery(name = Category.FIND_ALL, query = "Select c From Category c")
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Category implements Serializable {

    private static final long serialVersionUID = 2101360422378844320L;

    public static final String FIND_ALL = "FIND_ALL_CATEGORY";

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "category")
    @XmlAttribute
    private String name;

    @XmlValue
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}