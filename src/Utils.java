import java.util.ArrayList;


/**
 * Utility class for handling various operations in the Student Account Management System.
 */
public class Utils {
    // Path to the status file for saving workload replace with own path

    /**
     * Saves the workload information of valid students to a status file.
     *
     * @param validStudents ArrayList containing valid student information.
     */
    public static void saveWorkload(ArrayList<String> validStudents) {

    }

    /**
     * Calculates and returns the workload based on the number of classes.
     *
     * @param numClasses Number of classes taken by the student.
     * @return Workload description.
     */
    static String calculateWorkload (int numClasses) {
        if (numClasses == 1) {
            return "Very Light";
        } else if (numClasses == 2) {
            return "Light";
        } else if (numClasses >= 3 && numClasses <= 5) {
            return "Moderate";
        } else if (numClasses >= 6 && numClasses <= 8) {
            return "Heavy";
        } else {
            System.out.println("Not accurate class");
            return "Not specified";
        }
    }
    /**
     * Validates the details of a student using regex patterns.
     *
     * @param name      Student's name.
     * @param numClasses Number of classes taken by the student.
     * @param studentId Student ID.
     * @return True if the details are valid, false otherwise.
     */
    public static boolean isValidStudentDetails(String name, String numClasses, String studentId) {
        // Implement your validation logic here
        // For example, you can use the regular expressions provided earlier

        boolean isNameValid = name.matches("^[A-Za-z]+\\s[A-Za-z]+(?:\\d{1,3})?$");
        boolean isNumClassesValid = numClasses.matches("^[1-8]$");
        boolean isStudentIdValid = studentId.matches("^(20|21|22|23|24)[A-Z]{2,3}\\d{1,3}$");

        return isNameValid && isNumClassesValid && isStudentIdValid;
    }
}
