
public class Student {

	int studentNumber;
	String[] split_Course;
	
	Student(String courseLine){
		//split string using String[]
		//assign values to an array list
		//designate the student # based on line in file
		}
	
	public String[] splitCourses(String courseLine){
		 split_Course=courseLine.split(".");
	System.out.println("The courses needed by this student are:");
	int i=0;
	for(i=0;i<12;i++){
		System.out.println(split_Course[i]);
	}
	return split_Course;
	}
	}
	

