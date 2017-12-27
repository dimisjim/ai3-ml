import loader.Loader;
import java.util.concurrent.ThreadLocalRandom;

public class mainApp {

	public static int m;
	//theta is 6 parameters +1 size = 7
	public static double[] theta = {0,0,0,0,0,0,0};
	
	//prints the inputed dataset
	public static void testPrintDataset() {

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

	
	//shuffles the dataset by swapping each row with another chosen randomly each time
	public static void shuffleDataset() {
		
		for (int i = 0; i<m; i++) {
			
			int randomI = ThreadLocalRandom.current().nextInt(0, 119 + 1);
			double temp = Loader.Y[randomI];
			Loader.Y[randomI] = Loader.Y[i];
			Loader.Y[i] = temp;
			
			for (int j = 0; j<6; j++) {
				temp = Loader.X[randomI][j];
				Loader.X[randomI][j] = Loader.X[i][j];
				Loader.X[i][j] = temp;

			}
			
			
		}
		
	}
	
	
	public static double sigmoidHypothesis(int i) {
		double thetaTx = theta[0]*1 + Loader.X[i][0]*theta[1] + Loader.X[i][1]*theta[2] + Loader.X[i][2]*theta[3] + 
				Loader.X[i][3]*theta[4] + Loader.X[i][4]*theta[5] + Loader.X[i][5]*theta[6];
		
		return (1/( 1 + Math.pow(Math.E,(-thetaTx))));
	}
	

	public static double cost(int i) {
		return 0.5*Math.pow(sigmoidHypothesis(i) - Loader.Y[i], 2);
	}
	
	public static double JofTheta(int m) {
		double sum=0;
		for (int i=0; i<m; i++) {
			sum = sum + cost(i);
		}
		
		return (1/m)*sum;
	}
	
	public static void main(String[] args) {
		
		m = Loader.fileloaderLineCounter("diagnosisData.txt");
		Loader.fileloader("diagnosisData.txt", m);
		
		//testPrintDataset();
		
		shuffleDataset();
		System.out.println(sigmoidHypothesis(0));
		//testPrintDataset();

	}

}
