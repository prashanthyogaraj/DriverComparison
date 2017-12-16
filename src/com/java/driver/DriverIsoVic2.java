package com.java.driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriverIsoVic2 {
	public static void main(String[] args) throws InterruptedException, IOException{
		
		DriverIsoVic2 vic2 = new DriverIsoVic2();
		vic2.getOutput2("https://cspg-releng.cisco.com/vic/rack/2.0.9/Drivers/", "http://10.126.141.53/SET/DRV/UCS-C-Series/eng/ucs-cxxx-drivers-combo.3.1.1.10/Drivers/", "pyogaraj");
	//	vic2.getDriverIsoOutput("", driver, "pyogaraj", "", secondurl, key_secondurl);
	}
	public void getOutput2(String url,String url1,String name) throws InterruptedException, IOException {
		FunctionsExecute execute = new FunctionsExecute();
		FindDiscrepancy disc = new FindDiscrepancy();
		DriverIsoVic2 all = new DriverIsoVic2();
		// dayZero zero = new dayZero();
		Scanner s = new Scanner(System.in);
		String[] os = { "Linux/", "VMware/", "Windows/", "XenServer/" };
//		String[] os = {  "XenServer/" };
		String[] protocol = { "Network/", "Storage/" };
//		String[] protocol = { "Storage/" };
		Map<String, List<String>> url2comb = new HashMap<String, List<String>>();
		Map<String,String> secondurl = new HashMap<String,String>();
		Map<String,String> key_secondurl = new HashMap<String,String>();
		System.out.println("Enter the url to compare");
		// String url = s.nextLine();
		WebDriver driver = execute.getDriver(name);
		// WebDriver driver = element.getDriver();

		driver.get(url);
		Thread.sleep(20000);
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file2_network.txt");
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file2_storage.txt");
		execute.clearTextfile("C:/Users/"+name+"/Desktop/Discrepency.txt");
		execute.clearTextfile("C:/Users/"+name+"/Desktop/Discrepency_output.txt");
		for (int i = 0; i < os.length; i++) {
			try {
				driver.findElement(By.linkText(os[i])).click();
			} catch (Exception e) {
				os[i] = os[i + 1];
				System.out.println(os[i]);
				driver.findElement(By.linkText(os[i])).click();
			}
			System.out.println("protocol length is" + protocol.length);
			for (int j = 0; j < protocol.length; j++) {
				String pro = protocol[j];
				driver.findElement(By.linkText(protocol[j])).click();
				execute.listelements(driver, name);
				List<String> adap = execute.readfinal(name);
				// List<String> adap = zero.readfinal();
				execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
				for (int k = 0; k < adap.size(); k++) {
					// System.out.println("in main" + adap.get(k));
					driver.findElement(By.linkText(adap.get(k))).click();
					execute.listelements(driver, name);
					List<String> indadap = execute.readfinal(name);
					execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
					for (int l = 0; l < indadap.size(); l++) {
						if (adap.get(k).equals("FusionIO/")) {
							System.out.println("inside fio");
							indadap.remove("README.html");

						}
						driver.findElement(By.linkText(indadap.get(l))).click();
						execute.listelements(driver, name); // os list
						List<String> otheros = execute.readfinal(name);
						execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
						String ur = driver.getCurrentUrl();
						execute.createFile2(ur, pro, name);
						
						if (os[i] != "Linux/") {
							String othroskey = protocol[j]+""+indadap.get(l)+""+os[i];
							System.out.println("inside non linux");
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
//							if((url1all != null)){
//							disc.fileCompare(protocol[j], url1all, url2all, "", "");
//							}
						}
							
						System.out.println(driver.getCurrentUrl());
						for (int m = 0; m < otheros.size(); m++) {
							String otos = otheros.get(m);
							System.out.println("The other os s" + otos);
							// element.createFile(otos);
							driver.findElement(By.linkText(otheros.get(m))).click();
							execute.listelements(driver, name);
							List<String> otheroscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
							String othercontenturl = driver.getCurrentUrl();
							System.out.println("other content of url2 is"+othercontenturl);
							execute.createFile2(othercontenturl, pro, name);
							String vm_key = protocol[j]+""+indadap.get(l)+""+otheros.get(m);
							url2comb.put(vm_key, otheroscontent);
							System.out.println("vmkey is"+vm_key);
							List<String> esxos = url2comb.get(vm_key);
							
							secondurl.put(vm_key, othercontenturl);
							key_secondurl.put(othercontenturl, vm_key);
				//			List<String> url1esxos = url1comb.get(vm_key);
							String keyurl = secondurl.get(vm_key);
				//			String seckey = firsturl.get(vm_key); 
							
					//		System.out.println("keyurl is "+keyurl);
					//		System.out.println("keyurl is "+seckey);
					//		if((seckey != null)||(url1esxos != null)){
					//		disc.fileCompare(protocol[j], url1esxos, esxos, seckey, keyurl);
					//		}
						//	System.out.println("output of other os is"+esxos);
						//	System.out.println("output of url1 other os is"+url1esxos);
						
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
								 String linurl = driver.getCurrentUrl();
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
									String lin_key = protocol[j]+" "+indadap.get(l)+" "+linos.get(los);
								//	System.out.println("linux key is"+lin_key);
									url2comb.put(lin_key, oscontent);
								//	secondurl.put(lin_key, linurl);
								//	key_secondurl.put(linurl, lin_key);
									String keyurllin = secondurl.get(lin_key);
							//		String securllin = firsturl.get(lin_key);
									System.out.println("keyurl is "+keyurllin);
							//		System.out.println("seec lin is"+securllin);
							//		List<String> url1linux = url1comb.get(lin_key);
									List<String> linuxos = url2comb.get(lin_key);
								//	System.out.println("output of url2 is "+linuxos);
								//	System.out.println("output of url1 is"+url1linux);
									execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
									String contenturl = driver.getCurrentUrl();
									secondurl.put(lin_key, contenturl);
									key_secondurl.put(contenturl, lin_key);
									String linconturl = secondurl.get(lin_key);
							//		String seclincon = firsturl.get(lin_key);
							//		if((url1linux != null)||(seclincon != null)){
							//		disc.fileCompare(protocol[j], url1linux, linuxos, seclincon, linconturl);
							//		}
								//	System.out.println("keyurl is "+linconturl);
								//	System.out.println("keyurl is "+seclincon);
									execute.createFile2(contenturl, pro, name);

									// }
									for (int oscont = 0; oscont < oscontent.size(); oscont++) {
										String content = oscontent.get(oscont);

										execute.createFile2(content, pro, name);

									}
//									driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
									driver.navigate().back();
								}
							}
							// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
//							driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
							driver.navigate().back();
						} // indos for
							// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
//						driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
						driver.navigate().back();
					} // indadap for
						// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
//					driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
					driver.navigate().back();
				} // adap for
					// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
//				driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
				driver.navigate().back();
			} // protocol for end
//			driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
			driver.navigate().back();
		} // os for end
	//	all.getOutput(url1,driver, name,url2comb,secondurl,key_secondurl);
		all.getDriverIsoOutput(url1,driver, name,url2comb,secondurl,key_secondurl);
		
	}
	public void getDriverIsoOutput(String url,WebDriver driver,String name,Map<String,List<String>> url2comb, Map<String,String>secondurl,Map<String,String>key_secondurl) throws InterruptedException, IOException {
		System.out.println("insiedeeee............");
		FunctionsExecute execute = new FunctionsExecute();
//		DriverRepoSep  over = new DriverRepoSep ();
		FindDiscrepancy disc = new FindDiscrepancy();
		Scanner s = new Scanner(System.in);
		String[] os = { "Linux/", "VMware/", "Windows/", "XenServer/" };
//		String[] os = {  "Windows/","XenServer/"};
		String[] protocol = { "Network/", "Storage/" };
		List<String> adap = new ArrayList<String>();
		List<String> indadap = new ArrayList<String>();
		adap.add("Cisco/");
		indadap.add("VIC/");
		System.out.println("adap is"+adap);
		System.out.println("indadap is"+indadap);
		Map<String, List<String>> url1comb = new HashMap<String, List<String>>();
		Map<String,String> firsturl = new HashMap<String,String>();
		Map<String,String> key_firsturl = new HashMap<String,String>();
		List<String> mis_folder = new ArrayList<String>();
		List<String> osfolderkey = new ArrayList<String>();
		List<String> mis_content = new ArrayList<String>();
		Map<String, List<String>> folder_mismatch = new HashMap<String, List<String>>();
		Map<String, List<String>> content_mismatch = new HashMap<String, List<String>>();
		System.out.println("Enter the Url");
		// String drurl = s.nextLine();
		
	//	WebDriver driver = execute.getDriver();
		driver.get(url);
		Thread.sleep(2000);
		// driver.get("file:/10.126.141.46/DriverFirmwareInventory/Driver_ISO_Extracted/EPMR12/ucs-cxxx-drivers-combo.2.0.13.20/Drivers/");
		// System.out.println("Enter ur CecId");
		// String name = s.nextLine();
		// String name = execute.getCecId();
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file1_driverIso_network.txt");
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file1_driverIso_Storage.txt");
		for (int i = 0; i < os.length; i++) {
			driver.findElement(By.linkText(os[i])).click();
			System.out.println("protocol length is" + protocol.length);
			for (int j = 0; j < protocol.length; j++) {
				String pro = protocol[j];
				driver.findElement(By.linkText(protocol[j])).click();
		//		execute.listdriverIsoelements(driver, name);
		//		List<String> adap = execute.driverIsoReadFinal(name);
				execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
				for (int k = 0; k < adap.size(); k++) {
					System.out.println("in main" + adap.get(k));
//					if(adap.get(k).equals("Cisco/")){
//						adap.remove("Cisco/");
//					}

					driver.findElement(By.linkText(adap.get(k))).click();

					execute.listdriverIsoelements(driver, name);
			//		List<String> indadap = execute.driverIsoReadFinal(name);

					execute.clearTextfile("C:/Users/pyogaraj/Desktop/tmp_file.txt");
					for (int l = 0; l < indadap.size(); l++) {
						if (adap.get(k).equals("FusionIO/")) {
							System.out.println("inside fio");
							indadap.remove("README.html");

						}
						driver.findElement(By.linkText(indadap.get(l))).click();
						execute.listdriverIsoelements(driver, name);
						List<String> otheros = execute.driverIsoReadFinal(name);
						execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");

						String ur = driver.getCurrentUrl();
					//	execute.CreateDriverFile(ur, pro, name);
						execute.createFile(ur, pro, name);

						if (os[i] != "Linux/") {
							String othroskey = protocol[j]+""+indadap.get(l)+""+os[i];
							List<String> allos = new ArrayList<String>();
							String esurl1 = driver.getCurrentUrl();
						//	System.out.println("inside non linux");
							for (int mn = 1; mn < otheros.size(); mn++) {
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
								
							List<String>folder_otheros = disc.fileCompare(protocol[j], url1all, url2all,url1esx,url2esx,key_firsturl,othroskey,name);
							if(!folder_otheros.isEmpty()){
								osfolderkey.add(othroskey);
							}
							mis_folder.addAll(folder_otheros);
							folder_mismatch.put(othroskey, folder_otheros);
								}
						}
						for (int m = 1; m < otheros.size(); m++) {
							String otos = otheros.get(m);
							System.out.println("The other os's" + otos);
							// element.createFile(otos);
							driver.findElement(By.linkText(otheros.get(m))).click();
							execute.listelements(driver, name);
							List<String> otheroscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
							String othercontenturl = driver.getCurrentUrl();
	
							
							execute.createFile(othercontenturl, pro, name);
							String vm_key = protocol[j]+""+indadap.get(l)+""+otheros.get(m);
							url1comb.put(vm_key, otheroscontent);
							firsturl.put(vm_key, othercontenturl);
							key_firsturl.put(othercontenturl, vm_key);
							List<String> esxos = url2comb.get(vm_key);
						//	secondurl.put(vm_key, othercontenturl);
							List<String> url1esxos = url1comb.get(vm_key);
							System.out.println("url1 list cont  is"+url1esxos);
							System.out.println("url2 list cont  is"+esxos);
						//	System.out.println("vmkey is"+vm_key);
						//	List<String> esxos = url1comb.get(vm_key);
							String keyurl = firsturl.get(vm_key);
							String secondkeyurl = secondurl.get(vm_key);
						//	System.out.println("first url is"+keyurl);
						//	System.out.println("second url is"+secondkeyurl);
							if((secondkeyurl != null)||(esxos != null)){
							//	System.out.println("inside disc of esxi");
									if(os[i]=="Linux/"){
										System.out.println("linux os compare key is"+vm_key);
									List<String>folder_linux=disc.fileCompare(protocol[j], url1esxos, esxos,keyurl,secondkeyurl,key_firsturl,vm_key,name);
									mis_folder.addAll(folder_linux);
									if(!folder_linux.isEmpty()){
									osfolderkey.add(vm_key);
									folder_mismatch.put(vm_key, folder_linux);
									}
									}
									else{
										System.out.println("insdie compare of otheros");
									List<String>folder_linux =	disc.fileCompare(protocol[j], url1esxos, esxos,keyurl,secondkeyurl,key_firsturl,null,name);
									content_mismatch.put(vm_key, folder_linux);
									mis_content.addAll(folder_linux);
									}
								}
						//	System.out.println("keyurl is "+keyurl);
						//	System.out.println("output of other os is"+esxos);
							
							for (int oscont = 0; oscont < otheroscontent.size(); oscont++) {
								String content = otheroscontent.get(oscont);

								execute.createFile(content, pro, name);
							//	System.out.println("other os ccontetn is"+content);

							}

					//		System.out.println("The os folder is " + otheros.get(m));
							if (os[i].equals("Linux/")) {
								// System.out.println("inside linux");
								execute.listelements(driver, name);
								List<String> linos = execute.readfinal(name);
								execute.clearTextfile("C:/Users/" + name + "/Desktop/tmp_file.txt");
								 String linurl = driver.getCurrentUrl();
								// System.out.println("linurl is"+linurl);
								// element.createFile(linurl);
							//	System.out.println("lin url is"+driver.getCurrentUrl());
							
								
								for (int los = 1; los < linos.size(); los++) {
									// String lios = linos.get(los);
									// element.createFile(lios);
									// System.out.println("The os folder is
									// " +
									// linos.get(los));
							//		System.out.println("linos is "+linos.get(los));
									
									
									driver.findElement(By.linkText(linos.get(los))).click();
									execute.listelements(driver, name);
									List<String> oscontent = execute.readfinal(name);
									String lin_key = protocol[j]+" "+indadap.get(l)+" "+linos.get(los);
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
										List<String>folder_linux =	disc.fileCompare(protocol[j], linuxos, url2linux, linconturl, securllin,key_firsturl,null,name);
												content_mismatch.put(lin_key, folder_linux);
												mis_content.addAll(folder_linux);
											}
								//	System.out.println("keyurl is "+linconturl);
									execute.createFile(contenturl, pro, name);

									// }
									for (int oscont = 0; oscont < oscontent.size(); oscont++) {
										String content = oscontent.get(oscont);

										execute.createFile(content, pro, name);
									//	System.out.println("linux content is"+content);
									}
								//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
									driver.navigate().back();
								}
							}
							// zero.clearTextfile("C:/Users/"+name+"/Desktop/rohit.txt");
						//	driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
							driver.navigate().back();
						} // indos for
							// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
					//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
						driver.navigate().back();
					} // indadap for
						// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
				//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
					driver.navigate().back();

				} // adap for
					// zero.clearTextfile("C:/Users/pyogaraj/Desktop/rohit.txt");
			//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
				driver.navigate().back();
			} // protocol for end
		//	driver.findElement(By.xpath("//*[@id=\"tbody\"]/tr[1]/td[1]/a")).click();
			driver.navigate().back();
		} // os for end
		System.out.println("missing folder is"+mis_folder);
		System.out.println("osfolder is"+osfolderkey);
		disc.check(url1comb,url2comb,key_firsturl,key_secondurl,firsturl,secondurl,mis_folder,osfolderkey,folder_mismatch,content_mismatch,mis_content,name);
	}
}
