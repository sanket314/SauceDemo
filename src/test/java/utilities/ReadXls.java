package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXls {
	
	public static Map <String, String> getRowdata(String filepath, String sheetname ,int rownum) throws IOException {
		
		Map<String,String> rowdata = new HashMap();
		
		try(FileInputStream fis = new FileInputStream ("/Users/apple/eclipse-workspace/PracticeProject/src/test/resources/testdata/TestdataDemo.xlsx")){
			Workbook workbook = WorkbookFactory.create(fis);
			
			Sheet sheet = workbook.getSheet(sheetname);
			
			if(sheet==null) {
				throw new IllegalArgumentException();
			}
			Row headerRow =sheet.getRow(0);
			Row dataRow =sheet.getRow(rownum);
			
			for(int i=0;i<headerRow.getLastCellNum();i++) {
				Cell headerCell = headerRow.getCell(i);
				if(headerCell==null)
					continue;
				Cell dataCell = dataRow.getCell(i);
				
				String key = headerCell.toString();
				
				String value;
				
				if(dataCell!=null) {
					value=dataCell.toString();
				}
				else {
					value="";
				}
			
			rowdata.put(key, value);	
		}
			
			
	} catch (FileNotFoundException e) {
			e.printStackTrace();
	
	}
	
	return rowdata;
	
	}
}
