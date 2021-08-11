package model;
/**
 * This class functions to create an Expenses object that will contain two vital
 * pieces of information, the value of a given expense and its name. 
 * 
 * @author Timofei
 *
 */
public class Expenses {
	/**
	 * Expenses is a relatively light class, as it exists mainly to act as an object 
	 * and store two values, the name of a given expense and its value, so as to
	 * be later included in a greater list of expenses. 
	 */
	private String expenseName;
	private float expenseValue;
	
	/**
	 * Constructor for an expense.
	 * @param name The name of the expense.
	 * @param value The value of the expense.
	 */
	public Expenses(String name, float value) {
		expenseName = name;
		expenseValue = value;
	}
	
	/**
	 * The getter of the expense value.
	 * @return The expense value.
	 */
	public float getExpenseValue() {
		return expenseValue;
	}

	/**
	 * The getter of the expense name.
	 * @return The expense name.
	 */
	public String getExpenseName() {
		return expenseName;
	}
	
	

}
