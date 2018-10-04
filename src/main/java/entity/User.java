/*
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.DAO.*;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class User extends SystemUser implements Serializable{

	private static final long serialVersionUID = 5082373191804671329L;
	
	
	private String firstName;

	private String lastName;

	private Date dateOfBrith;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address billingAddress;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bid> bids;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Auction> auctions;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(Date dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public List<Auction> getAuctions() {
		return auctions;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}
}
*/
