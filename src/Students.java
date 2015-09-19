import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/*This class has a hash set of all students where each student object knows that classes
 * that it needs to take for the model*/
public class Students {

HashSet<Student> allStudents = new HashSet<Student>();
//key: student , value: String[c1, c2, c3...]
	
	//constructor, used to prepare object hash map
	 Students(String filePath){
		 BufferedReader br = null;
		 try{
			br = new BufferedReader(new FileReader(filePath));
			System.out.println("NOW IN BUFFERED READER");
		 String line = br.readLine();
		 int l=1;
		 while (line!= null){
			 line = br.readLine();
			 Student student = new Student(); //create student object to populate from line
			 student.setNumber(l); //set the student number
			 Courses c = new Courses(line); //create a courses object
			 String[] studentCourses = c.splitCourses(line); //courses class splits the courses to return String[]
			 student.setSplit_Course(studentCourses); //set the split_Courses attribute of the student object to studentCourses
			 System.out.println("read in line"+l+" : "+line);// printlns to debug
			 System.out.println("Created a student object for student number:"+student.getNumber()+" needing courses "+studentCourses);
			 l++;
			 
		 }
		 	System.out.println(allStudents);
		 }
			
		 catch(IOException exc){
			 System.out.println("ERROR:"+exc.getMessage());
			 
	}
		 finally{
			 
			 try{
				 br.close();
			 }
			 catch(IOException exc1){
				 //body not neededhere
			 }
		 	}
		 
	}
	 
public HashSet<Student> getAllStudents(){
	return allStudents;
}
	
	
}
