import java.util.Vector;

public interface scheduler {

	public void calculateSchedule( String dataFolder );
	
	public double getObjectiveValue();
	public Vector<String> getCoursesForStudentSemester( String student, String semester );
	public Vector<String> getStudentsForCourseSemester( String course, String semester );
}