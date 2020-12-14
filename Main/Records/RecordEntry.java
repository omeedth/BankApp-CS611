package Main.Records;

/*
 *  Creation Date: 12/10/2020
 *  Purpose: An individual RecordEntry that will allow functionality to convert into a String for ease of use storing in a file for later
 * 
 */

/* External Imports */
import java.util.HashMap;

/* Internal Imports */

public abstract class RecordEntry {
    
    /* Data Members */
    private String[] keys;
    private HashMap<String,Object> recordData;

    /* Constructors */

    public RecordEntry(String recordString) {
        this.keys = this.keys();
        boolean valid = validRecordString(recordString);
        if (valid) this.recordData = stringToRecord(recordString)
        else throw new IllegalArgumentException("Invalid Record String!");
    }

    /* Accessor Methods */

    public String[] getKeys() {
        return keys;
    }

    public HashMap<String,Object> getRecordData() {
        return recordData;
    }

    /* Mutator Methods */

    /* Logic Methods */

    public abstract String convertToString();    
    public abstract boolean validRecordString(String recordString);
    public abstract HashMap<String,Object> stringToRecord(String recordString);
    public abstract String[] keys();

}
