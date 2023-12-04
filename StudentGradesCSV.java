import java.io.*;
public class StudentGradesCSV {
    public static void main(String[] args) {
        String file = "C:\\Users\\tommy\\OneDrive\\Documents\\student_Grade.csv"; //Provide the filepath
        BufferedReader reader = null;
        String line = ""; //create string to be used to reach each line of csv file
        try {
            reader = new BufferedReader(new FileReader(file));  //pass in file name(student_Grade_CSV.csv) to FileReader
            while ((line = reader.readLine()) != null) {  //read next line of file and continue while loop, if there isnt a next line exit loop

                String[] row = line.split(",");  //split our line at all commas and assign values to a string array
                for (String index : row) {
                    System.out.printf("%-12s", index);   //displaying strings with 12 spaces of room, left justified, display contents at index
                }
                System.out.println();
            }
        } catch (Exception e) {  // catch all exceptions
            e.printStackTrace();  // Display errors if they occur
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
