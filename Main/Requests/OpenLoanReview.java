package Main.Requests;

import Main.FancyATM;
import Main.Display.Pages.LoanReviewPage;
import Main.Display.Pages.Page;

public class OpenLoanReview extends Request{
	
	public OpenLoanReview() {
		
	}
	
	@Override
	public int performRequest(FancyATM atm) {
		LoanReviewPage p = new LoanReviewPage(atm.getBank().getManager());
		atm.goToPage(p);
		setFlag(1);
		return 1;
	}
}
