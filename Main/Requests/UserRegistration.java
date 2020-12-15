package Main.Requests;

import Main.Bank;
import Main.FancyATM;
import Main.Users.User;

public class UserRegistration extends Request {
	
	protected User user;
	
	public UserRegistration() {
		user = null;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int performRequest(Bank bank, FancyATM atm) {
		if(bank.usernameExists(user.getUsername())) {
			setFlag(-1);
			return -1;
		}
		bank.addUser(user);
		bank.addToHistory(createRecordEntry());
		setFlag(1);
		return 1;
	}

}
