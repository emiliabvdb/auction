package EJB;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.AuctionDAO;
import REST.AuctionResource;
import SOAP.AuctionWebResource;
import entity.Auction;
//import ejb.UserEJB;
import entity.User;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class AuctionController implements Serializable {

	private static final long serialVersionUID = 3254181235309041386L;

	private Long auctionId;
	
	private Auction auction;
	

	public String getAuc() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		
		Principal principal = request.getUserPrincipal(); 
		//this.user = userEJB.findAuctionById(principal.getName());
		auctionId = principal.getName();
		this.auction = AuctionDAO.findById(auctionId);

	}


	public List<String> getAllAuctions() {
		String allAuctString = Auction.FIND_ALL_PUBLISHED;
		String[] allAuctArray = allAuctString.split(" ");
		List<String> listOfAuc = null;
		for(int i = 0; i<allAuctArray.length; i++)
			listOfAuc.add(allAuctArray[i]);
		//AuctionDAO.findAllPublished();
		return listOfAuc;
	}
/**
	public String getProductName() {
		return productName;
	}

	public String getRemainingTime() {
		return remainingTime;
	}

	public String getImage() {
		return image;
	}

	public String getFeedback() {
		return feedback;
	}

	public String getFeature() {
		return feature;
	}
**/
	
}