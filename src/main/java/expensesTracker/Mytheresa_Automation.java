package MT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mytheresa_Automation {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\softwares\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://www.mytheresa.com/en-de/");
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);			

		driver.manage().window().maximize();
		Thread.sleep(4000);
		Actions a=new Actions(driver);
		
	
		driver.switchTo().frame("privacy-iframe");
		WebElement button=driver.findElement(By.xpath("//*[@id='privacy-cat-modal']//div[contains(@class,'footer')]/button[contains(text(),'Accept all and continue')]"));
		a.moveToElement(button).click().build().perform();
		driver.switchTo().defaultContent();
			WebElement close_icon=driver.findElement(By.id("x-close"));

			 js.executeScript("arguments[0].click();", close_icon);

		driver.findElement(By.id("search")).sendKeys("Gucci Bags");
		Thread.sleep(2000);
		driver.findElement(By.id("search_callout")).click();
		Thread.sleep(2000);
		WebElement color=driver.findElement(By.xpath("//div/h3[contains(@class,'color')]"));
		a.moveToElement(color).build().perform();
	}

}
