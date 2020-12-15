package Main.Requests;

import Main.Bank;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class for register requests
 * 
 */

/* External Imports */

/* Internal Imports */

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
    public int performRequest(Bank bank) {
        // TODO - 1. Validates the credentials using Bank's backend
        //        2. Returns status variable whether or not it's okay to change page, etc.
        //        3. Sets the flag of this request to the status (same as the return)
        int status = 0;

        
        setFlag(status);
        return status;
    }

}