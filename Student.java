import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Student {
    private String name;
    private String studentId;
    private String moduleCode;
    private int yearOfStudy;
    private List<ModuleGrade> grades;
    /**
     * This method constructs student details.
     * @param name
     * @param studentId
     * @param moduleCode
     * @param yearOfStudy
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
    public void updateTranscript(){

    }
    public void displayTranscript() {
        System.out.println("/nTranscript for: "+name+ "/nID: "+studentId+"/nModule: "+moduleCode+"/nYear Of Study: "+yearOfStudy);
        for (ModuleGrade grade : grades) {
            System.out.println(grade);
        }
        System.out.println("QCA: " + QcaCalculator.calculateQca("student_grades.csv"));
    }
    public void addGrade(ModuleGrade grade) {
        grades.add(grade);
    }


    public void setName(String name){
        this.name= name;
    }
    public void setId(String studentId){
        this.studentId= studentId;
    }
    public void setModule(String ModuleCode){
        this.moduleCode= ModuleCode;
    }
    public void setYearOfStudy(int yearOfStudy){
        this.yearOfStudy=yearOfStudy;
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return studentId;
    }
    public String getModule(){
        return moduleCode;
    }
    public int getYearOfStudy(){
        return yearOfStudy;
    }
    public void displayTranscript(String csvFilePath) {
        StudentGradesCSV csvReader = new StudentGradesCSV();
        csvReader.readCSV(studentId, csvFilePath);
    }

    @Override
    public String toString(){
        return String.format("%s @ €%.2f", name,studentId,moduleCode,yearOfStudy,grades);
    }
}
