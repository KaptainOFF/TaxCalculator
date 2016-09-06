import java.util.Map;
import java.util.TreeMap;


public class Model {
	Map<String, Double> taxValues = new TreeMap<>();
	
	private double grossAnnual;
	private double mGrossMonthly;
	private double mGrossWeekly;
	private double mNetAnnual;
	private double mNetMonthly;
	private double mNetWeekly;
	
	public double getmGrossAnnual() {
		return grossAnnual;
	}
	public void setmGrossAnnual(double mGrossAnnual) {
		this.grossAnnual = mGrossAnnual;
	}
	public double getmGrossMonthly() {
		return mGrossMonthly;
	}
	public void setmGrossMonthly(double mGrossMonthly) {
		this.mGrossMonthly = mGrossMonthly;
	}
	public double getmGrossWeekly() {
		return mGrossWeekly;
	}
	public void setmGrossWeekly(double mGrossWeekly) {
		this.mGrossWeekly = mGrossWeekly;
	}
	public double getmNetAnnual() {
		return mNetAnnual;
	}
	public void setmNetAnnual(double mNetAnnual) {
		this.mNetAnnual = mNetAnnual;
	}
	public double getmNetMonthly() {
		return mNetMonthly;
	}
	public void setmNetMonthly(double mNetMonthly) {
		this.mNetMonthly = mNetMonthly;
	}
	public double getmNetWeekly() {
		return mNetWeekly;
	}
	public void setmNetWeekly(double mNetWeekly) {
		this.mNetWeekly = mNetWeekly;
	}

}
