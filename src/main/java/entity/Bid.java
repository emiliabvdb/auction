package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement
@NamedQuery(name = Bid.FIND_ALL, query = "Select b From Bid b")
public class Bid {

    public final static String FIND_ALL = "FIND_ALL_BIDS";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timePlaced;

    @ManyToOne(cascade = CascadeType.ALL)
    private Auction auction;

/*
    @OneToOne(cascade = CascadeType.ALL)
    private User ower;
*/

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }

    public entity.Auction getAuction() {
        return auction;
    }

    public void setAuction(entity.Auction auction) {
        this.auction = auction;
    }

/*
    public entity.User getOwer() {
        return ower;
    }

    public void setOwer(entity.User ower) {
        this.ower = ower;
    }
*/
}
