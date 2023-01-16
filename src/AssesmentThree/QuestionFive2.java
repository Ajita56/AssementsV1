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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuestionFive2 {
	static WebDriver driver;
	static String url = "https://www.orangehrm.com/";

	public static void main(String[] args) {
		setUp();
		driver.get(url);
		driver.findElement(By.id("Form_getForm_action_submitForm")).click();
		//get data from the excel sheet getData-- to be done
		String favname="ammana";
		String fullname="ammana serief";
		String emailb="Amana@gmail.com";
		String phonenum="987654211";
		String country="United States";
		//page down to the submit button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement submit=driver.findElement(By.cssSelector("input#Form_getForm_action_submitForm"));
		js.executeScript("arguments[0].scrollIntoView();", submit);
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
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.cssSelector("div.recaptcha-checkbox-border")).click();
		sleep(2);
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("input#Form_getForm_Contact")).sendKeys("1232154235");
		//submit button
		driver.findElement(By.cssSelector("input#Form_getForm_action_submitForm")).click();
		sleep(5);
		scrape();

	}

	private static void setUp() {
		System.out.println("Start the Testing ");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	private static void scrape() {
		System.out.println("End of Testing ");
		driver.quit();

	}

	private static void sleep(long m) {
		try {
			Thread.sleep(m * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
