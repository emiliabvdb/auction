package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	long id;
	
	String streetAddress;
	short zipCode;
	String city;
	String province;
	String country;
	short floor;

}
