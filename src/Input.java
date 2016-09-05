import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	Scanner scr = new Scanner(System.in);
	private float mAmount;
	private byte mAge;
	private byte mFinancialPeriod;
	
	
	public float getUserAmount() {
		
		do {
			try {
				System.out.print("Please provide gross amount of your salary: ");
				mAmount = scr.nextFloat();
			} catch (InputMismatchException ime) {
				System.out.println("Input needs to be a number!");
				scr.next();
			} 
			
		} while (mAmount < 0 && mAmount >= 200000);
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
