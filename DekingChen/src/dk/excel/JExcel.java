/**
 * 
 */
package dk.excel;

import java.io.File;
import java.io.IOException;

import dk.main.Show;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @author Administrator
 *
 */
public class JExcel extends Show{
	
	public static String  file_path = "F:\\WorkPlace\\file\\index.xls";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		readExcel();
		
	}
	//读取Excel文件(97-2003)
	public static void readExcel(){
		try {
			Workbook workbook = Workbook.getWorkbook(new File(file_path));
			Sheet sheet = workbook.getSheet(0);
			for(int i=0;i<sheet.getRows();i++){
				for(int j=0;j<sheet.getColumns();j++){
					Cell cell = sheet.getCell(j,i);
					show(cell.getContents()+" ");
				}
				show("\t\n");
			}
			workbook.close();
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
			
	}
	//写入Excel文件(97-2003)
	public static void writeExcel(){
		String[] title ={"ID","Name","Sex"};
		File file = new File (file_path);	
		try {
		file.createNewFile();
		WritableWorkbook workbook =  Workbook.createWorkbook(file);
		WritableSheet sheet = workbook.createSheet("sheet1",0);
		Label label = null;
		for(int i=0;i<title.length;i++){
			label = new Label(i,0,title[i]);
			sheet.addCell(label);
		}
		for(int i =1; i<10;i++){
			label = new Label(0,i,"a"+i);
			sheet.addCell(label);
			label = new Label(1,i,"user"+i);
			sheet.addCell(label);
			label = new Label(2,i,"Boy");
			sheet.addCell(label);
		}
		workbook.write();
		workbook.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
