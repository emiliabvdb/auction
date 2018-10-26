package entity;


import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@NamedQueries({
    @NamedQuery(name = Feedback.FIND_ALL, query = "Select a From Feedback a"),
    @NamedQuery(name = Feedback.FIND_ALL_ON_BIDDER, query = "Select a From Feedback a Where a.bidder.email = :bidderId"),
    @NamedQuery(name = Feedback.FIND_ALL_ON_AUCTION, query = "Select a From Feedback a Where a.auction.id = :auctionId")
})
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Feedback implements Serializable {

    public static final String FIND_ALL = "FIND_ALL_FEEDBACK";
    public final static String FIND_ALL_ON_BIDDER = "FIND_ALL_FEEDBACK_ON_AUCTION";
    public final static String FIND_ALL_ON_AUCTION = "FIND_ALL_FEEDBACK_ON_BIDDER";

    final static String BIDDER_ID = "bidder_id";
    final static String AUCTION_ID = "auction_id";

    private static final long serialVersionUID = -9002657586534820292L;

    @EmbeddedId
    @XmlTransient
    private FeedbackId id;

    @XmlAttribute(required = true)
	private Short rating;

	@XmlElement
	private String comment;

    @OneToOne(optional = false)
    @XmlTransient
    @JoinColumn(name = Feedback.BIDDER_ID, nullable = false, updatable = false, insertable = false)
    private User bidder;

    @OneToOne(optional = false)
    @XmlTransient
    @JoinColumn(name = Feedback.AUCTION_ID, nullable = false, updatable = false, insertable = false)
    private Auction auction;


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
