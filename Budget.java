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
		return goal - calculateWeeklyAmount();
	}
	
	public void printResult(Boolean achieved, int weekAchieved) {
		if(!achieved) {
			System.out.println("You won't be able to reach your goal!");
			System.out.println("You would only reach " + (int)((calculateWeeklyAmount()/goal)*100) 
			+ " percent of the way there!");
			System.out.println("You would need to increase your income or decrease your spending by " 
			+ getRemainingWeekly() + " every week!");
		} else {
			System.out.println("You will achieve your goal by Week:" + weekAchieved);
		}
	}
	
	public void showWeeklyGain() {
		int weekAchieved = -1;
		System.out.println("Calculating amount gained over "+ (int)timeToAchieve +" weeks...");
		for(int i = 0; i < timeToAchieve; i++) {
			inFlow.weeklyIncome(outFlow);
			if(inFlow.getSavings() >= goal && weekAchieved == -1) {
				weekAchieved = i;
			}
			System.out.println("Week " + i + ": | Amount gained as savings = " + 
		    inFlow.getSavings());
		}
		if(weekAchieved > -1) {
			printResult(true,weekAchieved);
		} else {
			printResult(false,0);
		}
	}
}
