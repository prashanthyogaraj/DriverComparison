package com.java.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


//****adapcontent checks the content of the adapter given as input and stores data in file1_network and file1_sorage
public class adapterContent {
	public static void main(String[] args) throws InterruptedException, IOException {
		adapterContent cmp = new adapterContent();
	//	cmp.setadapterInput2("https://cspg-releng.cisco.com/3rdparty/rack/3.1.2/Drivers/", "https://cspg-releng.cisco.com/3rdparty/rack/2.0.9/Drivers/", "Intel/", "pyogaraj");
 /*		Scanner s = new Scanner(System.in);
		FunctionsExecute execute = new FunctionsExecute();
		System.out.println("Enter the url to compare");
		String url = s.nextLine();
		System.out.println("Enter the Adapter to find");
		String  ad = s.nextLine();
		String name = execute.getCecId();
		// cmp.getAdapteroutput();
		cmp.setadapterInput(url,ad,name); */
	}
	public List setadapterInput2(String url,String url1,String ad,String name) throws InterruptedException, IOException {
		Scanner s = new Scanner(System.in);
		FunctionsExecute execute = new FunctionsExecute();
		adapterContent cmp = new adapterContent();

		ArrayList<String> list = new ArrayList<String>();
	//	System.out.println("Enter the url to compare");
	//	String url = s.nextLine();

		WebDriver driver = execute.getDriver(name);
		driver.get(url1);
		Thread.sleep(20000);
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file2_network.txt");
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file2_storage.txt");
		execute.clearTextfile("C:/Users/"+name+"/Desktop/Discrepency.txt");
		execute.clearTextfile("C:/Users/"+name+"/Desktop/Discrepency_output.txt");
	//	System.out.println("Enter the Adapter to find");
	//	 ad = s.nextLine();

		String[] adapter1 = ad.split(",");

		for (int i = 0; i < adapter1.length; i++) {
			String adapind = adapter1[i];
			if (adapind.contains("lsi")||(adapind.equalsIgnoreCase("lsi"))) {
				String adap = adapind.replace("lsi", "LSI/");
				list.add(adap);
			}
			if (adapind.contains("hgst")||(adapind.equalsIgnoreCase("hgst"))) {
				String adap = adapind.replace("hgst", "HGST/");
				list.add(adap);
			}
			if (adapind.contains("pmcsierra")||(adapind.equalsIgnoreCase("pmcsierra"))) {
				String adap = adapind.replace("pmcsierra", "PMC-Sierra/");
				list.add(adap);
			}
			if (adapind.contains("broadcom")||(adapind.equalsIgnoreCase("broadcom"))) {
				String adap = adapind.replace("broadcom", "Broadcom/");
				list.add(adap);
			}
			if (adapind.contains("emulex")||(adapind.equalsIgnoreCase("emulex"))) {
				String adap = adapind.replace("emulex", "Emulex/");
				list.add(adap);
			}
			if (adapind.contains("qlogic")||(adapind.equalsIgnoreCase("qlogic"))) {
				String adap = adapind.replace("qlogic", "QLogic/");
				list.add(adap);
			}
			if (adapind.contains("cisco")||(adapind.equalsIgnoreCase("cisco"))) {
				String adap = adapind.replace("cisco", "Cisco/");
				list.add(adap);
			}
			if (adapind.contains("intel")||(adapind.equalsIgnoreCase("intel"))) {
				String adap = adapind.replace("intel", "Intel/");
				list.add(adap);
			}
			if (adapind.contains("fusionio")||(adapind.equalsIgnoreCase("fusionio"))) {
				String adap = adapind.replace("fusionio", "FusionIO/");
				list.add(adap);
			}
			else{
				list.add(adapind);
			}

		}
		for (int j = 0; j < list.size(); j++) {
		//	System.out.println("list value is " + list.get(j));
			String adapterind = list.get(j);
		
			cmp.getAdapteroutput2(url,driver, adapterind,name);

		}
		
		return list;

	}
	
//********************************First adapter input*************************
	public List setadapterInput(String url,WebDriver driver,String ad,String name,Map<String, List<String>> url2comb,Map<String,String> secondurl,Map<String,String> key_secondurl) throws InterruptedException, IOException {
		Scanner s = new Scanner(System.in);
		FunctionsExecute execute = new FunctionsExecute();
		adapterContent cmp = new adapterContent();

		ArrayList<String> list = new ArrayList<String>();
	//	System.out.println("Enter the url to compare");
	//	String url = s.nextLine();

	//	WebDriver driver = execute.getDriver();
		driver.get(url);
		Thread.sleep(20000);
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file1_network.txt");
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file1_storage.txt");
	//	System.out.println("Enter the Adapter to find");
	//	 ad = s.nextLine();

		String[] adapter1 = ad.split(",");

		for (int i = 0; i < adapter1.length; i++) {
			String adapind = adapter1[i];
			if (adapind.contains("lsi")||(adapind.equalsIgnoreCase("lsi"))) {
				String adap = adapind.replace("lsi", "LSI/");
				list.add(adap);
			}
			if (adapind.contains("hgst")||(adapind.equalsIgnoreCase("hgst"))) {
				String adap = adapind.replace("hgst", "HGST/");
				list.add(adap);
			}
			if (adapind.contains("pmcsierra")||(adapind.equalsIgnoreCase("pmcsierra"))) {
				String adap = adapind.replace("pmcsierra", "PMC-Sierra/");
				list.add(adap);
			}
			if (adapind.contains("broadcom")||(adapind.equalsIgnoreCase("broadcom"))) {
				String adap = adapind.replace("broadcom", "Broadcom/");
				list.add(adap);
			}
			if (adapind.contains("emulex")||(adapind.equalsIgnoreCase("emulex"))) {
				String adap = adapind.replace("emulex", "Emulex/");
				list.add(adap);
			}
			if (adapind.contains("qlogic")||(adapind.equalsIgnoreCase("qlogic"))) {
				String adap = adapind.replace("qlogic", "QLogic/");
				list.add(adap);
			}
			if (adapind.contains("cisco")||(adapind.equalsIgnoreCase("cisco"))) {
				String adap = adapind.replace("cisco", "Cisco/");
				list.add(adap);
			}
			if (adapind.contains("intel")||(adapind.equalsIgnoreCase("intel"))) {
				String adap = adapind.replace("intel", "Intel/");
				list.add(adap);
			}
			if (adapind.contains("fusionio")||(adapind.equalsIgnoreCase("fusionio"))) {
				String adap = adapind.replace("fusionio", "FusionIO/");
				list.add(adap);
			}
			else{
				list.add(adapind);
			}

		}
		for (int j = 0; j < list.size(); j++) {
		//	System.out.println("list value is " + list.get(j));
			String adapterind = list.get(j);
			
			cmp.getAdapteroutput(driver, adapterind,name,url2comb,secondurl,key_secondurl);
			
		}
		
		
		return list;

	}

	public void getAdapteroutput(WebDriver driver, String adapterind,String name,Map<String, List<String>> url2comb,Map<String,String> secondurl,Map<String,String> key_secondurl) throws InterruptedException, IOException {
		FunctionsExecute execute = new FunctionsExecute();
		adapterContent cmp = new adapterContent();
		FindDiscrepancy disc = new FindDiscrepancy();
		int a = 0;
		Scanner s = new Scanner(System.in);
		String[] os = { "Linux/", "VMware/", "Windows/", "XenServer/" };
//		String[] os = { "Linux/", "VMware/" };
		ArrayList<String> protocol = new ArrayList<String>();
		protocol.add("Network/");
		protocol.add("Storage/");
		if(adapterind.contains("nVidia")){
			protocol.add("Video/");
		}
		Map<String, List<String>> url1comb = new HashMap<String, List<String>>();
		Map<String,String> firsturl = new HashMap<String,String>();
		Map<String,String> key_firsturl = new HashMap<String,String>();
		List<String> mis_folder = new ArrayList<String>();
		List<String> mis_content = new ArrayList<String>();
		List<String> osfolderkey = new ArrayList<String>();
		Map<String, List<String>> folder_mismatch = new HashMap<String, List<String>>();
		Map<String, List<String>> content_mismatch = new HashMap<String, List<String>>();
		// System.out.println("Enter the url to compare");
		// String url = s.nextLine();
		// WebDriver driver = execute.getDriver();
		// driver.get(url);
		// Thread.sleep(15000);
		// System.out.println("Enter the Adapter to find");
		// String adapter = s.nextLine();
		// String[] adapter1 = adapter.split(",");
		// List<String> adapter1 = cmp.setadapterInput();

		// List<String> adapter2 = cmp.setAdapterlist();
	//	String name = execute.getCecId();
		for (int i = 0; i < os.length; i++) {
			System.out.println("os is " + os[i]);
			try {
				driver.findElement(By.linkText(os[i])).click();
			} catch (Exception e) {
				System.out.println("In os catch...");
				os[i] = os[i + 1];
				System.out.println(os[i]);
				driver.findElement(By.linkText(os[i])).click();
			}
			for (int j = 0; j < protocol.size(); j++) {
				a = 0;
				String pro = protocol.get(j);
				System.out.println("protocol is" + pro);
				// driver.findElement(By.linkText(protocol.get(j))).click();

				execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
				// for (int k = 0; k < adapter1.size(); k++) {
				a = 0;
				// String adapterind = adapter1.get(k);
				System.out.println("adapter ind inside " + adapterind);

				try {
					a = 0;
					System.out.println("pro is " + pro);
					driver.findElement(By.linkText(pro)).click();
//					System.out.println(pro + "is clicked ");
					// driver.findElement(By.linkText(adapter1.get(k))).click();
					driver.findElement(By.linkText(adapterind)).click();

				} catch (NoSuchElementException e) {
					a = 1;
					System.out.println(adapterind + "not found and a value is" + a);
				}

				execute.listelements(driver, name);
				List<String> indadap = execute.readfinal(name);
				execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
				if ((a == 0)) {
					for (int l = 0; l < indadap.size(); l++) {
						System.out.println("inside inadap for...");
						if (adapterind.equals("FusionIO/")) {
							System.out.println("inside fio");
							indadap.remove("README.html");

						}
						driver.findElement(By.linkText(indadap.get(l))).click();
						// driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
						execute.listelements(driver, name); // os list
						List<String> otheros = execute.readfinal(name);
						execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
						String ur = driver.getCurrentUrl();
						execute.createFile(ur, pro, name);

						if (os[i] != "Linux/") {
							String othroskey = protocol.get(j)+""+indadap.get(l)+""+os[i];
							List<String> allos = new ArrayList<String>();
							String esurl1 = driver.getCurrentUrl();
						//	System.out.println("inside non linux");
							for (int mn = 0; mn < otheros.size(); mn++) {
								String vmos = otheros.get(mn);
								allos.add(vmos);
							//	System.out.println("vmos is "+vmos);
								execute.createFile(vmos, pro, name);

							}
							url1comb.put(othroskey, allos);
							firsturl.put(othroskey, esurl1);
							key_firsturl.put(esurl1, othroskey);
							List<String> url2all = url2comb.get(othroskey);
							List<String> url1all = url1comb.get(othroskey);
//							List<String> se = url1comb.get(othroskey);
							String url2esx = secondurl.get(othroskey);
							String url1esx = firsturl.get(othroskey);
//							System.out.println("sepos inside is"+se);
							if((url2all != null)){
								System.out.println("oscompare key is"+othroskey);
								
							List<String>folder_otheros = disc.fileCompare(protocol.get(j), url1all, url2all,url1esx,url2esx,key_firsturl,othroskey,name);
							if(!folder_otheros.isEmpty()){
								osfolderkey.add(othroskey);
							}
							mis_folder.addAll(folder_otheros);
							folder_mismatch.put(othroskey, folder_otheros);
								}
						}
						for (int m = 0; m < otheros.size(); m++) {
							String otos = otheros.get(m);
							if(otheros.get(m).contains("README.html")){
								System.out.println("inside readme...");
								driver.findElement(By.linkText(otheros.get(m))).click();
								driver.navigate().back();
								System.out.println("The other os s" + otos);
							}
							
							// element.createFile(otos);
							else{
							driver.findElement(By.linkText(otheros.get(m))).click();
							execute.listelements(driver, name);
							List<String> otheroscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
							String othercontenturl = driver.getCurrentUrl();
							execute.createFile(othercontenturl, pro, name);
							String vm_key = protocol.get(j)+""+indadap.get(l)+""+otheros.get(m);
							url1comb.put(vm_key, otheroscontent);
							firsturl.put(vm_key, othercontenturl);
							key_firsturl.put(othercontenturl, vm_key);
							List<String> esxos = url2comb.get(vm_key);
							List<String> url1esxos = url1comb.get(vm_key);
							String keyurl = firsturl.get(vm_key);
							String secondkeyurl = secondurl.get(vm_key);
							if((secondkeyurl != null)||(esxos != null)){
							//	System.out.println("inside disc of esxi");
									if(os[i]=="Linux/"){
										System.out.println("linux os compare key is"+vm_key);
									List<String>folder_linux=disc.fileCompare(protocol.get(j), url1esxos, esxos,keyurl,secondkeyurl,key_firsturl,vm_key,name);
									mis_folder.addAll(folder_linux);
									if(!folder_linux.isEmpty()){
									osfolderkey.add(vm_key);
									folder_mismatch.put(vm_key, folder_linux);
									}
									}
									else{
										List<String>folder_linux = disc.fileCompare(protocol.get(j), url1esxos, esxos,keyurl,secondkeyurl,key_firsturl,null,name);
										content_mismatch.put(vm_key, folder_linux);
										mis_content.addAll(folder_linux);
									}
								}
							for (int oscont = 0; oscont < otheroscontent.size(); oscont++) {
								String content = otheroscontent.get(oscont);

								execute.createFile(content, pro, name);

							}

							System.out.println("The os folder is " + otheros.get(m));
							if (os[i].equals("Linux/")) {
								// System.out.println("inside linux");
								execute.listelements(driver, name);
								List<String> linos = execute.readfinal(name);
								execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
								// String linurl = driver.getCurrentUrl();
								// element.createFile(linurl);
								System.out.println(driver.getCurrentUrl());
								for (int los = 0; los < linos.size(); los++) {
							
									driver.findElement(By.linkText(linos.get(los))).click();
									execute.listelements(driver, name);
									List<String> oscontent = execute.readfinal(name);
									String lin_key = protocol.get(j)+" "+indadap.get(l)+" "+linos.get(los);
									//	System.out.println("linux key is"+lin_key);
										url1comb.put(lin_key, oscontent);
									//	firsturl.put(lin_key, linurl);
									//	key_firsturl.put(linurl, lin_key);
										String keyurllin = firsturl.get(lin_key);
									//	System.out.println("keyurl is "+keyurllin);
										List<String> linuxos = url1comb.get(lin_key);
										List<String> url2linux = url2comb.get(lin_key);
									//	System.out.println("output is"+linuxos);
										execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
										String contenturl = driver.getCurrentUrl();
									//	System.out.println("content url is"+contenturl);
										firsturl.put(lin_key, contenturl);
										key_firsturl.put(contenturl, lin_key);
										String linconturl = firsturl.get(lin_key);
										String securllin = secondurl.get(lin_key);
										if((url2linux != null)||(securllin != null)){
											System.out.println("lin key inside url of linux is"+vm_key);
											List<String>folder_linux = 	disc.fileCompare(protocol.get(j), linuxos, url2linux, linconturl, securllin,key_firsturl,null,name);
											content_mismatch.put(lin_key, folder_linux);
											mis_content.addAll(folder_linux);
												}
									execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
								//	String contenturl = driver.getCurrentUrl();
											
									execute.createFile(contenturl, pro, name);

									// }
									for (int oscont = 0; oscont < oscontent.size(); oscont++) {
										String content = oscontent.get(oscont);

										execute.createFile(content, pro, name);

									}
//									System.out.println("get out from rhel indos PD goin toclick");

								//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
									driver.navigate().back();
//									System.out.println("get out from rhel indos PD clicked");
								}
							}
							// zero.clearTextfile("C:/Users/"+name+"/Desktop/rohit.txt");
//							System.out.println("going to click PD to get out indos");
						//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
							driver.navigate().back();
						}
						} // indos for
//						System.out.println("going to click PD to get out indadap");
						Thread.sleep(100);
					//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
						driver.navigate().back();
					} // ind adap for ,linux os out
				} // logic if

//				System.out.println("going to click PD to get out ofadapter");

				if (a != 1) {
					System.out.println("inside a ne 1");
					Thread.sleep(100);
				//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
					driver.navigate().back();

//					System.out.println("out of adapter clicked....");
				}

//				System.out.println("Inside the adapter for braces");

				// } // adapter for
//				System.out.println("Inside the adapter for braces");

//				System.out.println("going to click PD to get out of protocol");
				Thread.sleep(100);
			//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
				driver.navigate().back();
		//		System.out.println("protocol back clicked...");

			} // protocol for
		//	System.out.println("going to click PD to get out of os");
			Thread.sleep(100);
		//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
			driver.navigate().back();

		} // os for
		System.out.println("folder_mismatch is"+folder_mismatch);
		System.out.println("content mismatch is"+content_mismatch);
		System.out.println("mis_content is"+mis_content);
		System.out.println("missing folder is"+mis_folder);
		System.out.println("osfolder is"+osfolderkey);
		disc.check(url1comb,url2comb,key_firsturl,key_secondurl,firsturl,secondurl,mis_folder,osfolderkey,folder_mismatch,content_mismatch,mis_content,name);
	}// main for


//second function******************************
	public void getAdapteroutput2(String url1,WebDriver driver, String adapterind,String name) throws InterruptedException, IOException {
		FunctionsExecute execute = new FunctionsExecute();
		adapterContent cmp = new adapterContent();
		int a = 0;
		Scanner s = new Scanner(System.in);
		String[] os = { "Linux/", "VMware/", "Windows/", "XenServer/" };
//		String[] os = {"Linux/", "VMware/" };
		ArrayList<String> protocol = new ArrayList<String>();
		FindDiscrepancy disc = new FindDiscrepancy();
		protocol.add("Network/");
		protocol.add("Storage/");
		if(adapterind.contains("nVidia")){
			protocol.add("Video/");
		}
		Map<String, List<String>> url2comb = new HashMap<String, List<String>>();
		Map<String,String> secondurl = new HashMap<String,String>();
		Map<String,String> key_secondurl = new HashMap<String,String>();
		// System.out.println("Enter the url to compare");
		// String url = s.nextLine();
		// WebDriver driver = execute.getDriver();
		// driver.get(url);
		// Thread.sleep(15000);
		// System.out.println("Enter the Adapter to find");
		// String adapter = s.nextLine();
		// String[] adapter1 = adapter.split(",");
		// List<String> adapter1 = cmp.setadapterInput();

		// List<String> adapter2 = cmp.setAdapterlist();
	//	String name = execute.getCecId();
		for (int i = 0; i < os.length; i++) {
			System.out.println("os is " + os[i]);
			try {
				driver.findElement(By.linkText(os[i])).click();
			} catch (Exception e) {
//				System.out.println("In os catch...");
				os[i] = os[i + 1];
				System.out.println(os[i]);
				driver.findElement(By.linkText(os[i])).click();
			}
			for (int j = 0; j < protocol.size(); j++) {
				a = 0;
				String pro = protocol.get(j);
				System.out.println("protocol is" + pro);
				// driver.findElement(By.linkText(protocol.get(j))).click();

				execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
				// for (int k = 0; k < adapter1.size(); k++) {
				a = 0;
				// String adapterind = adapter1.get(k);
				System.out.println("adapter ind inside " + adapterind);

				try {
					a = 0;
					System.out.println("pro is " + pro);
					driver.findElement(By.linkText(pro)).click();
					System.out.println(pro + "is clicked ");
					// driver.findElement(By.linkText(adapter1.get(k))).click();
					driver.findElement(By.linkText(adapterind)).click();

				} catch (NoSuchElementException e) {
					a = 1;
					System.out.println(adapterind + "not found and a value is" + a);
				}

				execute.listelements(driver, name);
				List<String> indadap = execute.readfinal(name);
				execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
				if ((a == 0)) {
					for (int l = 0; l < indadap.size(); l++) {
						System.out.println("inside inadap for...");
						if (adapterind.equals("FusionIO/")) {
							System.out.println("inside fio");
							indadap.remove("README.html");

						}
						driver.findElement(By.linkText(indadap.get(l))).click();
						// driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
						execute.listelements(driver, name); // os list
						List<String> otheros = execute.readfinal(name);
						execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
						String ur = driver.getCurrentUrl();
						execute.createFile2(ur, pro, name);

						if (os[i] != "Linux/") {
							String othroskey = protocol.get(j)+""+indadap.get(l)+""+os[i];
//							System.out.println("inside non linux");
							System.out.println("inside non linux url is"+driver.getCurrentUrl());
							String esurl = driver.getCurrentUrl();
							List<String> allos = new ArrayList<String>();
							for (int mn = 0; mn < otheros.size(); mn++) {
								String vmos = otheros.get(mn);
						//		System.out.println("vmos is"+vmos);
								execute.createFile2(vmos, pro, name);
								allos.add(vmos);
							}
							secondurl.put(othroskey, esurl);
							key_secondurl.put(esurl, othroskey);
							
							url2comb.put(othroskey, allos);
							List<String> url2all = url2comb.get(othroskey);
						//	List<String> url1all = url1comb.get(othroskey);
						//	System.out.println("url1all is"+url1all);
							System.out.println("url2all is"+url2all);
						
						}
						for (int m = 0; m < otheros.size(); m++) {
							String otos = otheros.get(m);
							if(otheros.get(m).contains("README.html")){
								System.out.println("inside readme...");
								driver.findElement(By.linkText(otheros.get(m))).click();
								driver.navigate().back();
								System.out.println("The other os s" + otos);
							}
							
							// element.createFile(otos);
							else{
							driver.findElement(By.linkText(otheros.get(m))).click();
							execute.listelements(driver, name);
							List<String> otheroscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
							String othercontenturl = driver.getCurrentUrl();
							execute.createFile2(othercontenturl, pro, name);
							String vm_key = protocol.get(j)+""+indadap.get(l)+""+otheros.get(m);
							url2comb.put(vm_key, otheroscontent);
							System.out.println("vmkey is"+vm_key);
							List<String> esxos = url2comb.get(vm_key);
							
							secondurl.put(vm_key, othercontenturl);
							key_secondurl.put(othercontenturl, vm_key);
							String keyurl = secondurl.get(vm_key);
							for (int oscont = 0; oscont < otheroscontent.size(); oscont++) {
								String content = otheroscontent.get(oscont);

								execute.createFile2(content, pro, name);

							}

							System.out.println("The os folder is " + otheros.get(m));
							if (os[i].equals("Linux/")) {
								// System.out.println("inside linux");
								execute.listelements(driver, name);
								List<String> linos = execute.readfinal(name);
								execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
								// String linurl = driver.getCurrentUrl();
								// element.createFile(linurl);
								System.out.println(driver.getCurrentUrl());
								for (int los = 0; los < linos.size(); los++) {
									// String lios = linos.get(los);
									// element.createFile(lios);
									// System.out.println("The os folder is
									// " +
									// linos.get(los));
									driver.findElement(By.linkText(linos.get(los))).click();
									execute.listelements(driver, name);
									List<String> oscontent = execute.readfinal(name);
									String lin_key = protocol.get(j)+" "+indadap.get(l)+" "+linos.get(los);
									url2comb.put(lin_key, oscontent);
									String keyurllin = secondurl.get(lin_key);
									System.out.println("keyurl is "+keyurllin);
							
									List<String> linuxos = url2comb.get(lin_key);
									execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
									execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
									String contenturl = driver.getCurrentUrl();
									secondurl.put(lin_key, contenturl);
									key_secondurl.put(contenturl, lin_key);
									String linconturl = secondurl.get(lin_key);
									execute.createFile2(contenturl, pro, name);

									// }
									for (int oscont = 0; oscont < oscontent.size(); oscont++) {
										String content = oscontent.get(oscont);

										execute.createFile2(content, pro, name);

									}
//									System.out.println("get out from rhel indos PD goin toclick");

								//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
									driver.navigate().back();
//									System.out.println("get out from rhel indos PD clicked");
								}
							}
							// zero.clearTextfile("C:/Users/"+name+"/Desktop/rohit.txt");
//							System.out.println("going to click PD to get out indos");
						//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
							driver.navigate().back();
						}
						} // indos for
//						System.out.println("going to click PD to get out indadap");
						Thread.sleep(100);
					//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
						driver.navigate().back();
					} // ind adap for ,linux os out
				} // logic if

//				System.out.println("going to click PD to get out ofadapter");

				if (a != 1) {
					System.out.println("inside a ne 1");
					Thread.sleep(100);
				//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
					driver.navigate().back();

//					System.out.println("out of adapter clicked....");
				}

//				System.out.println("Inside the adapter for braces");

				// } // adapter for
//				System.out.println("Inside the adapter for braces");

//				System.out.println("going to click PD to get out of protocol");
				Thread.sleep(100);
			//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
				driver.navigate().back();
//				System.out.println("protocol back clicked...");

			} // protocol for
//			System.out.println("going to click PD to get out of os");
			Thread.sleep(100);
		//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
			driver.navigate().back();

		} // os for
		cmp.setadapterInput(url1,driver, adapterind, name,url2comb,secondurl,key_secondurl);
	}// main for

}//class end
// }
