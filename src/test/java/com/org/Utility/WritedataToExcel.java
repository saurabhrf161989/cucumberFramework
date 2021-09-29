package com.org.Utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WritedataToExcel {
	 private static String s = "DataSheet1";
	 static String projDir=System.getProperty("user.dir");
	 private static String s1 = projDir + "\\TestData\\test data.xlsx";
	 
	 public static void setVal(String testcasename,String groupordernumber,String jessionidmbt ) throws IOException {
	 FileInputStream fis;
	 int k =0;
	 
	 fis = new FileInputStream(s1);
	 XSSFWorkbook wb = new XSSFWorkbook(fis);
	 wb.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);
	 XSSFSheet ws = wb.getSheet(s);
	 int rows = ws.getPhysicalNumberOfRows();
	 
	 for(int i=0;i<rows;i++){
		
		String testCase=ws.getRow(i).getCell(0).getStringCellValue();
	 
		if(testCase.equalsIgnoreCase(testcasename)){
			
			 ws.getRow(i).createCell(4).setCellValue(groupordernumber);
			 ws.getRow(i).createCell(5).setCellValue(jessionidmbt);
			 FileOutputStream fout= new FileOutputStream(s1);
				wb.write(fout);
				
				wb.close();		
				
			 break;
		}
	 } 
	}
	 }
	 

