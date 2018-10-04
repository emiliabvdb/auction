package entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
@NamedQuery(name = Feedback.FIND_ALL_ON_BIDDER, query = "Select a From Feedback a Where a.bidder = :bidderId")
@NamedQuery(name = Feedback.FIND_ALL_ON_AUCTION, query = "Select a From Feedback a Where a.auction = :auctionId")
public class Feedback implements Serializable {

    public final static String FIND_ALL_ON_BIDDER = "FIND_ALL_FEEDBACK_ON_AUCTION";
    public final static String FIND_ALL_ON_AUCTION = "FIND_ALL_FEEDBACK_ON_BIDDER";

    private static final long serialVersionUID = -9002657586534820292L;

    @Id
    @XmlTransient
    @OneToOne
    private User bidder;

    @Id
    @XmlTransient
    @OneToOne
    private Auction auction;

	private Short rating;

	private String comment;

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Short getRating() {
		return rating;
	}

	public void setRating(Short rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
