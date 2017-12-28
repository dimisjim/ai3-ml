import loader.Loader;
import algorithm.SGDAlgorithm;

public class mainApp {
	
	
	
	
	
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

	

	
	

	
	
	
	
	
	public static void main(String[] args) {
		
		int m = Loader.fileloaderLineCounter("diagnosisData.txt");
		Loader.fileloader("diagnosisData.txt", m);
		
		//testPrintDataset(m);
		
		SGDAlgorithm.shuffleDataset(m);
		//System.out.println(SGDAlgorithm.sigmoidHypothesis(0));
		
		System.out.println(SGDAlgorithm.JofTheta(m));
		
		//testPrintDataset(m);

	}

}
