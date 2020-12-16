package Main;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the Bank
 * 
 */

/* External Imports */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/* Internal Imports */
import Main.Users.*;
import Main.Utility.FileParserUtility;
import Main.Records.AccountEntry;
import Main.Records.RequestEntry;
import Main.Records.UserEntry;
import Main.Records.RecordTable;
import Main.Records.TransactionEntry;
import Main.Currencies.Dollar;
import Main.Records.*;
import Main.Requests.*;

public class Bank {

    /* Static/Final Members */
    public static Dollar fee = new Dollar(5);
    public static double interest = 0.05;

    /* Data Members */
    private Manager manager;
    private RecordTable<RequestEntry> history;
    private RecordTable<UserEntry> users;
    private RecordTable<TransactionEntry> transactions;
    private RecordTable<AccountEntry> accounts;

    /* Temporary User Storage */
    private List<User> usersList;
    private HashMap<String,User> userMap;
    // private History bankRecord;

    /* Constructors */

    public Bank() {
        history = new RecordTable<>("History");
        users = new RecordTable<>("Users");
        accounts = new RecordTable<>("Accounts");
        transactions = new RecordTable<>("Transactions");        

        usersList = new ArrayList<>();
        // userMap = new HashMap<>();
        // bankRecord = new History();

        init();
    }

    /* Accessor Methods */
    
    public Manager getManager() {
    	return manager;
    }

    public RecordTable<UserEntry> getUsers() {
        return users;
    }

    public RecordTable<RequestEntry> getHistory() {
        return history;
    }

    public RecordTable<AccountEntry> getAccounts() {
        return accounts;
    }

    public RecordTable<TransactionEntry> getTransactions() {
        return transactions;
    }

    public List<User> getUsersList() {
        return usersList;
    }
    
    // public RecordTable<TransactionEntry> getTransactions() {
    // 	return transactions;
    // }

    /* Mutator Methods */

    /* Logic Methods */

    public void init() {

        System.out.println("Initializing Bank Records...");

        /* Fill RecordTable Objects */
        for (String line : FileParserUtility.getLines(RequestEntry.filepath)) {
            history.getRecordEntries().add(new RequestEntry(line));
        }

        for (String line : FileParserUtility.getLines(AccountEntry.filepath)) {
            accounts.getRecordEntries().add(new AccountEntry(line));
        }

        for (String line : FileParserUtility.getLines(TransactionEntry.filepath)) {
            transactions.getRecordEntries().add(new TransactionEntry(line));
        }

        List<String> lines = FileParserUtility.getLines(UserEntry.filepath);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);            
            UserEntry userEntry = new UserEntry(line);            
            users.getRecordEntries().add(userEntry);

            /* Fill User List */                     
            usersList.add(userEntry.getUser());
        }

        System.out.println("Initialized!\n\nHistory: " + history + "\nAccounts: " + accounts + "\nTransactions: " + transactions + "\nUsers: " + users + "\nUsers List: " + usersList);

    }

    /**
     * NOTE: UNUSED
     * @return
     */
    public int generateUserID() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }

    /**
     * 
     * @param username
     * @return - whether or not the username already exists
     */
    public boolean userExists(String username) {
        List<String> lines = FileParserUtility.getLines(UserEntry.filepath);
        for (String line : lines) {
            HashMap<String,Object> userRecordData = new UserEntry(line).getRecordData();
            if (username.equalsIgnoreCase(userRecordData.getOrDefault("username", null).toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param username
     * @param password
     * @return - whether or not the username, password combination exists in the set of users
     */
    public boolean validateUser(String username, String password) {
        List<String> lines = FileParserUtility.getLines(UserEntry.filepath);
        for (String line : lines) {
            HashMap<String,Object> userRecordData = new UserEntry(line).getRecordData();
            String hashedPassword = Integer.toString(password.hashCode());
            if (username.equalsIgnoreCase(userRecordData.getOrDefault("username", "").toString()) && hashedPassword.equalsIgnoreCase(userRecordData.getOrDefault("hashedPassword", "").toString())) {
                return true;
            }
        }
        return false;
    }

    public User getUserFromCredentials(String username, String password) {
        User result = null;

        // List<String> lines = FileParserUtility.getLines(UserEntry.filepath);
        // for (String line : lines) {
        //     UserEntry userEntry = new UserEntry(line);
        //     HashMap<String,Object> userRecordData = userEntry.getRecordData();
        //     String hashedPassword = Integer.toString(password.hashCode());
        //     if (username.equalsIgnoreCase(userRecordData.getOrDefault("username", "").toString()) && hashedPassword.equalsIgnoreCase(userRecordData.getOrDefault("hashedPassword", "").toString())) {
        //         result = userEntry.getUser();
        //         break;
        //     }
        // }

        String hashedPassword = Integer.toString(password.hashCode());
        for (User user : usersList) {
            if (username.equalsIgnoreCase(user.getUsername()) && hashedPassword.equalsIgnoreCase(Integer.toString(user.getHashedPassword()))) { 
                result = user;
                break;
            }
        }

        return result;
    }
    
    public void addToHistory(UserEntry entry) {
        this.users.getRecordEntries().add(entry);
    }

    public void addToHistory(AccountEntry entry) {
        this.accounts.getRecordEntries().add(entry);
    }

    public void addToHistory(TransactionEntry entry) {
        this.transactions.getRecordEntries().add(entry);
    }

    public void addToHistory(RequestEntry entry) {
        this.history.getRecordEntries().add(entry);
    }
    
    public Manager findLoanHandler() {
    	return manager;
    }

	public void sendLoanApplicationInformation(LoanReview review) {
		Manager loanHandler = findLoanHandler();
		loanHandler.addLoanToApprove(review);
	}
	
	public User findUser(String username) {
		return userMap.get(username);
	}
	
	public boolean usernameExists(String username) {
		return findUser(username) != null;
	}
	
	public void addUser(User user) {
		usersList.add(user);
		userMap.put(user.getUsername(), user);
    }
    
    /* Static Methods */

    /* NOTE: when setting fees and interest, save to the metadata file */
    public static void setFee(Dollar fee) {
        Bank.fee = fee;
    }

    public static void setInterest(double interest) {
        Bank.interest = interest;
    }

    public static Dollar getFee() {
        return Bank.fee;
    }

    public static double getInterest() {
        return Bank.interest;
    }
    
}
