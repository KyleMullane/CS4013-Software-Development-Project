import java.util.ArrayList;

/**
 * The Student Record System to Initialize Methods for "RunStudentRecordSystem"
 * Initializes ArrayList to save Data: "Students", "Faculty Members", "Module Grades", "Module List"
 */
public class StudentRecordSystem {
    private final ArrayList<Student> students;
    private final ArrayList<Faculty> facultyMembers;
    private final ArrayList<ArrayList<ModuleGrade>> moduleGrades;
    private final ArrayList<ModuleGrade> modulesList;
    private final ArrayList<Course> studentList;

    /**
     * Creates ArrayLists for Storage
     */
    public StudentRecordSystem() {
        this.students = new ArrayList<>();
        this.moduleGrades = new ArrayList<>();
        this.modulesList = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    /**
     * Method adds student to array list for menu.
     * @param studentId Students Unique ID.
     * @param name Student's Name
     * @param moduleCode Code of a specific Module
     */
    public void addStudent(String name, String studentId, String moduleCode, int yearOfStudy) {
        Student student = new Student(name, studentId,moduleCode,yearOfStudy);
        students.add(student);

    }

    /**
     * Method Adds Module to arrayList
     * @param moduleName Module Title.
     * @param moduleCode Code of a specific Module.
     * @param grade Grade.
     * @param credits Credits Available in a Module
     */
    public void addModule(String moduleName, String moduleCode,double grade, double credits){
        ModuleGrade module = new ModuleGrade(moduleName,moduleCode,grade,credits);
        modulesList.add(module);
    }

    /**
     * Method Fetches StudentTranscript and Displays
     * @param studentId Students unique ID.
     */
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
    /**
     * getFacultyTranscript using Faculty ID to fetch a specific faculty members information and Displays.
     * @param facultyId Faculty Members Unique ID.
     */
    public void getFacultyTranscript(String facultyId){
        System.out.println("Transcript for Faculty Member - "+facultyId);
        for (Faculty faculty : facultyMembers){
            if (faculty.getFacultyId().equals(facultyId)) {
                faculty.displayFacultyDetails();
                return;
            }
        }
    }
    /**
     * getModule simply uses moduleCode to retrieve module information and print it.
     * @param moduleCode Code of a specific Module
     */
    public void getModule(String moduleCode){
        System.out.println("Module: "+ moduleCode);
        for (ModuleGrade module2 : modulesList){
            if(module2.getModuleCode().equals(moduleCode)) {
                module2.getModule();
                return;
            }
        }
    }
    /**
     * getQCA uses Student ID to get QCA from saved csv file grades and uses QcaCalculator class to calculate QCA.
     * @param studentId Students Unique ID.
     */
    public void getQCA(String studentId){
        double qca = QcaCalculator.calculateQca("student_grades.csv");
        System.out.println("/nQCA for Student: "+studentId+"/n"+qca);
    }

    /**
     * Method Returns course information with a list of students enrolled in course
     * @param courseName Course Name.
     */
    public void getCourse(String courseName){
        System.out.println("Course: "+courseName);
        for (Course course : studentList ){
            course.getCourse(courseName);
            return;
        }
    }

    /**
     * Method Add Student to a course
     */
    public void addCStudent(String studentId){
        System.out.println("Student Added: "+studentId);
        for (Course course : studentList){
            course.addStudent(studentId);
        }
    }

    /**
     * Method Removes student from a course
     * @param studentName Student's Name
     */
    public void removeCStudent(String studentName){
        System.out.println("Student Removed: "+studentName);
        for (Course course : studentList){
            course.dropStudent(studentName);
        }
    }
}
