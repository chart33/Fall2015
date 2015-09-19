import java.util.ArrayList;

//this class has, as an attribute, an array list of courses that need to be taken by a student


public class Courses {
	Courses(String line){
		//Courses constructor
		splitCourses(line);
	}
	
	public String[] splitCourses(String courseLine){
			 String[] split_Course = courseLine.split(".");
		
			 System.out.println("The courses needed by this student are:");
		
			 int i=0;
		
			for(i=0;i<12;i++){
			System.out.println(split_Course[i]);
		}
		return split_Course;
		}
	}