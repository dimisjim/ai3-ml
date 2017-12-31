package writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class DatasetSubsetWriter {

    public static void writeSubset(int mode, String filenameInput, String filenameOutput){
    	int lineCounter = 1;
    	
        File f2 = null;
        PrintWriter writer = null;
        File f = null;
        BufferedReader TXTreader = null;
        String line;

        try {
            f2 = new File(filenameOutput);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }

        try {
            writer = new PrintWriter(f2, "UTF-8");
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        

        try {
            f = new File(filenameInput);
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
            	line = TXTreader.readLine();
            	if(lineCounter%mode!=0){
            		writer.println(line);
            	}
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
    	
    	
    	
    	writer.close();
    }

    
    public static void writeSubset2(int mode, String filenameInput, String filenameOutput){
    	int lineCounter = 0;
    	
        File f2 = null;
        PrintWriter writer = null;
        File f = null;
        BufferedReader TXTreader = null;
        String line;

        try {
            f2 = new File(filenameOutput);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }

        try {
            writer = new PrintWriter(f2, "UTF-8");
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        

        try {
            f = new File(filenameInput);
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
            	line = TXTreader.readLine();
            	if(lineCounter%mode==0){
            		writer.println(line);
            	}
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
    	
    	
    	
    	writer.close();
    }
    
}
