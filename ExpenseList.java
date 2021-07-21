/**
 * 
 * @author timof
 *
 */
public class ExpenseList {
	private Expenses[] expenseList;
	//Expense List, contains all of the expenses in a list
	public ExpenseList(int num) {
		if(num<1) {
			num = 1;
		}
		expenseList = new Expenses[num];
	}
	
	public void addExpense(Expenses expense) {
		if(expense!=null) {
			int index = 0;
			for(; index < expenseList.length && expenseList[index] != null; index++) {
			}
			expenseList[index] = expense;
		}
	}
	
	public float totalExpense() {
		float total = 0;
		for(Expenses expense : getExpenseList()) {
			total+=expense.getExpenseValue();
		}
		return total;
	}

	Expenses[] getExpenseList() {
		return expenseList;
	}

}
