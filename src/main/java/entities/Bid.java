package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Bid {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public static long id;
	
	public static String name;
	
	public static double amount;
	public static Date timePlaced;
	
	@ManyToOne
	Auction auction;
	
	@OneToOne
	User ower;
	
}
