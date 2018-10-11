package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SequenceGenerator(
    name="auction_sequence",
    sequenceName="auction_sequence"
)
@NamedQueries({
    @NamedQuery(name = Auction.FIND_ALL, query = "Select a From Auction a"),
    @NamedQuery(name = Auction.FIND_ALL_PUBLISHED, query = "Select a From Auction a Where a.published = true")
})
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Auction implements Serializable {

    private static final long serialVersionUID = -8947271574079458753L;

    public final static String FIND_ALL = "FIND_ALL_AUCTIONS";
    public final static String FIND_ALL_PUBLISHED = "FIND_ALL_AUCTIONS_PUBLISHED";


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auction_sequence")
    @XmlAttribute
    private Long id;

    @XmlAttribute(required = true)
    private String productName;

    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(required = true)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(required = true)
    private Date endDate;

    @XmlAttribute(required = true)
    private Boolean published;

    @ManyToOne(fetch = FetchType.LAZY)
    @XmlTransient
    private User owner;

    @ManyToMany
    @XmlElement
    private List<Category> category = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auction", orphanRemoval = true)
    @XmlElement
    @OrderBy("amount")
    private List<Bid> bids = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "auction", orphanRemoval = true)
    @XmlElement
    private Feedback feedback;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public entity.User getOwner() {
        return owner;
    }

    public void setOwner(entity.User owner) {
        this.owner = owner;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

}
