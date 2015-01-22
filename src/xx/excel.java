package xx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import xx.ReadWriteExcel;

import java.lang.AssertionError;
import java.lang.NumberFormatException;
import java.lang.NullPointerException;


public class excel 
{

	private static final HSSFCell Integer = null;
	private static int xRows;
	private static int xCols;
	private static String[][] xData;
	private static boolean String;

	public static void main(String[] args) throws Exception 
	{
		//String Test = "121321.5";
		//double Test1 = Double.parseDouble(Test);
		//System.out.println(Test1);
		
		// Config Program Value
		int StartReadCellRow=2;
		int StopReadCellRow=23;
		String ReadOrderFromFile="listSelect.xls";
		String OutputToFile="chiangrai_2-23.xls";
		// ====================
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("Begin Start Process");
		int r=2,c=1,rx=2,cx=1;
		int r2,c2,i,z;
		int n,m=4,tr=1;
		int cx1,cx2,cx3;
		String SelectGroup="",SelectGroupNum="";
		String text10="";	
		String text2="";
		String sum="";
		String textP="";
		String readfunction;
		String change1, change2;
		int error=0;
		double number1;
		double num2;
		
		System.out.println(readrow(ReadOrderFromFile));
		
//		System.out.println(readdata(ReadOrderFromFile,3,0));
//		System.out.println(writecell(ReadOrderFromFile,5,2,"1"));

		WebDriver driver= new FirefoxDriver();
		ReadWriteExcel excel1 = new ReadWriteExcel();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		//อ่านจาก excel
		FileInputStream readfile=new FileInputStream(ReadOrderFromFile);
		HSSFWorkbook readfile1=new HSSFWorkbook(readfile);
		HSSFSheet readsheet=readfile1.getSheetAt(0);
		
//		System.out.println(checkfilewrite(OutputToFile));
//		if (checkfilewrite(OutputToFile)==false)
	//	{
		
		try
		{
			rx=(readrow(OutputToFile));
		}
		catch(NullPointerException e)
		{
			
		}
		catch(IOException e)
		{
			
		}
		catch(IllegalArgumentException e)
		{
			
		}
		//เขียนลง excel
		FileOutputStream writefile=new FileOutputStream(new File(OutputToFile)); 
		HSSFWorkbook writefile1=new HSSFWorkbook();
		HSSFSheet writesheet=writefile1.createSheet();
		HSSFSheet writesheet1=writefile1.createSheet();
		HSSFSheet writesheet2=writefile1.createSheet();
		HSSFSheet writesheet3=writefile1.createSheet();
		
		//เขียนหัวใน excel งบกำไรขาดทุน
		int j1,j2,j3,j4;
		int i1,i2,i3,i4;
		String a1[] = new String[20];
		String a2[] = new String[60];
		String a3[] = new String[70];
		String a4[] = new String[70];
		
		//sheet0
		a1[0]="ลำดับที่";
		a1[1]="เลขนิติบุคคล";
		a1[2]="ชื่อนิติบุคคล";
		a1[3]="รหัสหมวดธุรกิจ";
		a1[4]="รายละเอียด";
		a1[5]="ภาค";
		a1[6]="จังหวัด";
		a1[7]="เขต/อำเภอ";
		a1[8]="แขวง/ตำบล";
		a1[9]="รายได้(บาท)";
		a1[10]="กำไรสุทธิ(บาท)";
		a1[11]="สินทรัพย์(บาท)";
		a1[12]="ทุนจดทะเบียน(บาท)";
		//ผลการค้นหา
		HSSFRow writerow=writesheet.createRow(1);
		i1=0;
		for(j1=1;j1<20;j1++)
		{
			HSSFCell writecell=writerow.createCell(j1);
			writecell.setCellValue(a1[i1]);
			i1++;
			
		}
		
		//sheet1
		a2[0]="ประเภทนิติบุคคล";
		a2[1]="วันที่จดทะเบียน";
		a2[2]="สถานะนิติบุคคล";
		a2[3]="ทุนจดทะเบียน(บาท)";
		a2[4]="ที่ตั้ง";
		a2[5]="หมวดธุรกิจ";
		a2[6]="วัตถุประสงค์";
		a2[7]="ปีที่ส่งงบการเงิน";
		a2[8]="คณะกรรมการ";
		a2[9]="คณะกรรมการลงชื่อผูกพัน";
		a2[10]="โทรศัพท์";
		a2[11]="โทรสาร";
		a2[12]="ข้อควรทราบ";
		
		//ข้อมูลบริษัท
		i2=0;
		HSSFRow writerow1=writesheet1.createRow(1);
		for(j2=1;j2<=13;j2++)
		{
			HSSFCell writecell1=writerow1.createCell(j2);
			writecell1.setCellValue(a2[i2]);
			i2++;
		}

		
		//sheet2
		a3[1]="ลูกหนี้การค้าสุทธิปี 54";
		a3[2]="% การเปลี่ยนแปลง";
		a3[3]="ลูกหนี้การค้าสุทธิปี 55";
		a3[4]="% การเปลี่ยนแปลง";
		a3[5]="ลูกหนี้การค้าสุทธิปี 56";
		a3[6]="% การเปลี่ยนแปลง";
		a3[7]="สินค้าคงเหลือปี 54";
		a3[8]="% การเปลี่ยนแปลง";
		a3[9]="สินค้าคงเหลือปี 55";
		a3[10]="% การเปลี่ยนแปลง";
		a3[11]="สินค้าคงเหลือปี 56";
		a3[12]="% การเปลี่ยนแปลง";
		a3[13]="สินทรัพย์หมุนเวียนปี 54";
		a3[14]="% การเปลี่ยนแปลง";
		a3[15]="สินทรัพย์หมุนเวียนปี 55";
		a3[16]="% การเปลี่ยนแปลง";
		a3[17]="สินทรัพย์หมุนเวียนปี 56";
		a3[18]="% การเปลี่ยนแปลง";
		a3[19]="ที่ดิน อาคารและอุปกรณ์ปี 54";
		a3[20]="% การเปลี่ยนแปลง";
		a3[21]="ที่ดิน อาคารและอุปกรณ์ปี 55";
		a3[22]="% การเปลี่ยนแปลง";
		a3[23]="ที่ดิน อาคารและอุปกรณ์ปี 56";
		a3[24]="% การเปลี่ยนแปลง";
		a3[25]="สินทรัพย์ไม่หมุนเวียนปี 54";
		a3[26]="% การเปลี่ยนแปลง";
		a3[27]="สินทรัพย์ไม่หมุนเวียนปี 55";
		a3[28]="% การเปลี่ยนแปลง";
		a3[29]="สินทรัพย์ไม่หมุนเวียนปี 56";
		a3[30]="% การเปลี่ยนแปลง";
		a3[31]="สินทรัพย์รวมปี 54";
		a3[32]="% การเปลี่ยนแปลง";
		a3[33]="สินทรัพย์รวมปี 55";
		a3[34]="% การเปลี่ยนแปลง";
		a3[35]="สินทรัพย์รวมปี 56";
		a3[36]="% การเปลี่ยนแปลง";
		a3[37]="หนี้สินหมุนเวียนปี 54";
		a3[38]="% การเปลี่ยนแปลง";
		a3[39]="หนี้สินหมุนเวียนปี 55";
		a3[40]="% การเปลี่ยนแปลง";
		a3[41]="หนี้สินหมุนเวียนปี 56";
		a3[42]="% การเปลี่ยนแปลง";
		a3[43]="หนี้สินไม่หมุนเวียนปี 54";
		a3[44]="% การเปลี่ยนแปลง";
		a3[45]="หนี้สินไม่หมุนเวียนปี 55";
		a3[46]="% การเปลี่ยนแปลง";
		a3[47]="หนี้สินไม่หมุนเวียนปี 56";
		a3[48]="% การเปลี่ยนแปลง";
		a3[49]="หนี้สินรวมปี 54";
		a3[50]="% การเปลี่ยนแปลง";
		a3[51]="หนี้สินรวมปี 55";
		a3[52]="% การเปลี่ยนแปลง";
		a3[53]="หนี้สินรวมปี 56";
		a3[54]="% การเปลี่ยนแปลง";
		a3[55]="ส่วนของผู้ถือหุ้นปี 54";
		a3[56]="% การเปลี่ยนแปลง";
		a3[57]="ส่วนของผู้ถือหุ้นปี 55";
		a3[58]="% การเปลี่ยนแปลง";
		a3[59]="ส่วนของผู้ถือหุ้นปี 56";
		a3[60]="% การเปลี่ยนแปลง";
		a3[61]="หนี้สินรวมและส่วนของผู้ถือหุ้นปี 54";
		a3[62]="% การเปลี่ยนแปลง";
		a3[63]="หนี้สินรวมและส่วนของผู้ถือหุ้นปี 55";
		a3[64]="% การเปลี่ยนแปลง";
		a3[65]="หนี้สินรวมและส่วนของผู้ถือหุ้นปี 56";
		a3[66]="% การเปลี่ยนแปลง";
		
		//งบแสดงสถานะการเงิน
		HSSFRow writerow2=writesheet2.createRow(1);
		i3=1;
		for(j3=1;j3<70;j3++)
		{
			HSSFCell writecell2=writerow2.createCell(j3);
			writecell2.setCellValue(a3[i3]);
			i3++;
		}
		
		//sheet3
		a4[0]="รายได้หลักปี 54";
		a4[1]="% การเปลี่ยนแปลง";
		a4[2]="รายได้หลักปี 55";
		a4[3]="% การเปลี่ยนแปลง";
		a4[4]="รายได้หลักปี 56";
		a4[5]="% การเปลี่ยนแปลง";
		a4[6]="รายได้รวมปี 54";
		a4[7]="% การเปลี่ยนแปลง";
		a4[8]="รายได้รวมปี 55";
		a4[9]="% การเปลี่ยนแปลง";
		a4[10]="รายได้รวมปี 56";
		a4[11]="% การเปลี่ยนแปลง";
		a4[12]="ต้นทุนขายปี 54";
		a4[13]="% การเปลี่ยนแปลง";
		a4[14]="ต้นทุนขายปี 55";
		a4[15]="% การเปลี่ยนแปลง";
		a4[16]="ต้นทุนขายปี 56";
		a4[17]="% การเปลี่ยนแปลง";
		a4[18]="กำไร(ขาดทุน)ขั้นต้นปี 54";
		a4[19]="% การเปลี่ยนแปลง";
		a4[20]="กำไร(ขาดทุน)ขั้นต้นปี 55";
		a4[21]="% การเปลี่ยนแปลง";
		a4[22]="กำไร(ขาดทุน)ขั้นต้นปี 56";
		a4[23]="% การเปลี่ยนแปลง";
		a4[24]="ค่าใช้จ่ายในการขายและบริการปี 54";
		a4[25]="% การเปลี่ยนแปลง";
		a4[26]="ค่าใช้จ่ายในการขายและบริการปี 55";
		a4[27]="% การเปลี่ยนแปลง";
		a4[28]="ค่าใช้จ่ายในการขายและบริการปี 56";
		a4[29]="% การเปลี่ยนแปลง";
		a4[30]="รายจ่ายรวมปี 54";
		a4[31]="% การเปลี่ยนแปลง";
		a4[32]="รายจ่ายรวมปี 55";
		a4[33]="% การเปลี่ยนแปลง";
		a4[34]="รายจ่ายรวมปี 56";
		a4[33]="% การเปลี่ยนแปลง";
		a4[35]="ดอกเบี้ยจ่ายปี 54";
		a4[36]="% การเปลี่ยนแปลง";
		a4[37]="ดอกเบี้ยจ่ายปี 55";
		a4[38]="% การเปลี่ยนแปลง";
		a4[39]="ดอกเบี้ยจ่ายปี 56";
		a4[40]="% การเปลี่ยนแปลง";
		a4[41]="กำไร(ขาดทุน7)ก่อนภาษีปี 54";
		a4[42]="% การเปลี่ยนแปลง";
		a4[43]="กำไร(ขาดทุน)ก่อนภาษีปี 55";
		a4[44]="% การเปลี่ยนแปลง";
		a4[45]="กำไร(ขาดทุน)ก่อนภาษีปี 56";
		a4[46]="% การเปลี่ยนแปลง";
		a4[47]="ภาษีเงินได้ปี 54";
		a4[48]="% การเปลี่ยนแปลง";
		a4[49]="ภาษีเงินได้ปี 55";
		a4[50]="% การเปลี่ยนแปลง";
		a4[51]="ภาษีเงินได้ปี 56";
		a4[52]="% การเปลี่ยนแปลง";
		a4[53]="กำไร(ขาดทุน)สุทธิปี 54";
		a4[54]="% การเปลี่ยนแปลง";
		a4[55]="กำไร(ขาดทุน)สุทธิปี 55";
		a4[56]="% การเปลี่ยนแปลง";
		a4[57]="กำไร(ขาดทุน)สุทธิปี 56";
		a4[58]="% การเปลี่ยนแปลง";
		
		//งบกำไรขาดทุน
		HSSFRow writerow3=writesheet3.createRow(1);
		i4=0;
		for(j4=1;j4<70;j4++)
		{
			HSSFCell writecell3=writerow3.createCell(j4);
			writecell3.setCellValue(a4[i4]);
			i4++;
		}
//		writefile1.write(writeheadfile);
//		writeheadfile.close();
//		}
		
/*		rx=(readrow(OutputToFile));
		FileOutputStream writefile=new FileOutputStream(new File(OutputToFile)); 
		HSSFWorkbook writefile1=new HSSFWorkbook();
		HSSFSheet writesheet=writefile1.createSheet();
		HSSFSheet writesheet1=writefile1.createSheet();
		HSSFSheet writesheet2=writefile1.createSheet();
		HSSFSheet writesheet3=writefile1.createSheet();
*/	
		driver.get("http://datawarehouse.dbd.go.th/bdw/home/login.html");
		driver.findElement(By.name("userName")).sendKeys("natta121@gmail.com");
		driver.findElement(By.name("userPassword")).sendKeys("0897554452");
		driver.findElement(By.name("captchaText")).getSize();		
		System.out.println(driver.findElement(By.name("captchaText")).getText().toString().length());
		

	
//				private static char[] writecell(String readOrderFromFile, int row, int col,
//			int i) {
		// TODO Auto-generated method stub
//		return null;
//	}
				//Thread.sleep(10000);
				//driver.findElement(By.xpath("html/body/form/div[2]/div/div/center/button")).click();
				
				//driver.findElement(By.xpath("html/body/form/div[2]/div/div/center/button")).sendKeys(Keys.ENTER);
				//input.sendKeys(Keys.ENTER);
				
				
		try
		{
				
			WebDriverWait wait55 = new WebDriverWait(driver, 60);
			WebElement element55 = wait55.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")));
			
		}
		catch(TimeoutException e)
		{
			driver.close();
			error = 1;
		}
		try
		{
		driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")).click();
		}
		catch(NoSuchElementException e)
		{
			
		}
		if (error!=1)
		{

			int count = (readrow(ReadOrderFromFile));
			for (i=1; i<=(count-1); i++)
			{	
				readfunction = readdata(ReadOrderFromFile,i,2);
				System.out.println("---"+readfunction+"----");
				
				if (readfunction == null || readfunction.equals(""))
				{
					readfunction = "0";
				}
				
				if (java.lang.Integer.parseInt(readfunction) != 1)
				{
					SelectGroupNum = (readdata(ReadOrderFromFile,i,0));
					SelectGroup = (readdata(ReadOrderFromFile,i,1));
					
					//เลือกกลุ่มธุรกิจ G,J
					WebDriverWait waittt=new WebDriverWait(driver,60);
					WebElement elementtt=waittt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")));
					driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")).click();
					
					int er=1;
					WebDriverWait wait10=new WebDriverWait(driver,60);
					WebElement element10=wait10.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[1]/td/select")));
					Select select = new Select (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[1]/td/select")));
					//select.selectByValue("J"); //เลือกค่ากลุ่มธุรกิจ J

					System.out.println("This is i = "+i);
					System.out.println("Select Group = "+SelectGroup);
					
					while(er==1)
					{
					//int no1=0;
						er=0;
						
						try
						{
							
							select.selectByValue(SelectGroup);
						}
						catch(NoSuchElementException e)
						{	
							er=1;
							//driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[1]/td/select")).click();	
						}
					}				
					//if (no1==0)
					//{
					//	driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[1]/td/select")).click();
					//}
					//else{
				
					//Thread.sleep(3000);
					//int no2=0;
					int err=1;
					WebDriverWait wait00 = new WebDriverWait(driver,60);
					WebElement element00 = wait00.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[2]/td/select/option[5]")));
					Select select2 = new Select (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[2]/td/select")));
					System.out.println("Select NUMMMMM Group = "+SelectGroupNum);
					while(err==1)
					{
						
						try
						{
							err=0;
						//	select2.selectByValue(Double.toString(readcell.getNumericCellValue()).substring(0,5));
							select2.selectByValue(SelectGroupNum);
						}
						catch(NoSuchElementException e)
						{
							err=1;
							//driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[2]/td/select")).click();	
						}
					}
					
					
				
					//เลือกหมวดธุรกิจ
					
					
					
					
					//if (no2==0)
					//{
					//	driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[2]/td/select")).click();	
					//}
					//else{
					
					//Thread.sleep(2000);
					//int no3=0;
					int error1=1;
					WebDriverWait wait9=new WebDriverWait(driver,60);
					WebElement element9=wait9.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[3]/td/select")));
					Select select3 = new Select (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[3]/td/select")));
					
					while(error1==1)
					{
						
						try
						{
							error1=0;
							select3.selectByValue("N");// ภาคกลาง
							//select3.selectByValue("C");// ภาคกลาง
						}
						catch(TimeoutException e)
						{
							error1=1;
							//driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[3]/td/select")).click();	
						}
					}
					
					
					
					//if (no3==0)
					//{
					//	driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[3]/td/select")).click();	
					//}
					//else{
					
					
					
					//เลือกจังหวัด
					//Thread.sleep(1000);
					//int no4=0;
					int error2=1;
					WebDriverWait wait=new WebDriverWait(driver,60);
					WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[4]/td/select/option[6]")));
					Select select4 = new Select (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[4]/td/select")));
					while(error2==1)
					{
					
						try
						{
							error2=0;
							
							//select4.selectByValue("13"); //ปทุมธานี
							
							//ภาคเหนือ
							select4.selectByValue("50"); //เชียงใหม่
							//select4.selectByValue("57");  //เชียงราย 
							//select4.selectByValue("54");  //แพร่
						}
						
						catch(NoSuchElementException e)
						{
							error2=1;
							//driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[4]/td/select")).click();
						}
					}
					
					
					
					
					
					
					//if (no4==0)
					//{
					//	driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[4]/td/select")).click();	
					//}
					//else{
						
					
					//เลือก ปีงบการเงิน
					//int no5=0;
					try
					{
						WebDriverWait wait11=new WebDriverWait(driver,60);
						WebElement element11=wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[8]/td/select")));
						Select select5 = new Select (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[8]/td/select")));
						select5.selectByValue("2555"); 
					}
					catch(TimeoutException e)
					{
						
						//driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[8]/td/select")).click();
					}
					//if(no5==0)
					//{
					//	driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[8]/td/select")).click();
					//}
					//else{
						
					
					//กดปุ่ม ค้นหา
					Thread.sleep(3000);
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/center/button")).click();
					
					
					
					int notfound=0;
					try
					{
						System.out.println("wait button object");
						WebDriverWait wait1=new WebDriverWait(driver,20);
						WebElement element1=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[5]/div[11]/div/button")));
					}
					catch(TimeoutException e)
					{
						notfound=1;
					}
					
					if(notfound==0)
					{
						System.out.println("..........................no information");
						writecell(ReadOrderFromFile,i,2,"1");
						System.out.println("เขียน 1 จาก no info");
						driver.findElement(By.xpath("html/body/div[5]/div[11]/div/button")).click();
						//writefile.close();
						//System.out.println("ปิดฟายยยยยย จาก no info");
					}
					else
					{
						
								
						WebDriverWait wait2=new WebDriverWait(driver,120);
						WebElement element2=wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")));
						textP= driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")).getText();	
						System.out.println(textP);
						System.out.println("เจอข้อมูลแล้วนะ");	
						
						int checkpage=countpage(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")).getText());
						System.out.println("Found " + checkpage + " page(s)");
						int checklist=countlist(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")).getText());
						System.out.println("Found " + checklist + " list(s)");
						
/*						try
						{
							rx=(readrow(OutputToFile));
						}
						catch(NullPointerException e)
						{
							
						}
						catch(IOException e)
						{
							
						}
						FileOutputStream writefile=new FileOutputStream(new File(OutputToFile)); 
						HSSFWorkbook writefile1=new HSSFWorkbook();
						HSSFSheet writesheet=writefile1.createSheet();
						HSSFSheet writesheet1=writefile1.createSheet();
						HSSFSheet writesheet2=writefile1.createSheet();
						HSSFSheet writesheet3=writefile1.createSheet();
*/						
						
						abc:
						for(n=1;n<=checkpage;n++)
						{	
							
							//System.out.println(readrow(OutputToFile));
							//System.out.println("counttttttttlist"+countlist(text10));
							System.out.println("Loop page");
							//WebDriverWait wait1=new WebDriverWait(driver,3600);
							//WebElement element1=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+r+"]/td["+c+"]/a")));					
							//rx=(readrow(OutputToFile)+1);
							for(r=2;r<=11;r++)
							{	
								System.out.println("rx======================="+rx);
								System.out.println("checklist free="+checklist+2);
								HSSFRow writeroww=writesheet.createRow(rx);
								tr++;
								System.out.println("Page="+n);
								System.out.println("Loop row"+(r-1));
								cx=1;
								
								
								for(c=1;c<=13;c++)
								{
									System.out.println("Loop col"+ c);
									
									int error555=1;
									while(error555==1)
									{
										try
										{
											error555=0;
											WebDriverWait wait1=new WebDriverWait(driver,200);
											WebElement element1=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+r+"]/td["+c+"]/a")));
										}
										catch(NoSuchElementException e)
										{
											error555=1;
										}
										catch (TimeoutException e)
										{
											error555=1;
										}
									}
									sum = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+ r +"]/td["+ c +"]/a")).getText();
									System.out.println(sum);	
									HSSFCell writecell=writeroww.createCell(cx);
									//row.createCell(ce).setCellValue(sum);
									writecell.setCellValue(sum);
									cx++;
								}
								
								//ข้อมูลทั่วไป
								//WebDriver driver1= new FirefoxDriver();
								//CharSequence href = null;
								//System.out.println(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+ tr +"]/td[2]/a")).getAttribute("href"));
								//driver1.get(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+ tr +"]/td[2]/a")).getAttribute("href"));
								//driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+ tr +"]/td[2]/a")).getLocation();
								//System.out.println(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+ tr +"]/td[2]/a")).getLocation().toString());
								driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+ r +"]/td[2]/a")).click();
								
								try
								{
									WebDriverWait wait1=new WebDriverWait(driver,36000);
									WebElement element1=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[2]/h2/cufon/canvas")));			
								}
								catch(TimeoutException e)
								{
									System.out.println("Error 1");
									
								}
								//ข้อมูลบริษัท
								cx1=1;
								HSSFRow writerow11=writesheet1.createRow(rx);
								for(z=1;z<=13;z++)
								{	
									try
									{
										WebDriverWait wait1=new WebDriverWait(driver,36000);
										WebElement element1=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr[13]/th")));
										
										// text1 = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr["+ i +"]/th")).getText();
										//System.out.println(text1);
										//HSSFCell writecell1=writerow1.createCell(cx1);
										//row.createCell(ce).setCellValue(sum);
										//writecell1.setCellValue("row ="+ i +" col = "+cx1 +" ==> "+text1);
										//row.createCell(ce).setCellValue(sum);
										text2 = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr["+ z +"]/td")).getText();
							//			change1 = text2;
							//			change2 = String.valueOf(change1);
										try 
										{
							//		        String.valueOf(change2);
									        System.out.println("...........................ข้อมูลบริษััท = String...........................");
									    } 
									    catch (NumberFormatException nfe) 
									    {
							//		    	System.out.println("!!!!!!!!!!!!!!! ข้อมูลบริษััท = Not String !!!!!!!!!!!!!!!");
									    }
									}	
									catch(TimeoutException e)
									{
										System.out.println("Error 2");
									}
		
									HSSFCell writecell1=writerow11.createCell(cx1);
									System.out.println(text2);
									writecell1.setCellValue(text2);
									cx1++;
								}
								
								//ข้อมูลเปรียบเทียบปีงบประมาณ
								driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[4]/a/dl/dd")).click();
								try
								{
									WebDriverWait wait8=new WebDriverWait(driver,36000);
									WebElement element8=wait8.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/h2/cufon/canvas")));	
								}
								catch(TimeoutException e)
								{
									System.out.println("Error 3");
								}
								
								cx2=1;
								HSSFRow writerow22=writesheet2.createRow(rx);
								
								for(r2=3;r2<=13;r2++)
								{	
									//งบแสดงสถานะการเงิน
									for(c2=1;c2<=6;c2++)
									{
										try
										{
											WebDriverWait wait1=new WebDriverWait(driver,36000);
											WebElement element1=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[13]/td[6]")));
											//Thread.sleep(100);
											String text6 = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+ r2 +"]/td["+ c2 +"]")).getText();
											//double Test1 = Double.parseDouble(text6);
											 text6 = text6.replaceAll(",","");
											 //double Test1 = Double.parseDouble(text6);
											//int num1 = new Integer(text6).intValue();
											//String str = text6;
											//Double num1 = Double.parseDouble(text6);
											//Double num1 = Double.valueOf(text6);
											//number1 = num1.doubleValue();
											//Double num1 = new Double(text6);
											 
											double num1 = Double.valueOf(text6.trim()).doubleValue();
											 
											
											System.out.print(num1 + "  ");
											HSSFCell writecell2=writerow22.createCell(cx2, HSSFCell.CELL_TYPE_NUMERIC);
											//row.createCell(ce).setCellValue(sum);
											writecell2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
											writecell2.setCellValue(num1);
											 
											
											cx2++;


										//		if (num1 == Math.round(num1)) {
										//			System.out.println("Double");
										//			} else 
										//			{
										//				System.out.println("Not double");
										//			}

											try
											{
										        Double.valueOf(num1);
										        System.out.println("Double");
										    } 
											catch (NumberFormatException nfe) 
										    {
										    	System.out.println("Not double");
										    }
											
										}
										catch(TimeoutException e)
										{
											System.out.println("Error 7");
										}
									}
									System.out.println("");
								}
								System.out.println("");
								
								
								
								//งบกำไรขาดทุน
								
								driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/input[2]")).click();
								try
								{
									WebDriverWait wait3=new WebDriverWait(driver,36000);
									WebElement element3=wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[12]/td[6]")));
								}
								catch(TimeoutException e)
								{
									System.out.println("Error 8");
								}
								
								cx3=1;
								HSSFRow writerow33=writesheet3.createRow(rx);
								
								for(r2=3;r2<=12;r2++)
								{	
									//งบกำไรขาดทุน
									
									for(c2=1;c2<=6;c2++)
									{
										
										WebDriverWait wait1=new WebDriverWait(driver,60);
										
										try
										{
											WebElement element1=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+ r2 +"]/td["+ c2 +"]")));
										}
										catch(TimeoutException e)
										{
											System.out.println("Error 12");
										}
										
										driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); 
											
										int error22=1;
										WebDriverWait waittt22=new WebDriverWait(driver,60);
										WebElement elementtt22=waittt22.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/h2/cufon/canvas")));
										
										while(error22==1)
										{
											
											try
											{
												error22=0;						
												text10=driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+ r2 +"]/td["+ c2 +"]")).getText();
											}
												
											catch(NoSuchElementException e)
											{
												error22=1;	
											}
											catch(StaleElementReferenceException ee)
											{
												error22=1;	
											}
										}
										
										//	int error22=1;
										//	WebDriverWait waittt22 = new WebDriverWait(driver, 10);
									    //  Wait for search to complete	
										//	waittt22.until(new ExpectedCondition<Boolean>() {
										//       public Boolean apply(WebDriver webDriver){
										//          System.out.println("Searching...");
										//          return webDriver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/h2/cufon/canvas")) !=null;
										//          }});
										/* 
										int limit = 5 ;  //waiting limit in seconds
									    double inc = 0.5 ;  //in seconds; sleep for 500ms
									    c = 0;
									    while (c==1)
									    {
									        try
									        {
									            System.out.print("Waiting... ");
									            driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/h2/cufon/canvas"));
									            System.out.print("Found!");
									        }
									        catch(NoSuchElementException e)
											{
												c=0;	
											}
										}
									              
										//String check =null;
										//do{text10=driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+ r2 +"]/td["+ c2 +"]")).getText();}
										//while (!check.equals(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/h2/cufon/canvas")));
										//driver.manage().timeouts().setScriptTimeout(15,TimeUnit.SECONDS);
										//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
										//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
										//Functions.waitForPageLoaded(driver);
										//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										/*	
										int error22=0;
										WebDriverWait waittt22=new WebDriverWait(driver,60);
																					
										try
										{
											WebElement elementtt22=waittt22.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/input[2]")));
										}
											
										catch(NoSuchElementException e)
										{
											error22=1;	
										}
										if (error22==0)
										{
											String page = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/h3/cufon[1]/canvas")).getText();
											System.out.println(page);
										}
										else
										{
											text10=driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+ r2 +"]/td["+ c2 +"]")).getText();
										}
										 */						
										Thread.sleep(500);
										//driver.waitForPageToLoad("60000");
										text10="";
										while(text10.length()==0)
										{					
											
								
											text10=driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+ r2 +"]/td["+ c2 +"]")).getText();

											
											System.out.println(text10.length()+"textttttttttttttttttt10000000000000000000=========a"+text10+"b==========");
											if (text10.length()==0)
											{
												Thread.sleep(500);
											}
											
										}
										text10 = text10.replaceAll(",","");
										System.out.println("text 10 = " +text10);
										num2 = Double.valueOf(text10.trim()).doubleValue();
										System.out.println(num2);
										
										
										// double Test2 = Double.parseDouble(text10);
										//int num2 = new Integer(text10).intValue();
										//Double num2 = Double.parseDouble(text10);
										//Double num2 = Double.valueOf(text10.trim());
										
										
										System.out.print(num2 + "  ");
										HSSFCell writecell3=writerow33.createCell(cx3);
										//row.createCell(ce).setCellValue(sum);
										writecell3.setCellType(Cell.CELL_TYPE_BLANK);
										writecell3.setCellValue(num2);

										
										try 
										{
									        Double.valueOf(num2);
									        System.out.println("Double");
									    } 
										catch (NumberFormatException nfe) 
										{
									    	System.out.println("Not double");
									    }	
									
										}
									System.out.println("");
								
								}
								
								//การกด back
								driver.navigate().back();
								driver.navigate().back();
								rx++;
								System.out.println("OK");
								checklist--;
								if(checklist==0)
								{
									break abc;
								}
								
							}
									
							if(checklist>0)
							{
								try
								{
									WebDriverWait wait1=new WebDriverWait(driver,60);
									WebElement element1=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")));
								}
								catch(TimeoutException e)
								{
									
								}
								System.out.println("next page="+(m-2));
								System.out.println("checkpage="+checkpage+"  m-2="+(m-2));
								WebDriverWait wait1=new WebDriverWait(driver,60);
								WebElement element1=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/ul/li["+ (checkpage+2) +"]/a")));
								try
									{
									WebDriverWait waitpagenum=new WebDriverWait(driver,60);
									WebElement elementpagenum=waitpagenum.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/ul/li["+ m +"]/a")));
									driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/ul/li["+ m +"]/a")).click();
									m++;
									}
								catch(TimeoutException e)
								{
									
								}
							}
							
							//writefile1.write(writefile);
							//writefile.close();
						}
						
						//rx = readrow (OutputToFile);	
						
						try
						{
						writefile1.write(writefile);
						writefile.close();
						System.out.println("ปิดและเขียนฟายยยยยยยยยยแบ๊วววววววววววว");
						Thread.sleep(60000);
						}
						catch(IOException e)
						{
						
						}
						writecell(ReadOrderFromFile,i,2,"1");
						System.out.println("เขียน 1 แบ๊วววววววววววว");
						
					}
					
				}	
				
				
				System.out.println("i = "+i+ "count = "+count);
			}
			
			
		//	writefile1.write(writefile);
			
			driver.close();
			System.out.println("end");
		}
	}


	public static int countlist(String a)
	{
		String subcha=null;
		int list;
		subcha= a.substring(a.indexOf(" ")+1, a.indexOf(" ราย"));
		list=java.lang.Integer.parseInt(subcha);
		System.out.println("list = "+list);
		return list;
	}

	public static int countpage(String a)
	{	
		String subp="";
		int page;
		int index3=a.indexOf("จำนวนหน้าทั้งหมด : ");	//43
		int index4=a.indexOf(" หน้า");
		System.out.println(index3+19); //จำนวนหน้าทั้งหมด : 43+1
		System.out.println(index4);		// หน้า 46
		subp= a.substring(index3+19, index4);
		System.out.println(subp);
		page=java.lang.Integer.parseInt(subp);
		System.out.println("page = "+page);
		return page;
	}


	public static int readrow (String Excel_File) throws IOException
	{
		int x = 1;
		
		FileInputStream readfile=new FileInputStream(Excel_File);
		HSSFWorkbook readfile1=new HSSFWorkbook(readfile);
		HSSFSheet readsheet=readfile1.getSheetAt(0);
		HSSFRow readrow=readsheet.getRow(x);
		HSSFCell readcellgroup=readrow.getCell(1); //อ่านค่าหมวดกลุ่มธุรกิจ
		HSSFCell readcell=readrow.getCell(0); //อ่านค่าหมวดธุรกิจ
		HSSFCell readwritecell=readrow.getCell(2); //เชคอ่านไฟล์ (อ่านเลข1)
		readfile.close();
		return (readsheet.getLastRowNum()+1);	
	}

	public static String readdata (String ReadOrderFromFile, int row, int col) throws IOException  
	{
		int x = 0;
		String apb = null;
		int num = 0;
		FileInputStream readfile=new FileInputStream(ReadOrderFromFile);
		HSSFWorkbook readfile1=new HSSFWorkbook(readfile);
		HSSFSheet readsheet=readfile1.getSheetAt(0);
		HSSFRow readrow=readsheet.getRow(row);
		HSSFCell readcellgroup=readrow.getCell(col); //อ่านค่าหมวดกลุ่มธุรกิจ
//		HSSFCell readcell=readrow.getCell(0); //อ่านค่าหมวดธุรกิจ
//		HSSFCell readwritecell=readrow.getCell(2); //เชคอ่านไฟล์ (อ่านเลข1)
		try
		{
			num=readcellgroup.getCellType();
		}
		catch(NullPointerException e)
		{
			
		}
		
		if(num==HSSFCell.CELL_TYPE_STRING)
		{
			apb = readcellgroup.getStringCellValue();
		}
		else if(num==HSSFCell.CELL_TYPE_NUMERIC)
		{
			try
			{
				num = (int)readcellgroup.getNumericCellValue();
				apb = java.lang.Integer.toString(num);
			}
			catch(NullPointerException e)
			{
				
			}
		}
		readfile.close();
//		String aa = readsheet.getRow(row).getCell(col).getStringCellValue();
		
		return apb;
	
	}

	public static String writecell (String ReadOrderFromFile, int row, int col, String result) throws IOException
	{
		int x = 0;
		FileInputStream readfile=new FileInputStream(ReadOrderFromFile);
		HSSFWorkbook readfile1=new HSSFWorkbook(readfile);
		HSSFSheet readsheet=readfile1.getSheetAt(0);
		HSSFRow readrow=readsheet.getRow(x);
		HSSFCell readcellgroup=readrow.getCell(1); //อ่านค่าหมวดกลุ่มธุรกิจ
		HSSFCell readcell=readrow.getCell(0); //อ่านค่าหมวดธุรกิจ
		HSSFCell readwritecell=readrow.getCell(2); //เชคอ่านไฟล์ (อ่านเลข1)
		
		HSSFRow rr=readsheet.getRow(row);
		HSSFCell cc=rr.createCell(col);
		cc.setCellValue(result);
		
		FileOutputStream fout = new FileOutputStream(ReadOrderFromFile);
		readfile1.write(fout);
		fout.close();
		System.out.println("closeeeeee");
		return result ;
	
	}
	
	public static boolean checkfilewrite (String OutputToFile) throws IOException
	{	
		boolean testfile;
		
		FileOutputStream writefile=new FileOutputStream(new File(OutputToFile)); 
		HSSFWorkbook writefile1=new HSSFWorkbook();	
		
		try
		{		
			HSSFSheet readsheet=writefile1.getSheetAt(0);
			testfile= true ;		
		}
		catch(IllegalArgumentException e)
		{
			testfile= false;
		}
		writefile.close();
		return testfile;
	}
}
