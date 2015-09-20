

//this class has, as an attribute, an array list of courses that need to be taken by a student


public class Courses {
	Courses(){
		//Courses constructor
	}
	
	public String[] splitCourses(String courseLine){
			 String[] split_Course = courseLine.split("\\.");
		
			 System.out.println("The courses needed by this student are:" + split_Course);
		
		
		return split_Course;
		}
	}