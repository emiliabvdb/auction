package EJB;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
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
import DAO.CategoryDAO;
import REST.AuctionResource;
import SOAP.AuctionWebResource;
import entity.Auction;
import entity.Category;
//import ejb.UserEJB;
import entity.User;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class AuctionController implements Serializable {

	private static final long serialVersionUID = 3254181235309041386L;

	
	private List<Auction> allAuctions = new ArrayList<>();
	private List<Category> allCategories = new ArrayList<>();
	
	
	AuctionDAO aDAO = new AuctionDAO();
	
	CategoryDAO cDAO = new CategoryDAO();
	


	public List<Auction> getAllAuctions() {	
		List<Auction> auctionList = aDAO.findAllPublished();
		return auctionList;
	}
	
	public List<Category> getAllCategories() {	
		List<Category> catList = cDAO.findAll();
		return catList;
	}

	
}