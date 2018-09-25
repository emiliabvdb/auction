package entities;

import javax.persistence.Entity;

@Entity
public class Address {
	
	String streetAddress;
	short zipCode;
	String city;
	String province;
	String country;
	short floor;

}
