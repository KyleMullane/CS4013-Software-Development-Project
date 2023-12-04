import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String facultyId;
    private String facultyName;
    private List<String> modules;

    /**
     * Creates Object Faculty
     * @param facultyId Faculty Member's ID
     * @param facultyName Faculty Member's Name
     */
    public Faculty(String facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.modules = new ArrayList<>();
    }

    /**
     * Method Gets Faculty ID
     * @return Returns a Value
     */
    public String getFacultyId() {
        return facultyId;
    }

    /**
     * Method sets Faculty ID
     * @param facultyId Faculty Member's ID
     */
    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    /**
     * Method gets Faculty Name 
     * @return Returns a Value
     */
    public String getFacultyName() {
        return facultyName;
    }

    /**
     * Method sets Faculty Member's Name
     * @param facultyName Faculty Member's Name
     */
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    /**
     * Method Gets all Faculty Information and Prints Details.
     */
    public void displayFacultyDetails() {
        System.out.println("Faculty ID: " + facultyId);
        System.out.println("Faculty Name: " + facultyName);
        System.out.println("Modules:");
        for (String module : modules) {
            System.out.println("- " + module);
        }
    }
}
