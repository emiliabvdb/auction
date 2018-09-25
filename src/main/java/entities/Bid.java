package entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Bid {
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
