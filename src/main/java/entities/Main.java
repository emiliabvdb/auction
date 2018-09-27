package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Address;
import entities.Auction;
import entities.Bid;
import entities.Category;
import entities.SystemUserRole;
import entities.User;

public class Main {
	public static void main(String[] args) {
		//Oppretter kategorier
		Category klaer = new Category();
		klaer.name = "Klaer";
		klaer.description = "Klaer og annet lignende";
		
		Category pynt = new Category();
		pynt.name = "Pynt";
		pynt.description = "Pyntegjenstander";
		
		Category bilder = new Category();
		bilder.name = "Bilder";
		bilder.description = "bilder, malerier, trykk og annet";
		
		Category dyrUtstyr = new Category();
		dyrUtstyr.name = "Dyr og utstyr";
		dyrUtstyr.description = "Her selges både dyr og utstyr som kreves for å ha dyr. Kjop og salg av dode dyr er forbudt.";
		
		
		//Oppretter Adresser
		Address emiAddr = new Address();
		emiAddr.streetAddress = "paaNordnesEnPlass 1234";
		emiAddr.city = "Bergen";
		emiAddr.country = "Norway";
		emiAddr.zipCode = 5009;
		
		Address friAddr = new Address();
		friAddr.streetAddress = "Styrmannsveien 15";
		friAddr.city="Haugesund";
		friAddr.country = "Norway";
		friAddr.zipCode = 5535;
		
		Address mikAddr = new Address();
		mikAddr.streetAddress = "IStavanger 1337";
		mikAddr.city = "Stavanger";
		mikAddr.country = "Norway";
		mikAddr.zipCode = 4031;
		
		
		//oppretter brukere
		User emilia = new User();
		emilia.firstName = "Emilia";
		emilia.lastName = "Botnen";
		emilia.dateOfBrith = new GregorianCalendar(1992, Calendar.DECEMBER, 07).getTime();
		emilia.address = emiAddr;
		emilia.billingAddress = emilia.address;
		emilia.email = "emibvdb@gmail.com";
		emilia.password = "EmiliaPassord";
		emilia.role = SystemUserRole.USER;
		
		
		User frida = new User();
		frida.firstName = "Frida";
		frida.lastName = "Klockmann";
		frida.dateOfBrith = new GregorianCalendar(1996, Calendar.FEBRUARY, 06).getTime();
		frida.address = friAddr;
		frida.billingAddress = frida.address;
		frida.email = "fridaklockmann@gmail.com";
		frida.password = "Fridapassord";
		frida.role = SystemUserRole.USER;
		
		User mikal = new User();
		mikal.firstName = "Mikal";
		mikal.lastName = "Fuglestein";
		mikal.dateOfBrith = new GregorianCalendar(1995, Calendar.AUGUST, 21).getTime();
		
		//creating an auction
		Auction jacketAuction = null;// = new Auction();
		jacketAuction.owner = emilia;
		jacketAuction.productName="Brukt jakke";
		jacketAuction.startDate = new GregorianCalendar(2018, Calendar.SEPTEMBER, 28).getTime();
		jacketAuction.endDate = new GregorianCalendar(2018, Calendar.OCTOBER, 10).getTime();
		jacketAuction.published = true;
		//bidList?? 
		
		List<Category> catList1 = new ArrayList<Category>(); 
		catList1.add(klaer);
		jacketAuction.category = catList1;
		
		//creating bids for auction
		Bid jacketBid1 = new Bid();
		jacketBid1.timePlaced = new GregorianCalendar(2018, Calendar.SEPTEMBER, 29).getTime();
		jacketBid1.ower = frida;
		jacketBid1.amount = 100.0;
		jacketBid1.auction = jacketAuction;
		
		Bid jacketBid2 = new Bid();
		jacketBid2.timePlaced = new GregorianCalendar(2018, Calendar.SEPTEMBER, 30).getTime();
		jacketBid2.ower = mikal;
		jacketBid2.amount = 200.0;
		jacketBid2.auction = jacketAuction;
		
		
		Auction bildeAuct = null; // = new Auction();
		bildeAuct.productName ="Stolen Child av AFK";
		List<Category> catList2 = new ArrayList<Category>(); 
		catList2.add(pynt);
		catList2.add(bilder);
		bildeAuct.category = catList2;
		bildeAuct.owner = mikal;
		bildeAuct.startDate = new GregorianCalendar(2018, Calendar.SEPTEMBER, 29).getTime();
		
		Bid bildeBid1 = new Bid();
		bildeBid1.timePlaced = new GregorianCalendar(2018, Calendar.SEPTEMBER, 30).getTime();
		bildeBid1.ower = frida;
		bildeBid1.amount = 2800;
		bildeBid1.auction = bildeAuct;
		
		Bid bildeBid2 = new Bid();
		bildeBid2.timePlaced = new GregorianCalendar(2018, Calendar.OCTOBER, 01).getTime();
		bildeBid2.ower = emilia;
		bildeBid2.amount = 3000;
		bildeBid2.auction = bildeAuct;
		
		Bid bildeBid3 = new Bid();
		bildeBid3.timePlaced = new GregorianCalendar(2018, Calendar.OCTOBER, 02).getTime();
		bildeBid3.ower = frida;
		bildeBid3.amount = 3200;
		bildeBid3.auction = bildeAuct;
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("auction");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(klaer);
		em.persist(pynt);
		em.persist(bilder);
		em.persist(dyrUtstyr);
		em.persist(emiAddr);
		em.persist(friAddr);
		em.persist(mikAddr);
		em.persist(emilia);
		em.persist(frida);
		em.persist(mikal);
		em.persist(jacketAuction);
		em.persist(jacketBid1);
		em.persist(jacketBid2);
		em.persist(bildeAuct);
		em.persist(bildeBid1);
		em.persist(bildeBid2);
		em.persist(bildeBid3);
		
		tx.commit();
		
		
	}
}
