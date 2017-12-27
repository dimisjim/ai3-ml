package algorithm;

import java.util.concurrent.ThreadLocalRandom;

import loader.Loader;

public class SGDAlgorithm {

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
	
}
