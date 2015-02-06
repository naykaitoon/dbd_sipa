
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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.AssertionError;
import java.lang.NumberFormatException;
import java.lang.NullPointerException;

import org.junit.*;

import static org.junit.Assert.*;
public class MainRun {


	
	static String[] company = new String[15];
	static WebDriver driver= new FirefoxDriver();
	public static void main(String[] args) throws Exception {
		
		int loop = 17; /// จำนวนหมดทั้งหมด
		String[] companytypeId = new String[loop];
		////////////////////////////////////////////////
		companytypeId[0] ="58200";
		companytypeId[1] ="62022";
		companytypeId[2] ="62011";
		companytypeId[3]="58201";
		companytypeId[4]="58202";
		companytypeId[5]="58203";
		companytypeId[6]="59122";
		companytypeId[7]="62000";
		companytypeId[8]="62010";
		companytypeId[9]="62012";
		companytypeId[10]="62020";
		companytypeId[11]="63100";
		companytypeId[12]="63110";
		companytypeId[13]="63120";
		companytypeId[14]="63900";
		companytypeId[15]="63000";
		companytypeId[16]="63112";
		String locationProvince = "อุตรดิตถ์";
		String year = "2555";
		String secter = "N";
		///////////////////////////////////////////////
		

		System.out.println("Begin Start Process");
		
		 TimeUnit.MILLISECONDS.sleep(1000);
		db sqls = new db();
		sqls.connectDB();
		 TimeUnit.MILLISECONDS.sleep(1000);
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1366, 550));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get("http://datawarehouse.dbd.go.th/bdw/home/login.html");
		 TimeUnit.MILLISECONDS.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.findElement(By.name("userName")).sendKeys("natta121@gmail.com");
		driver.findElement(By.name("userPassword")).sendKeys("0897554452");
		driver.findElement(By.name("captchaText")).getSize();	
		 TimeUnit.MILLISECONDS.sleep(1000);
	

		for(int i=0;i<loop;++i){
			
		try
		{
				
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")));
			
		}
		catch(TimeoutException e)
		{
			driver.close();
		}
		try
		{
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")).click();
		}
		catch(NoSuchElementException e)
		{
			
		}
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[1]/td/select")));
		 TimeUnit.MILLISECONDS.sleep(1000);
		 
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Select select = new Select (driver.findElement(By.className("input3")));
		select.selectByValue("J");
		 TimeUnit.MILLISECONDS.sleep(1000);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("input3")));		
		
		 TimeUnit.MILLISECONDS.sleep(1000);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Select select2 = new Select (driver.findElement(By.name("submitObjCode")));
		select2.selectByValue(companytypeId[i]);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submitObjCode")));	
		 TimeUnit.MILLISECONDS.sleep(1000);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Select locate = new Select (driver.findElement(By.name("zone")));
		locate.selectByValue(secter);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("zone")));	
		 TimeUnit.MILLISECONDS.sleep(1000);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Select province = new Select (driver.findElement(By.name("province")));
		province.selectByVisibleText(locationProvince);
		
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("province")));	
		TimeUnit.MILLISECONDS.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Select fiscalYear = new Select (driver.findElement(By.name("fiscalYear")));
		fiscalYear.selectByVisibleText(year);
		
		TimeUnit.MILLISECONDS.sleep(1000);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fiscalYear")));	
		driver.findElement(By.className("submit")).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("submit")));	
		TimeUnit.MILLISECONDS.sleep(1000);
	
		if(driver.findElements(By.className("ui-dialog")).isEmpty()){
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")));	
		int page=countpage(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")).getText());
		System.out.println("จำนวนหน้าทั้งหมด  = "+page);

		int list = countlist(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")).getText());
		int trvalue =11;
		for(int pagenum = 1;pagenum<=page;++pagenum){
			
			if(list<10){
				trvalue=list+1;
				}
			TimeUnit.MILLISECONDS.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(""+pagenum+"")));
			driver.findElement(By.id(""+pagenum+"")).click();
			
			for(int tr=2;tr<=trvalue;++tr){

				for(int td=2;td<=13;++td){
						if(td>0&&tr>0){
						//System.out.print(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+tr+"]/td["+td+"]")).getText().toString());
						company[td]=driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+tr+"]/td["+td+"]")).getText();
				
						}
		
				}
				int companyId = sqls.add_company(company, companytypeId[i]);
				
				////////////////////////////////////////////////////////////////////////////
			
				TimeUnit.MILLISECONDS.sleep(1000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+tr+"]/td[2]/a")));
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+tr+"]/td[2]/a")).click();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				
				String[] detailcompany = new String[20];
				for(int row=1;row<=13;++row){
		
					detailcompany[row]=driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr["+row+"]/td")).getText().toString();
					
				}
				sqls.add_detailcompany(companyId, detailcompany);
				
			
	
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[4]/a/dl/dd")));
				driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[4]/a/dl/dd")).click();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				
				TimeUnit.MILLISECONDS.sleep(1000);
				////////////////////  เก็บปี
				
				String years = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[2]")).getText().toString();
				String[][] financeAndDe = new String[5][30];

				for(int five=3;five<=13;++five){
				
				financeAndDe[1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
				financeAndDe[2][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[1]")).getText().toString();
				financeAndDe[3][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[2]")).getText().toString();
				
				}
				sqls.add_finance(companyId, years,financeAndDe);
				System.out.println("เพิ่ม finance"+years+" แล้ว");
				years = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[3]")).getText().toString();
				
				for(int five=3;five<=13;++five){
				
					financeAndDe[1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
					financeAndDe[2][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[3]")).getText().toString();
					financeAndDe[3][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[4]")).getText().toString();
				
				}
				sqls.add_finance(companyId, years,financeAndDe);
				System.out.println("เพิ่ม finance"+years+" แล้ว");
				years = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[4]")).getText().toString();
		
				for(int five=3;five<=13;++five){
				
					financeAndDe[1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
					financeAndDe[2][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[5]")).getText().toString();
					financeAndDe[3][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[6]")).getText().toString();
				
				}
				sqls.add_finance(companyId, years,financeAndDe);
				System.out.println("เพิ่ม finance"+years+" แล้ว");
				//////////////////////////////////////////////////////////////////////////////
				
				TimeUnit.MILLISECONDS.sleep(1000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div[3]/input[2]")));
				TimeUnit.MILLISECONDS.sleep(1000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/input[2]")).click();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				
				TimeUnit.MILLISECONDS.sleep(1000);
				
				years = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[2]")).getText().toString();

				for(int five=3;five<=12;++five){
				
				financeAndDe[1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
				financeAndDe[2][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[1]")).getText().toString();
				financeAndDe[3][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[2]")).getText().toString();
				
				}
				sqls.add_finance2(companyId, years,financeAndDe);
				System.out.println("เพิ่ม finance งบ"+years+" แล้ว");
				years = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[3]")).getText().toString();
				
				for(int five=3;five<=12;++five){
				
					financeAndDe[1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
					financeAndDe[2][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[3]")).getText().toString();
					financeAndDe[3][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[4]")).getText().toString();
				
				}
				sqls.add_finance2(companyId, years,financeAndDe);
				System.out.println("เพิ่ม finance งบ"+years+" แล้ว");
				years = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr[1]/th[4]")).getText().toString();
		
				for(int five=3;five<=12;++five){
				
					financeAndDe[1][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/th")).getText().toString();
					financeAndDe[2][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[5]")).getText().toString();
					financeAndDe[3][five] = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[5]/div[1]/div[2]/table/tbody/tr["+five+"]/td[6]")).getText().toString();
				
				}
				sqls.add_finance2(companyId, years,financeAndDe);
				System.out.println("เพิ่ม finance งบ"+years+" แล้ว");		
				TimeUnit.MILLISECONDS.sleep(1000);
				driver.navigate().back();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				TimeUnit.MILLISECONDS.sleep(1000);
				driver.navigate().back();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				TimeUnit.MILLISECONDS.sleep(1000);

				}
			list=list-10;
			if(list<0){
				list=list*-1;
			}
				if(list<10){
					trvalue=list;
				
				}		
		}
		TimeUnit.MILLISECONDS.sleep(1000);
		System.out.println("หมวด"+companytypeId[i]+"สำเร็จ");
			}else{
			
				driver.findElement(By.className("ui-button-text")).click();
				TimeUnit.MILLISECONDS.sleep(1000);
			}
		}
		
		System.out.println("บันทึกข้อมูลสำเร็จ ..!");
		TimeUnit.MILLISECONDS.sleep(1000);
		driver.close();
		
	}
	public static int countlist(String a)
	{
		String subcha=null;
		int list;
		subcha= a.substring(a.indexOf(" ")+1, a.indexOf(" ราย"));
		list=java.lang.Integer.parseInt(subcha);
		System.out.println("จำนวนแถวทั้งหมด = "+list);
		return list;
	}


	public static int countpage(String a)
	{	
		String subp="";
		int page;
		int index3=a.indexOf("จำนวนหน้าทั้งหมด : ");	//43
		int index4=a.indexOf(" หน้า");

		subp= a.substring(index3+19, index4);

		page=java.lang.Integer.parseInt(subp);

		return page;
	}
	

}
