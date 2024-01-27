import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Utility class for handling various operations in the Student Account Management System.
 */
public class Utils {
    // Path to the status file for saving workload replace with own path or follow on screen instructions
    static String statusPath = "Status.txt";

    /**
     * Saves the valid student information to a status file.
     *
     * @param validStudents ArrayList containing valid student information.
     */
    /**
     * Saves valid student information to a file.
     *
     * @param validStudents The list of valid student information.
     */
    public static void saveValidStudents(ArrayList<String> validStudents) {
        try {
            ensureFileExists();

            String fileName = getFileNameFromUser();
            saveStudentsToFile(validStudents, fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Saves student information to the specified file.
     *
     * @param validStudents The list of valid student information to save.
     * @param fileName      The name of the file to save the information to.
     */
    private static void saveStudentsToFile(ArrayList<String> validStudents, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String student : validStudents) {
                String[] studentInfo = student.split("\n");
                String name = studentInfo[0];
                int numClasses = Integer.parseInt(studentInfo[1]);
                String studentId = studentInfo[2];

                String secondName = getSecondName(name);
                String workload = calculateWorkload(numClasses);
                String output = String.format("%s-%s%n%s%n", studentId, secondName, workload);
                writer.write(output);
            }
            System.out.println("Valid Students saved to " + fileName + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Ensures that the file specified by the given path exists. If the file does not
     * exist, it creates a new empty file.
     *
     * @throws IOException If an I/O error occurs while creating the file.
     */
    private static void ensureFileExists() throws IOException {
        // Create a File object based on the provided path
        File file = new File(statusPath);

        // Check if the file does not exist
        if (!file.exists()) {
            // Create a new empty file
            file.createNewFile();
        }
    }

    /**
     * Prompts the user to enter a file name to save data. If the user enters an empty string,
     * the default file path (statusPath) is used. Otherwise, the provided file name is appended
     * with the ".txt" extension.
     *
     * @return The file name to be used for saving data.
     */
    private static String getFileNameFromUser() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Check if the file already exists
        File existingFile = new File(statusPath);

        if (existingFile.exists()) {
            System.out.println("Using fileOPath: " + statusPath);
            return statusPath;
        }

        // Prompt the user to enter a file name (without extension)
        System.out.print("Enter the file name to save (without extension): ");

        // Read the user input and trim leading/trailing whitespaces
        String fileName = scanner.nextLine().trim();

        // Check if the user input is empty
        if (fileName.isEmpty()) {
            // Use the default file path (statusPath)
            fileName = statusPath;
        } else {
            // Append the ".txt" extension to the provided file name
            fileName += ".txt";
        }

        // Return the resulting file name
        return fileName;
    }

    /**
     * Extracts the second name from a full name.
     *
     * @param fullName Full name containing two parts separated by a space.
     * @return Second name.
     */
    private static String getSecondName(String fullName) {
        // Assuming the second name is everything after the first space
        int spaceIndex = fullName.indexOf(' ');

        // If a space is found, extract the second name
        if (spaceIndex != -1) {
            return fullName.substring(spaceIndex + 1);
        } else {
            // If no space is found, return the full name
            return fullName;
        }
    }

    /**
     * Calculates and returns the workload based on the number of classes.
     *
     * @param numClasses Number of classes taken by the student.
     * @return Workload description.
     */
    static String calculateWorkload(int numClasses) {
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
     * @param name       Student's name.
     * @param numClasses Number of classes taken by the student.
     * @param studentId  Student ID.
     * @return True if the details are valid, false otherwise.
     */
    public static boolean isValidStudentDetails(String name, String numClasses, String studentId) {

        // Check if the name follows the pattern: Firstname Lastname(optional: numbers)
        boolean isNameValid = name.matches("^[A-Za-z]+\\s[A-Za-z]+(?:\\d{1,3})?$");

        // Check if the number of classes is in the range 1-8
        boolean isNumClassesValid = numClasses.matches("^[1-8]$");

        // Check if the student ID is valid
        boolean isStudentIdValid = isValidStudentId(studentId);

        // If the student ID is not valid, return false
        if (!isStudentIdValid) {
            return false;
        }

        // If all checks pass, return true
        return isNameValid && isNumClassesValid;
    }

    /**
     * Checks the validity of a student ID.
     *
     * @param studentId Student ID.
     * @return True if the student ID is valid, false otherwise.
     */
    private static boolean isValidStudentId(String studentId) {
        if (!isValidLength(studentId) || !isValidYearRange(studentId) || !isValidNumericPart(studentId)) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }

    /**
     * Validates the length of the student ID.
     *
     * @param studentId The student ID to be validated.
     * @return True if the length is within the valid range, otherwise false.
     */
    private static boolean isValidLength(String studentId) {
        int length = studentId.length();
        if (length < 5 || length > 8) {
            return false;
        }
        return true;
    }

    /**
     * Validates the year part of the student ID.
     *
     * @param studentId The student ID to be validated.
     * @return True if the year is within the valid range, otherwise false.
     */
    private static boolean isValidYearRange(String studentId) {
        if (studentId.length() < 2) {
            return false;
        }

        // Extract the year from the student ID
        int year = Integer.parseInt(studentId.substring(0, 2));

        // Check if the year is in the range 20-24
        if (year < 20 || year > 24) {
            return false;
        }
        return true;
    }

    /**
     * Validates the numeric part of the student ID.
     *
     * @param studentId The student ID to be validated.
     * @return True if the numeric part is within the valid range, otherwise false.
     */
    private static boolean isValidNumericPart(String studentId) {
        String numericPartString = studentId.substring(2).replaceAll("[^0-9]", "");

        // Check if the numeric part is not empty
        if (!numericPartString.isEmpty()) {
            int numericPart = Integer.parseInt(numericPartString);

            // Check if the numeric part is within the valid range (1-200)
            if (numericPart > 200) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}

