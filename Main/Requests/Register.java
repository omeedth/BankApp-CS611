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
import Main.FancyATM;
import Main.Records.UserEntry;
import Main.Users.Client;
import Main.Users.User;
import Main.Utility.FileParserUtility;

public class Register extends Request {
    
    /* Data Members */
    private String username;
    private String password;

    /* Constructors */

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Register() {
        this("","");
    }

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

    @Override
    public int performRequest(FancyATM atm) {
        // TODO - 1. Validates the credentials using Bank's backend
        //        2. Returns status variable whether or not it's okay to change page, etc.
        //        3. Sets the flag of this request to the status (same as the return)
        int status = 0;

        System.out.println("Registering...");
        Bank bank = atm.getBank();
        boolean userRecordExist = bank.userExists(username);
        atm.register();
        String unusableCharacters = "\s";
        String characterCheckRegex = ".*" + unusableCharacters + ".*";
        if(username.length() < 4) {
        	status = 1;
        	System.out.println("The username is too short!");
        	JLabel msg = new JLabel("The username must be at least 4 characters! Please enter another username.");
        	atm.msgReturn(msg);
        }
        else if(password.length() < 4) {
        	status = 1;
        	System.out.println("The password is too short!");
        	JLabel msg = new JLabel("The password must be at least 4 characters! Please enter another password.");
        	atm.msgReturn(msg);
        }
        else if(username.length() > 20) {
        	status = 1;
        	System.out.println("The username is too long!");
        	JLabel msg = new JLabel("The username must be at most 20 characters! Please enter another username.");
        	atm.msgReturn(msg);
        }
        else if(password.length() > 20) {
        	status = 1;
        	System.out.println("The password is too long!");
        	JLabel msg = new JLabel("The password must be at most 20 characters! Please enter another password.");
        	atm.msgReturn(msg);
        }
        else if(username.matches(characterCheckRegex)) {
        	status = 1;
        	System.out.println("The username contains an invalid character!");
        	JLabel msg = new JLabel("The username contains an invalid character! Please enter another username.");
        	atm.msgReturn(msg);
        }
        else if(password.matches(characterCheckRegex)) {
        	status = 1;
        	System.out.println("The password contains an invalid character!");
        	JLabel msg = new JLabel("The password contains an invalid character! Please enter another password.");
        	atm.msgReturn(msg);
        }
        else if (userRecordExist) {
        	status = 1;
        	System.out.println("User Exists!");
        	// username pwd exist, stay and tell go back
        	JLabel msg = new JLabel("You've already signed for an account! Please go back for login!");
        	atm.msgReturn(msg);
        } else {
        	System.out.println("User doesn\'t exist!");
        	Client client = new Client(username, password.hashCode());
        	FileParserUtility.writeLine(new UserEntry(client), UserEntry.filepath, true);
        	status = -1;
        	JLabel msg = new JLabel("Registration complete! Please go back for login!");
        	atm.msgReturn(msg);
        }
        setFlag(status);
        return status;
    }

}
