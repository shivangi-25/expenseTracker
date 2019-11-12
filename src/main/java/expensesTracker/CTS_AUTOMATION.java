package expensesTracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
public class CTS_Automation {

	public static void main(String[] args) throws InterruptedException{
		final DateTimeFormatter dtf_std3 = DateTimeFormatter.ofPattern("MMddmmss");
		final DateTimeFormatter dtf_std4 = DateTimeFormatter.ofPattern("ddmm");

		//WebDriver driver=new FirefoxDriver();
		
System.setProperty("webdriver.chrome.driver", "D:\\softwares\\Selenium\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
LocalDateTime now2 = LocalDateTime.now();
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\agarsh8\\Desktop\\softwares\\chromedriver.exe");
				//WebDriver driver=new InternetExplorerDriver();
		// launch the url
		driver.get("https://cafetownsend-angular-rails.herokuapp.com/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.xpath("//input[@ng-model='user.name']")).sendKeys("Luke");
		driver.findElement(By.xpath("//input[@ng-model='user.password']")).sendKeys("Skywalker");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		//Add an employee
		driver.findElement(By.xpath("//a[@ng-click='createEmployee()']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@ng-model='selectedEmployee.firstName']")).sendKeys("firstname"+dtf_std4.format(now2));
		driver.findElement(By.xpath("//input[@ng-model='selectedEmployee.lastName']")).sendKeys("Lastname"+dtf_std4.format(now2));
		driver.findElement(By.xpath("//input[@ng-model='selectedEmployee.startDate']")).sendKeys("2019-11-12");
		driver.findElement(By.xpath("//input[@ng-model='selectedEmployee.email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//button[@ng-show='isCreateForm']")).click();
		Thread.sleep(2000);

		//Edit an employee
		driver.findElements(By.xpath("//ul[@id='employee-list']//li[contains(text(),'firstname')]")).get(0).click();

		
		driver.findElement(By.xpath("//a[@ng-click='editEmployee()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@ng-model='selectedEmployee.email']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='selectedEmployee.email']")).sendKeys("abcdefgh@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		Thread.sleep(2000);
		//delete an employee
		driver.findElements(By.xpath("//ul[@id='employee-list']//li[contains(text(),'firstname')]")).get(0).click();

		driver.findElement(By.xpath("//a[@ng-click='deleteEmployee()']")).click();
		Thread.sleep(2000);
		
		
		
	}


}
