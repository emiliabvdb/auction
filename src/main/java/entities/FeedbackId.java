package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FeedbackId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4170470441284649491L;
	public User bidder;
	public Auction auction;
	
	// TODO implementer Hashcode og equals. 
	

}
