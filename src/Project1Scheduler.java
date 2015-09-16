import java.io.IOException;
import java.util.Vector;

import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;

public class Project1Scheduler implements scheduler {


//in the below argument, instead of dataFolder
	public void calculateSchedule(String dataFolder){
		int student = 600;
	    int course = 18;
	    int semester = 12;
	    

	    try {
	      GRBEnv env = new GRBEnv();
	      GRBModel model = new GRBModel(env);

	      // Create 3-D array of model variables

	      GRBVar[][][] vars = new GRBVar[student][course][semester];
	      GRBVar[] x = new GRBVar[1];//initialized to 1 because should only hold one value?
	      

	      for (int i = 0; i < student; i++) {
	        for (int j = 0; j < course; j++) {
	          for (int k = 0; k < semester; k++) {
	            String st = "G_" + String.valueOf(i) + "_" + String.valueOf(j)
	                             + "_" + String.valueOf(k);
	            vars[i][j][k] = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, st);
	          }
	        }
	      }

	      // Integrate variables into model

	      model.update();

	      //****************************** Add constraints***************************************

	      GRBLinExpr expr;

	      // CONSTRAINT 1: Students take max two classes per semester

	      for (int i = 0; i < student; i++) {
	    	  expr = new GRBLinExpr();
	        for (int j = 0; j < course; j++) {
	        	for(int k = 0; k < semester; k++){
	          expr.addTerm(1, vars[i][j][k]);
	        	}
	        }
	        String twoClassMax = "Student"+ String.valueOf(student)+".Course"+String.valueOf(course)+".semester"+String.valueOf(semester);
	        model.addConstr(expr, GRB.EQUAL, 2.0, twoClassMax);
	    }
	      
	      //constraint 2: class capacity <= x
	      //FIGURES OUT WTF X SHOULD BE DOING
	      for (int i = 0; i < student; i++) {
	    	  expr = new GRBLinExpr();
	        for (int j = 0; j < course; j++) {
	        	for(int k = 0; k < semester; k++){
	          expr.addTerm(1, vars[i][j][k]);
	          //expr.addTerm(1, x[0]);
	        	}
	        }
	        String maxCapacity = "MaxCap: Student"+ String.valueOf(student)+".Course"+String.valueOf(course)+".semester"+String.valueOf(semester);
	        model.addConstr(expr, GRB.LESS_EQUAL,10000, maxCapacity);
	      }
	      
	      //CONSTRAINT 3: classes needed (parse student input!)
	      //iterating through semesters.  =1 if student wants course, =0 if student doesnt want course
	      for (int i = 0; i < student; i++) {
	    	  expr = new GRBLinExpr();
	        for (int j = 0; j < course; j++) {
	        	for(int k = 0; k < semester; k++){
	          expr.addTerm(1, vars[i][j][k]);
	        	}
	        }
	        String needsClass = "Student"+ String.valueOf(student)+".Course"+String.valueOf(course)+".semester"+String.valueOf(semester);
	        model.addConstr(expr, GRB.EQUAL, 2.0, needsClass);
	    }
	      
	      //CONSTRAINT 4: prerequisites
	      for (int i = 0; i < student; i++) {
	    	  expr = new GRBLinExpr();
	        for (int j = 0; j < course; j++) {
	        	for(int k = 0; k < semester; k++){
	          expr.addTerm(1, vars[i][j][k]);
	        	}
	        }
	        String twoClassMax = "Student"+ String.valueOf(student)+".Course"+String.valueOf(course)+".semester"+String.valueOf(semester);
	        model.addConstr(expr, GRB.EQUAL, 2.0, twoClassMax);
	    }
	      
	      
	      
	      // Update model

	      model.update();



	      // Optimize model

	      model.optimize();

	      // Write model to file
	      model.write("scheduler.lp");

	     // double[][][] x = model.get(GRB.DoubleAttr.X, vars);

	    

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


