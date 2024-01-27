import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class handling operations related to student information in the Student Account Management System.
 */
public class Student {
    // Path to the student file for saving workload replace with own path
    static String studentPath = "Student.txt";
    /**
     * Displays the list of students with a specified header.
     *
     * @param students List of students to display.
     * @param header   Header to display before the list.
     */
    public static void showStudents(ArrayList<String> students, String header) {
        System.out.println(header + ":");
        for (String student : students) {
            System.out.println(student);
        }
    }
    /**
     * Searches for the student.txt file to ensure it exists. If not, provides options to the user.
     *
     * @param validStudents   List to store valid students.
     * @param invalidStudents List to store invalid students.
     */
    public static void searchForStudentFile(ArrayList<String> validStudents, ArrayList<String> invalidStudents) {
        File file = new File(studentPath);

        // If student.txt file doesn't exist, prompt user with options
        if (!file.exists()) {
            System.out.println("student.txt file does not exist.");

            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Amend the file path to student.txt");
            System.out.println("2. Exit the program to rewrite the StudentPath correctly");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the correct file path to student.txt: ");
                    studentPath = scanner.next();
                    break;
                case 2:
                    System.out.println("Exiting the program. Please rewrite the StudentPath correctly.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Exiting...");
                    System.exit(0);
            }
        }
    }
    /**
     * Reads student information from the student.txt file and populates valid and invalid student lists.
     *
     * @param validStudents   List to store valid students.
     * @param invalidStudents List to store invalid students.
     */
    public static void readStudents(ArrayList<String> validStudents, ArrayList<String> invalidStudents) {
        try (BufferedReader reader = new BufferedReader(new FileReader(studentPath))) {
            String name = null;
            String numClasses = null;
            String studentId;

            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                switch (lineCount % 3) {
                    case 1:
                        name = line;
                        break;
                    case 2:
                        numClasses = line;
                        break;
                    case 0:
                        studentId = line;

                        processStudentData(name, numClasses, studentId, validStudents, invalidStudents);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes the data of a single student and adds it to the appropriate list.
     *
     * @param name            Name of the student.
     * @param numClasses      Number of classes the student is enrolled in.
     * @param studentId       ID of the student.
     * @param validStudents   List to store valid students.
     * @param invalidStudents List to store invalid students.
     */
    private static void processStudentData(String name, String numClasses, String studentId,
                                           ArrayList<String> validStudents, ArrayList<String> invalidStudents) {
        if (Utils.isValidStudentDetails(name, numClasses, studentId)) {
            String newStudent = name + "\n" + numClasses + "\n" + studentId;

            if (!validStudents.contains(newStudent)) {
                validStudents.add(newStudent);
            } else {
                System.out.println("Duplicate student found in student.txt. Ignoring duplicate.");
            }
        } else {
            invalidStudents.add(name + "\n" + numClasses + "\n" + studentId);
        }
    }
    /**
     * Displays information about all students, including both valid and invalid students.
     * Shows the list of valid students, the number of valid students, the list of invalid students,
     * and the number of invalid students.
     *
     * @param validStudents   The list of valid student information.
     * @param invalidStudents The list of invalid student information.
     */
    public static void showAllStudents(ArrayList<String> validStudents, ArrayList<String> invalidStudents) {
        System.out.println("All Students:");

        displayValidStudents(validStudents);
        displayInvalidStudents(invalidStudents);
    }

    /**
     * Displays the list of valid students.
     *
     * @param validStudents The list of valid student information.
     */
    private static void displayValidStudents(ArrayList<String> validStudents) {
        System.out.println("Valid Students:");
        showStudents(validStudents);
        System.out.println("\nNumber of Valid Students: " + validStudents.size());
    }

    /**
     * Displays the list of invalid students.
     *
     * @param invalidStudents The list of invalid student information.
     */
    private static void displayInvalidStudents(ArrayList<String> invalidStudents) {
        System.out.println("\nInvalid Students:");
        showStudents(invalidStudents);
        System.out.println("\nNumber of Invalid Students: " + invalidStudents.size());
    }

    /**
     * Displays the list of students.
     *
     * @param students The list of student information.
     */
    private static void showStudents(ArrayList<String> students) {
        for (String student : students) {
            System.out.println(student);
        }
    }
}




