package setup;

import DAO.*;
import entity.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Singleton
@Startup
public class Setup {

    @EJB
    AuctionDAO auctionDAO;

    @EJB
    BidDAO bidDAO;

    @EJB
    AddressDAO addressDAO;


    @EJB
    CategoryDAO categoryDAO;

    @EJB
    UserDAO userDAO;

    @PostConstruct
    public void setup() {

        if (!auctionDAO.findAll().isEmpty())
            return;

        System.out.print("SETUP STARTED");
        //Oppretter kategorier
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
        emilia.setDateOfBirth(new GregorianCalendar(1992, Calendar.DECEMBER, 07).getTime());
        emilia.setAddress(emiAddr);
        emilia.setBillingAddress(emilia.getAddress());
        emilia.setEmail("emibvdb@gmail.com");
        emilia.setPassword("EmiliaPassord");
        emilia.setRole(SystemUserRole.USER);


        User frida = new User();
        frida.setFirstName("Frida");
        frida.setLastName("Klockmann");
        frida.setDateOfBirth(new GregorianCalendar(1996, Calendar.FEBRUARY, 06).getTime());
        frida.setAddress(friAddr);
        frida.setBillingAddress(frida.getAddress());
        frida.setEmail("fridaklockmann@gmail.com");
        frida.setPassword("Fridapassord");
        frida.setRole(SystemUserRole.USER);

        User mikal = new User();
        mikal.setFirstName("Mikal");
        mikal.setLastName("Fuglestein");
        mikal.setDateOfBirth(new GregorianCalendar(1995, Calendar.AUGUST, 21).getTime());

        //creating an auction
        Auction jacketAuction = new EnglishAuction();
        jacketAuction.setOwner(emilia);
        jacketAuction.setProductName("Brukt jakke");
        jacketAuction.setStartDate(new GregorianCalendar(2018, Calendar.SEPTEMBER, 28).getTime());
        jacketAuction.setEndDate(new GregorianCalendar(2018, Calendar.OCTOBER, 10).getTime());
        jacketAuction.setPublished(true);
        //bidList??
        Auction dutchAuction = new DutchAuction();
        dutchAuction.setOwner(emilia);
        dutchAuction.setProductName("Brukt jakke");
        dutchAuction.setStartDate(new GregorianCalendar(2018, Calendar.SEPTEMBER, 28).getTime());
        dutchAuction.setEndDate(new GregorianCalendar(2018, Calendar.OCTOBER, 10).getTime());
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
        bildeAuct.setStartDate(new GregorianCalendar(2018, Calendar.SEPTEMBER, 29).getTime());

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

        try{
            categoryDAO.create(klaer);
            categoryDAO.create(pynt);
            categoryDAO.create(bilder);
            categoryDAO.create(dyrUtstyr);
            addressDAO.create(emiAddr);
            addressDAO.create(friAddr);
            addressDAO.create(mikAddr);
            userDAO.create(emilia);
            userDAO.create(frida);
            userDAO.create(mikal);
            auctionDAO.create(dutchAuction);
            auctionDAO.create(jacketAuction);
            bidDAO.create(jacketBid1);
            bidDAO.create(jacketBid2);
            auctionDAO.create(bildeAuct);
            bidDAO.create(bildeBid1);
            bidDAO.create(bildeBid2);
            bidDAO.create(bildeBid3);
        } catch (Exception e){
            System.err.print(e.getMessage());
        }

        System.out.print("SETUP FINNISHED");

    }
}
