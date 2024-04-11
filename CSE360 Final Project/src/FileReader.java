import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//Save data to file
// writeToFile(gson.toJson(prescription));

// Retrieve data from file
// readFromFile();


public class FileReader {
    private static String prescriptionFileLocation = "/Documents/Prescriptions/";
    private static String diagnosisFileLocation = "/Documents/Diagnoses/";
    
    public String[] prescriptionList = new String[100];
    private int prescriptionLength = 0;
    public String[] diagnosisList = new String[100];
    private int diagnosisLength = 0;
    //private static final Gson gson = new Gson();
    
    // Prescription Manager
    public class Prescriptions {
    	public String prescriptionName;
    	public String[] dosages;
    	public String[] symptomsCured;
    	public String[] sideEffects;
        
    	// constructor
    	public Prescriptions(String prescriptionName, String[] dosages, String[] symptomsCured, String[] sideEffects) {
    		this.prescriptionName = prescriptionName;
    		this.dosages = dosages;
    		this.symptomsCured = symptomsCured;
    		this.sideEffects = sideEffects;
    		prescriptionList[prescriptionLength] = prescriptionName;
    		
    		String dosageText = "";
    		for (int i=0; i<dosages.length; i++) {
    			dosageText = dosageText + ", " + dosages[i];
    		}
    		
    		String symptomText = "";
    		for (int i=0; i<symptomsCured.length; i++) {
    			symptomText = symptomText + ", " + symptomsCured[i];
    		}
    		
    		String effectsText = "";
    		for (int i=0; i<sideEffects.length; i++) {
    			effectsText = effectsText + ", " + sideEffects[i];
    		}
    		
    		writeToFile(prescriptionName + ":\n" + dosageText + "\n" + symptomText + "\n" + effectsText, 
    				prescriptionFileLocation + prescriptionName + ".txt");
    	}  
    }
    
    // Diagnosis Manager
    public class Diagnoses {
    	public String diagnosisName;
    	public String[] treatments;
    	public String[] symptoms;
    	
    	// constructor
    	public Diagnoses(String diagnosisName, String[] treatments, String[] symptoms) {
    	        this.diagnosisName = diagnosisName;
    	        this.treatments = treatments;
    	        this.symptoms = symptoms;
    	        diagnosisList[diagnosisLength] = diagnosisName;
    	        diagnosisLength++;
    	        
    	        String treatmentText = "";
        		for (int i=0; i<treatments.length; i++) {
        			treatmentText = treatmentText + ", " + treatments[i];
        		}
        		
        		String symptomText = "";
        		for (int i=0; i<symptoms.length; i++) {
        			symptomText = symptomText + ", " + symptoms[i];
        		}
    	        
        		writeToFile(diagnosisName + ": \n" + treatmentText + "\n" + symptomText, 
        				diagnosisFileLocation + diagnosisName + ".txt");
    	    }
    	
    	// returns relevant prescription/s if available
    	public File[] getPrescriptions() {
    		File[] list = null;
    		int listLength = 0;
    		
    		for (int i=0; i<treatments.length; i++) {
    			if ((new File(prescriptionFileLocation + treatments[i] + ".txt")).exists()) {
    				list[0] = (new File(prescriptionFileLocation));
    				listLength ++;
    			}
    		}
    		return list;
    	}
    }
    
    // returns all the added Prescriptions
    public String GetAllPrescriptions() {
    	String list = "";
		
		for (int i=0; i < prescriptionList.length; i++) {
			if ((new File(prescriptionFileLocation + prescriptionList[i] + ".txt")).exists()) {
				list = list + "\n" + readFromFile(prescriptionFileLocation + prescriptionList[i] + ".txt");
			}
		}
		return list;
    }
    
    // returns all the added Diagnoses
    public String GetAllDiagnoses() {
    	String list = "";
		
		for (int i=0; i < diagnosisList.length; i++) {
			if ((new File(diagnosisFileLocation + diagnosisList[i] + ".txt")).exists()) {
				list = list + "\n" + readFromFile(diagnosisFileLocation + diagnosisList[i] + ".txt");
			}
		}
		return list;
    }
    
    
    public void SampleFileAdd() {
    	Prescriptions aderol = new Prescriptions("aderol", 
    			new String[] {"20 mg", "10 mg"}, 
    			new String[] {"headache", "muscle pain"},  
    			new String[] {"pain"});
    	
    	Diagnoses migrane = new Diagnoses("migrane", 
    			new String[] {"aderol", "ice"}, 
    			new String[] {"headache"});
    	
    }
    
    // Save to File Utility
    private static void writeToFile(String myData, String fileLocation) {
    	
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
    public static String readFromFile(String fileLocation) {
        File currentFile = new File(fileLocation);
        
        if (!currentFile.exists())
            crunchifyLog("File doesn't exist");
        
        InputStreamReader isReader;
        try {
            isReader = new InputStreamReader(new FileInputStream(currentFile), StandardCharsets.UTF_8);
            String output = "";
            Scanner scanner = new Scanner(currentFile);
            while (scanner.hasNextLine()) {
            	output = output + "\n" + scanner.nextLine();
            }
            return output;
        } catch (Exception e) {
            crunchifyLog("error load cache from file " + e.toString());
        }
        return "";
    }
    
    // Print Log
    private static void crunchifyLog(String string) {
        System.out.println(string);
    }
    
    
}
