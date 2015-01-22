package xx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ReadWriteExcel 
{
	public int xRows, xCols;
	
	public String xData[][]; 
	
	public void xlRead(String sPath,int sheet) throws Exception{
		
		File myxl = new File(sPath);
		FileInputStream myStream = new FileInputStream(myxl);
		
		HSSFWorkbook myWB = new HSSFWorkbook(myStream);

		HSSFSheet mySheet = myWB.getSheetAt(sheet);
		xRows = mySheet.getLastRowNum()+1;
		xCols = mySheet.getRow(0).getLastCellNum();
		//xRows = 1000;
		//xCols=20;
	
		xData = new String[xRows][xCols];
       for (int i = 0; i < xRows; i++) {
	           HSSFRow row = mySheet.getRow(i);
	            for (int j = 0; j < xCols; j++) {
	               HSSFCell cell = row.getCell(j); // To read value from each col in each row
	               String value = cellToString(cell);
	               xData[i][j] = value;
	               }
	            
       }}
	            public void xlReadfix(String sPath,int sheet) throws Exception{
	        		
	        		File myxl = new File(sPath);
	        		FileInputStream myStream = new FileInputStream(myxl);
	        		
	        		HSSFWorkbook myWB = new HSSFWorkbook(myStream);

	        		HSSFSheet mySheet = myWB.getSheetAt(sheet);
	        		//xRows = mySheet.getLastRowNum()+1;
	        		//xCols = mySheet.getRow(0).getLastCellNum();
	        		xRows = 1000;
	        		xCols=20;
	        	
	        		xData = new String[xRows][xCols];
	               for (int i = 0; i < xRows; i++) {
	        	           HSSFRow row = mySheet.getRow(i);
	        	            for (int j = 0; j < xCols; j++) {
	        	               HSSFCell cell = row.getCell(j); // To read value from each col in each row
	        	               String value = cellToString(cell);
	        	               xData[i][j] = value;
	        	               }
	        }	
	    }
	
	    public String cellToString(HSSFCell cell) {
		
	        int type = cell.getCellType();
	        Object result;
	        switch (type) {
	            case HSSFCell.CELL_TYPE_NUMERIC: //0
	                result = cell.getNumericCellValue();
	                break;
	            case HSSFCell.CELL_TYPE_STRING: //1
	                result = cell.getStringCellValue();
	                break;
	            case HSSFCell.CELL_TYPE_FORMULA: //2
	                throw new RuntimeException("We can't evaluate formulas in Java");
	            case HSSFCell.CELL_TYPE_BLANK: //3
	                result = "-";
	                break;
	            case HSSFCell.CELL_TYPE_BOOLEAN: //4
	                result = cell.getBooleanCellValue();
	                break;
	            case HSSFCell.CELL_TYPE_ERROR: //5
	                throw new RuntimeException ("This cell has an error");
	            default:
	                throw new RuntimeException("We don't support this cell type: " + type);
	        }
	        return result.toString();
	    }
	    
	    public void xlwrite(String xlPath, String[][] xData2) throws Exception {
			
	    	File outFile = new File(xlPath);
	        HSSFWorkbook wb = new HSSFWorkbook();

	        HSSFSheet osheet = wb.createSheet("TESTRESULTS");
	        
	    	for (int myrow = 0; myrow < xRows; myrow++) {
	    		
		        HSSFRow row = osheet.createRow(myrow);
		        
		        for (int mycol = 0; mycol < xCols; mycol++) {
		        	HSSFCell cell = row.createCell(mycol);
		        	
		        	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		        	
		        	cell.setCellValue(xData2[myrow][mycol]);
		        	
		        }
		        FileOutputStream fOut = new FileOutputStream(outFile);

		        wb.write(fOut);
		        fOut.flush();
		        fOut.close();
	    	}
	    }
	}
	
