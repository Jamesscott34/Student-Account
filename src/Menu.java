import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the menu options and user interface for the Student Account Management System.
 */
public class Menu {
    /**
     * Displays the menu options.
     */
    public static void showMenu() {
        System.out.println("1. Read Students");
        System.out.println("2. Show Valid Students");
        System.out.println("3. Show Invalid Students");
        System.out.println("4. Save Workload to status.txt");
        System.out.println("5. Add New Student");
        System.out.println("6. Edit invalid students");
        System.out.println("7. Exit");
    }
    /**
     * Runs the program based on user input.
     *
     * @param validStudents   List of valid students.
     * @param invalidStudents List of invalid students.
     * @param input           Scanner for user input.
     */
    public static void runProgram(ArrayList<String> validStudents, ArrayList<String> invalidStudents, Scanner input) {

        while (true) {
            Menu.showMenu();
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    Student.readStudents(validStudents, invalidStudents);
                    System.out.println("Students read successfully.");
                    break;
                case 2:
                    Student.showStudents(validStudents, "Valid Students");
                    break;
                case 3:
                    Student.showStudents(invalidStudents, "Invalid Students");
                    break;
                case 4:
                    Utils.saveWorkload(validStudents);
                    System.out.println("Workload saved to status.txt.");
                    break;
                case 5:
                    Student.addNewStudent(validStudents, invalidStudents);
                    break;
                case 6:
                    Student.editInvalidStudent(invalidStudents);
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
