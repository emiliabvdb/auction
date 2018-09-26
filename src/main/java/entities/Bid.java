package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = Auction.FIND_ALL, query = "select g from Bid g")
public class Bid {
	
	public static final String FIND_ALL = "findAll";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	
	double amount;
	Date timePlaced;
	
	@ManyToOne
	Auction auction;
	
	@OneToOne
	User ower;
	
}
