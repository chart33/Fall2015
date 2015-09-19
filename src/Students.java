import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/*This class has a hash set of all students where each student object knows that classes
 * that it needs to take for the model*/
public class Students {

HashMap<Student, String[]> allStudents = new HashMap<Student, String[]>();
//key: student , value: courses
	
	//constructor, but used to prepare object hash map
	 Students(String filePath){

		/*TODO implement this method to read values from file into memory via a buffered reader
		 * This will be used by the main class*/
		//implement this code such that 
		 BufferedReader br = null;
		 try{
			br = new BufferedReader(new FileReader(filePath));
			System.out.println("NOW IN BUFFERED READER");
		 String line = br.readLine();
		 int l=1;
		 while (line!= null){
			 line = br.readLine();
			 Student student = new Student();
			 student.setNumber(l);
			 Courses c = new Courses(line);
			 String[] studentCourses = c.splitCourses(line);
			 allStudents.put(student, studentCourses);
			 System.out.println("line"+l+" : "+line);
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
				 //whatever.
			 }
		 	}
		 
	}
	 
public HashMap getAllStudents(){
	return allStudents;
}
	
	
}
