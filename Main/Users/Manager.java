package Main.Users;



/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the Manager
 * 
 */

/* External Imports */
import java.util.ArrayList;

/* Internal Imports */
import Main.Requests.LoanReview;

public class Manager extends User {
	
    /* Data Members */
	private ArrayList<LoanReview>uncheckedLoans;

    /* Constructors */
	public Manager() {
        super();	
        uncheckedLoans = new ArrayList<LoanReview>();	
    }
    
    public Manager(String username, int hashedPassword) {
        super(username, hashedPassword);
        uncheckedLoans = new ArrayList<LoanReview>();
    }

    public Manager(String name, String username, int hashedPassword) {
        super(name, username, hashedPassword);
        uncheckedLoans = new ArrayList<LoanReview>();
    }

    public Manager(int id, String name, String username, int hashedPassword) {
        super(id, name, username, hashedPassword);
        uncheckedLoans = new ArrayList<LoanReview>();
    }

    /* Accessor Methods */
	
	public ArrayList<LoanReview> getUncheckedLoans() {
		return uncheckedLoans;
	}

    /* Mutator Methods */

    /* Logic Methods */

	public void addLoanToApprove(LoanReview review) {
		uncheckedLoans.add(review);
	}
	
}
