package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SystemUser {
	@Id
	String email;
	String password;
	SystemUserRole role;
	

}
