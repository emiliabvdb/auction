package entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
    @NamedQuery(name = DutchAuction.FIND_ALL, query = "Select a From DutchAuction a"),
    @NamedQuery(name = DutchAuction.FIND_ALL_PUBLISHED, query = "Select a From DutchAuction a Where a.published = true")
})
@Entity
@XmlRootElement
public class DutchAuction extends Auction {

    private static final long serialVersionUID = -4447005297617892886L;


    public final static String FIND_ALL = "FIND_ALL_DUTHC_AUCTIONS";
    public final static String FIND_ALL_PUBLISHED = "FIND_ALL_DUTHC_AUCTIONS_PUBLISHED";

}
