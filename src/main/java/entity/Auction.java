package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@TableGenerator(name = "auction", allocationSize = 1)
@Entity
@XmlRootElement
@NamedQuery(name = Auction.FIND_ALL, query = "Select a From Auction a")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Auction implements Serializable {

    private static final long serialVersionUID = -8947271574079458753L;

    public final static String FIND_ALL = "FIND_ALL_AUCTIONS";


    //Create elements ids automatically, incremented 1 by 1
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


/*
    @ManyToOne
    private User owner;

    @ManyToMany
    private List<Category> category;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Bid> bids;

    @OneToOne(cascade = CascadeType.ALL)
    private Feedback feedback;

/*
	@XmlElement(name = "Bid")
	public List<Bid> getBids() {
		return this.getBids();
	}
*/

    public Auction() {
    }

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

    /*
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
    */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
/*        result = prime * result + ((bids == null) ? 0 : bids.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());*/
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
/*        result = prime * result + ((owner == null) ? 0 : owner.hashCode());*/
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Auction other = (Auction) obj;
/*        if (bids == null) {
            if (other.bids != null)
                return false;
        } else if (!bids.equals(other.bids))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;*/
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (id != other.id)
            return false;
/*
        if (owner == null) {
            if (other.owner != null)
                return false;
        } else if (!owner.equals(other.owner))
            return false;
*/
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (startDate == null) {
            return other.startDate == null;
        } else return startDate.equals(other.startDate);
    }


}
