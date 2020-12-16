package Main.Records;

/*
 *  Creation Date: 12/10/2020
 *  Purpose: An individual RecordEntry that will allow functionality to convert into a String for ease of use storing in a file for later
 * 
 */

/* External Imports */
import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* Internal Imports */

public abstract class RecordEntry {    

    /* Data Members */
    private HashMap<String,Object> recordData;

    /* Constructors */

    // TODO: Delete Later
    public RecordEntry() {
        /* NOTE: We DONT want this to be called. I put this here temporarily */
    }

    public RecordEntry(String recordString) {
        boolean valid = validRecordString(recordString);
        if (valid) this.recordData = stringToRecord(recordString);
        else throw new IllegalArgumentException("Invalid Record String!");
    }

    /* Accessor Methods */

    public HashMap<String,Object> getRecordData() {
        return recordData;
    }

    /* Mutator Methods */

    /* Logic Methods */
  
    public boolean validRecordString(String recordString) {
        String[] values = recordString.split(",");
        String[] keys = this.getKeys();
        boolean sameLength = keys.length == values.length;
        System.out.println("Record: " + this.getClass().getSimpleName() + ", Values: " + Arrays.toString(values) + ", Keys: " + Arrays.toString(keys));
        return sameLength;
    }

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

    // public abstract boolean validRecordString(String recordString);
    // public abstract HashMap<String,Object> stringToRecord(String recordString);
    public abstract String[] getKeys();

    /* Static Methods */

    public static String convertToString(RecordEntry recordEntry) {
        List<String> resList = new ArrayList<>();
        String listSeparator = "~";
        String valueSeparator = ",";

        String[] keys = recordEntry.getKeys();
        HashMap<String,Object> recordData = recordEntry.getRecordData();
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            Object value = recordData.get(key);

            if (value instanceof Array) {
                // Doesn't Work with Array Objects
                System.out.println("Doesn\'t work with Array Objects!");
            }

            /* Depending on the Object Type we write it differently */
            if (value instanceof Collection) {
                // Lists, Sets, Arrays, etc.
                List<String> objectStrs = new ArrayList<>();
                Collection<Object> valueCollection = (Collection<Object>) value;

                // Get the list 
                for(Object obj : valueCollection) {
                    objectStrs.add(obj.toString());
                }

                // Join List with separator string
                resList.add(String.join(listSeparator,objectStrs));
            } else {
                // Individual Objects
                resList.add(value.toString());
            }

        }

        return String.join(valueSeparator, resList);
    }

    @Override
    public String toString() {
        return "<" + this.getClass().getSimpleName() + ": " + this.getRecordData() + ">";
    }

}
