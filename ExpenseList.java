/**
 * 
 * @author timof
 *
 */
public class ExpenseList {
	private Expenses[] expenseList;
	
	/**
	 * The constructor expense list, takes the number of expenses.
	 * @param num The number of expenses.
	 */
	public ExpenseList(int num) {
		if(num<1) {
			num = 1;
		}
		expenseList = new Expenses[num];
	}
	
	/**
	 * Adds an expense to the expense list.
	 * @param expense The expense to be added to the list.
	 */
	public void addExpense(Expenses expense) {
		if(expense!=null) {
			int index = 0;
			for(; index < expenseList.length && expenseList[index] != null; index++) {
			}
			expenseList[index] = expense;
		}
	}
	
	/**
	 * The sum of all the expense values within the list.
	 * @return The total expense value of all the expenses.
	 */
	public float totalExpense() {
		float total = 0;
		for(Expenses expense : getExpenseList()) {
			total+=expense.getExpenseValue();
		}
		return total;
	}

	/**
	 * A getter for the expense list.
	 * @return The expense list.
	 */
	public Expenses[] getExpenseList() {
		return expenseList;
	}

}
