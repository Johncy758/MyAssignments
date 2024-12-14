package week5.day2Assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NameData {

	public static String[][] readValue() throws IOException {

		// Excelworkbook path
		XSSFWorkbook wb = new XSSFWorkbook("./Excelsheet/Salesforcename.xlsx");

		// Get the sheet from book
		XSSFSheet sheet = wb.getSheetAt(0);

		// Get into row
		int lastRowNum = sheet.getLastRowNum();

		// Get into cell
		int lastCellNum = sheet.getRow(0).getLastCellNum();

		// Store it in string
		String[][] data = new String[lastRowNum - 1][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {

			for (int j = 0; j < lastCellNum; j++) {

				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = stringCellValue;
			}
		}
		// Close the window and return the statement
		wb.close();
		return data;

	}
}
