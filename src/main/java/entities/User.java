package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class User extends SystemUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5082373191804671329L;
	String firstName;
	String lastName;
	Date dateOfBrith;
	Address address;
	Address billingAddress;
	List<Bid> bids;
	List<Auction> auctions;
	

}
