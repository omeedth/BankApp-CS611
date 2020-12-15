package Main.Records;

import java.util.HashMap;
import Main.Requests.Request;

public class RequestRecord extends RecordEntry {

	protected Request originalRequest; // TODO replace with organized data

	public RequestRecord() {
        super();
    }

	public RequestRecord(String recordString) {
        super(recordString);
    }

	public Request getOriginalRequest() {
		return originalRequest;
	}

	public void setOriginalRequest(Request originalRequest) {
		this.originalRequest = originalRequest;
	}

	@Override
	public boolean validRecordString(String recordString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashMap<String, Object> stringToRecord(String recordString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public String convertToString() {
	// 	// TODO Create proper string
	// 	return originalRequest.toString();
	// }

}
