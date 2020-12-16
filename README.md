# CS611 - Object Oriented Text RPG Overview

We are creating a Banking Application

# Installation

Download all of the .java files into it's own folder and continue to usage

# Usage

When Running the program you can compile all of the java source code into runnable byte code by running the following command

***Suggested:*** use the "make.bat" and "clean.bat" files to build the project

1. Navigate into the directory with the "make.bat" and "clean.bat" files

2. Run the "make" command as shown below! (this will remove all .class files inside this directory and subdirectories of where the file is located)
```bash
./make
```

3. Run the "clean" command when you want to remove all .class files in the directory and subdirectories
```bash
./clean
```

***Alternatively:***

```bash
javac App.java
```

You can run the program by using this command

```bash
java App
```

You can remove all of the class files in the current folder with this command. (Be VERY CAREFUL. This will remove all class files in the folder)
***NOTE:*** since this project has multiple folders, you must go into each directory and run this command
 
```bash
rm *.class
```

# Game Setup

Below is an example of how you would run my game if you imported it

```java
public static void main(String args[]) {

    // Start Game
    FancyATM fancyATM = new FancyATM();
    fancyATM.start();

}
```

# Classes

## Launcher Classes

---

***App.java*** - The Launcher for the code

## Utility Classes

---

***FileParserUtility.java*** - Utility class for parsing files (will act as the helper to get information from our database)

***Listener.java*** - Interface for classes that will listen for changes from Notifier Class objects (Observer Pattern)

***Notifier.java*** - Interface for classes that will notify the Listener Class objects of changes (Observer Pattern)

## BackEnd Classes

---

***Bank.java*** - Class defining the Bank that handles all backend queries to users, transactions etc.

***FancyATM.java*** - Smart ATM that can handle all Bank operations for a customer, and allow administrative actions for the manager (Acts as the middle layer between the front-end and back-end)

***Updater.java*** - Establishes a process that does updates at certain intervals

## Accounts Classes

---

***Account.java*** - Abstract class for account types

***AdministrativeAccount.java*** - Class for administrators that can see all client information

***CheckingsAccount.java*** - Class defining checkings account

***ClientAccount.java*** - Abstract class for accounts for clients/customers

***DepositAccount.java*** - Abstract class for any account capable of depositing and withdrawing

***LoanAccount.java*** - Represents an account storing information about a client's loans

***ManagerAccount.java*** - Abstract class for accounts for managers/administrators

***SavingsAccount.java*** - Class defining savings account

***SecurityAccount.java*** - Class defining security account (stocks)

## Currencies Classes

---

***Currency.java*** - Abstract class for all currencies, holding with exchange rates, name, and amount  
***Dollar.java, Yen.java, Pound.java*** - Currency classes extend Currency.java.  

## Display Classes 

---

***Display.java*** - Display class for front end implements Listener and Notifier to listen to and notify all GUI features. Main helper class for front end display function.

## Display.Pages Classes

---

***Page package: Page.java*** - Abstract class for Page package with basic page design and actionPerformed method for listening from back-end.  
***Page.java*** - All files with page.java suffix extend Page.java, representing for corresponded user interfaces.  
***UserPage.java*** - Client page where all the functions as open/close account, transactions, loan application, and deposit/withdraw show.   

## Requests Classes

---

***AccountClosing.java*** - A request for closing an account in the Bank

***AccountOpening.java*** - A request for opening an account in the Bank

***Deposit.java*** - Class defining the deposit transaction

***JumpToAccount.java*** - A request to navigate to a specific account given the ID

***LoanApplication.java*** - A request for a loan in the bank that sends the manager a request

***LoanProcess.java*** - A request to process the loan

***LoanReview.java*** - A request to review the loan that was applied

***Login.java*** - A request for logging into an account

***OpenLoanReview.java*** - A request to open a loan review for the manager

***OpenManagerPage.java*** - A request for switching to the manager page

***PageChange.java*** - A request to jump to a certain page on the Display

***Register.java*** - A request for registering a new account

***Request.java*** - Abstract classes for requests (Strategy Pattern)

***Transaction.java*** - Abstract classes for transactions

***Withdraw.java*** - Class defining the withdraw transaction

## Records Classes

---

***AccountEntry.java*** - An individual AccountEntry for Users that will allow functionality to convert into a String for ease of use storing in a file for later

***Recordable.java*** - An interface defining what is a recordable Object to go into the Database

***RecordEntry.java*** - An individual RecordEntry that will allow functionality to convert into a String for ease of use storing in a file for later

***RecordTable.java*** - Keep track of all record data (Users, Accounts, Transactions, etc.) - Be able to pull from a database/file and convert from Record object to database/file format

***RequestEntry.java*** - All other extraneous Requests such as Loan applications

***TransactionEntry.java*** - An individual TransactionEntry for Users that will allow functionality to convert into a String for ease of use storing in a file for later

***UserEntry.java*** - An individual UserEntry for Users that will allow functionality to convert into a String for ease of use storing in a file for later
 
## Users Classes

---

***Client.java*** - Class defining the Clients/Customers

***Manager.java*** - Class defining the Manager

***User.java*** - Abstract classes for users

# Improvements




