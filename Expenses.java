/**
 * 
 * @author timof
 *
 */
public class Expenses {
	private String expenseName;
	private float expenseValue;
	
	public Expenses(String name, float value) {
		expenseName = name;
		expenseValue = value;
	}
	

	float getExpenseValue() {
		return expenseValue;
	}

	String getExpenseName() {
		return expenseName;
	}
	
	

}
