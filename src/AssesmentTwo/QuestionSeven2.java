/*7. Write the code to perform following operation
a)	Navigate to https://demo.automationtesting.in/
b)	Click on Skip sign in
c)	Click on switch to and select alerts
d)	Handle different types of alerts listed in the page*/

package AssesmentTwo;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuestionSeven2 {
	public static WebDriver driver;
	public static String url="https://demo.automationtesting.in/";
	public static DesiredCapabilities caps;
	
	public static void main(String[] args) {
		setUp();
		
		driver.get(url);
		driver.findElement(By.id("#btn2")).click();
		//a[text()='SwitchTo']
		//a[@href='Alerts.html']//a[text()='Alerts']
		
		sleep(3);
		scrape();

	}

	private static void setUp() {
		System.out.println("Start the Testing ");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		caps= new DesiredCapabilities();
		caps.setCapability(ChromeOptions.CAPABILITY, options);

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
