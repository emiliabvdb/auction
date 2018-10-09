package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@TableGenerator(name = "auction", allocationSize = 1)
@Entity
@XmlRootElement
@NamedQuery(name = Auction.FIND_ALL, query = "Select a From Auction a")
@NamedQuery(name = Auction.FIND_ALL_PUBLISHED, query = "Select a From Auction a Where a.published = true")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Auction implements Serializable {

    private static final long serialVersionUID = -8947271574079458753L;

    public final static String FIND_ALL = "FIND_ALL_AUCTIONS";
    public final static String FIND_ALL_PUBLISHED = "FIND_ALL_ACUTIONS_PUBLISHED";

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "auction")
    private Long id;

    private String productName;

    private Double rating;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    private Boolean published;

    @XmlTransient
    @ManyToOne(cascade = CascadeType.MERGE)
    private User owner;

    @XmlTransient
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Category> category;

    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bid> bids;

    @XmlTransient
    @OneToOne(cascade = CascadeType.ALL)
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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
