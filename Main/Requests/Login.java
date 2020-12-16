package Main.Requests;

import javax.swing.JLabel;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class for login requests
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Bank;
import Main.Users.Client;
import Main.Users.User;
import Main.Bank;
import Main.FancyATM;
import Main.Display.Pages.LoginPage;
import Main.Display.Pages.UserPage;

public class Login extends Request {
    
    /* Data Members */
    private String username, password;

    /* Constructors */

    public Login(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public Login() {
        this("","");
    }

    /* Accessor Methods */
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

    /* Mutator Methods */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    /* Logic Methods */
    
    protected User findUser(Bank bank) {
    	//TODO: Find a user based on the username
    	return null;
    }
    
    protected boolean enterPassword(User user) {
    	//TODO: Check if the password is correct
    	return true;
    }
    
    @Override
    public int performRequest(FancyATM atm) { // , FancyATM atm
        // TODO - 1. Validates the credentials using Bank's backend
        //        2. Returns status variable whether or not it's okay to change page, etc.
        //        3. Sets the flag of this request to the status (same as the return)
        int status = 0;

        System.out.println("Logging in...");
        Bank bank = atm.getBank();
        boolean userRecordExist = bank.validateUser(username, password);
        atm.login();
        if (userRecordExist) {
        	System.out.println("Username Password Combo Exists!");
        	status = 1;
			// username pwd exist and match, go to user page
        	Client client = bank.findClient(username);
			if(client == null) { //TODO: Temporary, until userList works
				client = new Client();
				client.setUsername(username);
				client.setHashedPassword(0);
			}
			atm.getDisplay().changePage(new UserPage(client));
        } else {
        	System.out.println("Username Password Combo doesn\'t exist!");
        	status = -1;
			// stay in page if user does not exist
			JLabel msg = new JLabel("Username Password Combo doesn\'t exist! Please register for account!");
			atm.msgReturn(msg);
        }
        setFlag(status);
        return status;
    }

}
