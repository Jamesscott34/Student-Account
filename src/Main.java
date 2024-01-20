import java.util.ArrayList;
import java.util.Scanner;

/**
 * @GitHub <a href="https://github.com/Jamesscott34/Student-Account.git">...</a>
 *
 * @Author james Scott
 *
 * @Student sba23056
 *  Features:
 *  * - Read and manage student information.
 *  * - Display valid and invalid students.
 *  * - Calculate and save student workload.
 *  * - Add new students and edit invalid student details.
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
    static String statusPath = "C:\\Users\\35387\\Desktop\\Ca1 main\\class-asignment\\Student-Account\\src\\Status.txt";
    static String studentPath = "C:\\Users\\35387\\Desktop\\Ca1 main\\class-asignment\\Student-Account\\src\\Student.txt";

    public static void main(String[] args) {
        // Initialize ArrayLists to store valid and invalid student information
        ArrayList<String> validStudents = new ArrayList<>();
        ArrayList<String> invalidStudents = new ArrayList<>();
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);


        // Start the program by invoking the runProgram method from the Menu class
        Menu.runProgram(validStudents, invalidStudents,input);

    }
}

