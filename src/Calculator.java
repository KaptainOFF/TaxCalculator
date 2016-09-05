
public class Calculator {
	Model model = new Model();
	Input in = new Input();
	
	public double getAnnualNetAmount(byte financialPeriod, double mAnnualGrossAmount) {
		double finalAmount = 0;
		if (financialPeriod == 1 && mAnnualGrossAmount <= 10000) {
			finalAmount = mAnnualGrossAmount;
		} else if ( financialPeriod == 1 && mAnnualGrossAmount > 10000 &&  mAnnualGrossAmount <= 41865) {
			double discount;
			double netAmount = mAnnualGrossAmount - 10000;
			discount = netAmount*20/100.0;
			finalAmount = netAmount - discount;
		}
		return finalAmount;
	}

	public void run() {
		byte mFinancialPeriod = in.getFinancialPeriod();
		model.setmGrossAnnual(in.getUserAmount());
		
		model.taxValues.put("Annual Gross Amount", model.getmGrossAnnual());
		model.taxValues.put("Annual Net Amount", getAnnualNetAmount(mFinancialPeriod,model.getmGrossAnnual()));
		
		for (String key : model.taxValues.keySet()) {
			System.out.printf("%s , %.2f%n",key, model.taxValues.get(key));
		}

	}

}
