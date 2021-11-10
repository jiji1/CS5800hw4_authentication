package model.business;

import java.sql.SQLException;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;
import view.LoginSuccessView;

public class LoginBusinessLayer {
	
	public String userName;
	public String password;
	User user = new User();
	LoginDataAccess lda = new LoginDataAccess();
	
	public LoginBusinessLayer() {		
	}	
	
	public Boolean validation(String userName, String password) throws ClassNotFoundException, SQLException {
		this.userName = userName;
		this.password = password;
		
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		} 
		
		user.initiate(userName, password);
		System.out.println(System.identityHashCode(user));
		
		if (!(lda.verifyCredentials(user))) {
			System.out.println(System.identityHashCode(lda));
			return false;
		} else {
			return true;
		}
		
	}
	
}
