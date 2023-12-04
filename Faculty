import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String facultyId;
    private String facultyName;
    private List<String> modules;

    public Faculty(String facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.modules = new ArrayList<>();
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void addModule(String moduleCode) {
        modules.add(moduleCode);
    }

    public void displayFacultyDetails() {
        System.out.println("Faculty ID: " + facultyId);
        System.out.println("Faculty Name: " + facultyName);
        System.out.println("Modules:");
        for (String module : modules) {
            System.out.println("- " + module);
        }
    }
}
