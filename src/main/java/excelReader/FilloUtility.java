package excelReader;

import java.util.ArrayList;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.log4j.Logger;


public class FilloUtility {
	public static final Logger log = Logger.getLogger(FilloUtility.class.getName());

	ArrayList<String> column = new ArrayList<String>();
	ArrayList<String> testData = new ArrayList<String>();
	public String filepath;

	public ArrayList<String> getData(String filepath2, String excelName, String sheetName, int rowNumber, String columnName) throws FilloException {
		filepath = filepath2;
		Fillo fillo = new Fillo(); // initialize the FIllo class
		String filepath1 = filepath + excelName; // complete path till the file to be used/opened

		Connection connection = fillo.getConnection(filepath1);  // Setting connection with the Excel File

		String fetchQuery = "Select * from " + sheetName + " where " + columnName + "='" + rowNumber + "' "; // Writing SQL Query

		Recordset recordset = connection.executeQuery(fetchQuery); // Execute Query and store result in Record set

		while (recordset.next()) {  // Condition till record set has values

			column = recordset.getFieldNames(); // get column names => 3 (0,1, 2, 3)
            log.info("I am in ExcelReader");
			for (int i = 1; i <= column.size() - 1; i++) {  // run for loop for desired columns
				testData.add(recordset.getField(column.get(i)));  // add row values to ArrayList
			}
		}
		recordset.close();
		connection.close();
		return testData;
	}

	public void updateData(String filepath, String excelName, String sheetName, int rowNumber, String columnName, String message) throws FilloException {

		this.filepath = filepath;
		Fillo fillo = new Fillo();
		String filepath1 = filepath + excelName;

		Connection connection = fillo.getConnection(filepath1);  // Setting connection with the Excel File

		String updateQuery="Update " + sheetName+ " Set " + columnName + "='"+ message + "' where TestNumber ='" + rowNumber + "'";
		connection.executeUpdate(updateQuery);

		connection.close();
	}
}
