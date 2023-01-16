/*Write a code to navigate to Amazon.com using Edge browser and perform the below operations
a.	Go to login screen without using action class
b.	Enter the invalid credentials and capture the error 
c.	Print the error message and navigate back to the home screen*/

package AssesmentOne;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuestionSix3 {
	static WebDriver driver;
	static String url = "https://www.amazon.com/";

	public static void main(String[] args) {
		setUp();
		driver.get(url);
		
//Go to login screen without using action class		
		driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).click();
//Enter the invalid credentials
		String logEmail = "mnbbvvvccc";
		driver.findElement(By.cssSelector("#ap_email")).sendKeys(logEmail);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
//		String logPwd = "betoogood";
//		driver.findElement(By.cssSelector("#ap_password")).sendKeys(logPwd);
//		driver.findElement(By.cssSelector("#signInSubmit")).click();
//capture the error 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='a-box-inner a-alert-container']/h4")));

		String eMsg = driver.findElement(By.xpath("//div[@class='a-box-inner a-alert-container']/h4")).getText();
		String etMsg = driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
//Print the error message 
		System.out.println(eMsg+"  "+etMsg);
//navigate back to the home screen
		
		  driver.navigate().back(); driver.navigate().back(); 
	
		sleep(5);
		scrape();

	}

	private static void setUp() {
		System.out.println("Start the Testing ");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
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
