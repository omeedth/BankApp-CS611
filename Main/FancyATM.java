package Main;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Smart ATM that can handle all Bank operations for a customer, and allow administrative actions for the manager
 * 
 *          Client:
 *          1. Create Accounts (savings, checkings and optionally security accounts)
 *          2. Support Multiple currency deposits
 *          3. Allow clients to take out loans
 *          4. View past transactions + current balance
 *          5. Withdraw money
 *          6. Have fees applied to transactions, opening, and closing accounts
 *          7. Stock market account for users with $5000+ in their savings account
 * 
 *          Manager:
 *          1. Look at specific customers
 *          2. Daily reports of transactions for the days
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Display.Display;
import Main.Display.Pages.*;
import Main.Users.User;
import Main.Requests.*;

public class FancyATM {
    
    /* Data Members */
    private Bank bank;
    private Display display;
    private boolean isRunning;

    /* Constructors */

    public FancyATM() {
        display = new Display();
        bank = new Bank();
    }

    /* Accessor Methods */

    public Bank getBank() {
        return bank;
    }

    public Display getDisplay() {
        return display;
    }

    /* Mutator Methods */

    public void startRunning() {
        this.isRunning = true;
    }

    public void stopRunning() {
        this.isRunning = false;
    }

    /* Logic Methods */

    public void start() {

        /* Starts the ATM */
        startRunning();

        /* Continually wait for actions on the Display */
        while(this.isRunning) {

            Request request = this.display.getCurrentRequest();
            if (request != null) {
                /* Fulfill the request */          
                int status = request.performRequest(bank);

                /*  */
                
            }

        }

    }

}
