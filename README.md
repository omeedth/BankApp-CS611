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

---


## Display Classes 

---


## Display.Pages Classes

---


## Requests Classes

---


## Users Classes

---


# Improvements




