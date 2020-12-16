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

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Main.Accounts.Account;
import Main.Currencies.Dollar;
/* Internal Imports */
import Main.Display.Display;
import Main.Display.Pages.*;
import Main.Utility.FileParserUtility;
import Main.Utility.Listener;
import Main.Requests.*;
import Main.Users.User;

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

    static {

        /* Important Variables */
        String  metadataFile = "./Data/Metadata.csv";

        /* Load Metadata from CSV File */
        List<String> metadata = FileParserUtility.getLines(metadataFile);
        String[] ids = metadata.get(0).split(",");
        String[] bankVariables = metadata.get(1).split(",");

        /* Set ID variables */
        Transaction.transactionCount = Integer.parseInt(ids[0]);
        Account.accountCount = Integer.parseInt(ids[1]);
        User.userCounter = Integer.parseInt(ids[2]);

        /* Set Bank Variables */
        Bank.setFee(new Dollar(Double.parseDouble(bankVariables[0])));
        Bank.setInterest(Double.parseDouble(bankVariables[1]));

        /* TESTING */
        System.out.println("Loaded Metadata!\nTransaction: " + Transaction.transactionCount + "\nAccount: " + Account.accountCount + "\nUser: " + User.userCounter + "\n\nBank Fee: " + Bank.getFee() + "\nBank Interest: " + Bank.getInterest());
    }

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

        // Clean-up Code
        this.display.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
                cleanup();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
        });

    }

    public void cleanup() {
        System.out.println("Cleaning up...");

        /* Generate Data */
        List<String[]> data = new ArrayList<>();
        String[] ids = new String[3];
        String[] bankVariables = new String[2];

        /* Ids */
        String transactionCount = Integer.toString(Transaction.transactionCount);
        String accountCount = Integer.toString(Account.accountCount);
        String userCount = Integer.toString(User.userCounter);

        ids[0] = transactionCount;
        ids[1] = accountCount;
        ids[2] = userCount;

        /* Bank Variables */
        String fee = Double.toString(Bank.getFee().getQuantity());
        String interest = Double.toString(Bank.getInterest());

        bankVariables[0] = fee;
        bankVariables[1] = interest;

        /* Add into data list */
        data.add(ids);
        data.add(bankVariables);

        /* Write Data */
        try {
            FileParserUtility.generateCSVFromData(data, "./Data/Metadata.csv");
        } catch(IOException ioe) {
            System.out.println("Failed to write metadata into file! ABORTING...");
        }

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

            int status = ((Request) obj).performRequest(this);
            
            if (obj instanceof Login) {
                // Do login
                if (status == 0) {
                    // login();
                }                
            }
            // if (obj instanceof Register){
            //     register();
            // }

        }
    }

    public void login() {
        this.display.changePage(new RegisterPage());
    }

    // public void register() {
    //     System.out.println("Registering for new user...");
    //     this.display.changePage(new UserPage();)
    // }

}
