/**
 * 
 * @author timof
 *
 */
public class Income {
	private float weeklyPay;
	private float savings;
	public static final int WORKING_WEEKS = 52;
	
	//test
	public Income() {}
	//Additional changes
	public Income(float pay) {
		this.weeklyPay = pay;
		savings = 0;
	}
	
	public Income(float pay, float saved) {
		this.weeklyPay = pay;
		this.savings = saved;
	}
	
	public Income(Income incomeCopy) {
		this.weeklyPay = incomeCopy.weeklyPay;
		this.savings = incomeCopy.savings;
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
	
	//public float monthlySavings(float percentPay) {
		//float monthSaved = weeklyPay*percentPay*4;
		//savings+=monthSaved;
		//return monthSaved;
	//}
	
	public void savingsAfterMonthlyExpenses(ExpenseList allExpenses) {
		float total = allExpenses.totalExpense();
		float monthlyIncome = weeklyPay*4;
		monthlyIncome-=total;
		if(monthlyIncome > 0){
			savingsAddition(monthlyIncome);
		}
		else if (monthlyIncome < 0) {
			savingsDeduction(monthlyIncome);
		}
	}
	
	public void ReturnOnStableInvestment (float investment, float returnPeriod, float percentageGain) {
		savingsDeduction(investment);
		float returnOnInvestment = (investment*returnPeriod*percentageGain);
		savingsAddition(returnOnInvestment);
		
	}
}
