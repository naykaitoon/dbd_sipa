import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Engine {
	public static WebDriver driver= new FirefoxDriver();

	public static WebDriverWait wait = new WebDriverWait(driver, 30);
	static WebElement element;

	static Select selectOption;
	public static void openLoginPage() throws Exception{

		System.out.println(">> Begin Start LoginPage");
	
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1366, 550));
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.get("http://datawarehouse.dbd.go.th/bdw/home/login.html");

		driver.findElement(By.name("userName")).sendKeys("natta121@gmail.com");
		System.out.println(">> INPUT Username");

		driver.findElement(By.name("userPassword")).sendKeys("0897554452");
		System.out.println(">> INPUT Password");
		System.out.println(">> INPUT capcha");
		driver.findElement(By.name("captchaText")).getSize();	
		driver.findElement(By.name("captchaText")).click();
		Boolean check=true;
		while (check == true) {
			try{
				element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div[1]/ul/li/ul/li[3]/a/dl/dd")));
				check = false;
			}catch (Exception e) {
				check = true;
			}
		}
		
		
		if(element.getText() != null){

			System.out.println(">> Login Complete\n------------------------------------------------");
			
		}else{
			System.out.println(">> Error Login");
		}
		element.click();
		
	}
	
	public static String[] searchGroupOptionSub() throws Exception{
		Boolean check = true;
		while (check == true) {
			try {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.name("objGrpCode")));
		check = false;
			} catch (org.openqa.selenium.TimeoutException e) {
				check = true;
			}
		}
		selectOption = new Select (element);
		 List<WebElement> OptionsobjGrpCode = selectOption.getOptions();

		 String grouplist[] = new String[OptionsobjGrpCode.toArray().length-1];
		 int i =0; 
		 System.out.println(">> find "+(OptionsobjGrpCode.toArray().length-1)+" Group");
		 for(WebElement option:OptionsobjGrpCode){
			 if(i>0){
			 grouplist[(i-1)]=option.getText();
			 }
			 ++i;
		 }
		 return grouplist;
		 
	}
	public static void optionSelect(String value,String name,String type) throws Exception{
		Boolean check = true;
		Select selectOptions = null;
		while (check == true) {
			try {
		WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
		
		selectOptions = new Select (elements);
		check = false;
			} catch (org.openqa.selenium.TimeoutException e) {
				check = true;
			}
		}
	
	
		if(type=="text"){
			selectOptions.selectByVisibleText(value);	
		}else if(type=="value"){
			selectOptions.selectByValue(value);	
		}
	
	}
	public static String[] optionSubSelect() throws Exception{
		Boolean check = true;
		while (check == true) {
			try {
		  element = wait.until(ExpectedConditions.elementToBeClickable(By.name("submitObjCode")));
		
	
		 check = false;
			} catch (org.openqa.selenium.TimeoutException e) {
				check = true;
			}
		}
		  Select selectOption = new Select (element);
		 List<WebElement> submitObjCode = selectOption.getOptions();
		 String sublist[] =null;
		 check = true;
			while (check == true) {
				try {
					sublist= new String[submitObjCode.toArray().length-1];
		 check = false;
				} catch (Exception e) {
					check = true;
				}
			}
		 int i=0;
		 for(WebElement option:submitObjCode){
			 if(i>0){
				 sublist[i-1]=option.getAttribute("value");
			 }
			 ++i;
		 }
		 return sublist;

	}
	public static boolean submit()throws Exception{
		Boolean check=true;
		while (check == true) {
			try {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("submit")));
		element.click();
	
		 check = false;
			} catch (org.openqa.selenium.TimeoutException e) {
				check = true;
			}
		}
		if(driver.findElements(By.className("ui-dialog")).isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	
}
