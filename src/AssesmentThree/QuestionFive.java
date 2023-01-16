/*5. Navigate to orangeHRM  
 * and click on try it for free. 
 * Enter the data in the text box and click on Submit. 
 * In order to enter the details, data must read from the excel file.*/ 
package AssesmentThree;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class QuestionFive {
	static WebDriver driver;
	static String url = "https://www.orangehrm.com/";

	@Test(dataProvider = "UserData", dataProviderClass = FiveDataProvider.class)
	public void TestLogin(	String favname,
							String fullname,
							String emailb,
							String phonenum,
							String country){
		driver.get(url);
		driver.findElement(By.id("Form_getForm_action_submitForm")).click();
		//get data from the excel sheet getData
		
		//page down to the submit button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement submit=driver.findElement(By.cssSelector("input#Form_getForm_action_submitForm"));
		WebElement footer=driver.findElement(By.cssSelector("div.footer-main"));
		js.executeScript("arguments[0].scrollIntoView();", footer);
		js.executeScript("window.scrollBy(0,500)");
		//fill in the form
		driver.findElement(By.cssSelector("input#Form_getForm_subdomain")).sendKeys(favname);
		
		driver.findElement(By.cssSelector("input#Form_getForm_Name")).sendKeys(fullname);
		driver.findElement(By.cssSelector("input#Form_getForm_Email")).sendKeys(emailb);
		driver.findElement(By.cssSelector("input#Form_getForm_Contact")).sendKeys(phonenum);
		//to select the country
		WebElement selectMenu=driver.findElement(By.id("Form_getForm_Country"));
		Select sel=new Select(selectMenu);
		sel.selectByValue(country);
		//i am not a robot check box
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.cssSelector("div.recaptcha-checkbox-border")).click();
		sleep(2);
		driver.switchTo().defaultContent();
		//submit button
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		WebElement submit=driver.findElement(By.cssSelector("input#Form_getForm_action_submitForm"));
		Actions act=new Actions(driver);
		act.moveToElement(submit)
		.click()
		.build()
		.perform();
		
		sleep(5);
	}
	@BeforeMethod
	private static void setUp() {
		System.out.println("Starting the registration process");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}
	@AfterMethod
	private static void scrape() {
		System.out.println("The details are successfully submitted");
		driver.quit();

	}

	private static void sleep(long m) {
		try {
			Thread.sleep(m * 1000);
		} catch (InterruptedException e) {
					e.printStackTrace();
		}
	}


}
