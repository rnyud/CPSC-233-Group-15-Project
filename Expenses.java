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
	

	public float getExpenseValue() {
		return expenseValue;
	}

	public String getExpenseName() {
		return expenseName;
	}
	
	

}
