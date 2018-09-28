package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@Entity
<<<<<<< Updated upstream
@XmlRootElement
@XmlSeeAlso(Bid.class)
public abstract class Auction implements Serializable{
=======
public class Auction implements Serializable{
>>>>>>> Stashed changes
	/**
	 * 
	 */
	public Auction() {
		super();
		}
		public Auction(Collection<? extends Bid> c) {
			super();
		}
		
		@XmlElement(name = "Bid")
		public List<Bid> getBids() {
			return this.getBids();
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
	
	public Auction(String prodName, double rating, Date sdate, Date edate, Boolean publ, User owner, List<Category> catList, Feedback feedback) {
		Auction.productName = prodName;
		this.rating = rating;
		this.startDate = sdate;
		this.endDate = edate;
		this.published = publ;
		this.owner = owner;
		this.category = catList;
		this.feedback = feedback; 
	}
/*	
	public abstract Bid getHighetBid();
	
	abstract User getOwer();
	
	abstract Date getStarTime();
	
	abstract Date getEndTime();
	
	abstract List<Bid> getAllBids();
*/
	

}
