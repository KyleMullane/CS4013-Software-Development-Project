import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class RunStudentRecordSystem {
    private Scanner in;

    public RunStudentRecordSystem(){ in = new Scanner(System.in); }


    /**
     * @param srs Variable name for Student Record System
     * @throws IOException
     */
    public void runSystem(StudentRecordSystem srs) throws IOException {
        while (true) {
            System.out.println("1. Student Login");
            System.out.println("2. Faculty Login");
            System.out.print("Select option: ");
            String command = in.nextLine().toUpperCase();
            Scanner scanner = new Scanner(System.in);

            if (command.equals("1")) {
                System.out.println("1. Get Transcript");
                System.out.println("2. Get QCA");
                System.out.println("3. Get Module Information");
                System.out.println("4. Get Course Information");
                System.out.println("5. Exit");
                System.out.print("Select option: ");
                String secondcommand = in.nextLine().toUpperCase();
                if (secondcommand.equals("1")) {
                    System.out.println("Enter Student ID: ");
                    String studentId = scanner.next();
                    srs.getStudentTranscript(studentId);
                } else if (secondcommand.equals("2")) {
                    System.out.println("Enter Student ID: ");
                    String studentId = scanner.next();
                    srs.getQCA(studentId);
                } else if (secondcommand.equals("3")) {
                    System.out.println("Enter Module Code: ");
                    String moduleCode = scanner.next();
                    srs.getModule(moduleCode);
                } else if (secondcommand.equals("4")) {
                    System.out.println("Enter Course Name: ");
                    String courseName = scanner.next();
                    srs.getCourse(courseName);
                } else {
                    System.out.println("Leaving Program.");
                    System.exit(0);
                }
            } else {
                System.out.println("1. Add Student");
                System.out.println("2. Add Module ");
                System.out.println("3. Get Student Transcript");
                System.out.println("4. Get Module Information");
                System.out.println("5. Print Faculty Transcript");
                System.out.println("6. Get Course Information");
                System.out.println("7. Add Student to Course");
                System.out.println("8. Remove Student from Course");
                System.out.println("9. Exit");
                System.out.print("Select option: ");
                String thirdcommand = in.nextLine().toUpperCase();

                if (thirdcommand.equals("1")) {
                    System.out.println("Name: ");
                    String name = in.nextLine();
                    System.out.println("ID: ");
                    String studentId = in.nextLine();
                    System.out.println("Module Code: ");
                    String moduleCode = in.next();
                    System.out.println("Year Of Study: ");
                    int yearOfStudy = in.nextInt();
                    in.nextLine();
                    srs.addStudent(name, studentId, moduleCode, yearOfStudy);
                } else if (thirdcommand.equals("2")) {
                    System.out.println("Module: ");
                    String moduleName = in.nextLine();
                    System.out.println("Module Code: ");
                    String moduleCode = in.nextLine();
                    System.out.println("Grade: ");
                    double grade = in.nextDouble();
                    System.out.println("Credits: ");
                    double credits = in.nextDouble();
                    srs.addModule(moduleName, moduleCode, grade, credits);
                } else if (thirdcommand.equals("3")) {
                    System.out.println("Enter Student ID: ");
                    String studentId = scanner.next();
                    srs.getStudentTranscript(studentId);
                } else if (thirdcommand.equals("4")) {
                    System.out.println("Enter Module Code: ");
                    String moduleCode = scanner.next();
                    srs.getModule(moduleCode);
                } else if (thirdcommand.equals("5")) {
                    System.out.println("Enter Faculty ID: ");
                    String facultyID = scanner.next();
                    srs.getFacultyTranscript(facultyID);
                } else if (thirdcommand.equals("6")) {
                    System.out.println("Enter Course Name: ");
                    String courseName = scanner.next();
                    srs.getCourse(courseName);
                } else if (thirdcommand.equals("7")) {
                    System.out.println("Enter Student Name: ");
                    String studentName = scanner.next();
                    srs.addCStudent(studentName);
                }else if (thirdcommand.equals("8")) {
                    System.out.println("Enter Student Name: ");
                    String studentName = scanner.next();
                    srs.removeCStudent(studentName);
                } else {
                System.out.println("Leaving Program.");
                    System.exit(0);
                }
            }
        }
    }

    // Assuming students is a list to store loaded student data
    private static List<Student> students = new ArrayList<>();
}


