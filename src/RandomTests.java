import java.math.BigDecimal;
import java.util.Scanner;

public class RandomTests {
	static Scanner scr = new Scanner(System.in);
	static BigDecimal amount;
	static BigDecimal newAmount = new BigDecimal("2");
	
	public static boolean testDecimal() {
		if (amount.equals(newAmount)) {
			return true;
		}
		return false;
	}
	
	public static int testDecimal2() {
		return amount.compareTo(newAmount);
	}
	
	
	public static void main(String[] args) {
		System.out.println("Enter a value: ");
		amount = scr.nextBigDecimal();
		System.out.println(testDecimal2());
	}
}
