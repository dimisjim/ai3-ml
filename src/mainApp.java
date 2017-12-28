import loader.Loader;

import java.util.Scanner;

import algorithm.SGDAlgorithm;

public class mainApp {
	
	
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("----------- Logistic Regression - Stochastic Gradient Descent -----------");
		System.out.println("----------- Dataset used: Acute Inflammations, from UCI repository -----------");
		System.out.println("-------- 6 attributes:");
		System.out.println("----- X[i][0]: Temperature of patient");
		System.out.println("----- X[i][1]: Occurrence of nausea, '0' for no, '1' for yes");
		System.out.println("----- X[i][2]: Lumbar pain, '0' for no, '1' for yes");
		System.out.println("----- X[i][3]: Urine pushing, '0' for no, '1' for yes");
		System.out.println("----- X[i][4]: Micturition pains, '0' for no, '1' for yes");
		System.out.println("----- X[i][5]: Burning of urethra, '0' for no, '1' for yes");
		System.out.println("-------- 2 decisions (4 classes):");
		System.out.println("----- Y1[i]: Inflammation of urinary bladder, '0' for no, '1' for yes");
		System.out.println("----- Y2[i]: Nephritis of renal pelvis origin , '0' for no, '1' for yes");
		
		System.out.println("\nEnter the filename of dataset: ");
		//String filename = reader.nextLine();
		//reader.close();
		String filename = "diagnosisData.txt";
		
		int m = Loader.fileloaderDataLineCounter(filename);
		Loader.fileloaderData(filename, m);
		
		Loader.testPrintDataset(m);
		
		SGDAlgorithm.shuffleDataset(m);
		//System.out.println(SGDAlgorithm.sigmoidHypothesis(0));
		
		//System.out.println(SGDAlgorithm.JofTheta(m));
		
		//Loader.testPrintDataset(m);
		
		
		SGDAlgorithm.SGD(0.002, m);
		
		
		
		
		double[] input = {40.5,1,1,1,1,0};
		double prediction = SGDAlgorithm.finalSigmoidHypothesis(SGDAlgorithm.finalTheta, input);
		System.out.println(prediction);
		
	}

}
