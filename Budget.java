/**
 * 
 * @author Manpreet
 *
 */
public class Budget {
	private double goal;
	private ExpenseList outFlow;
	private Income inFlow;
	private double timeToAchieve;
	
	/*
	 * Constructors
	 */
	public Budget(ExpenseList outFlow,Income inFlow) {
		this.outFlow = outFlow;
		this.inFlow = inFlow;
	}
	public Budget(Budget toCopy) {
		//Waiting for Income and Expense copy constructors to encapsulate
	}
	
	/*
	 * Methods
	 */
	public void setTimeToAchieve(double expectedTimeFrame) {
		this.timeToAchieve = expectedTimeFrame;

	}
	public double getGoal() {
		return goal;
	}
	
	public void setGoal(double moneyGoal) {
		this.goal = moneyGoal;
	}
	// Waiting on copy method in Income and Expenses to encapsulate getters for outflow and inflow
	public ExpenseList getOutFlow() {
		return outFlow;
		
	}
	
	public Income getInFlow() {
		return inFlow;
	}

	public double calculateNetFlow() {
		return inFlow.getWeeklyPay() - outFlow.totalExpense();
	}
	
	public double calculateWeeklyAmount() {
		return (inFlow.getSavings() + (calculateNetFlow() * timeToAchieve));
	}
	
	public double getRemainingWeekly() {
		return (goal/timeToAchieve) - calculateWeeklyAmount();
	}
	
	public void calculateIfPossible() {
		System.out.println(calculateWeeklyAmount()/goal);
		if(calculateWeeklyAmount()/goal < 1) {
			System.out.println("You won't be able to reach your goal!");
			System.out.println("You would only reach " + (int)((calculateWeeklyAmount()/goal)*100) 
			+ " percent of the way there!");
			System.out.println("You would need to increase your income or decrease your spending by " 
			+ getRemainingWeekly() + " every week!");
		} 
	}
	
	public void showWeeklyGain() {
		for(int i = 0; i < timeToAchieve; i++) {
			System.out.println("Week " + i + ": | Amount gained = " + 
		(inFlow.getSavings() + (calculateNetFlow() * i)));
		}
	}
}
