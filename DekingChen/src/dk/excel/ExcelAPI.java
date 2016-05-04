package dk.excel;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dk.main.Show;

public class ExcelAPI extends Show {
	public static String  file_path = "F:\\WorkPlace\\file\\index01.xlsx";
	public static void main(String[] args) throws IOException {
		writeExcel();
		//readExcel();
	}
	//读取Excel文件(97-2003)
	/*public static void readExcel() throws IOException{
		File file = new File (file_path);	
		try {
			FileInputStream in = new FileInputStream(file);
			Workbook workbook = new Workbook(in);
			Sheet sheet = workbook.getSheetAt(0);
			int firstrow = 0;
			int lastrow = sheet.getLastRowNum();
			for(int i=firstrow;i<=lastrow;i++){
				Row row = sheet.getRow(i);
				int lastcell = row.getLastCellNum();
				for(int j=0;j<lastcell;j++){
					Cell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					show(value+" ");
				}
				show();
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}*/
	//写入Excel文件(97-2003)
	public static void writeExcel(){
		String[] title ={"ID","Name","Sex"};
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		Cell cell = null;
		for(int i=0;i<title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		for(int j=1;j<=10;j++){
			Row nextrow = sheet.createRow(j);
			Cell nextcell = nextrow.createCell(0);
			nextcell.setCellValue("a"+j);
			nextcell = nextrow.createCell(1);
			nextcell.setCellValue("user"+j);
			nextcell = nextrow.createCell(2);
			nextcell.setCellValue("Boy");
		}
		File file = new File (file_path);	

		try {
			file.createNewFile();
			FileOutputStream stream = new FileOutputStream(file);
			workbook.write(stream);
			workbook.close();
			show("ok");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
