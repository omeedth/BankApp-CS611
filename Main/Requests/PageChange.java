package Main.Requests;

import Main.FancyATM;
import Main.Display.Pages.Page;

public class PageChange extends Request {
	
	private Page page;
	
	public PageChange() {
		this(null);
	}

	public PageChange(Page page) {
		this.setPage(page);
	}

	@Override
	public int performRequest(FancyATM atm) {
		atm.goToPage(page);
		setFlag(1);
		return 1;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
