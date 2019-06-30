package expensesTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ExpenseTracker_Automation {

	public static void main(String[] args) throws InterruptedException{
		final DateTimeFormatter dtf_std3 = DateTimeFormatter.ofPattern("MMddmmss");
		final DateTimeFormatter dtf_std4 = DateTimeFormatter.ofPattern("ddmm");

		System.setProperty("webdriver.chrome.driver", "D:\\softwares\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		System.setProperty("webdriver.ie.driver", "C:\\Users\\agarsh8\\Desktop\\softwares\\chromedriver.exe");
//				WebDriver driver=new InternetExplorerDriver();
		// launch the url
		driver.get("http://thawing-shelf-73260.herokuapp.com/index.jsp");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		//register new user
		driver.findElement(By.xpath("//a[contains(@href,'register')]")).click();
		LocalDateTime now2 = LocalDateTime.now();

		driver.findElement(By.id("login")).sendKeys("user"+dtf_std4.format(now2));
		driver.findElement(By.id("password1")).sendKeys("1234");
		driver.findElement(By.id("password2")).sendKeys("1234");

		Actions a = new Actions(driver);
		
		WebElement submit=driver.findElement(By.id("submit"));
		//a.click().build().perform();
		
		a.moveToElement(submit).click().build().perform();
		
		
		//change password - negative
		driver.findElement(By.id("editaccount")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("newpassword1")).sendKeys("12345678");
		driver.findElement(By.id("newpassword2")).sendKeys("12345678");
		WebElement submit_ChangePwd=driver.findElement(By.id("submit"));
		a.moveToElement(submit_ChangePwd).click().build().perform();
		Thread.sleep(2000);
		WebElement alert=driver.findElement(By.xpath("//div[contains(@class,'danger')]"));
if(alert.isDisplayed()){
	System.out.println(alert.getText()+ " error message is displayed");
}

		//change password - positive
				//driver.findElement(By.id("editaccount")).click();
				//Thread.sleep(5000);
				driver.findElement(By.id("password")).sendKeys("1234");
				driver.findElement(By.id("newpassword1")).sendKeys("12345678");
				driver.findElement(By.id("newpassword2")).sendKeys("12345678");
				WebElement submit_ChangePwd2=driver.findElement(By.id("submit"));
				a.moveToElement(submit_ChangePwd2).click().build().perform();
				Thread.sleep(2000);
		//add new category
		driver.findElement(By.id("go_list_categories")).click();
		driver.findElement(By.id("go_add_category")).click();
		Thread.sleep(2000);
		LocalDateTime now1 = LocalDateTime.now();
		
		driver.findElement(By.id("name")).sendKeys("category - "+dtf_std3.format(now1));
		driver.findElement(By.xpath("//input[contains(@value,'Create Category')]")).click();
String category_name=driver.findElement(By.xpath("//table//tr[1]/td[1]")).getText();
System.out.println("Category name is :" +category_name);		
//edit a category
driver.findElement(By.xpath("//a[contains(@href,'editcategory')]")).click();
WebElement save_editcat=driver.findElement(By.id("submit"));
a.moveToElement(save_editcat).click().build().perform();

//add expense


driver.findElement(By.id("go_add_expense")).click();
driver.findElement(By.id("day")).sendKeys("25");
driver.findElement(By.id("month")).clear();
driver.findElement(By.id("month")).sendKeys("5");

driver.findElement(By.id("year")).sendKeys("2015");
driver.findElement(By.id("amount")).sendKeys("22,99");
driver.findElement(By.id("reason")).sendKeys("expense for my category");

WebElement dropdown=driver.findElement(By.xpath("//select//option"));
System.out.println("drop down values are :" +dropdown.getText());

if(dropdown.getText().contains(category_name)){
	System.out.println("Categories are being populated as expected");
}
WebElement save_expense=driver.findElement(By.id("submit"));
a.moveToElement(save_expense).click().build().perform();
Thread.sleep(3000);

//edit an expense
driver.findElement(By.xpath("//a[contains(@href,'editexpense')]")).click();
WebElement save_editexp=driver.findElement(By.id("submit"));
a.moveToElement(save_editexp).click().build().perform();

List <WebElement> list1=driver.findElements(By.xpath("//table//tr[2]//th"));

for (int j = 0; j < list1.size(); j++) {
    System.out.println(list1.get(j).getText());
    if(list1.get(j).getText().equalsIgnoreCase("Date")||list1.get(j).getText().equalsIgnoreCase("Category")||list1.get(j).getText().equalsIgnoreCase("Amount")||list1.get(j).getText().equalsIgnoreCase("Reason")||list1.get(j).getText().equalsIgnoreCase("Modify")){
    	System.out.println("All the fields are dsplayed as expected in List expense screen");
    }

}
	}

}

