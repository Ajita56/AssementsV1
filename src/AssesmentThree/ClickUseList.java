/*3. Go to JqueryUI.com and navigate to selectable. 
 * Select more than one item from the window (This can be achieved by pressing control button). 
 * Then click on Auto complete using action class.*/

package AssesmentThree;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickUseList {
	static WebDriver driver;
	static String url = "https://jqueryui.com/";

	public static void main(String[] args) {
		setUp();
		driver.get(url);

		driver.findElement(By.partialLinkText("Selectable")).click();
		System.out.println("you are in the page:" + driver.getTitle());
		WebElement frame = driver.findElement(By.className("demo-frame"));

		driver.switchTo().frame(frame);
		List<WebElement> items=driver.findElements(By.cssSelector("li.ui-widget-content.ui-selectee"));
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL)
		.click(items.get(0)).click(items.get(1)).click(items.get(2))
		.keyUp(Keys.CONTROL).build().perform();

		sleep(2);
		driver.switchTo().defaultContent();
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Autocomplete']"))).click().build().perform();
		System.out.println("you are in the page:" + driver.getTitle());

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
