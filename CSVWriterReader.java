import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides functionality to write and read CSV files containing information about students and their grades.
 */
public class CSVWriterReader {

    // Instance variables to store student information
    String name;
    String studentId;
    String moduleCode;
    int yearOfStudy;
    private ArrayList<ModuleGrade> grades = new ArrayList<>();

    /**
     * The main method demonstrates the usage of CSVWriterReader by writing and reading a CSV file.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public void main(String[] args) {
        String filePath = "C:\\java\\csv\\user.csv";

        System.out.println("Starting write user.csv file: " + filePath);
        writeCsv(filePath);

        System.out.println("Starting read user.csv file");
        readCsv(filePath);
    }

    /**
     * Writes student information to a CSV file.
     *
     * @param filePath The path of the CSV file to be written.
     */
    public void writeCsv(String filePath) {
        List<Student> students = new ArrayList<>();

        // Create a test student
        Student student = new Student(name, studentId, moduleCode, yearOfStudy);
        Student.setName(student, "Tommy");
        Student.setId(student, "1");
        Student.setModule(student, "A2");
        Student.setYearOfStudy(student, 1);
        students.add(student);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);

            // Write header line
            fileWriter.append("Student Id, Name, Module Code, Year of study\n");

            // Write student information
            for (Student i : students) {
                fileWriter.append(i.getId());
                fileWriter.append(",");
                fileWriter.append(i.getName());
                fileWriter.append(",");
                fileWriter.append(i.getModule());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(i.getYearOfStudy()));
                fileWriter.append("\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Reads student information from a CSV file and prints the details.
     *
     * @param filePath The path of the CSV file to be read.
     */
    public static void readCsv(String filePath) {
        BufferedReader reader = null;
        String name = "";
        String studentId = "";
        String moduleCode = "";
        int yearOfStudy = 0;

        try {
            List<Student> students = new ArrayList<>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));

            // Skip the header line
            reader.readLine();

            // Read each line and create a Student object
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length > 0) {
                    Student student = new Student(name, studentId, moduleCode, yearOfStudy);
                    student.setId(student, fields[0]);
                    student.setName(student, fields[1]);
                    student.setModule(student, fields[2]);
                    student.setYearOfStudy(student, Integer.parseInt(fields[3]));
                    students.add(student);
                }
            }

            // Print student details
            for (Student i : students) {
                System.out.printf("[Student Id=%s, Name=%s, Module Code=%s, Year of Study=%d]\n",
                        i.getId(), i.getName(), i.getModule(), i.getYearOfStudy());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
