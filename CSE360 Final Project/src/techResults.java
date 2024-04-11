package cse360proj;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class techResults {
	String pID;
	String agaCAC;
	String lm;
	String lad;
	String lcx;
	String rca;
	String pda;
	
	public techResults()
    {
        pID = "";
        agaCAC = "";
        lm = "";
        lad = "";
        lcx = "";
        rca = "";
        pda = "";

    }
	
	public techResults(ArrayList<String> in)
    {
        pID = in.get(0);
        agaCAC = in.get(1);
        lm = in.get(2);
        lad = in.get(3);
        lcx = in.get(4);
        rca = in.get(5);
        pda = in.get(6);

    }
	
	public String toString() {
		return "Patient ID: " + this.pID + "\n" + 
				"The Total Agatson CAC Score: " + this.agaCAC + "\n" + 
				"Vessel Level Agatson CAC Score \n" + 
				"LM: " + this.lm + "\n" + 
				"LAD: " + this.lad + "\n" + 
				"LCX: " + this.lcx + "\n" + 
				"RCA: " + this.rca + "\n" + 
				"PDA: " + this.pda;
	}
	
	public void WriteToFile(String key){
	    try {
	      String filename = key + "Results.txt";
		  FileWriter fh = new FileWriter(filename);
		  fh.write(this.toString());
		  fh.close();
		  System.out.println("Successfully wrote to the file: " + key + "Results.txt");
	    } 
	    catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
    }
}
