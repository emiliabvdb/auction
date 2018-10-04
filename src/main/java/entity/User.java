package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = User.FIND_ALL, query = "Select a From User a")
public class User extends SystemUser implements Serializable{

	public final static String FIND_ALL = "FIND_ALL_USERS";
	private static final long serialVersionUID = 5082373191804671329L;
	
	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	@XmlTransient
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;

	@XmlTransient
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address billingAddress;

	@XmlTransient
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bid> bids;

	@XmlTransient
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
