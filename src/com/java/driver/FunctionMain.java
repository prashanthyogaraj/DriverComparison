package com.java.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



//Function main class collects all the input from Discrepency Controller and Depends on the test case it will call the backend code class files

public class FunctionMain {
	public static void main(String[] args) throws IOException, InterruptedException {
		FunctionsExecute exec = new FunctionsExecute();
		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the input");
//		String ip = s.nextLine();
//		System.out.println("Enter the URL1");
//		String url1 = s.nextLine();
//		System.out.println("Enter the URL2");
//		String url2 = s.nextLine();
//		System.out.println("Enter the cec id");
//		String cec = s.nextLine();
//	while (true) {
//			System.out.println("Select the input");
//			System.out.println("1.VDS and Other VDS Link Comparison");
//			System.out.println("2.VDS and DriverIso Comparison");
//			System.out.println("3.SingleOS Comarison");
//			System.out.println("4.ClearAll Text File");
//			System.out.println("5.Exit");
//			int ch = s.nextInt();
//			while ((ch < 1 )||(ch > 5)) {
//				System.out.println("Invalid Input");
//				System.out.println("Select the input");
//				System.out.println("1.VDS and Other VDS Link Comparison");
//				System.out.println("2.VDS and DriverIso Comparison");
//				System.out.println("3.SingleOS Comarison");
//				System.out.println("4.ClearAll Text File");
//				System.out.println("5.Exit");
//				 ch = s.nextInt();
//			}
//			switch (ch) {
//			
//			case 1:
//				FunctionsExecute execute = new FunctionsExecute();
//				ThirdpartyAll all = new ThirdpartyAll();
//				String name = all.getOutput();
//				ThirpartyAll2 all2 = new ThirpartyAll2();
//				all2.getOutput();
//				 CompareFile file = new CompareFile();
//				 file.fileCompare(name);
//				break;
//			case 2:
//				ThirdpartyAll alldriver = new ThirdpartyAll();
//				String name1 =	alldriver.getOutput();
//				DriverIsoAll driv = new DriverIsoAll();
//				driv.getDriverIsoOutput();
//				 CompareFile file1 = new CompareFile();
//				 file1.DriverFileCompare(name1);
//				break;
//			case 3:
//				IndividualOs os = new IndividualOs();
//			    String n = os.startIndOs();
//				IndividualOs2 os2 = new IndividualOs2();
//				os2.startIndOs();
//				CompareFile f = new CompareFile();
//				f.fileCompare(n);
//				break;
//			case 4 :
//				FunctionsExecute execut = new FunctionsExecute();
//				System.out.println("Enter your CEC ID");
//				s.nextLine();
//				String id= s.nextLine();
//				execut.clearAllTextFile(id);
//				break;
//			case 5:
//				System.exit(0);
//			}
//		}
	}
	public void getResult(String inp1,String url1,String url2,String cec) throws InterruptedException, IOException{
	
		 
		if(inp1.equals("VDS to VDS")){
		FunctionsExecute execute = new FunctionsExecute();
			VdsSep all = new VdsSep();
			all.getOutput2(url2, url1, cec);				
			 
		
		}
		else if(inp1.equals("VDS to DriverRepo")){
			System.out.println("VDS to DriverRepo");
			if(url1.contains("vic")){
		//	ThirdpartyAll all = new ThirdpartyAll();
				System.out.println("Vic is dere in url1");
				DriverIsoVic vi = new DriverIsoVic();
				vi.getDriverIsoOutput(url2, url1, cec);
			//	se.getOutput(url1, url2, cec);	
			
			}
			else if(url2.contains("vic")){
				//VdsSep vd =  new VdsSep();
				System.out.println("Vic is dere in url2");
				DriverIsoVic2 vic2 =  new DriverIsoVic2();
				vic2.getOutput2(url2, url1, cec);
			
				
				
			}
			else{
				System.out.println("3rd party is dere...");
				VdsToDriver driv =  new VdsToDriver();
				driv.getDriverIsoOutput1(url2, url1, cec);
			//	se.getOutput(url1, url2, cec);	
				
			}
		}
		else if(inp1.equals("DriverRepo to DriverRepo")){
			DriverRepoSep  all = new DriverRepoSep ();
			all.getDriverIsoOutput1(url2, url1, cec);
		//	all.getDriverIsoOutput(url1, url2, cec);
		
		}	
		
	
	}
	public void getIndosResult(String inp,String url1,String url2,String newsel,String newtext,String name) throws IOException, InterruptedException{
		System.out.println("..."+newsel+".."+newtext);
		System.out.println("inisde individual oscompare");
//		WriteContent wrcont = new  WriteContent();
//		WriteExcel2 vdsexcel = new WriteExcel2();
//		ReadDiscrepencyContent content = new ReadDiscrepencyContent();
		IndividualOs os = new IndividualOs();
		os.startIndOs2(newsel, url1, url2, newtext, name);
//		 os.startIndOs(newsel, url1, url2, newtext, name);
//		 CompareFile file = new CompareFile();
//		 file.fileCompare(name);
//		 content.getContent2();
//		 wrcont.VdsRemovehttp();
//		 vdsexcel.exe();
		 
	}
	public void getindos(String inp,String url,String newsel,String newtext,String name) throws IOException, InterruptedException{
//		IndividualOs os = new IndividualOs();
//		System.out.println("inisde individual os");
//		os.startIndOs(newsel, url, url, newtext, name);
		
	
	}
	public void clearText(String inp,String cec) throws FileNotFoundException{
		FunctionsExecute execute = new FunctionsExecute();
		execute.clearAllTextFile(cec);
	}
	public void getIndAdapterdetail(String url,String url1,String adaptername,String cec) throws InterruptedException, IOException{
		adapterContent cmp = new adapterContent();
		cmp.setadapterInput2(url, url1, adaptername, cec);
//		WriteExcel2 vdsexcel = new WriteExcel2();
//		ReadDiscrepencyContent content = new ReadDiscrepencyContent();
//		CompareFile file = new CompareFile();
//		 WriteContent wrcont = new  WriteContent();
//		cmp.setadapterInput(url, url1,adaptername, cec);
//		 file.fileCompare(cec);	
//		 content.getContent2();
//		 wrcont.VdsRemovehttp();
//		 vdsexcel.exe();
		
	}
	}
//}