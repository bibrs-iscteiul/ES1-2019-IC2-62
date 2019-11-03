package pt.iul.ista.es.applications;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromFile {

	int rowNumber = 0;
	int colNumber = 0;
	List<Method> allMethods;

	public ReadFromFile() {
		this.allMethods = new ArrayList<Method>();
	}

	public void read(String fileName, String sheetName) throws IOException {

		FileInputStream fis = new FileInputStream(new File(fileName));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> rowIterator;

		Row row;
		Cell cell;
		Iterator<Cell> cellIterator;

		rowIterator = sheet.iterator();
		rowIterator.next();

		while (rowIterator.hasNext()) {

			row = rowIterator.next();
			cellIterator = row.cellIterator();
			// colNumber = 0;
			Method method = new Method();
			System.out.println("linha: " + row.getRowNum());

			while (cellIterator.hasNext()) {

				cell = cellIterator.next();
				String aux;
				// System.out.println("coluna " + cell.getColumnIndex());

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
					// method.laa = (int)cell.getNumericCellValue(); //isto nao funciona
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

				// System.out.println(cell.toString() + ";");

			}
			allMethods.add(method);
			System.out.println("metodo : " + method);

			System.out.println();
			workbook.close();
			fis.close();
		}
	}

	public static void main(String[] args) {
		ReadFromFile read = new ReadFromFile();
		try {
			read.read("Long-Method.xlsx", "long-method");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
