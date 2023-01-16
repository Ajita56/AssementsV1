/*Write a code to navigate to Amazon.com using Edge browser and perform the below operations
a.	Go to login screen without using action class
b.	Enter the invalid credentials and capture the error 
c.	Print the error message and navigate back to the home screen*/

package AssesmentOne;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class QuestionSix2 {
	static WebDriver driver;
	static String url = "https://www.amazon.com/";

	public static void main(String[] args) {
		setUp();
		driver.get(url);
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println(parentWindowHandle);
//Go to login screen without using action class		
		driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).click();
//Enter the invalid credentials
		String logEmail = "abcdef@gmail.com";
		driver.findElement(By.cssSelector("#ap_email")).sendKeys(logEmail);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		String logPwd = "123456789";
		driver.findElement(By.cssSelector("#ap_password")).sendKeys(logPwd);

//navigate back to the home screen
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			System.out.println(windowHandle);
			if(!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				System.out.println(windowHandle);
			}
		}

		driver.switchTo().window(parentWindowHandle);



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
