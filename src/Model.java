import java.util.Map;
import java.util.TreeMap;
import java.math.BigDecimal;


public class Model {
	Map<String, BigDecimal> taxValues = new TreeMap<>();
	
	private BigDecimal grossAnnual;
	private BigDecimal mGrossMonthly;
	private BigDecimal mGrossWeekly;
	private BigDecimal mNetAnnual;
	private BigDecimal mNetMonthly;
	private BigDecimal mNetWeekly;
	
	public BigDecimal getmGrossAnnual() {
		return grossAnnual;
	}
	public void setmGrossAnnual(BigDecimal mGrossAnnual) {
		this.grossAnnual = mGrossAnnual;
	}
	public BigDecimal getmGrossMonthly() {
		return mGrossMonthly;
	}
	public void setmGrossMonthly(BigDecimal mGrossMonthly) {
		this.mGrossMonthly = mGrossMonthly;
	}
	public BigDecimal getmGrossWeekly() {
		return mGrossWeekly;
	}
	public void setmGrossWeekly(BigDecimal mGrossWeekly) {
		this.mGrossWeekly = mGrossWeekly;
	}
	public BigDecimal getmNetAnnual() {
		return mNetAnnual;
	}
	public void setmNetAnnual(BigDecimal mNetAnnual) {
		this.mNetAnnual = mNetAnnual;
	}
	public BigDecimal getmNetMonthly() {
		return mNetMonthly;
	}
	public void setmNetMonthly(BigDecimal mNetMonthly) {
		this.mNetMonthly = mNetMonthly;
	}
	public BigDecimal getmNetWeekly() {
		return mNetWeekly;
	}
	public void setmNetWeekly(BigDecimal mNetWeekly) {
		this.mNetWeekly = mNetWeekly;
	}

}
