package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Exercise_CSS {
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

	@Test
	public void TC_01_Empty() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("div.field_btn > .btn_pink_sm")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}

	@Test
	public void TC_02_Insert_Attributes() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input[name = 'txtFirstname']")).sendKeys("Trang Huyền");
		driver.findElement(By.cssSelector("#txtEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0875123641");
		
	
		driver.findElement(By.cssSelector("div.field_btn > .btn_pink_sm")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		
		}

	
	@Test
	public void TC_03_Multi_Attributes() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input[id='txtFirstname'][name='txtFirstname']")).sendKeys("Trang Huyền");
		driver.findElement(By.cssSelector("#txtEmail")).sendKeys("Lululala@gmail.com");
		driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0875123641");
		driver.findElement(By.cssSelector("div.field_btn > .btn_pink_sm")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_04_OR() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input[id='txtFirstname'],[name='txtFirstname']")).sendKeys("Trang Huyền");
		driver.findElement(By.cssSelector("#txtEmail")).sendKeys("Lululala@gmail.com");
		driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0875123641");
		driver.findElement(By.cssSelector("div.field_btn > .btn_pink_sm")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_05_CONTAINS() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input[name*='Firstname']")).sendKeys("Trang Huyền");
		driver.findElement(By.cssSelector("#txtEmail")).sendKeys("Lululala@gmail.com");
		driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0875123641");
		driver.findElement(By.cssSelector("div.field_btn > .btn_pink_sm")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_06_Start_withs() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input[name^='txtF']")).sendKeys("Trang Huyền");
		driver.findElement(By.cssSelector("#txtEmail")).sendKeys("Lululala@gmail.com");
		driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0875123641");
		driver.findElement(By.cssSelector("div.field_btn > .btn_pink_sm")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_07_End_withs() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input[name$='Firstname']")).sendKeys("Trang Huyền");
		driver.findElement(By.cssSelector("#txtEmail")).sendKeys("Lululala@gmail.com");
		driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0875123641");
		driver.findElement(By.cssSelector("div.field_btn > .btn_pink_sm")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_08_NTH_CHILD() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("div[class$='frmRegister']>div:nth-child(1)>input[name$='Firstname']")).sendKeys("Trang Huyền");
		driver.findElement(By.cssSelector("#txtEmail")).sendKeys("Lululala@gmail.com");
		driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0875123641");
		driver.findElement(By.cssSelector("div.field_btn > .btn_pink_sm")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_09_FIRST_INDEX() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("div[class$='frmRegister']>div:first-child>input[name$='Firstname']")).sendKeys("Trang Huyền");
		driver.findElement(By.cssSelector("#txtEmail")).sendKeys("Lululala@gmail.com");
		driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0875123641");
		driver.findElement(By.cssSelector("div.field_btn > .btn_pink_sm")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_10_LAST_INDEX() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("div[class$='frmRegister']>div:first-child>input[name$='Firstname']")).sendKeys("Trang Huyền");
		driver.findElement(By.cssSelector("#txtEmail")).sendKeys("Lululala@gmail.com");
		driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("Lululala@@ok");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0875123641");
		driver.findElement(By.cssSelector("div[class$='frmRegister']>div:last-child>button[class^='btn_pink_sm ']")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}

	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}