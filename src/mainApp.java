import loader.Loader;
import algorithm.SGDAlgorithm;

public class mainApp {

	//theta is 6 parameters +1 size = 7
	public static double[] theta = {0,0,0,0,0,0,0};
	
	
	
	
	
	//prints the inputed dataset
	public static void testPrintDataset(int m) {

		System.out.println("Number of training examples: " + m);
		for (int i=0; i<120; i++) {
			System.out.println("Traning Example: "+ (i+1));
			System.out.print(Loader.X[i][0]);
			System.out.print(" ");
			System.out.print(Loader.X[i][1]);
			System.out.print(" ");
			System.out.print(Loader.X[i][2]);
			System.out.print(" ");
			System.out.print(Loader.X[i][3]);
			System.out.print(" ");
			System.out.print(Loader.X[i][4]);
			System.out.print(" ");
			System.out.print(Loader.X[i][5]);
			System.out.print(" Y:");
			System.out.print(Loader.Y[i]);
			System.out.print("\n");
		}

		
	}

	

	
	
	//hypothesis function
	public static double sigmoidHypothesis(int i) {
		double thetaTx = theta[0]*1 + Loader.X[i][0]*theta[1] + Loader.X[i][1]*theta[2] + Loader.X[i][2]*theta[3] + 
				Loader.X[i][3]*theta[4] + Loader.X[i][4]*theta[5] + Loader.X[i][5]*theta[6];
		
		return (1/( 1 + Math.pow(Math.E,(-thetaTx))));
	}
	

	//cost function
	public static double cost(int i) {
		return 0.5*Math.pow(sigmoidHypothesis(i) - Loader.Y[i], 2);
	}
	
	
	//J(theta) function
	public static double JofTheta(int m) {
		double sum=0;
		for (int i=0; i<m; i++) {
			sum = sum + cost(i);
		}
		
		return (1/m)*sum;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int m = Loader.fileloaderLineCounter("diagnosisData.txt");
		Loader.fileloader("diagnosisData.txt", m);
		
		//testPrintDataset(m);
		
		SGDAlgorithm.shuffleDataset(m);
		System.out.println(sigmoidHypothesis(0));
		//testPrintDataset(m);

	}

}
