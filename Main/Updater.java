package Main;

/* 
 *  Author: 
 *  Creation Date: 12/15/2020
 *  Purpose: Establishes a process that does updates at certain intervals
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Accounts.ClientAccount;

public class Updater implements Runnable {
    
    /* Data Members */
	private FancyATM atm;
	private double interestRate;
	private int interestInterval, sleepInterval;
	private long lastUpdated;


    /* Constructors */
	public Updater() {
		this(null);
	}

	public Updater(FancyATM atm) {
		this.atm = atm;
		interestInterval = 1000;
		sleepInterval = 1000;
		lastUpdated = atm.getLastExitTime();
		if(lastUpdated < 0) {
			lastUpdated = System.currentTimeMillis();
		}
		performUpdates();
	}


    /* Accessor Methods */
	public int getInterestInterval() {
		return interestInterval;
	}

	public int getSleepInterval() {
		return sleepInterval;
	}

	public FancyATM getATM() {
		return atm;
	}

	public double getInterestRate() {
		return interestRate;
	}


    /* Mutator Methods */
	public void setInterestInterval(int interestInterval) {
		this.interestInterval = interestInterval;
	}

	public void setSleepInterval(int sleepInterval) {
		this.sleepInterval = sleepInterval;
	}

	public void setATM(FancyATM atm) {
		this.atm = atm;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


    /* Logic Methods */
	private void doUpdateRound() {
		Bank bank = atm.getBank();
		for(ClientAccount account : bank.getClientAccounts()) {
			account.addInterest(interestRate);
		}
	}
	
	private boolean performUpdates() {
		long nextUpdate = lastUpdated + interestInterval;
		boolean updated = false;
		while(nextUpdate < System.currentTimeMillis()) {
			doUpdateRound();
			lastUpdated = nextUpdate;
			nextUpdate = lastUpdated + interestInterval;
			updated = true;
		}
		return updated;
	}

	@Override
	public void run() {
		try {
			while(atm.isRunning()) {
				Thread.sleep(sleepInterval);
				performUpdates();
			}
		} catch (InterruptedException e) {
			System.out.println("Updater thread was interrupted.");
		}
	}

}
