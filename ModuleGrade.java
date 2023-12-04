import java.util.List;
import java.util.Map;

public class ModuleGrade {
    private String moduleName;
    private String moduleCode;
    private Map<String, Double> grades;
    private double grade;
    private double credits;

    /**
     * Method Creats an Object "ModuleGrade"
     * @param moduleName Module's Name
     * @param moduleCode Module's Unique Code
     * @param grade Grade
     * @param credits Module's Available Credits
     */
    public ModuleGrade(String moduleName, String moduleCode, double grade, double credits) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.grade = grade;
        this.credits = credits;
    }

    /**
     * Method Gets Module Name
     * @return returns a value
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Method Gets Module Code
     * @return returns a value
     */
    public String getModuleCode(){
        return moduleCode;
    }

    /**
     * Method Gets Module Object and prints Module Information.
     * @return returns a value
     */
    public String getModule() {
        return String.format("%s - %s (%s)", moduleName, moduleCode, grade);
    }

    /**
     * Method Maps Grades and saves them as an array would
     * @return returns a value
     */
    public Map getGrade() {
        return grades;
    }

    /**
     * Method fetches credits
     * @return returns a value
     */
    public double getCredits() {
        return credits;
    }

    /**
     * Method Sets Module Name
     * @param moduleName Module Name
     */
    public void setModuleName(String moduleName){
        this.moduleName = moduleName;
    }

    /**
     * Method Sets Module Code
     * @param moduleCode Code for specific Module
     */
    public void setModuleCode(String moduleCode){
        this.moduleCode = moduleCode;
    }

    /**
     * Returns to string for printing later on
     * @return returns a value.
     */
    @Override
    public String toString() {
        return moduleName + ": " + grades + " (" + credits + " credits)";
    }
}
