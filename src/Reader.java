import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import sun.misc.IOUtils;


public class Reader {
/* the purpose of this class is to read the contents of a provided
 * text file into memory. */
	
//hardcode filepath: /home/ubuntu/Documents/student_schedule.txt
//REMEMBER TO REMOVE THE HARDCODED FP BEFORE YOU SUBMIT.
	
public void readFile(String filePath){
	/*TODO implement this method to read values from file into memory via a buffered reader
	 * This will be used by the main class*/
	 BufferedReader br = null;
	 try{
		br = new BufferedReader(new FileReader(filePath));
	 String line = br.readLine();
	 while (line != null){
		 line = br.readLine();
		 //can I add code here such that each line read is added to the vector?
		 System.out.println("********************"+line);
		//here you need to figure out a way to go from the buffered stream to string or parse to array
		 /*StringWriter writer = new StringWriter();
		 IOUtils.copy(inputStream, writer, encoding);
		 String theString = writer.toString();*/
		 
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
			 //whatever.
		 }
	 }
}


}
	 


