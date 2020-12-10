package Main.Records;

/*
 *  Creation Date: 12/10/2020
 *  Purpose: An individual RecordEntry that will allow functionality to convert into a String for ease of use storing in a file for later
 * 
 */

/* External Imports */
import java.util.ArrayList;
import java.util.List;

/* Internal Imports */

public abstract class RecordEntry {
    
    /* Data Members */
    private String recordName;
    private List<Object> recordData;

    /* Constructors */

    public RecordEntry() {
        recordData = new ArrayList<>();
    }  

    public RecordEntry(String recordString) {

    }

    /* Accessor Methods */

    public String getRecordName() {
        return recordName;
    }

    public List<Object> getRecordData() {
        return recordData;
    }

    /* Mutator Methods */

    /* Logic Methods */

    public abstract String convertToString();

}
