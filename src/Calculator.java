import java.math.BigDecimal;

public class Calculator {
	Model model = new Model();
	Input in = new Input();
	
	public BigDecimal amountMonthly(BigDecimal input) {
		BigDecimal divisor = new BigDecimal("12");
		return input.divide(divisor,2,BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal amountWeekly(BigDecimal input) {
		BigDecimal divisor = new BigDecimal("52");
		return input.divide(divisor,2,BigDecimal.ROUND_HALF_UP);	
		}
	
	public BigDecimal netAmountAnnual(byte financialPeriod, BigDecimal mAnnualGrossAmount) {
		
		BigDecimal finalAmount = new BigDecimal("0");
		
		if (financialPeriod == 1) {
			
			BigDecimal firstTier = new BigDecimal("10000");
			BigDecimal secondTier = new BigDecimal("41865");
			BigDecimal thirdTier = new BigDecimal("150000");
			BigDecimal finalTier = new BigDecimal("200000");
			
			BigDecimal percentageTierOne = new BigDecimal("0.20");
			BigDecimal percentageTierTwo = new BigDecimal("0.40");
			BigDecimal percentageTierThree = new BigDecimal("0.45");
			
			if (mAnnualGrossAmount.compareTo(firstTier) == -1) {
				finalAmount = mAnnualGrossAmount;
			} else if ( mAnnualGrossAmount.compareTo(firstTier) == 1 && 
						(mAnnualGrossAmount.compareTo(secondTier) == 0 ||
						mAnnualGrossAmount.compareTo(secondTier) == -1) ) {
				
				BigDecimal taxableAmount = mAnnualGrossAmount.subtract(firstTier);
				
				// Calculating tax if amount is less than 41,865
				
				BigDecimal tax =  taxableAmount.multiply(percentageTierOne);
				
				finalAmount = mAnnualGrossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
			} else if ( mAnnualGrossAmount.compareTo(secondTier) == 1 &&
						(mAnnualGrossAmount.compareTo(thirdTier) == 0 ||
						mAnnualGrossAmount.compareTo(thirdTier) == -1) ) {
	
				BigDecimal firstTaxableAmount = new BigDecimal("31865");
				BigDecimal secondTaxableAmount = mAnnualGrossAmount.subtract(secondTier);
				
				
				// Calculating tax if amount is between 41,865 and 150,000
				
				BigDecimal tax = ((firstTaxableAmount.multiply(
									percentageTierOne)).add(
									secondTaxableAmount.multiply(
									percentageTierTwo)));
				
				finalAmount = mAnnualGrossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
			} else if ( mAnnualGrossAmount.compareTo(thirdTier) == 1 ) {
				
				BigDecimal firstTaxableAmount = new BigDecimal("31865");
				BigDecimal secondTaxableAmount = thirdTier.subtract(secondTier);
				BigDecimal thirdTaxableAmount = finalTier.subtract(mAnnualGrossAmount);
				
				// Calculating tax if amount is between 150,000 and 200,000
				
				BigDecimal tax = (firstTaxableAmount.multiply(
								   percentageTierOne).add(
								   secondTaxableAmount.multiply(
								   percentageTierTwo).add(
								   thirdTaxableAmount.multiply(
								   percentageTierThree))));
				
				finalAmount = mAnnualGrossAmount.subtract(tax);
			}
			
		} else if (financialPeriod == 2) {
			
			BigDecimal firstTier = new BigDecimal("10600");
			BigDecimal secondTier = new BigDecimal("42385");
			BigDecimal thirdTier = new BigDecimal("150000");
			BigDecimal finalTier = new BigDecimal("200000");
			
			BigDecimal percentageTierOne = new BigDecimal("0.20");
			BigDecimal percentageTierTwo = new BigDecimal("0.40");
			BigDecimal percentageTierThree = new BigDecimal("0.45");
			
			if (mAnnualGrossAmount.compareTo(firstTier) == -1) {
				finalAmount = mAnnualGrossAmount;
			} else if ( mAnnualGrossAmount.compareTo(firstTier) == 1 && 
						(mAnnualGrossAmount.compareTo(secondTier) == 0 ||
						mAnnualGrossAmount.compareTo(secondTier) == -1) ) {
				
				BigDecimal taxableAmount = mAnnualGrossAmount.subtract(firstTier);
				
				// Calculating tax if amount is less than 42,385
				
				BigDecimal tax =  taxableAmount.multiply(percentageTierOne);
				
				finalAmount = mAnnualGrossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
			} else if ( mAnnualGrossAmount.compareTo(secondTier) == 1 &&
						(mAnnualGrossAmount.compareTo(thirdTier) == 0 ||
						mAnnualGrossAmount.compareTo(thirdTier) == -1) ) {
	
				BigDecimal firstTaxableAmount = new BigDecimal("31785");
				BigDecimal secondTaxableAmount = mAnnualGrossAmount.subtract(secondTier);
				
				// Calculating tax if amount is between 42,385 and 150,000
				
				BigDecimal tax = (firstTaxableAmount.multiply(
								  percentageTierOne)).add(
								  secondTaxableAmount.multiply(
								  percentageTierTwo));
				
				finalAmount = mAnnualGrossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
				
			} else if ( mAnnualGrossAmount.compareTo(thirdTier) == 1 ) {
				
				BigDecimal firstTaxableAmount = new BigDecimal("31785");
				BigDecimal secondTaxableAmount = thirdTier.subtract(secondTier);
				BigDecimal thirdTaxableAmount = finalTier.subtract(mAnnualGrossAmount);
				
				// Calculating tax if amount is between 150,000 and 200,000
				
				BigDecimal tax = (firstTaxableAmount.multiply(
								  percentageTierOne).add(
								  secondTaxableAmount.multiply(
								  percentageTierTwo)).add(
								  thirdTaxableAmount.multiply(
								  percentageTierThree)));
				
				finalAmount = mAnnualGrossAmount.subtract(tax);
				System.out.println("Your tax is: " + tax);
			}
		}
		return finalAmount;
	}

	public void run() {
		
		byte mFinancialPeriod = in.getFinancialPeriod();
		model.setmGrossAnnual(in.getUserAmount());
		model.setmGrossMonthly(amountMonthly(model.getmGrossAnnual()));
		model.setmGrossWeekly(amountWeekly(model.getmGrossAnnual()));
		model.setmNetAnnual(netAmountAnnual(mFinancialPeriod,model.getmGrossAnnual()));
		model.setmNetMonthly(amountMonthly(model.getmNetAnnual()));
		model.setmNetWeekly(amountWeekly(model.getmNetAnnual()));
		model.taxValues.put("Gross Amount Annual", model.getmGrossAnnual());
		model.taxValues.put("Gross Amount Monthly", model.getmGrossMonthly());
		model.taxValues.put("Gross Amount Weekly", model.getmGrossWeekly());
		model.taxValues.put("Net Amount Annual", model.getmNetAnnual());
		model.taxValues.put("Net Amount Monthly", model.getmNetMonthly());
		model.taxValues.put("Net Amount Weekly", model.getmNetWeekly());

	}

}
