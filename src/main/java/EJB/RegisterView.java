package EJB;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import DAO.AddressDAO;
import DAO.UserDAO;
import entity.Address;
import entity.User;

@Named(value= "registerView")
@SessionScoped
public class RegisterView implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(RegisterView.class.getName());
	@Inject
	private UserDAO userDAO;
	private AddressDAO addressDAO;
	private String name;
	private String email;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String dateStr;
	private String streetAddress;

    private String zipCode;
    private String city;
    private String province;
    private String country;
    private String floor;
    
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    
	
	public void validatePassword(ComponentSystemEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UIComponent components = event.getComponent();
		// get password
		UIInput uiInputPassword = (UIInput) components.findComponent("password");
		String password = uiInputPassword.getLocalValue() == null ? "" : uiInputPassword.getLocalValue().toString();
		String passwordId = uiInputPassword.getClientId();
		// get confirm password
		UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirmpassword");
		String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
				: uiInputConfirmPassword.getLocalValue().toString();
		// Let required="true" do its job.
		if (password.isEmpty() || confirmPassword.isEmpty()) {
			return;
		}
		if (!password.equals(confirmPassword)) {
			FacesMessage msg = new FacesMessage("Confirm password does not match password");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			facesContext.addMessage(passwordId, msg);
			facesContext.renderResponse();
		}
		if (userDAO.findByEmail(email) != null) {
			FacesMessage msg = new FacesMessage("User with this e-mail already exists");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			facesContext.addMessage(passwordId, msg);
			facesContext.renderResponse();
		}
	}
	public String register() {
		Address address = new Address(this.streetAddress, this.zipCode, this.city, this.country, this.province, this.floor);
		addressDAO.create(address);
		LocalDate date = LocalDate.of(this.birthYear, this.birthMonth, this.birthDay);
		User user = new User(email, password, firstName, lastName, date, address);
		userDAO.create(user);
		log.info("New user created with e-mail: " + email + " , first name: " + name + " , last name: " + lastName + ".");
		return "regdone";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

}
