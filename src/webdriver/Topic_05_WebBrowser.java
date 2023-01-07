package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_WebBrowser {
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

	}

	// Tương tác với  Browser thì thông qua biến WebDriver driver
	// Tương tác với Element thì thông qua biến WebElement element
	@Test
	public void TC_01() {
		// Khi số tab trên trình duyệt >=2, close sẽ chỉ đóng tab hiện tại mà nó đang đứng
		driver.close();
		
		// Không quan tâm có bao nhiêu tab trên trình duyệt, quit sẽ đóng hết toàn bộ cửa sổ --> đóng hẳn browser
		driver.quit();
		
		//Kết quả sau khi tìm thấy 1 element
		//C1: Có thể lưu nó vào 1 biến để dùng thêm sau: Click vào hàm findElement để xem nó thuộc kiểu dữ liệu gì thì tạo biến có kiểu dữ liệu đó
		WebElement emailTextbox= driver.findElement(By.xpath("//input[@id='email']"));
		emailTextbox.clear();
		emailTextbox.click();
		
		//C2: Có thể dùng trực tiếp
		
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).click();
		
		// Tìm 1 element
		driver.findElement(By.xpath("//input[@id='email']"));
		
		// Tìm nhiều element
		List<WebElement> listCheckboxs = driver.findElements(By.xpath("//input[@id='checkbox']"));
		
		//Mở 1 url nào đó ra
		driver.get("https://www.swtestacademy.com/xpath-selenium/"); // Thường dùng
		driver.navigate().to("https://www.swtestacademy.com/xpath-selenium/"); // Ít dùng
		
		// Trả về url của page hiện tại
		driver.getCurrentUrl();
		
		// Lấy page source HTML của trang hiện tại
		// Verify tương đối
		driver.getPageSource();
		Assert.assertTrue(driver.getPageSource().contains("ABCD"));
		
		//Lấy ra ID của page mà driver đang đứng
		driver.getWindowHandle();
		
		// Lấy ra ID của tất cả Window/Tab
		Set<String> lisID = driver.getWindowHandles();
		
		//Cookie và Cache
			// Cookie: Lưu thông tin người dùng truy cập 
			// Cache: Lưu thông tin web
		
		driver.manage().getCookies();
		driver.manage().logs();
		
		// Thời gian chờ element xuất hiện
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
		
		
		//Khoảng thời gian chờ script thực thi trong vòng X giây
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		
		// Mở hết màn hình - không nhìn thấy  các chức năng đóng/resize cửa sổ
		driver.manage().window().fullscreen();
		
		// Mở hết màn hình - vẫn nhìn thấy các chức năng đóng/resize cửa sổ
		driver.manage().window().maximize();
		
		
		//Test FUI: Functional
		// Test GUI: Font, size, color,....
		driver.manage().window().getPosition();
		driver.manage().window().getSize();
		
		// Di chuyển về trang trước/Sau của trang hiện tại: Back/Forward/Refresh
		Navigation nav = driver.navigate();
		
		// Đi lùi về trang trước đó
		nav.back();
		
		// Quay lại trang kế tiếp
		nav.forward();
		
		// Refresh trang hiện tại
		nav.refresh();
		
		 
		
		
		
		
	}

	@Test
	public void TC_02_() {
		
	}

	
	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}