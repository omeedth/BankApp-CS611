package Main.Records;

import Main.Requests.Request;

public class RequestRecord extends RecordEntry {
	
	protected Request originalRequest; //TODO replace with organized data
	
	public Request getOriginalRequest() {
		return originalRequest;
	}
	
	public void setOriginalRequest(Request originalRequest) {
		this.originalRequest = originalRequest;
	}
	
	
	@Override
	public String convertToString() {
		// TODO Create proper string
		return originalRequest.toString();
	}

}
