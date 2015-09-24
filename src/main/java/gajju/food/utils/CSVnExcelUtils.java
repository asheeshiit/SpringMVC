package gajju.food.utils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

public class CSVnExcelUtils {

	public static Sheet getExcelSheet(String filePath) {
		Sheet sheet=null;
		try{
			File inputWorkbook = new File(filePath);
			Workbook w= Workbook.getWorkbook(inputWorkbook);;
			sheet = w.getSheet(0);
			
		}catch(Exception e){
			System.out.println("exception: "+e);
		}
		return sheet;
	}
	
	public static Sheet getExcelSheet(String filePath ,int sheetno) {
		Sheet sheet=null;
		try{
			File inputWorkbook = new File(filePath);
			Workbook w= Workbook.getWorkbook(inputWorkbook);;
			sheet = w.getSheet(sheetno);
			
		}catch(Exception e){
			System.out.println("exception: "+e);
		}
		return sheet;
	}
	
	public static List<String> getCSVFile(String filePath) {
		List<String> lines = null;
		try{
		    File file = new File(filePath);
		    lines = Files.readAllLines(file.toPath(),StandardCharsets.UTF_8);
		}catch(Exception e){
			System.out.println("exception: "+e);
		}
		return lines;
	}
}
