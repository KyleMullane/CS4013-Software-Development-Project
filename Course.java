import java.util.*;
public class Course {
  private String courseName;
  private int numberOfStudents;
  private ArrayList<String> studentList = new ArrayList<String>();
  
  /** Defines the course name **/  
  public Course(String courseName) {
    this.courseName = courseName;
  }
  
  /** Adds a new student to the list **/
  public void addStudent(String student) {
    studentList.add(student);
  }
  
  /** Returns the list of students **/
  public ArrayList<String> getStudents() {
      System.out.println(studentList);
      return studentList;
  }

  /** Returns the number of students **/
  public int getNumberOfStudents() {
      System.out.println("The number of students is " + studentList.size());
      return studentList.size();
  }  

  /** Returns the name of the course **/
  public String getCourseName() {
      System.out.println(courseName);
      return courseName;
  }  
  
  /** Removes a student from the list **/
  public void dropStudent(String student){
      studentList.remove(student);
  }
  
  /** Removes all students from the list **/
  public void clear(){
      studentList.clear();
  }
}
