package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Exercise_AutomationFC_Gitio {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if(osName.contains("Windows")) {
				System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");	
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://automationfc.github.io/basic-form/");

	}

	@Test
	public void TC_01_getText() {
		System.out.println(driver.findElement(By.id("nested")).getText());
	}

	@Test
	public void TC_02_Tuyetdoi_AND() {
		System.out.println(driver.findElement(By.xpath("//h5[text()='Michael Jackson' and @id = 'four']")).getText());
	}

	
	@Test
	public void TC_03_Tuongdoi_OR() {
		System.out.println(driver.findElement(By.xpath("//span[@class= 'year' or contains(text(),18)]")).getText());
	}

	@Test
	public void TC_034_Concat() {
		System.out.println(driver.findElement(By.xpath("//span[text()= concat(\'Hello \"John\",',\" What\'s happened?\")]")).getText());
	}
	
	@Test
	public void TC_05_NOT() {
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.findElement(By.xpath("//a[text()='7']")).click();
		System.out.println(driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class =\"raDiv\"]")));
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}