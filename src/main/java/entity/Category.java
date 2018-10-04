package entity;

import javax.persistence.*;
import java.io.Serializable;

@TableGenerator(name = "category", allocationSize = 1)
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 2101360422378844320L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "category")
    private String name;

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