import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReader {
	public static String name;
    private static String fileLocation = "/Users/appshah/Documents/" + name + ".txt";
    //private static final Gson gson = new Gson();
    
    // Prescription Manager
    private static class Prescriptions {
    	public String prescriptionName;
    	public String[] dosages;
    	public String[] symptomsCured;
    	public String[] sideEffects;
        
    	public Prescriptions(String prescriptionName, String[] dosages, String[] symptomsCured, String[] sideEffects) {
    		this.prescriptionName = prescriptionName;
    		this.dosages = dosages;
    		this.symptomsCured = symptomsCured;
    		this.sideEffects = sideEffects;
    	}  
    }
    
    // Diagnosis Manager
    private static class Diagnoses {
    	public String diagnosisName;
    	public String[] treatments;
    	public String[] symptoms;
    	
    	// constructor
    	public Diagnoses(String diagnosisName, String[] treatments, String[] symptoms) {
    	        this.diagnosisName = diagnosisName;
    	        this.treatments = treatments;
    	        this.symptoms = symptoms;
    	    }
    	
    	// returns relevant prescription/s if available
    	public File[] getPrescriptions() {
    		File[] list = null;
    		int listLength = 0;
    		
    		for (int i=0; i<treatments.length; i++) {
    			fileLocation = "/Users/appshah/Documents/" + treatments[i] + ".txt";
    			if ((new File(fileLocation)).exists()) {
    				list[0] = (new File(fileLocation));
    				listLength ++;
    			}
    		}
    		return list;
    	}
    }
    
    // Main Method
    public static void main(String[] args) {
        // Save data to file
        // writeToFile(gson.toJson(prescription));
        
        // Retrieve data from file
        // readFromFile();
    }
    
    // Save to File Utility
    private static void writeToFile(String myData) {
        
        File currentFile = new File(fileLocation);
        
        // Tests whether the file or directory denoted by this abstract pathname exists.
        if (!currentFile.exists()) {
        
            try {
                File directory = new File(currentFile.getParent());
                // stores file in file directory
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                
                currentFile.createNewFile();
            } catch (IOException e) {
                crunchifyLog("Exception Occurred: " + e.toString());
            }
        }
        
        try {
            // Convenience class for writing character files
            FileWriter fileWriter;
            fileWriter = new FileWriter(currentFile.getAbsoluteFile(), true);
            
            // Writes text to a character-output stream
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(myData.toString());
            bufferWriter.close();
            
            crunchifyLog("File saved at: " + fileLocation + " Data: " + myData + "\n");
        } catch (IOException e) {
            
            crunchifyLog("Error: " + e.toString());
        }
    }
    
    // Read From File Utility
    public static void readFromFile() {
    	// Creates new file
        File currentFile = new File(fileLocation);
        
        if (!currentFile.exists())
            crunchifyLog("File doesn't exist");
        
        InputStreamReader isReader;
        try {
            isReader = new InputStreamReader(new FileInputStream(currentFile), StandardCharsets.UTF_8);
            
            //JsonReader myReader = new JsonReader(isReader);
            //Prescriptions prescription = gson.fromJson(myReader, Prescriptions.class);
            
            //crunchifyLog("Prescription Name: " + prescription.prescriptionName);
            
        } catch (Exception e) {
            crunchifyLog("error load cache from file " + e.toString());
        }
        
        crunchifyLog("\nFile loaded successfully: " + fileLocation);
        
    }
    
    private static void crunchifyLog(String string) {
        System.out.println(string);
    }
    
}
