package entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
    @NamedQuery(name = EnglishAuction.FIND_ALL, query = "Select a From EnglishAuction a"),
    @NamedQuery(name = EnglishAuction.FIND_ALL_PUBLISHED, query = "Select a From EnglishAuction a Where a.published = true")
})
@Entity
@XmlRootElement
public class EnglishAuction extends Auction {

    private static final long serialVersionUID = -4447005297617892886L;


    public final static String FIND_ALL = "FIND_ALL_ENGLISH_AUCTIONS";
    public final static String FIND_ALL_PUBLISHED = "FIND_ALL_ENGLISH_AUCTIONS_PUBLISHED";

}
