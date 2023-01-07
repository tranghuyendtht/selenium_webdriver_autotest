package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element_PartI {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01() {

		// Tìm element và sử dụng chúng

		// Cách 1: Chỉ dùng 1 lần
		driver.findElement(By.xpath("")).sendKeys("");

		// Cách 2: Dùng lại nhiều hơn 1 lần --> Dùng cách khai báo biến
		WebElement searchTextbox = driver.findElement(By.id("search"));

		// Xóa dữ liệu trước khi nhập dữ liệu mới
		searchTextbox.clear();

		// Nhập dữ liệu vào
		searchTextbox.sendKeys("Dữ liệu mới");

		// Click vào 1 element
		searchTextbox.click();
		
		// Tìm và thao tác với 1 element
		searchTextbox.findElement(By.id("email")).click();
		
		// Tìm và thao tác với nhiều element
		searchTextbox.findElements(By.id("email")).get(0).click();
		
		// Thao tác với attribute tagname[@attribute='value'] = //input[@id='search']
		searchTextbox.getAttribute("id");
		
		// Test GUI: font/size/color/...
		String loginButtonColor = searchTextbox.getCssValue("background");
		System.out.println(loginButtonColor); // Kết quả trả về mã màu #3399cc
		
				
		//Chụp màn hình - Mục đích lấy ảnh màn hình để cho vào Report
		 searchTextbox.getScreenshotAs(OutputType.BYTES);
		 searchTextbox.getScreenshotAs(OutputType.BASE64);
		 searchTextbox.getScreenshotAs(OutputType.FILE);
		 
		 // Trả về text của một element
		 searchTextbox.getText();
		 
		 // Assert True/False
		 Assert.assertTrue(searchTextbox.isDisplayed());
		 Assert.assertFalse(searchTextbox.isEnabled());
		 
		 // Thường dùng khi làm với Radio Button, Checkbox
		 Assert.assertTrue(searchTextbox.isSelected());
		 
		 // Thường làm với form (form login, register,..) - ít dùng vì hay dùng click hơn để giảm việc nhầm lẫn
		 searchTextbox.submit();
		 
		

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}