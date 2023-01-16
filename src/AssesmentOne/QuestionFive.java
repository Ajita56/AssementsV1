/*5.Write a code to perform following operations on jqeuriui .com 
a.	Navigate to checkboxradio
b.	Select the location paris
c.	Select Hotel ratings from 3-5 stars
d.	Select the bed type as 1 queen
e.	Then click on Demos 
*/

package AssesmentOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuestionFive {
	static WebDriver driver;
	static String url = "https://jqueryui.com/";

	public static void main(String[] args) {
		setUp();
		driver.get(url);
//navigate to checkboxradio
		driver.findElement(By.xpath("//a[contains(text(),'Checkboxradio')]")).click();
//Select the location paris
		WebElement frameObj = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frameObj);
		String className="ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank";
		driver.findElement(By.xpath(
				"//div[@class='widget']//label[@for='radio-2']//span[@class='"+className+"']"))
				.click();
//Select Hotel ratings from 3-5 stars
		driver.findElement(By.xpath(
				"//label[@for='checkbox-2']//span[@class='"+className+"']"))
				.click();
		driver.findElement(By.xpath(
				"//label[@for='checkbox-3']//span[@class='"+className+"']"))
				.click();
		driver.findElement(By.xpath(
				"//label[@for='checkbox-4']//span[@class='"+className+"']"))
				.click();
//Select the bed type as 1 queen
		driver.findElement(By.xpath(
				"//label[@for='checkbox-nested-3']//span[@class='"+className+"']"))
				.click();
		sleep(5);
//Then click on Demos 
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(
				"//div[@class='menu-top-container']//a[contains(text(),'Demos')]"))
				.click();
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
