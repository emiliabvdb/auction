package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Bid.class)
public class Bids {
	
	private static final long serialVersionUID = 1L;
	
	public Bids() {
		super();
		}
		public Bids(Collection<? extends Bid> c) {
			super();
		}
		
		@XmlElement(name = "Bid")
		public List<Bid> getBids() {
			return this.getBids();
		}
		//public void setBooks(List<Bid> Bids) {
			//this.addAll(Bids);
		//}
}
