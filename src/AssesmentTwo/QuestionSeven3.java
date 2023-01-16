/*7. Write the code to perform following operation
a)	Navigate to https://demo.automationtesting.in/
b)	Click on Skip sign in
c)	Click on switch to and select alerts
d)	Handle different types of alerts listed in the page*/

package AssesmentTwo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class QuestionSeven3 {
	public static WebDriver driver;
	public static String url="https://demo.automationtesting.in/Alerts.html";
	
	
	public static void main(String[] args) {
		setUp();
		
		driver.get(url);
		/*Alerts with ok --this is already the first tab */
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		String  alertMsg= driver.switchTo().alert().getText();
		System.out.println("Message : " + alertMsg);
		sleep(3);//just to view the alert box
		driver.switchTo().alert().accept();
		
		/*Alerts with ok and cancel*/
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		alertMsg= driver.switchTo().alert().getText();
		System.out.println("Message : " + alertMsg);
		sleep(3);//just to view the alert box
		driver.switchTo().alert().accept();
		
		/*Alerts with text box*/
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		alertMsg= driver.switchTo().alert().getText();
		System.out.println("Message : " + alertMsg);
		//enter data into text box
		driver.switchTo().alert().sendKeys("hello how are you doing!!!"); 
		sleep(3);//just to view the alert box
		driver.switchTo().alert().accept();
		sleep(3);
		scrape();

	}

	private static void setUp() {
		System.out.println("Start the Testing ");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
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
