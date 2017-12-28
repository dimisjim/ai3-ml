package algorithm;

import java.util.concurrent.ThreadLocalRandom;

import loader.Loader;

public class SGDAlgorithm {
	
	//theta is 6 parameters +1 size = 7
	public static double[] theta = {0,0,0,0,0,0,0};
	public static int alpha = 1;
	
	
	//shuffles the dataset by swapping each row with another chosen randomly each time
	public static void shuffleDataset(int m) {
		
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
	
	
	//Stochastic Gradient Descent Algorithm
	public static void SGD(double J, double alpha, int m, int n){
		
		n = theta.length;
		double[] thetaCopy = new double[n];
		
		for (int r=0; r<10; r++){
			
			for (int i=0; i<m; i++){
				
				for (int j=0; j<n; j++){
					
					if (j==0){
						thetaCopy[j] = theta[j] - alpha*(sigmoidHypothesis(i) - Loader.Y[i])*1;
					}
					else{
						thetaCopy[j] = theta[j] - alpha*(sigmoidHypothesis(i) - Loader.Y[i])*Loader.X[i][j];
					}
					
					
				}
				
				updateTheta(thetaCopy);
				
			}
			
		}
		
	}
	
	public static void updateTheta(double[] thetaCopy){
		
		for (int j=0; j<theta.length; j++){
			
			theta[j] = thetaCopy[j];
			
		}
		
	}

}
