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

    /* Data Members */
    private int id;
    private String name;
    private String username;
    private int hashedPassword;
    private List<Account> accounts;

    /* Constructors */

    // public User() {
    //     id = (int) (Math.random() * Integer.MAX_VALUE);
    //     name = "";
    //     username = "";
    //     hashedPassword = 0;
    //     accounts = new ArrayList<>();
    // }

    public User(int id, String username, int hashedPassword) {
        this.id = id;
        this.name = "";
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.accounts = new ArrayList<>();
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
    
}
