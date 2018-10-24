package EJB;

import DAO.AuctionDAO;
import JMS.AuctionMessage;
import entity.Auction;
import entity.Bid;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSSessionMode;
import javax.jms.Topic;
import java.time.LocalDate;
import java.util.List;

@Singleton
public class AuctionCompleteChecker {

    @Inject
    @JMSConnectionFactory("jms/dat250/ConnectionFactory")
    @JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
    private JMSContext context;

    @Resource(lookup = "jms/dat250/Topic")
    private Topic topic;

    @EJB
    AuctionDAO auctionDAO;

    @Schedule(hour = "0", minute = "0", second = "0") // Runs every day at 00:00:00
    public void checkAllPublishedAuctions(){

        List<Auction> auctions = auctionDAO.findAllIncomplete();

        LocalDate now = LocalDate.now();

        for(Auction auction : auctions){
            LocalDate end = auction.getEndDate();

            if (now.isAfter(end)){
                auction.setComplete(true);
                auctionDAO.update(auction);

                AuctionMessage auctionMessage = new AuctionMessage();
                auctionMessage.setAuction(auction);

                auctionMessage.setSeller(auction.getOwner());

                List<Bid> bid = auction.getBids();
                Bid highestBid = bid.get(bid.size() - 1);
                auctionMessage.setWinner(highestBid.getOwner());

                context.createProducer().setProperty("AuctionStatus", "Complete").send(topic, auctionMessage);
            }

        }

    }
}
