import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QcaCalculator {
    // Grading 
    private static final Map<String, Double> gradingScale = new HashMap<>();

    static {
        gradingScale.put("A1", 4.0);
        gradingScale.put("A2", 3.6);
        gradingScale.put("B1", 3.2);
        gradingScale.put("B2", 3.0);
        gradingScale.put("B3", 2.8);
        gradingScale.put("C1", 2.6);
        gradingScale.put("C2", 2.4);
        gradingScale.put("C3", 2.0);
        gradingScale.put("D1", 1.6);
        gradingScale.put("D2", 1.2);
        gradingScale.put("F", 0.0);
        gradingScale.put("NG", 0.0);
    }

    public static double calculateQca(String filePath) {
        double totalQca = 0.0;
        double totalCredits = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String module = data[0].trim();
                    String grade = data[1].trim();
                    double credits = Double.parseDouble(data[2].trim());

                    if (gradingScale.containsKey(grade)) {
                        double qca = gradingScale.get(grade);
                        totalQca += qca * credits;
                        totalCredits += credits;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return (totalCredits == 0) ? 0.0 : totalQca / totalCredits;
    }

    public static void main(String[] args) {
        // Needs CSV file with student grades
        String filePath = "student_grades.csv";
        double qca = calculateQca(filePath);

        System.out.printf("QCA: %.2f%n", qca);
    }
}
