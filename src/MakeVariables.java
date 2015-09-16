/*import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBModel;
import gurobi.GRBVar;*/

/* The purpose of this class is to generate all possible permutations of 
 * 600 students* 18 courses * 12 semesters.*/

/*public class MakeVariables {
	int c = 0;
	
	public int allVariables(){
		try {
		      GRBEnv env = new GRBEnv();
		      GRBModel model = new GRBModel(env);

		      // Create 3-D array of model variables

		      GRBVar[][][] vars = new GRBVar[601][19][13];

		      for (int i = 1; i <= 600; i++) {
		        for (int j = 1; j <= 18; j++) {
		          for (int k = 1; k <= 12; k++) {
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
		      
		      System.out.println("The total number of variables generated is: "+ c);
		      return c;
	}
}*/

//********* commented this out, might need later but not sure.
		    		 
		


