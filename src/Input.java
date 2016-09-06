import java.util.InputMismatchException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Input {
	Scanner scr = new Scanner(System.in);
	private BigDecimal mAmount;
	//private byte mAge;
	private byte mFinancialPeriod;
	
	
	public BigDecimal getUserAmount() {
		BigDecimal lowerLimit = new BigDecimal("0");
		BigDecimal upperLimit = new BigDecimal("200000");
		do {
			try {
				System.out.print("Please provide gross amount of your salary: ");
				mAmount = scr.nextBigDecimal();
			} catch (InputMismatchException ime) {
				System.out.println("Input needs to be a number!");
				scr.next();
			} 
			
		} while (mAmount.compareTo(lowerLimit) == -1 && mAmount.compareTo(upperLimit) == 1);
	return mAmount;
	}
/*	
	public byte getAge() {
		
		do {
			try{
				System.out.print("Please enter your age: ");
				mAge = scr.nextByte();
			} catch (InputMismatchException ime) {
				System.out.println("Age must be a number!");
				scr.next();
			}
		} while (mAge < 1);
		return mAge;
	}
	*/
public byte getFinancialPeriod() {
		
		do {
			try{
				System.out.print("For 2014/2015 enter \"1\" for 2015/2016 enter \"2\" : ");
				mFinancialPeriod = scr.nextByte();
			} catch (InputMismatchException ime) {
				System.out.println("Value must be either 1 or 2!");
				scr.next();
			}
		} while (mFinancialPeriod < 1 && mFinancialPeriod >2);
		return mFinancialPeriod;
	}

}
