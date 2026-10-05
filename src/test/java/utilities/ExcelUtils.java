package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static final String FILE_PATH = "src/test/resources/testdata/PizzaHutData.xlsx";

	public static String getCellData(int rowNum, int cellNum) {

		try {

			FileInputStream file = new FileInputStream(FILE_PATH);

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheet("TestData");

			String data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();

			workbook.close();
			file.close();

			return data;

		} catch (Exception e) {

			e.printStackTrace();

			throw new RuntimeException("Unable to read data from Excel file");
		}
	}
}