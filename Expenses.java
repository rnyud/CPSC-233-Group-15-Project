
public class Expenses {
	String expenseName;
	float expenseValue;
	
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
