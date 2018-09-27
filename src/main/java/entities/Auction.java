package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public abstract class Auction implements Serializable{
	/**
	 * 
	 */
	public Auction() {
		}
	private static final long serialVersionUID = -8947271574079458753L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	public static String productName;
	
	double rating;
	
	Date startDate;
	
	Date endDate;
	
	Boolean published;
	
	
	@ManyToOne
	User owner;

	@ManyToMany
	List<Category> category;
	
	@OneToMany
	List<Bid> bid;
	
	@OneToOne
	Feedback feedback;
	
	public abstract Bid getHighetBid();
	
	abstract User getOwer();
	
	abstract Date getStarTime();
	
	abstract Date getEndTime();
	
	abstract List<Bid> getAllBids();
	

}
