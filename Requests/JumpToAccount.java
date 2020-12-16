package Main.Requests;

import javax.swing.JLabel;

import Main.FancyATM;
import Main.Accounts.Account;
import Main.Accounts.CheckingsAccount;
import Main.Accounts.SavingsAccount;
import Main.Display.Pages.CheckingPage;
import Main.Display.Pages.SavingsPage;
import Main.Display.Pages.UserPage;
import Main.Users.Client;
import Main.Users.User;

public class JumpToAccount extends Request {
	
	private Client client;
	private String accountString;

	public JumpToAccount() {
		this(null, "");
	}
	
	public JumpToAccount(Client client, String accountString) {
		this.setClient(client);
		this.accountString = accountString;
	}
	
	public String getAccountString() {
		return accountString;
	}

	public void setAccountString(String accountString) {
		this.accountString = accountString;
	}

	@Override
	public int performRequest(FancyATM atm) {
		// TODO Auto-generated method stub
		int status = 0;
		int accountID = -1;
		try {
			accountID = Integer.parseInt(accountString);
			status = 1;
			Account account = Account.getAccountByID(accountID);
			if(account == null || account.getAccountHolder() != client) {
				System.out.println("That account is not accessible.");
				atm.goToPage(new UserPage(client));
				JLabel msg = new JLabel("That account is not accessible.");
				atm.msgReturn(msg);
				status = -1;
				atm.goToPage(new UserPage(client));
			}
			else if(account instanceof CheckingsAccount) {
				System.out.println("Going to account");
				atm.goToPage(new CheckingPage((CheckingsAccount)account));
			}
			else if(account instanceof SavingsAccount) {
				System.out.println("Going to account");
				atm.goToPage(new SavingsPage((SavingsAccount)account));
			}
		}
		catch(Exception e) {
			System.out.println("The account ID is not an int");
			atm.goToPage(new UserPage(client));
			JLabel msg = new JLabel("Please make sure the account ID is an integer");
			atm.msgReturn(msg);
			status = -1;
		}
		return status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
