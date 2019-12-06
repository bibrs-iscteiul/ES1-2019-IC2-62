package pt.iul.ista.es.applications;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The Class ReadFromFile.
 * @author Joana Cavalheiro
 * @since 2019-11-04
 * 
 */
public class ReadFromFile {

	/** The row number. */
	int rowNumber = 0;

	/** The col number. */
	int colNumber = 0;

	/** A list with all methods which exists in excel file. */
	ArrayList<Method> allMethods;

	/**
	 * Instantiates a new read from file.
	 */
	public ReadFromFile() {
		this.allMethods = new ArrayList<Method>();
	}

	/**
	 * Read from a file.
	 *
	 * @param fileName the file name
	 * @param sheetName the sheet name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ArrayList<Method> read(String fileName, int sheetIndex) throws IOException {

		FileInputStream fis = new FileInputStream(new File(fileName));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		Iterator<Row> rowIterator;

		Row row;
		Cell cell;
		Iterator<Cell> cellIterator;

		rowIterator = sheet.iterator();
		rowIterator.next();

		while (rowIterator.hasNext()) {

			row = rowIterator.next();
			cellIterator = row.cellIterator();
			Method method = new Method();

			while (cellIterator.hasNext()) {
				cell = cellIterator.next();

				switch (cell.getColumnIndex()) {
				case 0:
					method.MethodID = (int) cell.getNumericCellValue();
					break;

				case 1:
					method.packageName = cell.getStringCellValue();
					break;

				case 2:
					method.className = cell.getStringCellValue();
					break;

				case 3:
					method.methodName = cell.getStringCellValue();
					break;

				case 4:
					method.loc = (int) cell.getNumericCellValue();
					break;

				case 5:
					method.cyclo = (int) cell.getNumericCellValue();
					break;

				case 6:
					method.atfd = (int) cell.getNumericCellValue();
					break;

				case 7:
					if (cell.getCellType() == CellType.NUMERIC) 
						method.laa = cell.getNumericCellValue();
					else 
						method.laa = Double.parseDouble(cell.getStringCellValue());
					break;

				case 8:
					method.is_long_method = cell.getBooleanCellValue();
					break;

				case 9:
					method.iplasma = cell.getBooleanCellValue();
					break;
				case 10:
					method.pmd = cell.getBooleanCellValue();
					break;
				case 11:
					method.is_feature_envy = cell.getBooleanCellValue();
					break;
				default:
					break;
				}
			}

			allMethods.add(method);

			workbook.close();
			fis.close();
		}
		return this.allMethods;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ReadFromFile read = new ReadFromFile();
		try {
			read.read("Long-Method.xlsx", 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
