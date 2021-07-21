/**
 * 
 * @author Manpreet
 *
 */
public class Budget {
	private double goal;
	private Expenses outFlow;
	private Income inFlow;
	private double timeToAchieve;
	
	/*
	 * Constructors
	 */
	public Budget(Expenses outFlow,Income inFlow) {
		this.outFlow = outFlow;
		this.inFlow = inFlow;
	}
	public Budget(Budget toCopy) {
		//Waiting for Income and Expense copy constructors to encapsulate
	}
	
	/*
	 * Methods
	 */
	public double getGoal() {
		return goal;
	}
	
	public void setGoal(double moneyGoal) {
		this.goal = moneyGoal;
	}
	// Waiting on copy method in Income and Expenses to encapsulate getters for outflow and inflow
	public Expenses getOutFlow() {
		return null;
		
	}
	
	public Income getInFlow() {
		return null;
	}
	
	//Waiting on Expenses and Income classes to complete

	public double calculateAmountLeft() {
		return 0;
	}
	
	public double calculateTimeToAchieveGoal() {
		return 0;
	}
}
