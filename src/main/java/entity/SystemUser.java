package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@TableGenerator(name = "system_user", allocationSize = 1)
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 5671951796348271942L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "system_user")
    @XmlAttribute(required = true)
    private String email;

    @XmlAttribute(required = true)
    private String password;

    @XmlAttribute
    private SystemUserRole role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SystemUserRole getRole() {
        return role;
    }

    public void setRole(SystemUserRole role) {
        this.role = role;
    }

}