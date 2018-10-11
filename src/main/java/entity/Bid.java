package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

@NamedQueries({
    @NamedQuery(name = Bid.FIND_ALL, query = "Select b From Bid b"),
    @NamedQuery(name = Bid.FIND_ALL_ON_AUCTION, query = "Select b From Bid b Where b.auction.id = :auctionId"),
    @NamedQuery(name = Bid.FIND_ON_AUCTION, query = "Select b From Bid b Where b.auction.id = :auctionId And b.id = :id"),
    @NamedQuery(name = Bid.FIND_ALL_ON_OWNER, query = "Select b From Bid b Where b.owner.email = :ownerId")
})
@TableGenerator(name = "bid", allocationSize = 1)
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bid implements Serializable {

    public final static String FIND_ALL = "FIND_ALL_BIDS";
    public final static String FIND_ALL_ON_AUCTION = "FIND_ALL_BIDS_ON_AUCTION";
    public final static String FIND_ON_AUCTION = "FIND_BID_ON_AUCTION";
    public final static String FIND_ALL_ON_OWNER = "FIND_ALL_BIDS_ON_OWNER";

    private static final long serialVersionUID = 2992572541056266703L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "bid")
    @XmlAttribute
    private Long id;

    @ManyToOne
    @XmlTransient
    private Auction auction;

    @XmlAttribute(required = true)
    private String name;

    @XmlAttribute(required = true)
    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(required = true)
    private Date timePlaced;

    @OneToOne
    @XmlElement
    private User owner;

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

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(entity.Auction auction) {
        this.auction = auction;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
