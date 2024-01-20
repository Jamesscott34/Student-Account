import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class handling operations related to student information in the Student Account Management System.
 */
public class Student {
    // make sure to use relevant txt location
    static String studentPath = "C:\\Users\\35387\\Desktop\\Ca1 main\\class-asignment\\Student-Account\\src\\Student.txt";
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
     * Adds a new student to the system, validating input and updating the status file.
     *
     * @param validStudents   List of valid students.
     * @param invalidStudents List of invalid students.
     */
    public static void addNewStudent(ArrayList<String> validStudents, ArrayList<String> invalidStudents) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the new student: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of classes for the new student: ");
        String numClasses = scanner.nextLine();

        System.out.print("Enter the student ID for the new student: ");
        String studentId = scanner.nextLine();

        if (Utils.isValidStudentDetails(name, numClasses, studentId)) {
            String newStudent = name + "\n" + numClasses + "\n" + studentId;

            if (!validStudents.contains(newStudent)) {
                validStudents.add(newStudent);
                System.out.println("New student added successfully.");
                Utils.saveWorkload(validStudents);

                // Append the new student information to student.txt
                appendToStudentFile(newStudent);
            } else {
                System.out.println("Duplicate student. This student is already in the valid students list.");
            }
        } else {
            System.out.println("Invalid student details. The new student is invalid.");

        }
    }
    /**
     * Appends the provided student information to the student.txt file.
     *
     * @param studentInfo Information of the new student to append.
     */
    private static void appendToStudentFile(String studentInfo) {
        try (FileWriter writer = new FileWriter(studentPath, true)) {
            // Append the new student information to the file
            writer.write(studentInfo);
            System.out.println("New student added to student.txt.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to student.txt: " + e.getMessage());
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
            String studentId = null;

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
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Allows editing of invalid student information, updating both the list and the student.txt file.
     *
     * @param invalidStudents List of invalid students.
     */
    static void editInvalidStudent(ArrayList<String> invalidStudents) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Invalid Students:");
        for (int i = 0; i < invalidStudents.size(); i++) {
            System.out.println((i + 1) + ". " + invalidStudents.get(i));
        }

        System.out.print("Enter the number of the invalid student you want to edit: ");
        int studentNumber = scanner.nextInt();

        if (studentNumber >= 1 && studentNumber <= invalidStudents.size()) {
            int index = studentNumber - 1; // Adjust to zero-based index

            System.out.println("Editing invalid student:");
            System.out.println(invalidStudents.get(index));

            System.out.print("Enter the corrected name: ");
            String name = scanner.next();

            System.out.print("Enter the corrected number of classes: ");
            String numClasses = scanner.next();

            System.out.print("Enter the corrected student ID: ");
            String studentId = scanner.next();

            if (Utils.isValidStudentDetails(name, numClasses, studentId)) {
                String updatedStudent = name + "\n" + numClasses + "\n" + studentId;
                invalidStudents.set(index, updatedStudent);
                System.out.println("Student updated successfully.");

                // Update the student.txt file
                updateStudentFile(invalidStudents);
            } else {
                System.out.println("Invalid student details. No changes made.");
            }
        } else {
            System.out.println("Invalid student number. Please enter a valid number.");
        }
    }

    private static void updateStudentFile(ArrayList<String> students) {
        try (FileWriter writer = new FileWriter(studentPath)) {
            for (String student : students) {
                // Write each student's information to the file
                writer.write(student + "\n");
            }
            System.out.println("Student.txt updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error updating student.txt: " + e.getMessage());
        }
    }
}



