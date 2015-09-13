import java.util.Vector;
//How Is this an interface?  what is the difference between calculateScheudle here and in the Project 1 scheduler?

public interface scheduler {

	public void calculateSchedule( String dataFolder );
	
	public double getObjectiveValue();
	public Vector<String> getCoursesForStudentSemester( String student, String semester );
	public Vector<String> getStudentsForCourseSemester( String course, String semester );
}