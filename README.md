# Student Account Management System

This Java program is designed to manage student data efficiently. It includes features such as reading and processing student information from files, displaying valid and invalid students, calculating workload, and providing a user-friendly menu for interaction.

## Table of Contents
- [Features](#features)
- [How to Run](#how-to-run)
- [Program Overview](#program-overview)
- [File Structure](#file-structure)

  
## Features

1. **Read and Manage Student Information:**

  -Reads student data from the "Student.txt" file.
  -Processes the data, validates it, and separates valid and invalid students.
  -Displays the list of all students, valid students, and invalid students.

2. **Calculate and Save Student Workload:**

   -Determines the workload for each student based on the number of classes they are enrolled in.
   -Saves the workload information along with student details to the "Status.txt" file.

3. **User-Friendly Menu:**

-Provides an interactive menu for users to navigate through different options.
-Users can view all students, display valid or invalid students separately, save valid students to a file, and exit the program.

4. **Error Handling:**

-Includes error handling for user input, ensuring smooth program execution.


## How to Run

1. **Compile the Code:**

-Ensure you have Java installed on your system.

-Open a terminal or command prompt.

-Navigate to the project directory.

-Compile the Java files using the javac command:

-bash
Copy code
javac Main.java Menu.java Student.java Utils.java

2. **Run the Program:**

-Run the compiled program using the java command:

-bash
Copy code
java Main
-Follow the on-screen instructions to interact with the menu options.

## Program Overview

1. **Main Class:**

-Entry point of the program.
-Initializes necessary data structures and starts the program execution.

2. **Menu Class:**

-Manages the user interface and menu options.
-Displays a menu for users to choose various operations.


3. **Student Class:**

-Handles student-related operations such as reading student data, processing information, and displaying students.


4. **Utils Class:**

-Provides utility methods for file handling, validation, and workload calculation.


## File Structure

Main.java: Entry point of the program.
Menu.java: Manages the user interface and menu options.
Student.java: Handles student-related operations.
Utils.java: Provides utility methods for file handling and validation.

## Author
James Scott
