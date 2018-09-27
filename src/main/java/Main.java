

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		//Oppretter kategorier
		Category klaer = new Category();
		klaer.name = "klaer";
		klaer.description = "Klaer og annet lignende";
		
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
		
		//creating an auction
		Auction auct = new EnglishAuction();
		auct.owner = emilia;
		auct.productName="Brukt jakke";
		auct.published = false;
		auct.startDate = new GregorianCalendar(2018, Calendar.SEPTEMBER, 28).getTime();
		auct.endDate = new GregorianCalendar(2018, Calendar.OCTOBER, 10).getTime();
		//bidList?? 
		
		List<Category> catList1 = new ArrayList<Category>(); 
		catList1.add(klaer);
		auct.category = catList1;
		
		//creating new bid
		Bid bid1 = new Bid();
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
	}
}
