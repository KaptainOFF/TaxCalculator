
public class Calculator {
	Model model = new Model();
	Input in = new Input();
	
	public double grossAmountMonthly(double input) {
		return input / 12;
	}
	
	public double grossAmountWeekly(double input) {
		return input / 52;
	}
	
	public double netAmountMonthly(double input) {
		return input / 12;
	}
	
	public double netAmountWeekly(double input) {
		return input / 52;
	}
	
	public double netAmountAnnual(byte financialPeriod, double mAnnualGrossAmount) {
		double finalAmount = 0;
		if (financialPeriod == 1) {
			if(mAnnualGrossAmount <= 10000) {
				finalAmount = mAnnualGrossAmount;
			} else if ( mAnnualGrossAmount > 10000 &&  mAnnualGrossAmount <= 41865) {
				double tax;
				double taxableAmount = mAnnualGrossAmount - 10000;
				tax = (double) taxableAmount*20.0/100;
				finalAmount = mAnnualGrossAmount - tax;
			} else if ( mAnnualGrossAmount > 41865 &&  mAnnualGrossAmount <= 150000) {
				double tax;
				double taxableAmount = mAnnualGrossAmount - 10000;
				tax = (double) taxableAmount*40.0/100;
				finalAmount = mAnnualGrossAmount - tax;
			} else if ( mAnnualGrossAmount > 150000 ) {
				double tax;
				double taxableAmount = mAnnualGrossAmount - 10000;
				tax = (double) taxableAmount*45.0/100;
				finalAmount = mAnnualGrossAmount - tax;
			}
		} else if (financialPeriod == 2) {
			if(mAnnualGrossAmount <= 10600) {
				finalAmount = mAnnualGrossAmount;
			} else if ( mAnnualGrossAmount > 10600 &&  mAnnualGrossAmount <= 42365) {
				double tax;
				double taxableAmount = mAnnualGrossAmount - 10600;
				tax = (double) taxableAmount*20.0/100;
				finalAmount = mAnnualGrossAmount - tax;
			} else if ( mAnnualGrossAmount > 42365 &&  mAnnualGrossAmount <= 150000) {
				double tax;
				double taxableAmount = mAnnualGrossAmount - 10600;
				tax = (double) taxableAmount*40.0/100;
				finalAmount = mAnnualGrossAmount - tax;
			} else if ( mAnnualGrossAmount > 150000 ) {
				double tax;
				double taxableAmount = mAnnualGrossAmount - 10000;
				tax = (double) taxableAmount*45.0/100;
				finalAmount = mAnnualGrossAmount - tax;
			}
		}
		return finalAmount;
	}

	public void run() {
		byte mFinancialPeriod = in.getFinancialPeriod();
		model.setmGrossAnnual(in.getUserAmount());
		model.setmGrossMonthly(grossAmountMonthly(model.getmGrossAnnual()));
		model.setmGrossWeekly(grossAmountWeekly(model.getmGrossAnnual()));
		model.setmNetAnnual(netAmountAnnual(mFinancialPeriod,model.getmGrossAnnual()));
		model.setmNetMonthly(netAmountMonthly(model.getmNetAnnual()));
		model.setmNetWeekly(netAmountWeekly(model.getmNetAnnual()));
		model.taxValues.put("Gross Amount Annual", model.getmGrossAnnual());
		model.taxValues.put("Gross Amount Monthly", model.getmGrossMonthly());
		model.taxValues.put("Gross Amount Weekly", model.getmGrossWeekly());
		model.taxValues.put("Net Amount Annual", model.getmNetAnnual());
		model.taxValues.put("Net Amount Monthly", model.getmNetMonthly());
		model.taxValues.put("Net Amount Weekly", model.getmNetWeekly());

	}

}
