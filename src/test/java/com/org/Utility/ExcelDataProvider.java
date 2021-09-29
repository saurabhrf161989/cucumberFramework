package com.org.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;




public class ExcelDataProvider {

	static String projDir=System.getProperty("user.dir");
	private static String Excelfile=projDir + "\\TestData\\input.xlsx";
	
	
	 public  static String readCell(Integer row, Integer column,Integer sheetNo) throws IOException  {

		 File src= new File(Excelfile);
			FileInputStream fis= new FileInputStream(src);
			
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			
  
           XSSFSheet sheet= wb.getSheetAt(sheetNo);
            int r = sheet.getLastRowNum();
            
            String element= sheet.getRow(row).getCell(column).getStringCellValue();
            
              wb.close();
             return element;
	 }
	 
	
	 
	 
	
	 
	 public static String readCell2(Integer row, Integer column,Integer sheetNo) throws Exception{

		 File src= new File(Excelfile);
			FileInputStream fis= new FileInputStream(src);
			
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			
  
           XSSFSheet sheet= wb.getSheetAt(sheetNo);
            int r = sheet.getLastRowNum();
            
            DataFormatter objDefaultFormat = new DataFormatter();  
            FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) wb);   
            
            Cell str=sheet.getRow(row).getCell(column);
            objFormulaEvaluator.evaluate(str);
            String cellValueStr = objDefaultFormat.formatCellValue(str,objFormulaEvaluator);
            String element2=cellValueStr;
              wb.close();
             return element2;
                  
            
	 }
	 
	 
	 public static void writeCell(Integer row, Integer column,Integer sheetNo,String data) throws Exception{
		    File src= new File(Excelfile);
			FileInputStream fis= new FileInputStream(src);
			
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			

            XSSFSheet sheet= wb.getSheetAt(sheetNo);;
			
            sheet.getRow(row).createCell(column).setCellValue(data);
			
			FileOutputStream fout= new FileOutputStream(src);
			wb.write(fout);
			
			wb.close();		
			
		}
	 
	 public static int rows(Integer sheetNo) throws Exception{
		    File src= new File(Excelfile);
			FileInputStream fis= new FileInputStream(src);
			
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			

         XSSFSheet sheet= wb.getSheetAt(sheetNo);;
			
         
			
			int rows=sheet.getLastRowNum();
			
			wb.close();		
			return rows;
		}
	 public static Row row(Integer sheetNo) throws Exception{
		    File src= new File(Excelfile);
			FileInputStream fis= new FileInputStream(src);
			
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			

      XSSFSheet sheet= wb.getSheetAt(sheetNo);;
			
      
			
			int rows=sheet.getLastRowNum();
			Row row=sheet.getRow(rows);
			wb.close();		
			return row;
		}
	 
	 

            
	 
}
