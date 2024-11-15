package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author anushma
 */
public class Excelutility {
	/**
	 * This method is used to read String data from excel
	 * user must pass sheetname, rowIndex, column index
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws IOException
	 */
	
	public String getStringDataFromExcel(String sheetName, int rowIndex, int colIndex) throws IOException
	{
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptDatas.xlsx");
		Workbook workbook =  WorkbookFactory.create(fis);
		String value =workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to read boolean data from excel
	 * user must pass sheetname, rowIndex, column index
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return value
	 * @throws IOException
	 */
	public boolean getBooleanDataFromExcel(String sheetName, int rowIndex, int colIndex) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/demowebshopTestScriptDatas.xlsx");
			Workbook workbook =  WorkbookFactory.create(fis);
		 boolean value = workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
		return value;
	}
	/**
	 * This method is used to read Numeric data from excel
	 * user must pass sheetname, rowIndex, column index 
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return value
	 * @throws IOException
	 */
	public double getNumericDataFromExcel(String sheetName, int rowIndex, int colIndex) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/demowebshopTestScriptDatas.xlsx");
			Workbook workbook =  WorkbookFactory.create(fis);
		   double value = workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
		return value;
	}
	
	/**
	 * This method is used to read Date data from excel
	 * user must pass sheetname, rowIndex, column index 
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return value
	 * @throws IOException
	 */
	public LocalDateTime getDateFromExcel(String sheetName, int rowIndex, int colIndex) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/demowebshopTestScriptDatas.xlsx");
			Workbook workbook =  WorkbookFactory.create(fis);
		  LocalDateTime value = workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
		return value;
	}
}
