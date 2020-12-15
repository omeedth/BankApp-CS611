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
import javax.swing.JFrame;

/* Internal Imports */
import Main.Display.Display;
import Main.Display.Pages.*;
import Main.Utility.Listener;
import Main.Requests.*;

public class FancyATM implements Listener {

    /* Data Members */
    private Bank bank;
    private Display display;
    private boolean isRunning;

    /* Constructors */

    public FancyATM() {
        this.display = new Display();
        this.bank = new Bank();        
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

    /**
     * Initialize variables necessary for the FancyATM
     */
    public void init() {

        /* Configure Display */
        int width = 500, height = 500;

        this.display.setName("Fancy ATM");
        this.display.setTitle("Fancy ATM Application");
        this.display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.display.setSize(width, height);
        this.display.setVisible(true);

        /* Add Listeners */
        this.display.addListener(this);

    }

    public void start() {

        /* Starts the ATM */
        startRunning();

        /* Initialize the ATM */
        this.init();        

    }

    @Override
    public void update(Object obj) {
        System.out.println("Update (FancyATM): " + obj);

        /* Check what type of object is is and update accordingly */
        if (obj instanceof Request) {

            ((Request) obj).performRequest(bank, this);
        }
    }

    public void login() {
        System.out.println("Logging in...");
        this.display.changePage(new RegisterPage());
    }

}
