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

## Accounts Classes

---


## Currencies Classes
***Currency.java*** - Abstract class for all currencies, holding with exchange rates, name, and amount
***Dollar.java, Yen.java, Pound.java*** - Currency classes extend Currency.java.

---

## Display Classes 
***Display.java*** - Display class for front end implements Listener and Notifier to listen to and notify all GUI features. Main helper class for front end display function.

---


## Display.Pages Classes
***Page package: Page.java*** - Abstract class for Page package with basic page design and actionPerformed method for listening from back-end.
****Page.java*** - All files with page.java suffix extend Page.java, representing for corresponded user interfaces.
***UserPage.java*** - Client page where all the functions as open/close account, transactions, loan application, and deposit/withdraw show. 

---


## Requests Classes

---


## Users Classes

---


# Improvements




