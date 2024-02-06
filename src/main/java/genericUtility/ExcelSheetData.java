package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Anjana this is excelSheet java representation class from where we can
 *         read data from excel sheet w.t.h of create() method
 */
public class ExcelSheetData {
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Exception
	 */
	public static  String fetchStringDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws Exception {
		return WorkbookFactory.create(new FileInputStream("./src/test/resources/testData/testData.xlsx"))
				.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}

	public static double fetchNumericDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws Exception {
		return WorkbookFactory.create(new FileInputStream("./src/test/resources/testData/testData.xlsx"))
				.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}

	public static boolean fetchBooleanDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws FileNotFoundException, IOException {
		return WorkbookFactory.create(new FileInputStream("./src/test/resources/testData/testData.xlsx"))
				.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}

	public  static String fetchDateDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		return WorkbookFactory.create(new FileInputStream("./src/test/resources/testData/testData.xlsx"))
				.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getLocalDateTimeCellValue().toString()
				.substring(0, 10);
	}

}
