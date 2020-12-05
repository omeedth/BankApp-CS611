package Main.Users;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract classes for users
 * 
 */

/* External Imports */

/* Internal Imports */

public abstract class User {

    /* Data Members */
    private int id;
    private String name;
    private String username;
    private int hashedPassword;

    /* Constructors */

    public User() {

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

    /* Mutator Methods */

    /* Logic Methods */
    
}
