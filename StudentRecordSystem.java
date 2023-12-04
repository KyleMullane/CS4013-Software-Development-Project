import java.util.ArrayList;

/**
  The Student Record System
 */
public class StudentRecordSystem {
    private final ArrayList<Student> students;
    private final ArrayList<Faculty> facultyMembers;
    private final ArrayList<ArrayList<ModuleGrade>> moduleGrades;
    private final ArrayList<ModuleGrade> modulesList;
    public StudentRecordSystem() {
        this.students = new ArrayList<>();
        this.moduleGrades = new ArrayList<>();
        this.modulesList = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    /**
     * Method adds student to array list for menu.
     * @param studentId
     * @param name
     * @param moduleCode
     */
    public void addStudent(String name, String studentId, String moduleCode, int yearOfStudy) {
        Student student = new Student(name, studentId,moduleCode,yearOfStudy);
        students.add(student);
    }
    public void addModule(String moduleName, String moduleCode,double grade, double credits){
        ModuleGrade module = new ModuleGrade(moduleName,moduleCode,grade,credits);
        modulesList.add(module);
    }
    public void getStudentTranscript(String studentId) {
        System.out.println("Transcript for Student ID: " + studentId);
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                student.displayTranscript();
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }
    public void getFacultyTranscript(String facultyId){
        System.out.println("Transcript for Faculty Member - "+facultyId);
        for (Faculty faculty : facultyMembers){
            if (faculty.getFacultyId().equals(facultyId)) {
                faculty.displayFacultyDetails();
                return;
            }
        }
    }
    public void getModule(String moduleCode){
        System.out.println("Module: "+ moduleCode);
        for (ModuleGrade module2 : modulesList){
            if(module2.getModuleCode().equals(moduleCode)) {
                module2.getModule();
                return;
            }
        }
    }
    public void getQCA(String studentId){
        double qca = QcaCalculator.calculateQca("student_grades.csv");
        System.out.println("/nQCA: " + qca);
    }
}
