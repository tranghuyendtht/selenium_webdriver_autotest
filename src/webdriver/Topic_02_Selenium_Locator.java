package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
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
		driver.get("https://www.topcv.vn/");

	}

	@Test
	public void TC_01_ID() {
		
		//Tìm kiếm từ khóa "tester" trong mục từ khóa. Kiểm tra ở dev tool: input[id='keyword']
		driver.findElement(By.id("keyword")).sendKeys("tester");
	}

	@Test
	public void TC_02_Class() {
		// Vào trang login
		driver.get("https://www.topcv.vn/login");
		//click vào textbox tìm kiếm
		driver.findElement(By.className("form-control")).sendKeys("chunchun@gmail.com");
		driver.findElement(By.className("form-control")).clear();
	}

	
	@Test
	public void TC_03_Name() {
		driver.get("https://www.topcv.vn/login");
		driver.findElement(By.name("email")).sendKeys("trangdth202@gmail.com");
		
	}
	@Test
	public void TC_04_TagName() {
		System.out.print(driver.findElements(By.tagName("input")).size());
		
	}
	@Test
	public void TC_05_LinkText() {
	driver.findElement(By.linkText("Đăng ký ngay")).click();
		
	}
	@Test
	public void TC_06_PartialLinkText() {
	driver.findElement(By.partialLinkText("Điều khoản")).click();
		
	}
	
	@Test
	public void TC_07_CSS() {
		driver.get("https://www.topcv.vn/sign-up");
	driver.findElement(By.cssSelector("input[name='fullname']")).sendKeys("Là Trang Đây");
	driver.findElement(By.cssSelector("input[name='fullname']")).clear();
			
		
	}
	@Test
	public void TC_08_Xpath() {
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("trangdth202@gmail.com");
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}