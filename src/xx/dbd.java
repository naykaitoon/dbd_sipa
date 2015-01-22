package xx;

import xx.ReadWriteExcel;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dbd {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//login
		WebDriver driver= new FirefoxDriver();
		ReadWriteExcel excel = new ReadWriteExcel();
		driver.get("http://datawarehouse.dbd.go.th/bdw/home/login.html");
		driver.findElement(By.name("userName")).sendKeys("Momay.pt@gmail.com");
		driver.findElement(By.name("userPassword")).sendKeys("Momaypt072");
		driver.findElement(By.name("captchaText")).getSize();	
		System.out.println(driver.findElement(By.name("captchaText")).getText().toString().length());
		Thread.sleep(10000);
		driver.findElement(By.xpath("html/body/form/div[2]/div/div/center/button")).click();
		
		//select
		driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")).click();
		
		
		Thread.sleep(1000);
		Select select = new Select (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[1]/td/select")));
		select.selectByValue("J");
		
		Thread.sleep(1000);
		Select select4 = new Select (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[2]/td/select")));
		select4.selectByValue("63112");
		
		
		Thread.sleep(1000);
		Select select2 = new Select (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[3]/td/select")));
		select2.selectByValue("N");
		
		Thread.sleep(1000);
		Select select3 = new Select (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/table/tbody/tr[4]/td/select")));
		select3.selectByValue("50");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/form[1]/center/button")).click();
		
		
		//row&col
		int r,c;
		
		int listnumber=countlistnumber(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")).getText());
		
		for(r=2; r<=11; r++)
		{	
			if(listnumber>0)
			{
				listnumber--;
				System.out.println("row="+r);
				
				for(c=1;c<=13;c++)	
				{
					System.out.println("col="+c);
				
					String sum = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/table/tbody/tr["+r+"]/td["+c+"]/a")).getText();								
					System.out.println(sum);
					
					HSSFWorkbook wb = new HSSFWorkbook();
					HSSFSheet s = wb.createSheet();
					HSSFRow row = s.createRow(r);
					HSSFCell cell1 = row.createCell(c);				
					cell1.setCellValue(sum);
					
					FileOutputStream write = new FileOutputStream("D:/Selenium/xls/xls/tt.xls");
					wb.write(write);
					write.close();
				}
			}
			else
			{
				r=11;
			}
				
		}	
	}
	public static int countpagenumber(String page)
	{
		//String page = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")).getText();
		System.out.println(page);
		
		String aa = page;
		
		int intIndex = aa.indexOf("���Ҿ�������: ");
		intIndex = aa.indexOf ( " " );
		System.out.println (intIndex);
		
		int intIndex2 = aa.indexOf(" ���");
		System.out.println (intIndex2);

		String bb = null;
		bb = aa.substring(intIndex+1, intIndex2 );
		System.out.println (bb);
		
		String cc = page;
		
		int intIndex3 = cc.lastIndexOf(" �ӹǹ˹�ҷ����� : ");
		System.out.println (intIndex3);
		
		int  intIndex4 = cc.indexOf(" ˹��");
		System.out.println (intIndex4);
		
		String dd = null;
		dd = cc.substring(intIndex3+20 , intIndex4);
		System.out.println (dd);
		
		return Integer.parseInt(bb);
		
	}
	public static int countlistnumber(String page)
	{
		//�ӹǹ��¡�þ��鹾�
		//String page = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[3]/b")).getText();
		System.out.println(page);
		
		String aa = page;
		
		int intIndex = aa.indexOf("���Ҿ�������: ");
		intIndex = aa.indexOf ( " " );
		System.out.println (intIndex);
		
		int intIndex2 = aa.indexOf(" ���");
		System.out.println (intIndex2);

		String bb = null;
		bb = aa.substring(intIndex+1, intIndex2 );
		System.out.println (bb);
		
		String cc = page;
		
		int intIndex3 = cc.lastIndexOf(" �ӹǹ˹�ҷ����� : ");
		System.out.println (intIndex3);
		
		int  intIndex4 = cc.indexOf(" ˹��");
		System.out.println (intIndex4);
		
		String dd = null;
		dd = cc.substring(intIndex3+20 , intIndex4);
		System.out.println (dd);
		
		return Integer.parseInt(bb);
	}
}
