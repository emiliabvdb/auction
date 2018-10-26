package JMS;

import entity.Auction;
import entity.User;

import java.io.Serializable;

public class AuctionMessage implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Auction auction;
    private User winner;
    private User seller;

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
