import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVWriterReader {

    String name;
    String studentId;
    String moduleCode;
    int yearOfStudy;
    private ArrayList<ModuleGrade> grades = new ArrayList();

    public void main(String[] args) {
        String filePath = "C:\\java\\csv\\user.csv";

        System.out.println("starting write user.csv file: " + filePath);
        writeCsv(filePath);

        System.out.println("starting read user.csv file");
        readCsv(filePath);
    }

    public void writeCsv(String filePath) {
        List<Student> students = new ArrayList<Student>();

        //create test student
        Student student = new Student(name,studentId,moduleCode,yearOfStudy);
        Student.setName(student, "Tommy");
        Student.setId(student, "1");
        Student.setModule(student, "A2");
        Student.setYearOfStudy(student, 1);
        students.add(student);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);

            fileWriter.append("Student Id, Name, Grade, Year of study\n");
            for(Student i: students) {
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

    public static void readCsv(String filePath) {
        BufferedReader reader = null;
        String name = "";
        String studentId = "";
        String moduleCode = "";
        int yearOfStudy = 0;

        try {
            List<Student> students = new ArrayList<Student>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    Student student = new Student(name,studentId,moduleCode,yearOfStudy);
                    student.setId(student, fields[0]);
                    student.setName(student, fields[1]);
                    student.setModule(student, fields[2]);
                    student.setYearOfStudy(student,Integer.parseInt(fields[3]));
                    students.add(student);
                }
            }

            for(Student i: students) {
                System.out.printf("[studentId=%s, Name=%s, Module Code=%s, yearOfStudy=%d]\n", i.getId(), i.getName(), i.getModule(), i.getYearOfStudy());
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
