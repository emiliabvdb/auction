package entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQuery(name = EnglishAuction.FIND_ALL, query = "Select a From EnglishAuction a")
public class EnglishAuction extends Auction {

    public final static String FIND_ALL = "FIND_ALL_ENGLISH_AUCTIONS";

    public EnglishAuction() {
    }

}
