/* this class really only makes it easier to
 * make and store student objects including their student numbers*/
public class Student {

	int studentNumber;
	String[] split_Course;
	
	Student(){
	//blank Student constructor
	}
	
	public int getNumber() {
		return studentNumber;
	}
	public void setNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public String[] getSplit_Course(){
		return split_Course;
	}
	
	public void setSplit_Course(String[] splitCourses){
		this.split_Course = splitCourses;
	}
}
	

