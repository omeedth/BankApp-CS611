package Main.Records;

import java.util.HashMap;

/*
 *  Creation Date: 12/12/2020
 *  Purpose: An individual RecordEntry for Users that will allow functionality to convert into a String for ease of use storing in a file for later
 * 
 */

/* External Imports */

/* Internal Imports */

public class UserEntry extends RecordEntry {

    /* Data Members */
    // These Variables Are in The HashMap //
    // private int id;
    // private String name;
    // private String username;
    // private int hashedPassword;

    /* Constructors */

    public UserEntry(String recordString) {
        super(recordString);
    }

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

    @Override
    public String convertToString() {
        String res = "";

        String[] keys = this.getKeys();
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            Object value = this.getRecordData().get(key);
        }

        return res;
    }

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

        return null;
    }

    @Override
    public String[] keys() {
        String[] keys = new String[4];

        /* Keys */
        keys[0] = "id";
        keys[1] = "name";
        keys[2] = "username";
        keys[3] = "hashedPassword";

        return keys;
    }

}
