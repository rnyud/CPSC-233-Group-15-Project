
public class Income {
	int weeklyPay;
	int savings;
	public static final int WORKING_WEEKS = 52;
	
	
	public Income() {}
	
	public Income(int pay) {
		this.weeklyPay = pay;
		savings = 0;
	}
	
	public Income(int pay, int saved) {
		this.weeklyPay = pay;
		this.savings = saved;
	}
	
	
	public int AnnualIncome() {
		int annualPay = weeklyPay*WORKING_WEEKS;
		
		return annualPay;
	}
}
