package Main.Records;

/*
 *  Creation Date: 12/10/2020
 *  Purpose: Keep track of all record data (Users, Accounts, Transactions, etc.) - Be able to pull from a database/file and convert from Record object to database/file format
 * 
 */

/* External Imports */
import java.util.List;

/* Internal Imports */

public class Record {
    
    /* Data Members */
    List<RecordEntry> recordEntries;

    /* Constructors */

    public Record() {

    }

    /* Accessor Methods */

    public List<RecordEntry> getRecordEntries() {
        return recordEntries;
    }

    /* Mutator Methods */

    /* Logic Methods */

}
