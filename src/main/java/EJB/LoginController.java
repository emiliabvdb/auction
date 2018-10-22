package EJB;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named(value="loginController")
@SessionScoped
public class LoginController implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	private String password;
	
	private String email; 
	
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the username to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String validateEmailPassword() {
		HttpSession session = SessionUtils.getSession();
		session.setAttribute(Constants.USERNAME, this.email);
		return Constants.INDEX;
	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return Constants.LOGIN;
	}
	
	public String redirect() throws IOException {
		HttpSession session = SessionUtils.getSession();
		if (session.getAttribute(Constants.USERNAME)==null) {
			SessionUtils.getResponse().sendRedirect(Constants.LOGIN + ".xhtml");
		}
		return Constants.INDEX;
	}

}
