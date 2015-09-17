
public class Course {

	int courseNumber;
	boolean fallSemester;
	boolean springSemester;
	boolean summerSemester;
	
	Course(int courseNumber, boolean fallSemester, boolean springSemester, boolean summerSemester){
		//constructor for courses
	}
	
	public static boolean isOffered(int semester, int courseNumber){
		//this method will tell you if a class is offered based on current semester number and course number
		int s = (semester+3)%3;
		boolean offered = false;
		
		if(courseNumber==2 //this block is for courses offered every semester
				||courseNumber==3
				||courseNumber==4
				||courseNumber==6
				||courseNumber==8
				||courseNumber==9
				||courseNumber==12
				||courseNumber==13
				){
			offered = true;
		}else if(courseNumber==1 //this block is for courses offered only in the fall
				||courseNumber==7
				||courseNumber==11
				||courseNumber==15
				||courseNumber==17){
					if(s == 0){
						offered = true;}
							else {offered = false;}
		}else if(courseNumber == 5 //this block is for courses offered only in the spring
				||courseNumber==10
				||courseNumber==14
				||courseNumber==16
				||courseNumber==18){
					if(s == 1){
						offered = true;}else{offered=false;}
					}
		
		return offered;
	}
	
	
}
