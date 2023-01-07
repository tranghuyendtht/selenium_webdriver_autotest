package testng;

import org.testng.Assert;

public class Assert_TestNG {

	public static void main(String[] args) {
		String textCompare = "Automation Testing";

		// Verify 1 điều kiện đúng (Mong chờ nó là đúng)
		Assert.assertTrue(textCompare.contains("Automation"));

		// Verify 1 điều kiện sai (Mong chờ nó là sai)
		Assert.assertFalse(textCompare.contains("Manual"));

		// Verify 1 điều kiện đầu vào bằng đầu ra
		Assert.assertEquals(textCompare,"Automation Testing");
		
		
		
		// AssertTrue, AssertFalse trả về kiểu boolean ==> Thường dùng với isDisplay/isEnable/isSelected..
		// AssertEquals trả về kiểu dữ liệu: String, int, ...

	}

}
