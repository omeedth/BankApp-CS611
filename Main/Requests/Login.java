package Main.Requests;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class for login requests
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Bank;
import Main.Users.User;
import Main.Bank;
import Main.FancyATM;
import Main.Display.Pages.LoginPage;

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
    
    protected void login(User user, FancyATM atm) {
        atm.login();
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
        if (userRecordExist) {
            System.out.println("Username Password Combo Exists!");
        } else {
            System.out.println("Username Password Combo doesn\'t exist!");
            status = -1;
        }
        setFlag(status);
        return status;
    }

}
