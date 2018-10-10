package entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@NamedQueries({
    @NamedQuery(name = Feedback.FIND_ALL, query = "Select a From Feedback a"),
    @NamedQuery(name = Feedback.FIND_ALL_ON_BIDDER, query = "Select a From Feedback a Where a.bidder.email = :bidderId"),
    @NamedQuery(name = Feedback.FIND_ALL_ON_AUCTION, query = "Select a From Feedback a Where a.auction.id = :auctionId")
})
@Entity
public class Feedback implements Serializable {

    public static final String FIND_ALL = "FIND_ALL_FEEDBACK";
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
