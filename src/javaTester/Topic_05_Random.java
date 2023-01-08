package javaTester;

import java.util.Random;

public class Topic_05_Random {

	public static void main(String[] args) {
		Random ran = new Random();
		// Khởi tạo ngẫu nhiên 1 chuỗi số nguyên <= 9999
		System.out.println(ran.nextInt(9999));

	}

}
