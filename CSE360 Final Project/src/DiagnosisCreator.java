import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class DiagnosisCreator {
		private final String diagnosisName;
	    private final String[] treatments;
	    private final String[] symptoms;
	 
	    public DiagnosisCreator(String className, String diagnosisName, 
	    		String[] treatments, String[] symptoms) 
	    		throws ClassNotFoundException {
	        Class.forName(className);
	        this.diagnosisName = diagnosisName;
	        this.treatments = treatments;
	        this.symptoms = symptoms;
	    }
	}
