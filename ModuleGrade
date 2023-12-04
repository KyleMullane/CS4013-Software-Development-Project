import java.util.List;
import java.util.Map;

public class ModuleGrade {
    private String moduleName;
    private String moduleCode;
    private Map<String, List<String>> grade;
    private double credits;

    public ModuleGrade(String moduleName, String moduleCode, Map grade, double credits) {
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

    public Map getGrade() {
        return grade;
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
        return moduleName + ": " + grade + " (" + credits + " credits)";
    }
}
