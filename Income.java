/**
 * 
 * @author timof
 *
 */
public class Income {
	float weeklyPay;
	float savings;
	public static final int WORKING_WEEKS = 52;
	
	//test
	public Income() {}
	
	public Income(float pay) {
		this.weeklyPay = pay;
		savings = 0;
	}
	
	public Income(float pay, float saved) {
		this.weeklyPay = pay;
		this.savings = saved;
	}
	
	
	public float annualIncome() {
		float annualPay = weeklyPay*WORKING_WEEKS;
		
		return annualPay;
	}
	
	public void savingsDeduction(float amount) {
		savings-=amount;
	}
	
	public void savingsAddition(float amount) {
		savings+=amount;
	}
	
	public void ReturnOnStableInvestment (float investment, float returnPeriod, float percentageGain) {
		savingsDeduction(investment);
		float returnOnInvestment = (investment*returnPeriod*percentageGain);
		savingsAddition(returnOnInvestment);
		
	}
}
