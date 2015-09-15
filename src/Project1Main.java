
public class Project1Main {

	public static void main(String[] args) {
		Project1Scheduler scheduler = new Project1Scheduler();
		scheduler.calculateSchedule("");
		System.out.println("Now running main method to access scheduler");
		Reader reader = new Reader();
		reader.readFile("/home/ubuntu/Documents/student_schedule.txt");
		MakeVariables mVar = new MakeVariables();
		mVar.allVariables();
		
	}		
}
//add comment