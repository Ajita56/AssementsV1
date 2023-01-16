/*4. Go to JqueryUI.com and navigate to Date picker. 
 * Select the current date. 
 * Click on support and move back to date picker again. 
 * Select any future date and close the browser. 
 * Prioritize these actions using TestNG annotations.*/ 
package AssesmentThree;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuestionFour2 {
	static WebDriver driver;
	static String url = "https://jqueryui.com/";

	public static void main(String[] args) {
		setUp();
		driver.get(url);
		driver.findElement(By.partialLinkText("Datepicker")).click();
		System.out.println("you are in the page:" + driver.getTitle());
		
		//select todays date
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		String date = todaysDateSelector();
		driver.switchTo().defaultContent();
		System.out.println("todays date is:"+date);
		sleep(2);
		// goto page Support
		driver.findElement(By.xpath("//a[@href='https://jqueryui.com/support/']")).click();
		System.out.println("you are in the page:" + driver.getTitle());
		sleep(2);
		//come back to date picker page
		driver.findElement(By.partialLinkText("Datepicker")).click();
		System.out.println("you are in the page:" + driver.getTitle());
		sleep(2);
		//Select any future date 
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		date=futureDateSelector();
		driver.switchTo().defaultContent();
		System.out.println("Selected date is:"+date);
		
		sleep(5);
		scrape();

	}

	private static String todaysDateSelector() {
		driver.findElement(By.id("datepicker")).click();
		//to select default date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		String date=driver.findElement(By.id("datepicker")).getAttribute("value");
		
		return date;
	}
	private static String futureDateSelector() {
		driver.findElement(By.id("datepicker")).click();
		//to select given date
		String reqyear="2023",reqmonth="May",reqday="28";
		//to select the year of the date required
		while(true)
		{
			String curyear=driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
			if(curyear.equalsIgnoreCase(reqyear))
				break;
			else
				driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		}
		//to select the month of the date required
		while(true)
		{
			String curmonth=driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
			if(curmonth.equalsIgnoreCase(reqmonth))
				break;
			else
				driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		}
		//to select the day of the date required
		List<WebElement> days=driver.findElements(By.xpath("//td[@data-handler='selectDay']/a"));
		for(int i =0;i<days.size();i++)
		{
			String curday=days.get(i).getText();
			if(curday.equalsIgnoreCase(reqday))
			{
				days.get(i).click();
				break;
			}
				
		}
		String date=driver.findElement(By.id("datepicker")).getAttribute("value");
		return date;
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
