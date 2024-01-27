import java.util.ArrayList;
import java.util.Scanner;

/**
 * @GitHub <a href="https://github.com/Jamesscott34/Student-Account.git">...</a>
 *
 * @Author james Scott
 *
 * @Student sba23056
 *
 * To ensure correct outcome please enter Student.txt and Status.txt file paths
 *  Features:
 *  * - Read and manage student information.
 *  * - Display valid and invalid students.
 *  * - Calculate and save student workload.
 *  * - Provides a user-friendly menu for interaction.
 *  * - Utilizes ArrayLists for student storage.
 *  * - Includes error handling for user input.
 *  *
 *  * Main Method:
 *  * - Initializes ArrayLists for valid and invalid students.
 *  * - Creates a Scanner for user input.
 *  * - Invokes the 'runProgram' method from the Menu class to start the program.
 */

public class Main {

    public static void main(String[] args) {

        /*
         * Ensure all paths are corrected for programme implementations
         * located in Student.java and Utils.java
         */


        // Initialize ArrayLists to store valid and invalid student information
        ArrayList<String> validStudents = new ArrayList<>();
        ArrayList<String> invalidStudents = new ArrayList<>();

        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

       Student.searchForStudentFile(validStudents, invalidStudents);

        // Automatically read student information
        Student.readStudents(validStudents, invalidStudents);
        // Start the program by invoking the runProgram method from the Menu class
        Menu.runProgram(validStudents, invalidStudents, input);
    }
}

