package Main.Requests;

import Main.FancyATM;
import Main.Display.Pages.ManagerPage;

public class OpenManagerPage extends Request {

	
	public OpenManagerPage() {
		
	}
	
	@Override
	public int performRequest(FancyATM atm) {
		ManagerPage p = new ManagerPage(atm.getBank());
		atm.goToPage(p);
		setFlag(1);
		return 1;
	}

}
