import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class MainRun extends Engine{
	//////////////// config //////////////////

	String fiscalYear="2555"; //// ปีในการค้นหา
	int StratGroup = 6; ///// เลขหมวด เริ่ม จาก A = 0 ,B = 1 ตามลำดับถึงหมด U
	int StratSubGroupNum = 0; ///// กลุ่มย่อย ตามลำดับ Elliment บนหน้าเว็บ 
	int selectProvince = 16; ///// เลขจังหวัด ตาม ARRAY ด้านล่าง
	String zone="N"; //// ภาคในการค้นหา ควร เปลี่ยนให้สอดคร้องการจังหวัด
	String swichLimitProvince = "on";
	
	////////////////////////////////////////////////
	
	
	//////////////  ตัวแปรเบื้องต้น (ห้ามเปลี่ยน)
	String[] province;
	String[] allgroupList;
	String[] ListSub;
	Boolean checkDataResult;
	int checkerrorValue = 0;
	static int trvalue = 11;
	private static int tr;
	private static int companyId;
	int provinceValue;
	int lineSelectProvince = selectProvince;
	/////////////////

	public void Run() throws Exception {
		province= new String[17];
		province[0]="กำแพงเพชร";
		province[1]="ตาก";
		province[2]="นครสวรรค์";
		province[3]="น่าน";
		province[4]="พะเยา";
		province[5]="พิจิตร";
		province[6]="พิษณุโลก";
		province[7]="ลำปาง";
		province[8]="ลำพูน";
		province[9]="สุโขทัย";
		province[10]="อุตรดิตถ์";
		province[11]="อุทัยธานี";
		province[12]="เชียงราย";
		province[13]="เพชรบูรณ์";
		province[14]="แพร่";
		province[15]="แม่ฮ่องสอน";
		province[16]="เชียงใหม่";

		db sqls = new db();
		printStr(">> Test Connect To DataBase...");
		try {
			sqls.connectDB();
			printStr(">> Connected DataBase");
			sqls.closedb();
			printStr(">> Deconnected DataBase");
		
			printStr(">> Test Connect To DataBase Complete!");
			printStr("-----------------------------");
	try {
		printStr(">> Opening Browser");
		Engine.openLoginPage();
		if(swichLimitProvince=="off"){
			StratGroup = 0;
			StratSubGroupNum = 0; 
			selectProvince = 0;
			lineSelectProvince = province.length-1;
		}
	for(provinceValue=selectProvince;provinceValue<=lineSelectProvince;provinceValue++){	
		
		allgroupList = Engine.searchGroupOptionSub();
	
		for(int loopOut=StratGroup;loopOut<allgroupList.length;loopOut++){
		
			Engine.optionSelect(allgroupList[loopOut], "objGrpCode", "text");
			
			ListSub = Engine.optionSubSelect();
			int StartSubGroup = 0;
				if(loopOut==StratGroup){
					StartSubGroup = StratSubGroupNum;
				}
			for(int loopIn=StartSubGroup;loopIn<ListSub.length;loopIn++){
			   	printStr("-------------------------------------------------------------------");
				printStr(">> type "+ListSub[loopIn].substring(0, 5)+"\n>> group "+allgroupList[loopOut].substring(0, 1)+"");
				Boolean check = true;
				while (check == true) {
					try {
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")));
						driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")).click();
						check = false;
					} catch (org.openqa.selenium.TimeoutException e) {
						check = true;
					}
				}
				check = true;
				while (check == true) {
					try {
				Engine.optionSelect(allgroupList[loopOut], "objGrpCode", "text");
				check = false;
					} catch (org.openqa.selenium.TimeoutException e) {
						check = true;
					}
				}
				check = true;
				while (check == true) {
					try {
				Engine.optionSelect(ListSub[loopIn], "submitObjCode", "value");
				check = false;
					} catch (org.openqa.selenium.TimeoutException e) {
						check = true;
					}
				}
				check = true;
				while (check == true) {
					try {
				Engine.optionSelect(zone, "zone", "value");
				printStr(">> ZONE "+zone);
				check = false;
					} catch (org.openqa.selenium.TimeoutException e) {
						check = true;
					}
				}
				check = true;
				while (check == true) {
					try {
				Engine.optionSelect(""+province[provinceValue]+"", "province", "text");
				check = false;
					} catch (org.openqa.selenium.TimeoutException e) {
						check = true;
					}
				}
				check = true;
				while (check == true) {
					try {
				Engine.optionSelect(fiscalYear, "fiscalYear", "text");
				printStr(">> YEAR = "+fiscalYear);
				check = false;
					} catch (org.openqa.selenium.TimeoutException e) {
						check = true;
					}
				}
				checkDataResult = Engine.submit();
				if(checkDataResult==true){
					////////////////////////////////////////////////////
					check = true;
					int page = 0;
					while (check == true) {
						try {
					WebElement pageEi = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")));	
					page=countpage(pageEi.getText());
					check = false;
						} catch (org.openqa.selenium.TimeoutException e) {
							check = true;
						}
					}

			
					int list=0;
					check = true;
					while (check == true) {
						try {
					list = countlist(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")).getText());
					check = false;
						} catch (org.openqa.selenium.TimeoutException e) {
							check = true;
						}
					}
					
					printStr(">>  AllPage  = "+page);
					printStr("-----------------------------");
					String company[] = new String[15];
					for(int pagenum = 1;pagenum<=page;++pagenum){
						
			
					
					
					
						WebElement pagenumEiss;
						WebElement pagenumEi;
						if((pagenum%10)==1&&pagenum>1){
							check = true;
							while (check == true) {
								try {
							  pagenumEiss  = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(""+(pagenum-2)+"")));
							  pagenumEiss.click();
							  pagenumEi  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/ul/li[13]/a")));
							  pagenumEi.click();
							  check = false;
							  printStr(">> ThisPage Now = ("+pagenum+")");
						
								} catch (org.openqa.selenium.TimeoutException e) {
									check = true;
								}
							}
				
					}else{
						check = true;
						while (check == true) {
							try {
							pagenumEi  = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(String.valueOf(pagenum))));
							pagenumEi.click();
							printStr(">> ThisPage Now = ("+pagenum+")");
							check = false;
					} catch (org.openqa.selenium.TimeoutException e) {
						check = true;
					}
				}
					}	
						if(list<=10){
							trvalue=list+1;
						}
						if(list>=10){
							trvalue = 11;
						}
							for(tr=2;tr<=trvalue;++tr){
								checkerrorValue = 99;
								printStr(">> row In Page = "+(tr));
								printStr(">> Result Data = "+(list-(tr+4)));
								printStr(">> PageNow = ("+pagenum+")");
						
						Boolean cheErrorAdd= true;
						while (cheErrorAdd==true) {
						
					
								try {
				
							for(int td=2;td<=13;++td){
						
									if(td>0&&tr>0){
							
										check = true;
										while (check == true) {
											try {
												checkerrorValue = 1;
										WebElement companyEi = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+tr+"]/td["+td+"]")));
										company[td]=companyEi.getText();
										check = false;
											} catch (org.openqa.selenium.TimeoutException e) {
											
												check = true;
											}
										}
							
									}
					
							}
							
		
						sqls.connectDB();
						companyId = sqls.add_company(company, ListSub[loopIn]);
						check = false;
						sqls.closedb();
						
							
							
							////////////////////////////////////////////////////////////////////////////
						if(companyId>0||companyId!=0){
					
							WebElement selectMoney = null;
								check = true;
								while (check == true) {
									try {
										checkerrorValue = 2;
										selectMoney = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+tr+"]/td[2]/a")));
										check = false;
									} catch (org.openqa.selenium.TimeoutException e) {
										check = true;
										
									}
								}
							selectMoney.click();
							String[] detailcompany = null;
							detailcompany = new String[20];
							for(int row=1;row<=13;++row){
								WebElement detailcompanyEi = null;
								check = true;
								while (check == true) {
									try {
										checkerrorValue = 3;
								detailcompanyEi = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr["+row+"]/td")));
								check = false;
									} catch (org.openqa.selenium.TimeoutException e) {
										check = true;
									}
								}
						Boolean checkGetText =false;
						while(checkGetText==false){
							try{
									detailcompany[row]=detailcompanyEi.getText().toString();
									checkGetText=true;
							}catch(org.openqa.selenium.TimeoutException e){
								checkGetText =false;
							}
						}
							}
							sqls.connectDB();
							sqls.add_detailcompany(companyId, detailcompany);
							sqls.closedb();
							WebElement selecttype2 = null;
							check = true;
							while (check == true) {
								try{
									checkerrorValue = 4;
									selecttype2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[4]/a/dl/dd")));
									selecttype2.click();
									check = false;
								}catch(org.openqa.selenium.TimeoutException e){
							
									check = true;
								}
							}
						
							String[] years;
							years = new String[3];
							String[][][] financeAndDe = new String[3][4][30];
							String[][][] financeAndDe2 = new String[3][4][30];
							check = true;
							WebElement getdataEi1 = null;
							while (check == true) {
								try{
							getdataEi1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[2]")));
							years[0] = getdataEi1.getText().toString();
							check = false;
								}catch(org.openqa.selenium.TimeoutException e){
									
									check = true;
								}
							}
						
							
							for(int five=3;five<=13;++five){
								check = true;
								while (check == true) {
									try {
							//financeAndDe[0][1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
							financeAndDe[0][2][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[1]")).getText().toString());
						//	financeAndDe[0][3][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[2]")).getText().toString());
							if(financeAndDe[0][2][five]!=null||financeAndDe[0][2][five].length()!=0){
								check = false;
							}
						
									}catch(org.openqa.selenium.StaleElementReferenceException e){
								
										check = true;
									}catch(org.openqa.selenium.TimeoutException e){
										
										check = true;
									}
									}
							}
							
							years[1] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[3]")).getText().toString();
							
							for(int five=3;five<=13;++five){
								check = true;
								while (check == true) {
									try {
							//	financeAndDe[1][1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
								financeAndDe[1][2][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[3]")).getText().toString());
							//	financeAndDe[1][3][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[4]")).getText().toString());
				
								if(financeAndDe[1][2][five]!=null||financeAndDe[1][2][five].length()!=0){
									check = false;
								}
							}catch(org.openqa.selenium.StaleElementReferenceException e){
						
								check = true;
							}catch(org.openqa.selenium.TimeoutException e){
								
								check = true;
							}
							}
							}
				
							years[2] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[4]")).getText().toString();
					
							for(int five=3;five<=13;++five){
								check = true;
								while (check == true) {
									try {
							//	financeAndDe[2][1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
								financeAndDe[2][2][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[5]")).getText().toString());
							//	financeAndDe[2][3][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[6]")).getText().toString());
					
								if(financeAndDe[0][2][five]!=null||financeAndDe[2][2][five].length()!=0){
									check = false;
								}
									}catch(org.openqa.selenium.StaleElementReferenceException e){
								
										check = true;
									}catch(org.openqa.selenium.TimeoutException e){
										
										check = true;
									}
									}
							}
							
							//////////////////////////////////////////////////////////////////////////////
							check = true;
							while (check == true) {
								try{
									checkerrorValue = 5;
							WebElement selecttypeInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/input[2]")));
						
							selecttypeInput.click();
							check = false;
							
								}catch(org.openqa.selenium.TimeoutException e){
									
									check = true;
								}
							}
		
							for(int five=3;five<=12;++five){
								check = true;
								while (check == true) {
								try{
								//	financeAndDe2[0][1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
									financeAndDe2[0][2][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[1]")).getText().toString());
								//	financeAndDe2[0][3][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[2]")).getText().toString());
				
									if(financeAndDe2[0][2][five]!=null||financeAndDe2[0][2][five].length()!=0){
										check = false;
									}
								}catch(org.openqa.selenium.StaleElementReferenceException e){
									check = true;
								}catch(org.openqa.selenium.TimeoutException e){
									
									check = true;
								}
								}
							}
							

							
				//			years[1] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[3]")).getText().toString();
							
							for(int five=3;five<=12;++five){
								check = true;
								while (check == true) {
									try {
									//	financeAndDe2[1][1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
										financeAndDe2[1][2][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[3]")).getText().toString());
									//	financeAndDe2[1][3][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[4]")).getText().toString());
					
										if(financeAndDe2[1][2][five]!=null||financeAndDe2[1][2][five].length()!=0){
											check = false;
										}
							}catch(org.openqa.selenium.StaleElementReferenceException e){
						
								check = true;
							}catch(org.openqa.selenium.TimeoutException e){
								
								check = true;
							}
							}
							}
						
				//			years[2] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[4]")).getText().toString();
					
							for(int five=3;five<=12;++five){
								check = true;
								while (check == true) {
									try {
									//	financeAndDe2[2][1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
										financeAndDe2[2][2][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[5]")).getText().toString());
									//	financeAndDe2[2][3][five] = cutComma(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[6]")).getText().toString());
										if(financeAndDe2[2][2][five]!=null||financeAndDe2[2][2][five].length()!=0){
											check = false;
										}
									}catch(org.openqa.selenium.StaleElementReferenceException e){
								
										check = true;
									}catch(org.openqa.selenium.TimeoutException e){
										
										check = true;
									}
									}
							}
							
							sqls.add_finance(companyId, years,financeAndDe,financeAndDe2);
							printStr(">> addData finance group  "+ListSub[loopIn].substring(0, 5)+" Data Budgeting Year = "+years[0]+","+years[1]+","+years[2]+" Complete!");
							printStr("----------------- \n");
				
						
							driver.navigate().back();
						
							driver.navigate().back();
							companyId = 0;
						
						}
						cheErrorAdd = false;
						checkerrorValue = 99;
						}catch(org.openqa.selenium.StaleElementReferenceException e){
							tr--;
							
							check = true;
							
						
							companyId = 0;
							if(checkerrorValue==3&&checkerrorValue!=99){
								driver.navigate().back();

							}else if(checkerrorValue>3&&checkerrorValue!=99){
								driver.navigate().back();
								
								driver.navigate().back();
							}
						}catch(org.openqa.selenium.TimeoutException e){
							tr--;
							check = true;
							
							companyId = 0;
							if(checkerrorValue==3&&checkerrorValue!=99){
								driver.navigate().back();

							}else if(checkerrorValue>3&&checkerrorValue!=99){
								driver.navigate().back();
								
								driver.navigate().back();
							}
						}
								
						}
					} 
							list=list-10;
							if(list<0){
								list=list*-1;
							}
					
								if(list<10){
									trvalue=list;
								
								}	
						
							
					}
					
					printStr("Group : "+ListSub[loopIn].substring(0, 5)+" Get All Data Complete!");
					printStr("-------------------------------------------------------------------\n");
					
					///////////////////////////////////////////////////
					
				}else{
					printStr(">> Not found : "+ListSub[loopIn].substring(0, 5)+" Group "+allgroupList[loopOut].substring(0, 1));
			
					try {
					    
					
					WebElement companyEi = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ui-button-text")));
		
					companyEi.click();
					} catch (Exception e) {
					    driver.get("http://datawarehouse.dbd.go.th/bdw/search/search2.html");
					    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")));
					    
					}
				}
				
			}
			
			//
		
		
		
		}
	}
		} catch (Exception e) {
			printStr("Can't To Open");
			e.printStackTrace();
			
		}
		}catch(Exception e){
			printStr(">> Can't Connect To DataBase");
		}
		
	}
	private static int countlist(String a)
	{
		String subcha=null;
		int list;
		subcha= a.substring(a.indexOf(" ")+1, a.indexOf(" ราย"));
		list=java.lang.Integer.parseInt(cutComma(subcha));
		printStr(">> AllData Record = "+list);
		String result = "";
		String result2 = "";
	if(subcha.length()>=5){
			
			result = a.substring(2,a.length());
			result2 = a.substring(0,a.length()-4);
			list=java.lang.Integer.parseInt(result2+result);
		}
		return list;
	}


	private static int countpage(String a)
	{	
		String subp="";
		int page;
		int index3=a.indexOf("จำนวนหน้าทั้งหมด : ");	
		int index4=a.indexOf(" หน้า");

		subp= a.substring(index3+19, index4);

		page=java.lang.Integer.parseInt(subp);

		return page;
	}
	
	public static void printStr(String massage){
		System.out.println(massage);
	}
	public static void printStr(int massage){
		System.out.println(massage);
	}
	   public static String cutComma(String str) {
	    	if(str.indexOf(",") != -1){
	    		str = str.replaceAll(",",""); 
	    	}
	    	return str;
			
		}
}
