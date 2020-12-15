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
    public boolean validRecordString(String recordString) {
        String[] values = recordString.split(",");
        String[] keys = this.getKeys();
        boolean sameLength = keys.length == values.length;
        return sameLength;
    }

    @Override
    public HashMap<String,Object> stringToRecord(String recordString) {
        HashMap<String,Object> data = new HashMap<>();
        String[] values = recordString.split(",");
        String[] keys = this.getKeys();

        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            String key = keys[i];
            data.put(key, value);
        }

        return data;
    }

    @Override
    public String[] getKeys() {
        return keys;
    }

}
