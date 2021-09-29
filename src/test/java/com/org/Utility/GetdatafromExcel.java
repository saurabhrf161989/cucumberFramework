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

public class GetdatafromExcel {
	 private static String s = "DataSheet1";
	 
	 static String projDir=System.getProperty("user.dir");
	 private static String s1 = projDir + "\\TestData\\test data.xlsx";
		
		
	 private static Map<String, String> map = new HashMap<String, String>();

	 public static String getVal(String testcasename,String columnname) throws IOException {
	 FileInputStream fis;
	 int k =0;
	 try {
	 fis = new FileInputStream(s1);
	 XSSFWorkbook wb = new XSSFWorkbook(fis);
	 wb.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);
	 XSSFSheet ws = wb.getSheet(s);
	 int rows = ws.getPhysicalNumberOfRows();
	 
	 for(int i=0;i<rows;i++){
		 
	 int cols = ws.getRow(0).getPhysicalNumberOfCells();
	 for (int j = 0; j < cols; j++) { 
		 
	 if(ws.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase(columnname))
	 { 
	 k=j;
	 }
	 map.put(ws.getRow(i).getCell(0).getStringCellValue(),ws.getRow(i).getCell(k).getStringCellValue()); 
	 }
	 } 
	 }catch (Exception e){e.printStackTrace(); } 
	 return map.get(testcasename);
	 } 
	}