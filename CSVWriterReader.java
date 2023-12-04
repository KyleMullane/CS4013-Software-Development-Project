import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVWriterReader {

    private String name;
    private String studentId;
    private String moduleCode;
    private int yearOfStudy;
    private ArrayList<ModuleGrade> grades = new ArrayList();

    public static void main(String[] args) {
        String filePath = "C:\\java\\csv\\user.csv";

        System.out.println("starting write user.csv file: " + filePath);
        writeCsv(filePath);

        System.out.println("starting read user.csv file");
        readCsv(filePath);
    }

    public static void writeCsv(String filePath) {
        List<Student> students = new ArrayList<Student>();

        //create test student
        Student student = new Student();
        Student.setId("1");
        Student.setName("Tommy");
        Student.setModule("A2");
        Student.setYearOfStudy(1);
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

        try {
            List<Student> students = new ArrayList<Student>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    Student student = new Student();
                    student.setId((fields[0]));
                    student.setName(fields[1]);
                    student.setModule(fields[2]);
                    student.setYearOfStudy(Integer.parseInt(fields[3]));
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
