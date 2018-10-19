package EJB;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpSession;


@Named(value="loginController")
@SessionScoped
public class LoginController implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	private String password;
	
	private String username; 
	
	
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String validateUsernamePassword() {
		HttpSession session = SessionUtils.getSession();
		session.setAttribute(Constants.USERNAME, this.username);
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
