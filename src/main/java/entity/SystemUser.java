package entity;

import javax.persistence.*;
import java.io.Serializable;

@TableGenerator(name = "system_user", allocationSize = 1)
@Entity
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 5671951796348271942L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "system_user")
    private String email;

    private String password;

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