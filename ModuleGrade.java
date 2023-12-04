import java.util.List;
import java.util.Map;

public class ModuleGrade {
    private String moduleName;
    private String moduleCode;
    private Map<String, Double> grades;
    private double grade;
    private double credits;

    public ModuleGrade(String moduleName, String moduleCode, double grade, double credits) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.grade = grade;
        this.credits = credits;
    }

    public String getModuleName() {
        return moduleName;
    }
    public String getModuleCode(){
        return moduleCode;
    }
    public String getModule() {
        return String.format("%s - %s (%s)", moduleName, moduleCode, grade);
    }


    public Map getGrade() {
        return grades;
    }

    public double getCredits() {
        return credits;
    }
    public void setModuleName(String moduleName){
        this.moduleName = moduleName;
    }
    public void setModuleCode(String moduleCode){
        this.moduleCode = moduleCode;
    }
    @Override
    public String toString() {
        return moduleName + ": " + grades + " (" + credits + " credits)";
    }
}
