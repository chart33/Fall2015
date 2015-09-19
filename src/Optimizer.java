import java.io.IOException;
import java.util.Vector;

import com.sun.media.sound.ModelAbstractChannelMixer;

import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;

public class Optimizer implements scheduler {
String filepath;

//in the below argument, instead of dataFolder
	public void calculateSchedule(String dataFolder){
		int student = 600;
	    int course = 18;
	    int semester = 12;
	    GRBVar[] x = new GRBVar[1]; //quick fix
	    Students allStudent = new Students(filepath); //create and instance of Students to access set of student courses
	    

	    try {
	    //create GRBEnv
	      GRBEnv env = new GRBEnv("mip1.log");
	      GRBModel model = new GRBModel(env);

	   // create variables and add to model
	      GRBVar[][][] vars = new GRBVar[student][course][semester];
	      //GRBVar[] capacity = new GRBVar[x];
	      //I know this is adding a variable for each combination because of printed output (remove before submitting)
	      for (int i = 0; i < student; i++) {
	        for (int j = 0; j < course; j++) {
	          for (int k = 0; k < semester; k++) {
	            String st = "G_" + String.valueOf(i) + "_" + String.valueOf(j)
	                             + "_" + String.valueOf(k);
	            vars[i][j][k] = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, st);
	            System.out.println("student:"+i+", course:"+j+", semester:"+k);
	          }
	        }
	      }
//add X (maximum capacity) as a variable
	      
	      // Integrate variables into model

	      model.update();

	      
	      /********OBJECTIVE FUNCTION************/
	      
	      GRBLinExpr objectiveExpr = new GRBLinExpr();
	      for (int i = 0; i < student; i++) {
		        for (int j = 0; j < course; j++) {
		          for (int k = 0; k < semester; k++) {
		            objectiveExpr.addTerm(1, vars[i][j][k]);
		          }
		        }
		      }
	      
	      model.setObjective(objectiveExpr, GRB.MINIMIZE);
	      
	      
	      //****************************** Add constraints***************************************

	      GRBLinExpr expr;

	      // CONSTRAINT 1: Students take max two classes per semester

	      for (int i = 0; i < student; i++) {
	    	  int j;
	        for (int k = 0; k < semester; k++) {
	        	GRBLinExpr maxCourseConstraint = new GRBLinExpr();
	        	for( j = 0; j < course; j++){
	        		maxCourseConstraint.addTerm(1, vars[i][j][k]);
	        		//System.out.println("add term" + vars[i][j][k]);
	        	}
	        
	        String twoClassMax = "Student"+ String.valueOf(i)+".semester"+String.valueOf(k);
	       //System.out.println(twoClassMax);
	        
	        model.addConstr(maxCourseConstraint, GRB.LESS_EQUAL, 2.0, twoClassMax);
	        }
	      }   
	      
	      
	      //constraint 2: class capacity <= 0
	      //this constraint should take into account which course is offered which semester
	      for (int j = 0; j < course; j++) {
	        for (int k = 0; k < semester; k++) {
	        	int i;
	        	int semesterNumber= k+1;
	        	//use semesterNumber to account for index discrepancy from k to course number
	        	Course courseK = new Course();
	        	int courseNumber = j+1;
	        	GRBLinExpr capacityConstraint = new GRBLinExpr();
	        	if(courseK.isOffered(semesterNumber, courseNumber)==true){
	        	System.out.println("Course"+courseNumber+" is offered in semester "+ semesterNumber);
	        	for(i = 0; i < student; i++){
	          capacityConstraint.addTerm(1, vars[i][j][k]);
	        	}}else{System.out.println("course "+courseNumber+" is not offered in semester"+ semesterNumber);
	        //now build in X variable, which I"m still not confident about
	        /*	GRBLinExpr xConstraint = new GRBLinExpr();
	        	xConstraint.addTerm(-1, x[1]);*/
	        	//FIX BELOW!
	        	}
	         String maxCapacity = "MaxCap"+ String.valueOf(j)+".Course_"+String.valueOf(k)+".semester";
	        model.addConstr(capacityConstraint, GRB.LESS_EQUAL,0, maxCapacity);
	        	}
	        } 
	    
	      
	      //CONSTRAINT 3: make student take class (parse student input!)
	      //iterating through semesters.  =1 if student wants course, =0 if student doesn't want course
	      for(int i=0; i<= student; i++){
	    	  String mustTakeCourse = null;
	    	  for(int j=0; j<=course; j++){
	    		  GRBLinExpr mustTake = new GRBLinExpr();
	    		  //get the student object corresponding to student number
	    		  Students optStudents = new Students(filepath);
	    		  int studentNumber = i+1;
	    		  
	    		  // check if the course appears in array of courses
	    		  //if it does, add k term to expression to represent each semester
	    		  for(int k=0; k<=semester; k++){
	    		  mustTake.addTerm(1, vars[i][j][k]);
	    		  //if it doesn't... do nothing
	    		  
	    		  //here build string for constraints
	    		  mustTakeCourse = String.valueOf(i)+"must take"+String.valueOf(j)+" in semester "+String.valueOf(k);
	    		  }
	    		  //here goes constraint statement
	    		  model.addConstr(mustTake, GRB.EQUAL, 1, mustTakeCourse);
	    	  }
	      }
	      
	      //CONSTRAINT 4: prerequisites
	      //need to define right side and left sided expressions here. coefficients correspond to semester
	      
	      
	      // Update model
	      model.update();



	      // Optimize model

	      model.optimize();

	      // Write model to file
	      model.write("scheduler.lp");

	     

	    

	      // Dispose of model and environment
	      model.dispose();
	      env.dispose();

	    } catch (GRBException e) {
	      System.out.println("Error code: " + e.getErrorCode() + ". " +
	          e.getMessage());
	    }
	  }
		
@Override
public double getObjectiveValue() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Vector<String> getCoursesForStudentSemester(String student,
		String semester) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Vector<String> getStudentsForCourseSemester(String course,
		String semester) {
	// TODO Auto-generated method stub
	return null;
	}
}


