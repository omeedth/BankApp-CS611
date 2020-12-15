package Main.Requests;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract classes for requests 
 *  Pattern: Strategy Pattern
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Bank;
import Main.FancyATM;
import Main.Records.RecordEntry;
import Main.Records.RequestRecord;

public abstract class Request {

    /* Data Members */
    private int flag;

    /* Constructors */

    public Request() {
        this.flag = 0; // default flag
    }

    /* Accessor Methods */

    public int getFlag() {
        return flag;
    }

    /* Mutator Methods */

    public void setFlag(int flag) {
        this.flag = flag;
    }

    /* Logic Methods */

    // public abstract int performRequest(Bank bank, FancyATM atm); // Might return RequestResult Object (Think about later)
    public abstract int performRequest(Bank bank); // Might return RequestResult Object (Think about later)

    public RequestRecord createRecordEntry() {
    	RequestRecord record = new RequestRecord();
    	record.setOriginalRequest(this);
    	return record;
    }
    
    protected void writeRecord(Bank bank) {
    	bank.addToHistory(createRecordEntry());
    }
    
}
