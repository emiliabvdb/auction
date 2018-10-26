package auction;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.validation.Validator;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

//import org.junit.Test;

import EJB.BidValidator;
import entity.Address;
import entity.Auction;
import entity.Bid;
import entity.Category;
import entity.DutchAuction;
import entity.EnglishAuction;
import entity.SystemUserRole;
import entity.User;
import junit.framework.TestCase;

public class AuctionAppValidator extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	//@Test
	public void shouldCheckCreditCardValidity() throws MalformedURLException {
		
		// Publishes the SOAP Web Service
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/cardValidator", new EnglishAuction());
		assertTrue(endpoint.isPublished()); assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());
	
		// Needed properties to access the web service
		URL wsdlDocumentLocation = new URL("http://localhost:8080/cardValidator?wsdl");
		String namespaceURI = "http://chapter14.javaee7.book.agoncal.org/";
		String servicePart = "CardValidatorService";
		String portName = "CardValidatorPort";
		QName serviceQN = new QName(namespaceURI, servicePart);
		QName portQN = new QName(namespaceURI, portName);
	   
		// Creates a service instance
		Service service = Service.create(wsdlDocumentLocation, serviceQN);
	    BidValidator bidVal = new BidValidator();
	
		// Invokes the web service
		 Category klaer = new Category();
	     klaer.setName("Klaer");
	     klaer.setDescription("Klaer og annet lignende");

	     Category pynt = new Category();
	     pynt.setName("Pynt");
	     pynt.setDescription("Pyntegjenstander");

	     Category bilder = new Category();
	     bilder.setName("Bilder");
	     bilder.setDescription("bilder, malerier, trykk og annet");

	     Category dyrUtstyr = new Category();
	     dyrUtstyr.setName("Dyr og utstyr");
	     dyrUtstyr.setDescription("Her selges både dyr og utstyr som kreves for å ha dyr. Kjop og salg av dode dyr er forbudt.");


	     //Oppretter Adresser
	     Address emiAddr = new Address();
	     emiAddr.setStreetAddress("paaNordnesEnPlass 1234");
	     emiAddr.setCity("Bergen");
	     emiAddr.setCountry("Norway");
	     emiAddr.setZipCode((short)5009);

	     Address friAddr = new Address();
	     friAddr.setStreetAddress("Styrmannsveien 15");
	     friAddr.setCity("Haugesund");
	     friAddr.setCountry("Norway");
	     friAddr.setZipCode((short)5535);

	     Address mikAddr = new Address();
	     mikAddr.setStreetAddress("IStavanger 1337");
	     mikAddr.setCity("Stavanger");
	     mikAddr.setCountry("Norway");
	     mikAddr.setZipCode((short)4031);


	     //oppretter brukere
	     User emilia = new User();
	     emilia.setFirstName("Emilia");
	     emilia.setLastName("Botnen");
	     emilia.setDateOfBirth(LocalDate.of(1992, 12, 07));
	     emilia.setAddress(emiAddr);
	     emilia.setBillingAddress(emilia.getAddress());
	     emilia.setEmail("emibvdb@gmail.com");
	     emilia.setPassword("EmiliaPassord");
	     emilia.setRole(SystemUserRole.USER);


	     User frida = new User();
	     frida.setFirstName("Frida");
	     frida.setLastName("Klockmann");
	     frida.setDateOfBirth(LocalDate.of(1996, 2, 06));
	     frida.setAddress(friAddr);
	     frida.setBillingAddress(frida.getAddress());
	     frida.setEmail("fridaklockmann@gmail.com");
	     frida.setPassword("Fridapassord");
	     frida.setRole(SystemUserRole.USER);

	     User mikal = new User();
	     mikal.setFirstName("Mikal");
	     mikal.setLastName("Fuglestein");
	     mikal.setDateOfBirth(LocalDate.of(1995, 8, 21));

	     //creating an auction
	     Auction jacketAuction = new EnglishAuction();
	     jacketAuction.setOwner(emilia);
	     jacketAuction.setProductName("Brukt jakke");
	     jacketAuction.setStartDate(LocalDate.of(2018, 9, 28));
	     jacketAuction.setEndDate(LocalDate.of(2018, 10, 10));
	     jacketAuction.setPublished(true);
	      //bidList??
	     Auction dutchAuction = new DutchAuction();
	     dutchAuction.setOwner(emilia);
	     dutchAuction.setProductName("Brukt jakke");
	     dutchAuction.setStartDate(LocalDate.of(2018, 9, 28));
	     dutchAuction.setEndDate(LocalDate.of(2018, 10, 10));
	     dutchAuction.setPublished(true);

	     List<Category> catList1 = new ArrayList<>();
	     catList1.add(klaer);
	     jacketAuction.setCategory(catList1);

	     //creating bids for auction
	     Bid jacketBid1 = new Bid();
	     jacketBid1.setTimePlaced(new GregorianCalendar(2018, Calendar.SEPTEMBER, 29).getTime());
	     jacketBid1.setOwner(frida);
	     jacketBid1.setAmount(100.0);
	     jacketBid1.setAuction(jacketAuction);

	     Bid jacketBid2 = new Bid();
	     jacketBid2.setTimePlaced(new GregorianCalendar(2018, Calendar.SEPTEMBER, 30).getTime());
	     jacketBid2.setOwner(mikal);
	     jacketBid2.setAmount(200.0);
	     jacketBid2.setAuction(jacketAuction);
	     

	     Auction bildeAuct = new EnglishAuction();
	     bildeAuct.setProductName("Stolen Child av AFK");
	     List<Category> catList2 = new ArrayList<>();
	     catList2.add(pynt);
	     catList2.add(bilder);
	     bildeAuct.setCategory(catList2);
	     bildeAuct.setOwner(mikal);
	   
	     bildeAuct.setStartDate(LocalDate.of(2018, 9, 29));
	    
	    Bid bildeBid1 = new Bid();
	    bildeBid1.setTimePlaced(new GregorianCalendar(2018, Calendar.SEPTEMBER, 30).getTime());
	    bildeBid1.setOwner(frida);
	    bildeBid1.setAmount(2800);
	    bildeBid1.setAuction(bildeAuct);
	     
	    Bid bildeBid2 = new Bid();
	    bildeBid2.setTimePlaced(new GregorianCalendar(2018, Calendar.OCTOBER, 01).getTime());
	    bildeBid2.setOwner(emilia);
	    bildeBid2.setAmount(3000);
	    bildeBid2.setAuction(bildeAuct);

	    Bid bildeBid3 = new Bid();
	    bildeBid3.setTimePlaced(new GregorianCalendar(2018, Calendar.OCTOBER, 02).getTime());
	    bildeBid3.setOwner(frida);
	    bildeBid3.setAmount(3200);
	    bildeBid3.setAuction(bildeAuct);
	     
	    Bid bildeBid4 = new Bid();
	    bildeBid3.setTimePlaced(new GregorianCalendar(2018, Calendar.OCTOBER, 04).getTime());
	    bildeBid3.setOwner(emilia);
	    bildeBid3.setAmount(3100);
	    bildeBid3.setAuction(bildeAuct);
	     
		assertTrue("bildeBid2 should be valid", bidVal.isValidBid(bildeBid2));
		assertFalse("bildeBid4 should not be valid", bidVal.isValidBid(bildeBid4));
		
		// Unpublishes the SOAP Web Service
		endpoint.stop();
		assertFalse(endpoint.isPublished());
	}

}
