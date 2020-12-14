package Main.Records;

/*
 *  Creation Date: 12/10/2020
 *  Purpose: Keep track of all record data (Users, Accounts, Transactions, etc.) - Be able to pull from a database/file and convert from Record object to database/file format
 * 
 */

/* External Imports */
import java.util.List;

/* Internal Imports */

public class RecordTable<T extends RecordEntry> {
    
    /* Data Members */
    String tableName;
    List<T> recordEntries;

    /* Constructors */

    public RecordTable() {

    }

    /* Accessor Methods */

    public String getTableName() {
        return tableName;
    }

    public List<T> getRecordEntries() {
        return recordEntries;
    }

    /* Mutator Methods */

    /* Logic Methods */

}
