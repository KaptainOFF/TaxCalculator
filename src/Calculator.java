
public class Calculator {
	Model model = new Model();
	Input in = new Input();
	
	public double getAnnualNetAmount(byte financialPeriod, double mAnnualGrossAmount) {
		double finalAmount = 0;
		if (financialPeriod == 1) {
			if(mAnnualGrossAmount <= 10000) {
				finalAmount = mAnnualGrossAmount;
			} else if ( mAnnualGrossAmount > 10000 &&  mAnnualGrossAmount <= 41865) {
				double tax;
				double taxableAmount = mAnnualGrossAmount - 10000;
				tax = (double) taxableAmount*20.0/100;
				System.out.println(tax);
				finalAmount = mAnnualGrossAmount - tax;
			} else if ( mAnnualGrossAmount > 41865 &&  mAnnualGrossAmount <= 150000) {
				double tax;
				double taxableAmount = mAnnualGrossAmount - 10000;
				tax = (double) taxableAmount*40.0/100;
				System.out.println(tax);
				finalAmount = mAnnualGrossAmount - tax;
			} else if ( mAnnualGrossAmount > 150000 ) {
				double tax;
				double taxableAmount = mAnnualGrossAmount - 10000;
				tax = (double) taxableAmount*45.0/100;
				System.out.println(tax);
				finalAmount = mAnnualGrossAmount - tax;
			}
			} else if (financialPeriod == 2) {
				if(mAnnualGrossAmount <= 10600) {
					finalAmount = mAnnualGrossAmount;
				} else if ( mAnnualGrossAmount > 10600 &&  mAnnualGrossAmount <= 42365) {
					double tax;
					double taxableAmount = mAnnualGrossAmount - 10600;
					tax = (double) taxableAmount*20.0/100;
					System.out.println(tax);
					finalAmount = mAnnualGrossAmount - tax;
				} else if ( mAnnualGrossAmount > 42365 &&  mAnnualGrossAmount <= 150000) {
					double tax;
					double taxableAmount = mAnnualGrossAmount - 10600;
					tax = (double) taxableAmount*40.0/100;
					System.out.println(tax);
					finalAmount = mAnnualGrossAmount - tax;
				} else if ( mAnnualGrossAmount > 150000 ) {
					double tax;
					double taxableAmount = mAnnualGrossAmount - 10000;
					tax = (double) taxableAmount*45.0/100;
					System.out.println(tax);
					finalAmount = mAnnualGrossAmount - tax;
				}
			}
		return finalAmount;
	}

	public void run() {
		byte mFinancialPeriod = in.getFinancialPeriod();
		model.setmGrossAnnual(in.getUserAmount());
		getAnnualNetAmount(mFinancialPeriod,model.getmGrossAnnual());
		model.taxValues.put("Annual Gross Amount", model.getmGrossAnnual());
		model.taxValues.put("Annual Net Amount", getAnnualNetAmount(mFinancialPeriod,model.getmGrossAnnual()));

	}

}
