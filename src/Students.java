import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/*This class has a hash set of all students where each student object knows that classes
 * that it needs to take for the model*/
public class Students {

HashSet<Student> allStudents = new HashSet<Student>();
	
	//constructor 
	 Students(){
		 System.out.println("Constructing optStudents object");
	 }
	 
	 public void readStudentClassNeeds(String filePath){
		 BufferedReader br = null;
		 try{
			br = new BufferedReader(new FileReader(filePath)); 
		 String line = null;
		 int l=0;
		 
		 while ( ( line = br.readLine()) != null ){
			 if(line.contains("%")){continue;}
			 if(line.trim().length() == 0){continue;}
			 
			 System.out.println(line);
			 Student student = new Student(); //create student object to populate from line
			 student.setNumber(l); //set the student number
			 Courses c = new Courses(); //create a courses object
			 /* HERE IS YOUR PROBLEM*/
			 System.out.println(line);
			 String[] studentCourses = c.splitCourses(line); //courses class splits the courses to return String[]
			 //student.setSplit_Course(studentCourses); //set the split_Courses attribute of the student object to studentCourses
			 //System.out.println("read in line"+l+" : "+line);// printlns to debug
			 //System.out.println("Created a student object for student number:"+student.getNumber()+" needing courses "+studentCourses);
			 allStudents.add(student);  //add student to hash set
		 	}
		 }
		 
			
		 catch(IOException exc){
			 System.out.println("ERROR:"+exc.getMessage());
		 } 
	
		 finally{
			 
			 try{
				 br.close();
			 }
			 catch(IOException exc1){
				 //body not needed here
			 }
		 } 
	}
	 
public HashSet<Student> getAllStudents(){
	return allStudents;
}
	
	
}
