package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Loader {
	public static double[][] X;
	public static double[] Y;
	
	//returns the number m of training examples inputed by the user
	public static int fileloaderLineCounter(String filename) {
		int lineCounter = 1;

        File f = null;
        BufferedReader TXTreader = null;
        String line;

        try {
            f = new File(filename);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }

        try {
            TXTreader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        }

        try {

        	line = TXTreader.readLine();
    		 
            while (line!=null){
            	//System.out.println(line);
            	line = TXTreader.readLine();
            	lineCounter++;
            }
            
            
            
        } //try
        catch (IOException e) {
            System.err.println("Error reading line " + lineCounter + ".");
        }

        try {
            TXTreader.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
        
        return lineCounter - 1;
	}

	
	//read dataset and initialize the X and Y vectors (arrays)
	public static void fileloader(String filename, int m) {
		
		
		X = new double[m][6];
		Y = new double[m];
		
		//Y has the target value: 0 for "does not have inflammation", 1 for "has"
		//X has the attribute of each give example
		//Attributes: 6, 8th is the target value (7th is a target value for another classification which in here is ignored)
		
    	int lineCounter = 1;
    	int i = 0;
    	int j = 0;
    		
        File f = null;
        BufferedReader TXTreader = null;
        String line;

        try {
            f = new File(filename);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }

        try {
            TXTreader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        }

        try {

        	line = TXTreader.readLine();
    		 
            while (line!=null){
            	
        		StringTokenizer st = new StringTokenizer(line.trim());
                String token = st.nextToken();
                
                X[i][j] = Double.parseDouble(token);
            	for (int a =0; a<7; a++){
            		
            		token = st.nextToken();
                	j++;
            		if (a<5) {
                    	
                    	if (token.equals("yes")) {
                    		X[i][j] = 1;
                    	}
                    	else {X[i][j] = 0;}
            		}
            		else if (a==6) {
            			if (token.equals("yes")) {
            				Y[i] = 1;
            			}
            			else {Y[i] = 0;}
            			 
            		}
            	}	
            	i++;
            	j=0;
            	line = TXTreader.readLine();
            	lineCounter++;
            }
            
            
            
        } //try
        catch (IOException e) {
            System.err.println("Error reading line " + lineCounter + ".");
        }

        try {
            TXTreader.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
	}
	
}
