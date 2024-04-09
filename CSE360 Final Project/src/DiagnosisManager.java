
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class DiagnosisManager {
	
	
	public void main(String[] args) {
		
	}
	
	// returns new database connection
	private Connection getConnection(String diagnosisName, String treatments, String prescriptions) 
			throws SQLException {
        return DriverManager.getConnection(diagnosisName, treatments, prescriptions);
    }

	// prints data in connection
    private void printMetaData(Connection connection)
    		throws SQLException
    {
    	DatabaseMetaData metaData = connection.getMetaData();
    	String format = "\nDatabase metadata\n"
    			+ "Database name : %s\n"
                + "Database version : %s\n"
                + "Database driver name : %s\n"
                + "Database driver version : %s\n\n";
    	System.out.printf(format,
                  metaData.getDatabaseProductName(),
                  metaData.getDatabaseProductVersion(),
                  metaData.getDriverName(),
                  metaData.getDriverVersion());
    }
    
    // executes SQL commands in the file
    public void executeFile(String path)
    {
    	try (FileReader reader = new FileReader(path);
    		// Wrap the FileReader in a BufferedReader for efficient reading.
    		BufferedReader bufferedReader = new BufferedReader(reader);
    		// Establish a connection to the database.
    		Connection connection = getConnection(diagnosisName, treatments, prescriptions);
    		// Create a statement object to execute SQL commands.
    		Statement statement = connection.createStatement();) {

    		printMetaData(connection);
    		System.out.println("Executing commands at : " + path);

    		StringBuilder builder = new StringBuilder();

    		String line;
    		int lineNumber = 0;
    		int count = 0;

    		// Read lines from the SQL file until the end of the file
    		while ((line = bufferedReader.readLine()) != null) {
    			lineNumber += 1;
    			line = line.trim();

    			// Skip empty lines and single-line comments.
    			if (line.isEmpty() || line.startsWith("--"))
    				continue;

    			builder.append(line);
    			// If the line ends with a semicolon, it
    			// indicates the end of an SQL command.
    			if (line.endsWith(";"))
    				try {
    					// Execute the SQL command
    					statement.execute(builder.toString());
    					// Print a success message along with
    					// the first 15 characters of the
    					// executed command.
    					System.out.println(
    						++count
    						+ " Command successfully executed : "
    						+ builder.substring(
    							0,
    							Math.min(builder.length(), 15))
    						+ "...");
    					builder.setLength(0);
    				}
    				catch (SQLException e) {
    					// If an SQLException occurs during
    					// execution, print an error message and
    					// stop further execution.
    					System.err.println(
    						"At line " + lineNumber + " : "
    						+ e.getMessage() + "\n");
    					return;
    				}
    		}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    

}
