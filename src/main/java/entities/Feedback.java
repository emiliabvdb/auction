package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Feedback {
	@EmbeddedId
	FeedbackId id;
	User bidder;
	Auction auction;
	short rating;
	String comment;
	

}
