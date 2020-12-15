package Main.Users;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the Clients/Customers
 * 
 */

/* External Imports */

/* Internal Imports */

public class Client extends User {

    /* Data Members */

    /* Constructors */

    public Client(int id, String username, int hashedPassword) {
        super(id, username, hashedPassword);
    }

    public Client(int id, String name, String username, int hashedPassword) {
        super(id, name, username, hashedPassword);
    }

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */
    
}
