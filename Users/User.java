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
    }

    // public User(int id, String username, int hashedPassword) {
    //     this(id,"",username,hashedPassword);
    // }

    public User(String name, String username, int hashedPassword) {
        this(userCounter,name,username,hashedPassword);
    }

    public User(int id, String name, String username, int hashedPassword) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.accounts = new ArrayList<>();
        userCounter++;
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

        /* Add All Data */
        data.add(Integer.toString(getId()));
        data.add(getName());
        data.add(getUsername());
        data.add(Integer.toString(getHashedPassword()));
        // data.add(String.join("~", accounts));

        return String.join(",", data);
    }
    
    public void addAccount(Account account) {
    	accounts.add(account);
    }
    
}
