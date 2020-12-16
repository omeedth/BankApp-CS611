package Main.Records;

/*
 *  Creation Date: 12/12/2020
 *  Purpose: An individual RecordEntry for Users that will allow functionality to convert into a String for ease of use storing in a file for later
 * 
 */

/* External Imports */
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* Internal Imports */
import Main.Users.User;

public class UserEntry extends RecordEntry {

    /* Static/Final Members */
    public static final String filepath = "./Data/Users.csv";
    public static final String[] keys = new String[] {"id","name","username","hashedPassword"};

    /* Data Members */

    /* Constructors */

    public UserEntry(String recordString) {
        super(recordString);
    }

    public <T extends User & Recordable> UserEntry(T recordableObj) {
        super(recordableObj.toRecordString());
    }

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */    

    @Override
    public String[] getKeys() {
        return keys;
    }

}
