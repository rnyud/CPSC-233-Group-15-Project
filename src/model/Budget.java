package model;
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
	

	/**
	 * Constructor for a standard budget object using an Expenselist and an income object.
	 * 
	 * @param outFlow, ExpenseList object representing total expenses
	 * @param inFlow, Income object representing total income and savings
	 */
	public Budget(ExpenseList outFlow,Income inFlow) {
		this.outFlow = outFlow;
		this.inFlow = inFlow;
	}


	/**
	 * Setter for instance variable timeToAchieve, most likely set using user input.
	 * 
	 * @param expectedTimeFrame, double representing expected time to reach goal
	 */
	public void setTimeToAchieve(double expectedTimeFrame) {
		this.timeToAchieve = expectedTimeFrame;
	}
	
	/**
	 * Getter for instance variable goal
	 * 
	 * @return goal, double representing amount of money that the user wants to reach.
	 */
	public double getGoal() {
		return goal;
	}
	
	/**
	 * Setter for instance variable goal.
	 * 
	 * @param moneyGoal
	 */
	public void setGoal(double moneyGoal) {
		this.goal = moneyGoal;
	}
	
	/**
	 * (Private Helper Method)
	 * Calculates the net gain/loss weekly from total weekly pay subtracted by weekly expenses.
	 * 
	 * @return 
	 */
	private double calculateNetFlow() {
		return inFlow.getSavings() - outFlow.totalExpense();
	}
	
	/**
	 * (Private Helper Method)
	 * Calculates the remaining weekly amount before reaching the goal
	 * 
	 * @return
	 */
	private double getRemainingWeekly() {
		return (goal - (calculateNetFlow()))/timeToAchieve;
	}
	
	/**
	 * Prints out the result of whether the user will be able to achieve their goal in the number
	 * of weeks they have previously specified, also shows the percentage and amount they need to
	 * achieve their goal and if they do manage to achieve their goal, the week in which they achieve
	 * it.
	 * 
	 * @param achieved, boolean representing whether or not the user will achieve their goal
	 * @param weekAchieved, int representing the week they achieved their goal
	 */
	public void printResult(boolean achieved, int weekAchieved) {
		if(!achieved) {
			System.out.println("You won't be able to reach your goal!");
			System.out.println("You would only reach " + (int)((calculateNetFlow()/goal)*100) 
			+ " percent of the way there!");
			System.out.println("You would need to increase your income or decrease \nyour spending by " 
			+ getRemainingWeekly() + " every week!\n");
		} else {
			System.out.println("You will achieve your goal by Week:" + weekAchieved + "\n");
		}
	}
	
	/**
	 * This function displays the amount a user will gain weekly over a specified period of
	 * weeks, and checks to see if and when they achieve their goal
	 * 
	 */
	public void showWeeklyGain() {
		int weekAchieved = -1;
		System.out.println("\nCalculating amount gained over "+ (int)timeToAchieve +" weeks...\n\n" +
		"---------------------------------");
		for(int i = 0; i < timeToAchieve; i++) {
			inFlow.weeklyIncome(outFlow);
			if(inFlow.getSavings() >= goal && weekAchieved == -1) {
				weekAchieved = i;
			}
			System.out.println("Week " + i + ": | Amount in savings = " + 
		    inFlow.getSavings());
		}
		System.out.println("---------------------------------");
		if(weekAchieved > -1) {
			printResult(true,weekAchieved);
		} else {
			printResult(false,0);
		}
	}
}
