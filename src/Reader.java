import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Reader {
	ArrayList studentNeeds = new ArrayList();
//hardcode filepath: /home/ubuntu/Documents/student_schedule.txt
//REMEMBER TO REMOVE THE HARDCODED FP BEFORE YOU SUBMIT.
	
HashSet<Student> allStudents = new HashSet<Student>(600);
	
public void readFile(String filePath){
	/*TODO implement this method to read values from file into memory via a buffered reader
	 * This will be used by the main class*/
	 BufferedReader br = null;
	 try{
		br = new BufferedReader(new FileReader(filePath));
		System.out.println("NOW IN BUFFERED READER");
	 String line = br.readLine();
	 int l=0;
	 while (line!= null){
		 line = br.readLine();
		 Student student = new Student(line);
		 //can I add code here such that each line read is added to the vector?
		 System.out.println("line"+l+" : "+line);
		 studentNeeds.add(line);
		 allStudents.add(student);
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
}
 
