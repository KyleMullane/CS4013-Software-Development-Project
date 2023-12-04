import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Student {
    private String name;
    private String studentId;
    private String moduleCode;
    private int yearOfStudy;
    private ArrayList<ModuleGrade> grades;
    /**
     * This method constructs student details.
     * @param name Student's Name
     * @param studentId Student ID
     * @param moduleCode Code for Specific Module
     * @param yearOfStudy Year Of Study
     */
    public Student(String name, String studentId, String moduleCode, int yearOfStudy) {
        this.name = name;
        this.studentId = studentId;
        this.moduleCode = moduleCode;
        this.yearOfStudy = yearOfStudy;
        this.grades = new ArrayList<>();
    }

    public List<ModuleGrade> getGrades() {
        return grades;
    }
    public void updateTranscript(String moduleName,String moduleCode,double grade, double credits) {
        ModuleGrade newGrade = new ModuleGrade(moduleName,moduleCode,grade,credits);
        addGrade(newGrade);
    }

    /**
     * Method Displays Student Transcript
     */
    public void displayTranscript() {
        System.out.println("/nTranscript for: "+name+ "/nID: "+studentId+"/nModule: "+moduleCode+"/nYear Of Study: "+yearOfStudy);
        for (ModuleGrade grade : grades) {
            System.out.println(grade);
        }
        System.out.println("QCA: " + QcaCalculator.calculateQca("student_grades.csv"));
    }

    /**
     * Method Adds grade to student transcript
     * @param grade Grade.
     */
    public void addGrade(ModuleGrade grade) {
        grades.add(grade);
    }

    /**
     * Method Sets Student Name
     * @param name Student Name
     */
    public static void setName(Student student, String name){
        student.name = name;
    }

    /**
     * Method Sets studentID
     * @param studentId Student ID
     */
    public static void setId(Student student,String studentId){
        student.studentId=studentId;
    }

    /**
     * Method Sets Students Module
     * @param ModuleCode Code for a Specific Module
     */
    public static void setModule(Student student,String ModuleCode){
        student.moduleCode=ModuleCode;
    }

    /**
     * Method Sets students year of Study
     * @param yearOfStudy Year of Study
     */
    public static void setYearOfStudy(Student student,int yearOfStudy){
        student.yearOfStudy=yearOfStudy;
    }

    /**
     * Method Gets Student Name.
     * @return Returns a value.
     */
    public String getName(){
        return name;
    }

    /**
     * Method Gets Students ID.
     * @return Returns a value.
     */
    public String getId(){
        return studentId;
    }

    /**
     * Method Gets Module Code
     * @return Returns a value.
     */
    public String getModule(){
        return moduleCode;
    }

    /**
     * Method Gets Students Year of Study.
     * @return Returns a value.
     */
    public int getYearOfStudy(){
        return yearOfStudy;
    }
}

