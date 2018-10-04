package setup;

import DAO.AuctionDAO;
import DAO.BidDAO;
import entity.Auction;
import entity.EnglishAuction;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.GregorianCalendar;

@Singleton
@Startup
public class Setup {

    @EJB
    AuctionDAO auctionDAO;

    @EJB
    BidDAO bidDAO;

    @PostConstruct
    public void setup() {

        if (auctionDAO.findAll().size() == 0)
            this.generateAuctions();
        if (bidDAO.findAll().size() == 0)
            this.generateBids();

    }

    private void generateAuctions() {
        Auction auction = new EnglishAuction();
        auction.setProductName("English Auction 1");
        auction.setPublished(true);
        auction.setStartDate(new GregorianCalendar(2018, 9, 10, 0, 0).getTime());
        auction.setEndDate(new GregorianCalendar(2018, 11, 10, 0, 0).getTime());
        auctionDAO.create(auction);

        auction = new EnglishAuction();
        auction.setProductName("English Auction 2");
        auction.setPublished(false);
        auction.setStartDate(new GregorianCalendar(2018, 9, 18, 0, 0).getTime());
        auction.setEndDate(new GregorianCalendar(2018, 11, 23, 0, 0).getTime());
        auctionDAO.create(auction);
    }

    private void generateBids() {

    }

}
