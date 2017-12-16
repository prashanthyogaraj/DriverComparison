package com.java.driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class IndividualOs {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner s = new Scanner(System.in);
		 FunctionsExecute execute = new FunctionsExecute();
		 IndividualOs os = new IndividualOs();
		 System.out.println("Enter the Os");
		 String os1 = s.nextLine();
		 System.out.println("Enter the url");
		 String url = s.nextLine();
		 System.out.println("Enter the url");
		 String url1 = s.nextLine();
		 System.out.println("Select the Os you want to test");
		 String oses = s.nextLine();
		 String name = execute.getCecId();
		 os.startIndOs2(os1,url,url1,oses,name);
	}

	public void startIndOs2(String os, String url,String url1, String oses,String name)
			throws IOException, InterruptedException {
		Scanner s = new Scanner(System.in);
		IndividualOs ind = new IndividualOs();

		if (os.equals("Linux/")) {

			 ind.getIndividualoutput2(os, url,url1, oses,name);
		}

		if (os.equals("VMware/")) {
			 ind.getIndividualoutput2(os,url, url1, oses,name);
		}
	
		if (os.equals("Windows/")) {
			 ind.getIndividualoutput2(os, url,url1, oses,name);
		}

		if (os.equals("XenServer/")) {
		 ind.getIndividualoutput2(os,url, url1, oses,name);
		}

		

	}
	

	public void getIndividualoutput2(String os, String url,String url1, String oses, String name)
			throws IOException, InterruptedException {
		System.out.println("inside second ind os");
		System.out.println("os is" + os);
		FunctionsExecute execute = new FunctionsExecute();
		IndividualOs ind = new IndividualOs();
		Scanner s = new Scanner(System.in);
		int a = 0;
		int b=0;
		String pro;
		String OSlink = null;
		String OSname = null;
		String OSname1 = null;
		String OSname2 = null;
		String OSname3 = null;
	
		Map<String, List<String>> url2comb = new HashMap<String, List<String>>();
		Map<String,String> secondurl = new HashMap<String,String>();
		Map<String,String> key_secondurl = new HashMap<String,String>();

		System.out.println("in second");
		WebDriver driver = execute.getDriver(name);
		driver.get(url1);
		Thread.sleep(25000);
		System.out.println("Enter the OS name");
		// String oses = s.nextLine();
		String[] osname = oses.split(",");
		// name = execute.getCecId();
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file2_network.txt");
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file2_storage.txt");
		execute.clearTextfile("C:/Users/"+name+"/Desktop/Discrepency.txt");
		execute.clearTextfile("C:/Users/"+name+"/Desktop/Discrepency_output.txt");
		for (int i = 0; i < osname.length; i++) {
			if (os.equals("Linux/")) {
				OSname = osname[i].toUpperCase();
				if (OSname.contains("RHEL") || (OSname.contains("SLES"))) {
					OSname = OSname + "/";
				}

				// OSname = osname[i] + "/";
				System.out.println(OSname);
				if (OSname.contains("ORACLE")) {
					System.out.println("Inside orac..");

					OSname = OSname.replaceAll("RAC", "");
					// OSname = osname[i].replaceALL("RAC", "");
					OSname = OSname.replaceAll("E", "");
					OSname = OSname + "/";
					System.out.println(OSname);
				}
				if (OSname.contains("CENT")) {
					System.out.println("Inside cent..");
					OSname = OSname.replaceAll("CENT", "CENTOS");
					OSname = OSname + "/";
					System.out.println(OSname);
				}
				if (OSname.contains("CENT")) {
					OSlink = "CentOS/";
				} else if (OSname.contains("OL")) {
					OSlink = "Oracle/";
				} else if (OSname.contains("RHEL")) {

					OSlink = "RHEL/";
				} else if (OSname.contains("SLES")) {

					OSlink = "SLES/";
				}
			}

			if (os.equals("VMware/")) {
				System.out.println("inside....." + os);
				System.out.println(",,,,," + osname[i]);

				// OSname = osname[i].toUpperCase();
				OSname1 = osname[i].toUpperCase();
				OSname1 = OSname1.replace("I", "i");
				OSname1 = OSname1.replace("ESXi", "ESXi_");
				OSname1 = OSname1 + "/";
				System.out.println(OSname1);
			}
			if (os.equals("Windows/")) {
				System.out.println("inside....." + os);
				OSname2 = osname[i].toUpperCase();
				OSname2 = OSname2 + "/";
				System.out.println(OSname2);
			}
			if (os.equals("XenServer/")) {
				System.out.println("inside....." + os);
				OSname3 = osname[i].toUpperCase();
				OSname3 = OSname3.replace("XEN", "XS");
				OSname3 = OSname3 + "/";
				System.out.println(OSname3);
			}

			// String[] os = { "Linux/", "VMware/", "Windows/", "XenServer/" };

			ArrayList<String> protocol = new ArrayList<String>();
			protocol.add("Network/");
			protocol.add("Storage/");

			driver.findElement(By.linkText(os)).click();
			for (int j = 0; j < protocol.size(); j++) {
				pro = protocol.get(j);

				System.out.println("in main" + pro);
				try {
					driver.findElement(By.linkText(protocol.get(j))).click();
				} catch (Exception e) {
					System.out.println(protocol.get(j) + "is not present in that link");
				}
				execute.listelements(driver, name);
				List<String> adap = execute.readfinal(name);
				execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
				for (int k = 0; k < adap.size(); k++) {
					driver.findElement(By.linkText(adap.get(k))).click();
					execute.listelements(driver, name);
					List<String> indadap = execute.readfinal(name);
					execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
					for (int l = 0; l < indadap.size(); l++) {
						if (adap.get(k).equals("FusionIO/")) {
							System.out.println("inside fio");
							indadap.remove("README.html");

						}
						driver.findElement(By.linkText(indadap.get(l))).click();
						execute.listelements(driver, name);
						List<String> otheros = execute.readfinal(name);
						execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
						String ur = driver.getCurrentUrl();
						
					
						execute.createFile2(ur, pro, name);
						if (os.equals("VMware/")) {
							String othroskey = protocol.get(j)+""+indadap.get(l)+""+os;
							String esurl = driver.getCurrentUrl();
							List<String> allos = new ArrayList<String>();
							for (int mn = 0; mn < otheros.size(); mn++) {
								String vmos = otheros.get(mn);
								allos.add(vmos);
							}
							secondurl.put(othroskey, esurl);
							key_secondurl.put(esurl, othroskey);
							url2comb.put(othroskey, allos);
							a = 0;
							System.out.println("Inside vmware");
							try {
								driver.findElement(By.linkText(OSname1)).click();
							} catch (NoSuchElementException e) {
								a = 1;
								System.out.println(OSname1 + "not found");
							}
							execute.listelements(driver, name);
							List<String> oscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							String contenturl = driver.getCurrentUrl();
							if(a!=1){
							execute.createFile2(contenturl, pro, name);
							}
							String vm_key = protocol.get(j)+""+indadap.get(l)+""+OSname1;
							url2comb.put(vm_key, oscontent);
							System.out.println("vmkey is"+vm_key);
							List<String> esxos = url2comb.get(vm_key);
							
							secondurl.put(vm_key, contenturl);
							key_secondurl.put(contenturl, vm_key);
							String keyurl = secondurl.get(vm_key);
				
			
							for (int oscont = 0; oscont < oscontent.size(); oscont++) {
								String content = oscontent.get(oscont);
								if(a!=1){
								execute.createFile2(content, pro, name);
								}
							}

						}
						if (os.equals("Windows/")) {
							String othroskey = protocol.get(j)+""+indadap.get(l)+""+os;
							String esurl = driver.getCurrentUrl();
							List<String> allos = new ArrayList<String>();
							for (int mn = 0; mn < otheros.size(); mn++) {
								String vmos = otheros.get(mn);
								allos.add(vmos);
							}
							secondurl.put(othroskey, esurl);
							key_secondurl.put(esurl, othroskey);
							url2comb.put(othroskey, allos);
							a = 0;
							System.out.println("Inside Windows");
							try {
								driver.findElement(By.linkText(OSname2)).click();
							} catch (NoSuchElementException e) {
								a = 1;
								System.out.println(osname + "not found");
							}
							execute.listelements(driver, name);
							List<String> oscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							String contenturl = driver.getCurrentUrl();
							if(a!=1){
							execute.createFile2(contenturl, pro, name);
							}
							String vm_key = protocol.get(j)+""+indadap.get(l)+""+OSname2;
							url2comb.put(vm_key, oscontent);
							System.out.println("vmkey is"+vm_key);
							List<String> esxos = url2comb.get(vm_key);
							
							secondurl.put(vm_key, contenturl);
							key_secondurl.put(contenturl, vm_key);
							String keyurl = secondurl.get(vm_key);
				
							for (int oscont = 0; oscont < oscontent.size(); oscont++) {
								String content = oscontent.get(oscont);
								if(a!=1){
								execute.createFile2(content, pro, name);
								}
							}

						}
						if (os.equals("XenServer/")) {
							String othroskey = protocol.get(j)+""+indadap.get(l)+""+os;
							String esurl = driver.getCurrentUrl();
							List<String> allos = new ArrayList<String>();
							for (int mn = 0; mn < otheros.size(); mn++) {
								String vmos = otheros.get(mn);
								allos.add(vmos);
							}
							secondurl.put(othroskey, esurl);
							key_secondurl.put(esurl, othroskey);
							url2comb.put(othroskey, allos);
							a = 0;
							System.out.println("inside xen");
							try {
								driver.findElement(By.linkText(OSname3)).click();
							} catch (NoSuchElementException e) {
								a = 1;
								System.out.println(osname + "not found");
							}
							execute.listelements(driver, name);
							List<String> oscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							String contenturl = driver.getCurrentUrl();
							if(a!=1){
							execute.createFile2(contenturl, pro, name);
							}
							String vm_key = protocol.get(j)+""+indadap.get(l)+""+OSname3;
							url2comb.put(vm_key, oscontent);
							System.out.println("vmkey is"+vm_key);
							List<String> esxos = url2comb.get(vm_key);
							
							secondurl.put(vm_key, contenturl);
							key_secondurl.put(contenturl, vm_key);
							String keyurl = secondurl.get(vm_key);
				
							for (int oscont = 0; oscont < oscontent.size(); oscont++) {
								String content = oscontent.get(oscont);
								if(a!=1){
								execute.createFile2(content, pro, name);
								}
							}

						}
						if (os.equals("Linux/")) {
							a = 0;
							b = 0;
							System.out.println("inside Linux...");

							try {
								driver.findElement(By.linkText(OSlink)).click();
								execute.listelements(driver, name);
								List<String> otherlinosos = execute.readfinal(name);
								String othroskey = protocol.get(j)+""+indadap.get(l)+""+OSlink;
								String esurl = driver.getCurrentUrl();
								List<String> allos = new ArrayList<String>();
								for (int mn = 0; mn < otherlinosos.size(); mn++) {
									String vmos = otherlinosos.get(mn);
									allos.add(vmos);
								}
								secondurl.put(othroskey, esurl);
								key_secondurl.put(esurl, othroskey);
								url2comb.put(othroskey, allos);
							} catch (NoSuchElementException e) {
								// e.printStackTrace();
								a = 1;
								b = 1;
								System.out.println("a is" + a);
								System.out.println(OSname + "not found");
							}
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							if (b != 1) {
								try {
									System.out.println("inside b!=1");
									driver.findElement(By.linkText(OSname)).click();
									execute.listelements(driver, name);
									String contenturl = driver.getCurrentUrl();
									List<String> oscontent = execute.readfinal(name);
									String vm_key = protocol.get(j)+""+indadap.get(l)+""+OSname;
									url2comb.put(vm_key, oscontent);
									System.out.println("vmkey is"+vm_key);
									List<String> esxos = url2comb.get(vm_key);
									
									secondurl.put(vm_key, contenturl);
									key_secondurl.put(contenturl, vm_key);
									String keyurl = secondurl.get(vm_key);

								} catch (NoSuchElementException e) {
									// e.printStackTrace();
									a = 1;
									System.out.println("a is" + a);
									System.out.println(OSname + "not found");
								}
							}
							
							execute.listelements(driver, name);
							List<String> oscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							String contenturl = driver.getCurrentUrl();
							execute.createFile(contenturl, pro, name);
							for (int oscont = 0; oscont < oscontent.size(); oscont++) {
								String content = oscontent.get(oscont);
								if(a!=1){
								execute.createFile(content, pro, name);
								}
							}
						
							if ((a != 1)) {
								System.out.println("inside  ne 1");
//								driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
								driver.navigate().back();
							}

							// } // lios for
						}
						System.out.println("os is " + os);
						if ((a != 1) || ((os.equals("Linux/")&&(b!=1)))) {
//							driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
							driver.navigate().back();
						}
						// indos for
//						driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
						driver.navigate().back();
					} // indadap for
//					driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
					driver.navigate().back();
				} // adap for
//				driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
				driver.navigate().back();
			} // protocol for
//			driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
			driver.navigate().back();
			// return name;
		}
		ind.startIndOs(os,url,oses,driver, name,url2comb,secondurl,key_secondurl);

	}

	public void startIndOs(String os, String url, String oses,WebDriver driver, String name,Map<String,List<String>> url2comb, Map<String,String>secondurl,Map<String,String>key_secondurl) throws IOException, InterruptedException {
		Scanner s = new Scanner(System.in);
		IndividualOs ind = new IndividualOs();

		if (os.equals("Linux/")) {

		 ind.getIndividualoutput(os, url,driver,oses,name,url2comb,secondurl,key_secondurl);
		}

		if (os.equals("VMware/")) {
			 ind.getIndividualoutput(os, url,driver,oses, name,url2comb,secondurl,key_secondurl);
		}
	
		if (os.equals("Windows/")) {
			 ind.getIndividualoutput(os, url,driver, oses, name,url2comb,secondurl,key_secondurl);
		}
		if (os.equals("XenServer/")) {
			 ind.getIndividualoutput(os, url,driver, oses, name,url2comb,secondurl,key_secondurl);
		}
	
		

	}
	

	public void getIndividualoutput(String os, String url,WebDriver driver, String oses, String name,Map<String,List<String>> url2comb, Map<String,String>secondurl,Map<String,String>key_secondurl)
			throws IOException, InterruptedException {
		System.out.println("os is" + os);
		IndividualOs ind = new IndividualOs();
		FunctionsExecute execute = new FunctionsExecute();
		Scanner s = new Scanner(System.in);
		FindDiscrepancy disc = new FindDiscrepancy();
		Map<String, List<String>> url1comb = new HashMap<String, List<String>>();
		Map<String,String> firsturl = new HashMap<String,String>();
		Map<String,String> key_firsturl = new HashMap<String,String>();
		List<String> mis_folder = new ArrayList<String>();
		List<String> mis_content = new ArrayList<String>();
		List<String> osfolderkey = new ArrayList<String>();
		Map<String, List<String>> folder_mismatch = new HashMap<String, List<String>>();
		Map<String, List<String>> content_mismatch = new HashMap<String, List<String>>();
		int a = 0;
		int b = 0;
		String pro;
		String OSlink = null;
		String OSname = null;
		String OSname1 = null;
		String OSname2 = null;
		String OSname3 = null;
		// String name = null;
		// System.out.println("1.vic 2.3rdparty");
		// int inp = s.nextInt();

		System.out.println("in first");
		// s.nextLine();
		// String url = s.nextLine();
//		WebDriver driver = execute.getDriver();
		driver.get(url);
		Thread.sleep(2000);
		System.out.println("Enter the OS name");
		// String oses = s.nextLine();
		String[] osname = oses.split(",");

		// name = execute.getCecId();
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file1_network.txt");
		execute.clearTextfile("C:/Users/" + name + "/Desktop/file1_storage.txt");
		for (int i = 0; i < osname.length; i++) {
			if (os.equals("Linux/")) {
				OSname = osname[i].toUpperCase();
				if (OSname.contains("RHEL") || (OSname.contains("SLES"))) {
					OSname = OSname + "/";
				}

				// OSname = osname[i] + "/";
				System.out.println(OSname);
				if (OSname.contains("ORACLE")) {
					System.out.println("Inside orac..");

					OSname = OSname.replaceAll("RAC", "");
					// OSname = osname[i].replaceALL("RAC", "");
					OSname = OSname.replaceAll("E", "");
					OSname = OSname + "/";
					System.out.println(OSname);
				}
				if (OSname.contains("CENT")) {
					System.out.println("Inside cent..");
					OSname = OSname.replaceAll("CENT", "CENTOS");
					OSname = OSname + "/";
					System.out.println(OSname);
				}
				if (OSname.contains("CENT")) {
					OSlink = "CentOS/";
				} else if (OSname.contains("OL")) {
					OSlink = "Oracle/";
				} else if (OSname.contains("RHEL")) {

					OSlink = "RHEL/";
				} else if (OSname.contains("SLES")) {

					OSlink = "SLES/";
				}
			}

			if (os.equals("VMware/")) {
				System.out.println("inside....." + os);
				System.out.println(",,,,," + osname[i]);

				// OSname = osname[i].toUpperCase();
				OSname1 = osname[i].toUpperCase();
				OSname1 = OSname1.replace("I", "i");
				OSname1 = OSname1.replace("ESXi", "ESXi_");
				OSname1 = OSname1 + "/";
				System.out.println(OSname1);
			}
			if (os.equals("Windows/")) {
				System.out.println("inside....." + os);
				OSname2 = osname[i].toUpperCase();
				OSname2 = OSname2 + "/";
				System.out.println(OSname2);
			}
			if (os.equals("XenServer/")) {
				System.out.println("inside....." + os);
				OSname3 = osname[i].toUpperCase();
				OSname3 = OSname3.replace("XEN", "XS");
				OSname3 = OSname3 + "/";
				System.out.println(OSname3);
			}

			// String[] os = { "Linux/", "VMware/", "Windows/", "XenServer/" };
			ArrayList<String> protocol = new ArrayList<String>();
			protocol.add("Network/");
			protocol.add("Storage/");
			driver.findElement(By.linkText(os)).click();

			for (int j = 0; j < protocol.size(); j++) {
				pro = protocol.get(j);

				System.out.println("in main" + pro);
				try {
					driver.findElement(By.linkText(protocol.get(j))).click();
				} catch (Exception e) {
					System.out.println(protocol.get(j) + "is not present in that link");
				}
				execute.listelements(driver, name);
				List<String> adap = execute.readfinal(name);
				execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
				for (int k = 0; k < adap.size(); k++) {
					driver.findElement(By.linkText(adap.get(k))).click();
					execute.listelements(driver, name);
					List<String> indadap = execute.readfinal(name);
					execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
					for (int l = 0; l < indadap.size(); l++) {
						if (adap.get(k).equals("FusionIO/")) {
							System.out.println("inside fio");
							indadap.remove("README.html");

						}
						driver.findElement(By.linkText(indadap.get(l))).click();
						execute.listelements(driver, name);
						List<String> otheros = execute.readfinal(name);
						execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
						String ur = driver.getCurrentUrl();

						execute.createFile(ur, pro, name);
						if (os.equals("VMware/")) {
							String othroskey = protocol.get(j)+""+indadap.get(l)+""+os;
							List<String> allos = new ArrayList<String>();
							String esurl1 = driver.getCurrentUrl();
							for (int mn = 0; mn < otheros.size(); mn++) {
								String vmos = otheros.get(mn);
								allos.add(vmos);
								execute.createFile(vmos, pro, name);

							}
							url1comb.put(othroskey, allos);
							firsturl.put(othroskey, esurl1);
							key_firsturl.put(esurl1, othroskey);
							List<String> url2all = url2comb.get(othroskey);
							List<String> url1all = url1comb.get(othroskey);
							String url2esx = secondurl.get(othroskey);
							String url1esx = firsturl.get(othroskey);
							if((url2all != null)){
								System.out.println("oscompare key is"+othroskey);
								
							List<String>folder_otheros = disc.fileCompare(protocol.get(j), url1all, url2all,url1esx,url2esx,key_firsturl,othroskey,name);
							if(!folder_otheros.isEmpty()){
								osfolderkey.add(othroskey);
							}
							mis_folder.addAll(folder_otheros);
							folder_mismatch.put(othroskey, folder_otheros);
								}
							a = 0;
							System.out.println("Inside vmware");
							try {
								driver.findElement(By.linkText(OSname1)).click();
							} catch (NoSuchElementException e) {
								a = 1;
								System.out.println(osname + "not found");
							}
							execute.listelements(driver, name);
							List<String> oscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							String contenturl = driver.getCurrentUrl();
							String vm_key = protocol.get(j)+""+indadap.get(l)+""+OSname1;
							url1comb.put(vm_key, oscontent);
							firsturl.put(vm_key, contenturl);
							key_firsturl.put(contenturl, vm_key);
							List<String> esxos = url2comb.get(vm_key);
							List<String> url1esxos = url1comb.get(vm_key);
							String keyurl = firsturl.get(vm_key);
							String secondkeyurl = secondurl.get(vm_key);
							if((secondkeyurl != null)||(esxos != null)){
							//	System.out.println("inside disc of esxi");
								List<String>folder_linux = disc.fileCompare(protocol.get(j), url1esxos, esxos,keyurl,secondkeyurl,key_firsturl,null,name);
								content_mismatch.put(vm_key, folder_linux);
								mis_content.addAll(folder_linux);
									
								}
							execute.createFile(contenturl, pro, name);
							for (int oscont = 0; oscont < oscontent.size(); oscont++) {
								String content = oscontent.get(oscont);

								execute.createFile(content, pro, name);

							}

						}
						if (os.equals("Windows/")) {
							String othroskey = protocol.get(j)+""+indadap.get(l)+""+os;
							List<String> allos = new ArrayList<String>();
							String esurl1 = driver.getCurrentUrl();
							for (int mn = 0; mn < otheros.size(); mn++) {
								String vmos = otheros.get(mn);
								allos.add(vmos);
								execute.createFile(vmos, pro, name);

							}
							url1comb.put(othroskey, allos);
							firsturl.put(othroskey, esurl1);
							key_firsturl.put(esurl1, othroskey);
							List<String> url2all = url2comb.get(othroskey);
							List<String> url1all = url1comb.get(othroskey);
							String url2esx = secondurl.get(othroskey);
							String url1esx = firsturl.get(othroskey);
							if((url2all != null)){
								System.out.println("oscompare key is"+othroskey);
								
							List<String>folder_otheros = disc.fileCompare(protocol.get(j), url1all, url2all,url1esx,url2esx,key_firsturl,othroskey,name);
							if(!folder_otheros.isEmpty()){
								osfolderkey.add(othroskey);
							}
							mis_folder.addAll(folder_otheros);
							folder_mismatch.put(othroskey, folder_otheros);
								}
							a = 0;
							System.out.println("Inside Windows");
							try {
								driver.findElement(By.linkText(OSname2)).click();
							} catch (NoSuchElementException e) {
								a = 1;
								System.out.println(osname + "not found");
							}
							execute.listelements(driver, name);
							List<String> oscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							String contenturl = driver.getCurrentUrl();
							String vm_key = protocol.get(j)+""+indadap.get(l)+""+OSname2;
							url1comb.put(vm_key, oscontent);
							firsturl.put(vm_key, contenturl);
							key_firsturl.put(contenturl, vm_key);
							List<String> esxos = url2comb.get(vm_key);
							List<String> url1esxos = url1comb.get(vm_key);
							String keyurl = firsturl.get(vm_key);
							String secondkeyurl = secondurl.get(vm_key);
							if((secondkeyurl != null)||(esxos != null)){
							//	System.out.println("inside disc of esxi");
								List<String>folder_linux = disc.fileCompare(protocol.get(j), url1esxos, esxos,keyurl,secondkeyurl,key_firsturl,null,name);
								content_mismatch.put(vm_key, folder_linux);
								mis_content.addAll(folder_linux);
									
								}
							execute.createFile(contenturl, pro, name);
							for (int oscont = 0; oscont < oscontent.size(); oscont++) {
								String content = oscontent.get(oscont);

								execute.createFile(content, pro, name);

							}

						}
						if (os.equals("XenServer/")) {
							String othroskey = protocol.get(j)+""+indadap.get(l)+""+os;
							List<String> allos = new ArrayList<String>();
							String esurl1 = driver.getCurrentUrl();
							for (int mn = 0; mn < otheros.size(); mn++) {
								String vmos = otheros.get(mn);
								allos.add(vmos);
								execute.createFile(vmos, pro, name);

							}
							url1comb.put(othroskey, allos);
							firsturl.put(othroskey, esurl1);
							key_firsturl.put(esurl1, othroskey);
							List<String> url2all = url2comb.get(othroskey);
							List<String> url1all = url1comb.get(othroskey);
							String url2esx = secondurl.get(othroskey);
							String url1esx = firsturl.get(othroskey);
							if((url2all != null)){
								System.out.println("oscompare key is"+othroskey);
								
							List<String>folder_otheros = disc.fileCompare(protocol.get(j), url1all, url2all,url1esx,url2esx,key_firsturl,othroskey,name);
							if(!folder_otheros.isEmpty()){
								osfolderkey.add(othroskey);
							}
							mis_folder.addAll(folder_otheros);
							folder_mismatch.put(othroskey, folder_otheros);
								}
							a = 0;
							System.out.println("inside xen");
							try {
								driver.findElement(By.linkText(OSname3)).click();
							} catch (NoSuchElementException e) {
								a = 1;
								System.out.println(osname + "not found");
							}
							execute.listelements(driver, name);
							List<String> oscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							String contenturl = driver.getCurrentUrl();
							String vm_key = protocol.get(j)+""+indadap.get(l)+""+OSname3;
							url1comb.put(vm_key, oscontent);
							firsturl.put(vm_key, contenturl);
							key_firsturl.put(contenturl, vm_key);
							List<String> esxos = url2comb.get(vm_key);
							List<String> url1esxos = url1comb.get(vm_key);
							String keyurl = firsturl.get(vm_key);
							String secondkeyurl = secondurl.get(vm_key);
							if((secondkeyurl != null)||(esxos != null)){
							//	System.out.println("inside disc of esxi");
								List<String>folder_linux = disc.fileCompare(protocol.get(j), url1esxos, esxos,keyurl,secondkeyurl,key_firsturl,null,name);
								content_mismatch.put(vm_key, folder_linux);
								mis_content.addAll(folder_linux);
									
								}
							execute.createFile(contenturl, pro, name);
							for (int oscont = 0; oscont < oscontent.size(); oscont++) {
								String content = oscontent.get(oscont);

								execute.createFile(content, pro, name);

							}

						}
						if (os.equals("Linux/")) {
							a = 0;
							b = 0;
							System.out.println("inside Linux...");

							try {
								driver.findElement(By.linkText(OSlink)).click();
								execute.listelements(driver, name);
								List<String> otherlinosos = execute.readfinal(name);
								String othroskey = protocol.get(j)+""+indadap.get(l)+""+OSlink;
								List<String> allos = new ArrayList<String>();
								String esurl1 = driver.getCurrentUrl();
								for (int mn = 0; mn < otherlinosos.size(); mn++) {
									String vmos = otherlinosos.get(mn);
									allos.add(vmos);


								}
								url1comb.put(othroskey, allos);
								System.out.println("all os is"+allos);
								firsturl.put(othroskey, esurl1);
								key_firsturl.put(esurl1, othroskey);
								List<String> url2all = url2comb.get(othroskey);
								List<String> url1all = url1comb.get(othroskey);
								String url2esx = secondurl.get(othroskey);
								String url1esx = firsturl.get(othroskey);
								if((url2all != null)){
									System.out.println("oscompare key is"+othroskey);
									
								List<String>folder_otheros = disc.fileCompare(protocol.get(j), url1all, url2all,url1esx,url2esx,key_firsturl,othroskey,name);
								if(!folder_otheros.isEmpty()){
									osfolderkey.add(othroskey);
								}
								mis_folder.addAll(folder_otheros);
								folder_mismatch.put(othroskey, folder_otheros);
									}
							} catch (NoSuchElementException e) {
								// e.printStackTrace();
								a = 1;
								b = 1;
								System.out.println("a is" + a);
								System.out.println(OSname + "not found");
							}
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							if (b != 1) {
								try {
									System.out.println("inside b!=1");
									driver.findElement(By.linkText(OSname)).click();
									String contenturl = driver.getCurrentUrl();
									execute.listelements(driver, name);
									List<String> lincont = execute.readfinal(name);
									System.out.println("content inside try is"+lincont);
									String vm_key = protocol.get(j)+""+indadap.get(l)+""+OSname;
									url1comb.put(vm_key, lincont);
									firsturl.put(vm_key, contenturl);
									key_firsturl.put(contenturl, vm_key);
									List<String> esxos = url2comb.get(vm_key);
									List<String> url1esxos = url1comb.get(vm_key);
									String keyurl = firsturl.get(vm_key);
									String secondkeyurl = secondurl.get(vm_key);
									if((secondkeyurl != null)||(esxos != null)){
									//	System.out.println("inside disc of esxi");
										List<String>folder_linux = disc.fileCompare(protocol.get(j), url1esxos, esxos,keyurl,secondkeyurl,key_firsturl,vm_key,name);
									//	System.out.println("vm_key is"+vm_key+"and the content is"+folder_linux);
										content_mismatch.put(vm_key, folder_linux);
										mis_content.addAll(folder_linux);
											
										}
								} catch (NoSuchElementException e) {
									// e.printStackTrace();
									a = 1;
									System.out.println("a is" + a);
									System.out.println(OSname + "not found");
								}
							}
							execute.listelements(driver, name);
							List<String> oscontent = execute.readfinal(name);
							execute.clearTextfile("C:/Users/"+name+"/Desktop/tmp_file.txt");
							String contenturl = driver.getCurrentUrl();
							execute.createFile(contenturl, pro, name);
				
							execute.createFile(contenturl, pro, name);
							for (int oscont = 0; oscont < oscontent.size(); oscont++) {
								String content = oscontent.get(oscont);
								if(a!=1){
								execute.createFile(content, pro, name);
								}
							}
							if ((a != 1)) {
								System.out.println("inside  ne 1");
//								driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
								driver.navigate().back();
							}

							// } // lios for
						} // linux if
						System.out.println("os is " + os);
						if ((a != 1) || ((os.equals("Linux/")&&(b!=1)))) {
							System.out.println("clicked os is linux");
//							driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
							driver.navigate().back();
						}
						// indos for
//						driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
						driver.navigate().back();
					} // indadap for
//					driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
					driver.navigate().back();
				} // adap for
//				driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
				driver.navigate().back();
			} // protocol for
//			driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
			driver.navigate().back();
			// return name;
		}
		System.out.println("folder_mismatch is"+folder_mismatch);
		System.out.println("content mismatch is"+content_mismatch);
		System.out.println("mis_content is"+mis_content);
		System.out.println("missing folder is"+mis_folder);
		System.out.println("osfolder is"+osfolderkey);
		disc.check(url1comb,url2comb,key_firsturl,key_secondurl,firsturl,secondurl,mis_folder,osfolderkey,folder_mismatch,content_mismatch,mis_content,name);
	

	} // function close
	
} // main close
