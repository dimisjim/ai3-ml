package algorithm;

import java.util.concurrent.ThreadLocalRandom;

import loader.Loader;

public class SGDAlgorithm {
	
	//theta is 6 parameters +1 size = 7
	public static double[] theta = {0,0,0,0,0,0,0};
	public static double[] finalTheta = {0,0,0,0,0,0,0};
	
	
	//shuffles the dataset by swapping each row with another chosen randomly each time
	public static void shuffleDataset(int m) {
		
		for (int i = 0; i<m; i++) {
			
			int randomI = ThreadLocalRandom.current().nextInt(0, 119 + 1);
			double temp = Loader.Y2[randomI];
			Loader.Y2[randomI] = Loader.Y2[i];
			Loader.Y2[i] = temp;
			
			for (int j = 0; j<6; j++) {
				temp = Loader.X[randomI][j];
				Loader.X[randomI][j] = Loader.X[i][j];
				Loader.X[i][j] = temp;

			}
			
			
		}
		
	}
	

	//hypothesis function
	public static double sigmoidHypothesis(int i, double[] Theta) {
		double thetaTx = Theta[0]*1 + Loader.X[i][0]*Theta[1] + Loader.X[i][1]*Theta[2] + Loader.X[i][2]*Theta[3] + 
				Loader.X[i][3]*Theta[4] + Loader.X[i][4]*Theta[5] + Loader.X[i][5]*Theta[6];
		
		//System.out.println(1/( 1 + Math.pow(Math.E,(-thetaTx))));
		
		return (1/( 1 + Math.pow(Math.E,(-thetaTx))));
	}
	

	//cost function
	public static double cost(int i, double[] Theta) {
		return 0.5*Math.pow(sigmoidHypothesis(i, Theta) - Loader.Y2[i], 2);
	}
	
	
	//J(theta) function
	public static double JofTheta(int m, double[] Theta) {
		double sum=0;
		for (int i=0; i<m; i++) {
			sum = sum + cost(i, Theta);
		}
		
		return sum/m;
	}
	
	
	//Stochastic Gradient Descent Algorithm
	public static void SGD(double alpha, int m){
		
		int n = theta.length;
		double[] thetaCopy = new double[n];
		
		System.out.println("Initial value of vector theta: " + theta[0] +" " + theta[1] +" " + 
				theta[2] +" " + theta[3] +" " + theta[4] +" " + theta[5] +" " + theta[6]);
		System.out.println("Initial Value of J(theta): " + JofTheta(m, theta));
		
		double minValue = JofTheta(m, theta);
		
		for (int r=0; r<10; r++){
			
			for (int i=0; i<m; i++){
				
				for (int j=0; j<n; j++){
					
					if (j==0){
						thetaCopy[j] = theta[j] - alpha*(sigmoidHypothesis(i, theta) - Loader.Y2[i])*1;
					}
					else{
						thetaCopy[j] = theta[j] - alpha*(sigmoidHypothesis(i, theta) - Loader.Y2[i])*Loader.X[i][j-1];
					}
					
					
				}
				
				updateTheta(thetaCopy);
				
				
				
				
				if(JofTheta(m, theta)<minValue){
					minValue = JofTheta(m, theta);
					//System.out.println(minValue);
					chosenTheta();
				}
				//System.out.println(JofTheta(m));
				//System.out.println(theta[0] +" " + theta[1] +" " + theta[2] +" " + theta[3] +" " + theta[4] +" " + theta[5] +" " + theta[6]);
				
			}
			
		}
		
		System.out.println("Final value of vector theta: " + finalTheta[0] +" " + finalTheta[1] +" " + 
				finalTheta[2] +" " + finalTheta[3] +" " + finalTheta[4] +" " + finalTheta[5] +" " + finalTheta[6]);
		System.out.println("Final value of J(theta): " + JofTheta(m, finalTheta));
		
	}
	
	
	
	public static void updateTheta(double[] thetaCopy){
		
		for (int j=0; j<theta.length; j++){
			
			theta[j] = thetaCopy[j];
			
		}
		
	}
	
	
	public static void chosenTheta(){
		
		for (int j=0; j<theta.length; j++){
			
			finalTheta[j] = theta[j];
			
		}
		
	}
	
	
	//hypothesis function, to be used to for new predictions, based on newly inputed data
	public static double finalSigmoidHypothesis(double[] Theta, double[] input) {
		double thetaTx = Theta[0]*1 + input[0]*Theta[1] + input[1]*Theta[2] + input[2]*Theta[3] + 
				input[3]*Theta[4] + input[4]*Theta[5] + input[5]*Theta[6];
		
		
		return (1/( 1 + Math.pow(Math.E,(-thetaTx))));
	}

}
