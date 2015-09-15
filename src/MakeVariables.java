import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBModel;
import gurobi.GRBVar;

/* The purpose of this class is to generate all possible permuations of 
 * 600 students* 18 courses * 12 semesters.  this is a shitload of
 * variables.*/
public class MakeVariables {
	int c = 0;
	
	public int allVariables(){
		try {
		      GRBEnv env = new GRBEnv();
		      GRBModel model = new GRBModel(env);

		      // Create 3-D array of model variables

		      GRBVar[][][] vars = new GRBVar[600][18][12];

		      for (int i = 0; i <= 600; i++) {
		        for (int j = 0; j <= 18; j++) {
		          for (int k = 0; k <= 12; k++) {
		            String st = "G_" + String.valueOf(i) + "_" + String.valueOf(j)
		                             + "_" + String.valueOf(k);
		            vars[i][j][k] = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, st);
		            System.out.println("Added variable:[" + i + ","+j+","+k+"]");
		            c++;
		          }
		        }
		      }} catch (GRBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {}
		      
		      System.out.println("The total number of variables generaged is: "+ c);
		      return c;
	}
}
//add comment
		    		 
		


