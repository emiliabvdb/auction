package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	String name;
	
	String description;
	

}
