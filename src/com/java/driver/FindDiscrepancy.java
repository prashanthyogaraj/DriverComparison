package com.java.driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

public class FindDiscrepancy {
	public static void main(String[] args) throws IOException {
		FindDiscrepancy disc = new FindDiscrepancy ();
	//	disc.check();

	}

	public List<String> fileCompare(String protocol, List<String> url1comb, List<String> url2comb, String url1, String url2,
			Map<String, String> key_firsturl,String osfolderkey,String name) {
		FindDiscrepancy disc = new FindDiscrepancy ();
		List<String> tmp = new ArrayList<String>(url1comb);
		List<String> folder = new ArrayList<String>();

		if (url1comb.equals(url2comb)) {
			System.out.println("No Discrepancy...");

		} else if (!url1comb.equals(url2comb)) {
			System.out.println("Discrepancy is present...");
			System.out.println("key_first url is"+key_firsturl);
			tmp.removeAll(url2comb);
			for(int a=0;a<tmp.size();a++){
				if(osfolderkey!= null){
					folder.add(tmp.get(a));
				}
				else{
					folder.add(tmp.get(a));
				}
				
			}
		//	System.out.println("folder value is"+folder);
			System.out.println("tmp is" + tmp);

			File file = new File("C:/Users/"+name+"/Desktop/Discrepency.txt");
		//	File file1 = new File("C:/Users/pyogaraj/Desktop/Discrepency_storage.txt");
			File file2 = new File("C:/Users/"+name+"/Desktop/Discrepency_output.txt");
			if (!tmp.isEmpty()) {
				try {
					if (!file.exists()) {
						file.createNewFile();
					}
					BufferedWriter writer = new BufferedWriter(
							new FileWriter("C:/Users/"+name+"/Desktop/Discrepency_output.txt", true));
					
					writer.write(url1);
					// writer.write(url1);
					writer.newLine();
					writer.newLine();
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
					try {
						if (!file2.exists()) {
							file2.createNewFile();
						}
						BufferedWriter writer = new BufferedWriter(
								new FileWriter("C:/Users/"+name+"/Desktop/Discrepency.txt", true));

						writer.write(url1);
						// writer.write(url1);
						writer.newLine();
						writer.newLine();
						writer.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				for (int i = 0; i < tmp.size(); i++) {
				//	System.out.println("Discrepancy is" + tmp.get(i));
					String discrepency = tmp.get(i);
						try {
							if (!file.exists()) {
								file.createNewFile();
							}
							BufferedWriter writer = new BufferedWriter(
									new FileWriter("C:/Users/"+name+"/Desktop/Discrepency.txt", true));

							writer.write(discrepency);
							writer.newLine();
							writer.newLine();
							writer.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
			}

		}
		return folder;
						
	}
	public void check(Map<String,List<String>> url1comb,Map<String,List<String>> url2comb,Map<String,String>key_firsturl,Map<String,String>key_secondurl,Map<String,String>firsturl,Map<String,String>secondurl,List<String> mis_folder,List<String> osfolderkey,Map<String,List<String>> folder_mismatch,Map<String,List<String>> content_mismatch,List<String>mis_content,String name) throws IOException{
		BufferedReader br1 = new BufferedReader(new FileReader("C:/Users/"+name+"/Desktop/Discrepency_output.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("C:/Users/"+name+"/Desktop/Discrepency.txt"));
		String line1;
		String line2;
		FindDiscrepancy disc = new FindDiscrepancy();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> keylist = new ArrayList<String>();
		List<Integer> getrowid = new ArrayList<Integer>();
		
		while ((line1 = br1.readLine()) != null) {

			list1.add(line1);
			list1.remove("");

		}
		while ((line2 = br2.readLine()) != null) {

			list2.add(line2);
			list2.remove("");

		}
		for(int i=0;i<list1.size();i++){
		//	System.out.println("list1 is"+list1.get(i));
			String tmp = list1.get(i);
		//	System.out.println("before adding list "+key_firsturl.get(tmp));
			keylist.add(key_firsturl.get(tmp));
			
			
		}

		FileOutputStream out = new FileOutputStream("C:/Users/"+name+"/Desktop/output.xls");
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFSheet sheet1 = wb.createSheet();
		CellStyle style = wb.createCellStyle();
		Row row = null;
		
		Cell cell = null;
	
		// set the sheet name
		wb.setSheetName(0, "Summary");
		wb.setSheetName(1, "Discrepency Output");
		
		row = sheet.createRow(10);
		cell = row.createCell(8);
		cell.setCellValue("No.of os folder Missing is ");
		cell = row.createCell(10);
		cell.setCellValue(mis_folder.size());
		
		row = sheet.createRow(11);
		cell = row.createCell(8);
		cell.setCellValue("No.of content Mismatch is ");
		cell = row.createCell(10);
		cell.setCellValue(mis_content.size());
		
		int rowid = 0;
		int rowid1 = 0;
		
			for(int j=0;j<keylist.size();j++){
		
		//	System.out.println("inside keylist.....");
		//	System.out.println("key list is"+keylist.get(j));
			List<String> url1data = url1comb.get(keylist.get(j));
			List<String> url2data = url2comb.get(keylist.get(j));
		//	System.out.println("url1comb is"+url1data);
		//	System.out.println("url2comb is"+url2data);
				int list1_size = url1data.size();
			    int list2_size = url2data.size();
			
			int var1 = 0;
			int var2 =0;
			if(list1_size>list2_size){
				var1 = list1_size-list2_size;
//				System.out.println("list1 is greater so size is"+var1);
				
			}
			if(list2_size>list1_size){
				var2 = list2_size-list1_size;
//				System.out.println("list2 is greater so size is"+var2);
			}
		
			
			String ur1 = firsturl.get(keylist.get(j));
			sheet1.addMergedRegion(new CellRangeAddress(rowid, rowid, 0, 8));
			row = sheet1.createRow(rowid++);
			int cellid = 0;
			cell = row.createCell(cellid++);
			cell.setCellValue(ur1);
			for(int k=0;k<url1data.size();k++){
				
					
				sheet1.addMergedRegion(new CellRangeAddress(rowid, rowid, 0, 8));
//				System.out.println("rowid is "+rowid);
				String data1 = url1data.get(k);
			//	System.out.println("cell value is"+cell.getStringCellValue());
				List<String> osmissing = folder_mismatch.get(keylist.get(j));
				List<String> contentmissing = content_mismatch.get(keylist.get(j));
				if(osmissing != null){
				for(int z=0;z<osmissing.size();z++){
					if(osmissing.get(z).equals(data1)){
				
						getrowid.add(rowid);
					//	System.out.println("rowid inside data find is "+rowid);
					}
				  }
				}
				
			//	System.out.println("data1 is"+data1);
				row = sheet1.createRow(rowid++);
				 cellid = 0;
				cell = row.createCell(cellid++);
				
				cell.setCellValue(data1);
//				System.out.println("cell value after written is"+cell.getStringCellValue());
				if((osmissing != null) ){
				for(String osmiss :osmissing){
					if(data1.equals(osmiss)){
						style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
						style.setFillPattern(CellStyle.BORDER_THIN);
						cell.setCellStyle(style);
					}
				}
				}
				if((contentmissing != null)){
				for(String contmiss :contentmissing){
					if(data1.equals(contmiss)){
						style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
						style.setFillPattern(CellStyle.BORDER_THIN);
						cell.setCellStyle(style);
					}
				}
				}
			}
			
		//	sheet1.addMergedRegion(new CellRangeAddress(rowid, rowid, 0, 8));
//			System.out.println("rowid is"+rowid);
//			if(var2!=0){
//			for(int q=0;q<var2;q++){
//				System.out.println("var inside if for is"+var2);
//				rowid = rowid+1;
//				System.out.println("after increasing rowid is"+rowid);
//				
//						
//			}
//			}
			System.out.println("key list is"+keylist.get(j));
		//	rowid = rowid+var2;
			
			
			String ur2 = secondurl.get(keylist.get(j));
			row = sheet1.getRow(rowid1++);
			int cellid1 = 13;
			cell = row.createCell(cellid1++);
			cell.setCellValue(ur2);
		
			for(int m=0;m<url2data.size();m++){
				
			//	System.out.println("rowid1 inside data writing is"+rowid1);
				sheet1.addMergedRegion(new CellRangeAddress(rowid1, rowid1, 13, 20));
				
				//sheet.addMergedRegion(new CellRangeAddress(rowid, rowid, 13, 20));
			//	System.out.println("inside url2 data");
				String data2 = url2data.get(m);
				
				try{
			
//				System.out.println("rowid1 is"+rowid1);	
//				System.out.println("cell value is"+cell.getStringCellValue());
				for(int t=0;t<getrowid.size();t++){	
				if(rowid1==getrowid.get(t)){
					rowid1 = rowid1+1;
				}
				}	
				if(rowid1<rowid){
				row = sheet1.getRow(rowid1++);
				}
				
				else{
//					System.out.println("insde else");
					row = sheet1.createRow(rowid1++);
				}
					
				
				//	System.out.println("inside try after rowid1++ is"+rowid1);
				 cellid1 = 13;
				cell = row.createCell(cellid1++);
			  //  cell.setCellValue(data2);
				}catch(Exception e){
				//	System.out.println("rowid1 inside catch is"+rowid1);
					row = sheet1.createRow(rowid1);
					
				//	continue;
				}
			//	cell = row.createCell(cellid1);
				cell.setCellValue(data2);
			
				//cell.setCellValue(data2);
			}
		//	sheet1.addMergedRegion(new CellRangeAddress(rowid1, rowid1, 13, 20));
		
//				rowid = rowid+var2;
		
		//	System.out.println("var before increasing rowid1 is"+var1); 
//			rowid1 = rowid1+var1;
			if(rowid>rowid1){
				System.out.println("rowid is greater");
				rowid1 = rowid;
			}
			else if(rowid1>rowid){
				System.out.println("rowid1 is greater");
				rowid = rowid1;
			}
			else{
				System.out.println("Both are same");
				continue;
			}
			System.out.println("rowid is"+rowid);
			System.out.println("rowid1 is"+rowid1);
					
		//	System.out.println("url1comb is"+url1data);
		//	System.out.println("url2comb is"+url2data);
		 
	}
		wb.write(out);
		out.close();
		System.out.println("outside keylist...."); 
	}
//	}
	
}
