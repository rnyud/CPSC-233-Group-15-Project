/**
 * 
 * @author timof
 *
 */
public class Income {
	private float weeklyPay;
	private float savings;
	public static final int WORKING_WEEKS = 48;
	//Working weeks was extrapolated from paid time off, vacation days
	//and sick leave.
	public static final int AVERAGE_WEEKS_IN_MONTH = 4;
	
	/**
	 * Default constructor.
	 */
	public Income() {}
	
	/**
	 * Constructor if object called with payment but no savings.
	 * @param pay The amount the user receives her week.
	 * Savings set to zero.
	 */
	public Income(float pay) {
		System.out.println("Pay checker" + pay);
		this.weeklyPay = pay;
		savings = 0;
	}
	
	/**
	 * Constructor for when the object is called with pay and savings.
	 * @param pay The user's pay per week.
	 * @param saved The user's savings.
	 */
	public Income(float pay, float saved) {
		this.weeklyPay = pay;
		this.savings = saved;
	}
	
	/**
	 * The copy constructor.
	 * @param incomeCopy The object to copy.
	 */
	public Income(Income incomeCopy) {
		this.weeklyPay = incomeCopy.getWeeklyPay();
		this.savings = incomeCopy.getSavings();
	}
	
	/**
	 * Calculates the pay per year.
	 * @return The annual pay.
	 * Multiplies the weekly pay by the constant of working weeks in a year.
	 */
	public float annualIncome() {
		float annualPay = getWeeklyPay()*WORKING_WEEKS;
		return annualPay;
	}
	
	/**
	 * Deducts a certain amount from the savings variable.
	 * @param amount Amount deducted from savings.
	 */
	public void savingsDeduction(float amount) {
		savings = getSavings() - amount;
	}
	
	/**
	 * Adds a certain amount to the savings variable.
	 * @param amount Amount added to savings.
	 */
	public void savingsAddition(float amount) {
		savings = getSavings() + amount;
	}
	
	/**
	 * Calculates the resulting savings after factoring in monthly pay and expenses.
	 * @param allExpenses The list of Expenses for a given week.
	 */
	public void savingsAfterMonthlyExpenses(ExpenseList allExpenses) {
		// This method takes the total of every weekly expense, multiplies by the amount of weeks
		// in a month, and subtracts it from the user's income to see if they came out even,
		// or not. If they spent less than they made, that surplus is added to savings.
		// If they spent more than they made, the surplus is subtracted from savings,
		// indicating that the user had to dip into their savings for all of their expenses.
		// In future iterations, will consider making certain expenses optional and others
		// mandatory.
		float total = allExpenses.totalExpense()*AVERAGE_WEEKS_IN_MONTH;
		float monthlyIncome = getWeeklyPay()*AVERAGE_WEEKS_IN_MONTH;
		monthlyIncome-=total;
		if(monthlyIncome > 0){
			savingsAddition(monthlyIncome);
		}
		else if (monthlyIncome < 0) {
			savingsDeduction(monthlyIncome);
		}
	}
	
	/**
	 * Calculates the resulting savings after factoring in weekly pay and expenses, and returns 
	 * the income for the week with the expenses subtracted.
	 * @param allExpenses
	 * @return The amount earned or lost after subtracting expenses from a week's pay.
	 */
	public float weeklyIncome(ExpenseList allExpenses) {
		// This method behaves in a similar way to savingsAfterMonthlyExpenses,
		// but works for a given week as opposed to a month.
		float total = allExpenses.totalExpense();
		float weekPay = getWeeklyPay() - total;
		if(weekPay > 0){
			savingsAddition(weekPay);
		}
		else if (weekPay < 0) {
			savingsDeduction(weekPay);
		}
		return weekPay;
	}
	
	/**
	 * A getter for weekly pay.
	 * @return The weekly income for the user.
	 */
	public float getWeeklyPay() {
		return weeklyPay;
	}
	
	/**
	 * A getter for the total savings.
	 * @return The user's savings.
	 */
	public float getSavings() {
		return savings;
	}
}
