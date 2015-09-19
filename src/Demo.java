
public class Demo {

	public static void main(String[] args) {
		String filepath = args[0];
		Optimizer scheduler = new Optimizer(filepath);
		scheduler.calculateSchedule(filepath);
				
	}		
}
