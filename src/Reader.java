import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

//hardcode filepath: /home/ubuntu/Documents/student_schedule.txt
//REMEMBER TO REMOVE THE HARDCODED FP BEFORE YOU SUBMIT.
	
public void readFile(String filePath){
	/*TODO implement this method to read values from file into memory via a buffered reader
	 * This will be used by the main class*/
	 BufferedReader br = null;
	 try{
		br = new BufferedReader(new FileReader(filePath));
		
	 String line = br.readLine();
	 
	 while (line != null && line.contains("%")== false){
		 line = br.readLine();
		 //can I add code here such that each line read is added to the vector?
		 System.out.println("********************"+line);}
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
	 }}}
 
