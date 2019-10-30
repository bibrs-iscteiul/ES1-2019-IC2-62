package pt.iul.ista.es.applications;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromFile {
	
//	int rowNumber = 0;
	int colNumber = 0;
	
	public void read (String fileName, String sheetName) throws IOException {

		FileInputStream fis = new FileInputStream(new File(fileName));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);	
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> rowIterator;
		
		Row row;
		Cell cell;
		Iterator<Cell> cellIterator;
		
		rowIterator = sheet.iterator();
		
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			cellIterator = row.cellIterator();
			colNumber = 0;
			
			while(cellIterator.hasNext()) {
				cell = cellIterator.next();
				System.out.println(cell.toString() + ";");
			}
			
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
