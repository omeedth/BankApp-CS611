package Main.Users;


/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract classes for users
 * 
 */

/* External Imports */
import java.util.List;
import java.util.ArrayList;

/* Internal Imports */
import Main.Accounts.Account;
import Main.Records.Recordable;

public abstract class User implements Recordable {

    /* Static/Final Members */
    public static int userCounter;

    /* Data Members */
    private int id;
    private String name;
    private String username;
    private int hashedPassword;
    private List<Account> accounts;

    /* Constructors */

    public User() {
        this("",0);
    }

    public User(String username, int hashedPassword) {
        this(userCounter,"",username,hashedPassword);
        userCounter++;
    }

    // public User(int id, String username, int hashedPassword) {
    //     this(id,"",username,hashedPassword);
    // }

    public User(String name, String username, int hashedPassword) {
        this(userCounter,name,username,hashedPassword);
        userCounter++;
    }

    public User(int id, String name, String username, int hashedPassword) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.accounts = new ArrayList<>();
    }

    /* Accessor Methods */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getHashedPassword() {
        return hashedPassword;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    /* Mutator Methods */
    public void setUsername(String username) {
    	this.username = username;
    }

    public void setHashedPassword(int hashedPassword) {
    	this.hashedPassword = hashedPassword;
    }

    /* Logic Methods */

    @Override
    public String toRecordString() {
        List<String> data = new ArrayList<>();

        /* Convert List<Account> to List<String> where it is the ids of the account */
        List<String> accountIds = new ArrayList<>();
        for (Account account : this.accounts) {
            accountIds.add(Integer.toString(account.getAccountID()));
        }

        /* Add All Data */
        data.add(Integer.toString(getId()));
        data.add(this.getClass().getSimpleName());
        data.add(getName());
        data.add(getUsername());
        data.add(Integer.toString(getHashedPassword()));    
        
        String accountIdsString = String.join("~", accountIds);
        data.add((accountIdsString.isEmpty() ? " " : accountIdsString));        

        System.out.println("Data: " + data + ", Length: " + String.join(",", data).split(",").length);

        return String.join(",", data);
    }
    
    public void addAccount(Account account) {
    	accounts.add(account);
    }

    @Override
    public String toString() {
        return "<User: " + this.getClass().getSimpleName() + ", ID: " + id + ", Name: " + name + ", Username: " + username + ", HashedPassword: " + hashedPassword + ", Accounts: " + accounts + ">";
    }
    
}
