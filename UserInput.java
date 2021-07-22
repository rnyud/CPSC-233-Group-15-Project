import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Manpreet
 *
 */
public class UserInput {
	public static Budget getUserInfo(Scanner scn, String userChoice) {
		 ExpenseList expenses = getExpenses(scn,userChoice);
		 Income userInFlow = getUserIncome(scn);
		 System.out.println("Please enter your savings goal/ the amount you want to save:");
		 double goal = scn.nextDouble();
		 System.out.println("Please enter the number of weeks you want to complete this goal by:");
		 int timeLeft = scn.nextInt();
		 Budget userBudget = new Budget(expenses,userInFlow);
		 userBudget.setGoal(goal);
		 userBudget.setTimeToAchieve(timeLeft);
		 return userBudget;
	}
	
	public static Income getUserIncome(Scanner scn) {
		System.out.println("Please add your weekly income:");
		float userIncome = scn.nextFloat();
		System.out.println("Please add the amount you have saved:");
		float userSaved = scn.nextFloat();
		Income userInFlow = new Income(userIncome,userSaved);
		return userInFlow;
	}
	
	public static ExpenseList getExpenses(Scanner scn,String userChoice) {
		 
		 System.out.println("Please add your weekly expenses(Write done once your finished)");
		 ArrayList<Expenses> expenses = new ArrayList<Expenses>();
		 int expenseListLength = 0;
		 while(!userChoice.equalsIgnoreCase("done")) {
			 System.out.println("Please add the name of this expense, followed by the amount of this expense(with a comma):");
			 userChoice = scn.nextLine();
				 if(!userChoice.equalsIgnoreCase("done")) {
					 System.out.println(userChoice.split(",")[1]);
					 float value = Float.valueOf(userChoice.split(",")[1]);
					 Expenses expense = new Expenses(userChoice.split(",")[0],value);
					 expenses.add(expense);
					 expenseListLength++;
				 }
			 }
		 ExpenseList userExpenses = new ExpenseList(expenseListLength);
		 for(Expenses expense: expenses) {
			 userExpenses.addExpense(expense);
		 }
		 return userExpenses;
	}
	
	/**
	 * This function gets user input for the parameters needed for the retirement calculation,
	 * and uses annual income from the income class.
	 * It also shows how much the user can expect to need yearly for retirement.
	 * User can select their risk tolerance; low, medium or high, and receive a projection based on that.
	 * 
	 * @param scn, scanner
	 */
	public static void getRetirement(Scanner scn) {
		 Income incForRetirementPlan = getUserIncome(scn);
		 float inc = incForRetirementPlan.annualIncome();
		 float initSavings = incForRetirementPlan.getSavings();
		 System.out.println("What is your current age?");
		 int ageChoice = scn.nextInt();
		 System.out.println("What is your expected retirement age?");
		 int retAgeChoice = scn.nextInt();
		 System.out.println("Enter your expected monthly contributions:");
		 float monthlySavings = scn.nextFloat();
		 System.out.println("What is your risk tolerance: Low (3% avg. returns), Medium (5% avg. returns), or High? (7% avg. returns)");
		 String riskChoice = scn.next();
		 if (riskChoice.equalsIgnoreCase("low")) {
			 double invRate = 0.03;
			 RetirementPlan lowRisk = new RetirementPlan(ageChoice, (monthlySavings * 12), invRate, retAgeChoice, initSavings);
			 lowRisk.calculateYearlyGrowth();
			 float retirementSpend = lowRisk.calculateAmountNeededPerYear(inc);
			 System.out.println("Expected yearly spending amount: " + retirementSpend);
			 
		 }
		 else if (riskChoice.equalsIgnoreCase("medium")) {
			 double invRate = 0.05;
			 RetirementPlan medRisk = new RetirementPlan(ageChoice, (monthlySavings * 12), invRate, retAgeChoice, initSavings);
			 medRisk.calculateYearlyGrowth();
			 float retirementSpend = medRisk.calculateAmountNeededPerYear(inc);
			 System.out.println("Expected yearly spending amount: " + retirementSpend);
		 }
		 else if (riskChoice.equalsIgnoreCase("high")) {
			 double invRate = 0.07;
			 RetirementPlan highRisk = new RetirementPlan(ageChoice, (monthlySavings * 12), invRate, retAgeChoice, initSavings);
			 highRisk.calculateYearlyGrowth();
			 float retirementSpend = highRisk.calculateAmountNeededPerYear(inc);
			 System.out.println("Expected yearly spending amount: " + retirementSpend);
			 
		 }
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome to the budgeting app");
		System.out.println("What would you like to begin with?\n(Budget, Retirement Plan, or Quit)");
		String userChoice = scn.nextLine();
		while(!userChoice.equalsIgnoreCase("quit")){
			 if(userChoice.equalsIgnoreCase("Budget")) {
				 System.out.println("In Budget");
				 Budget budget = getUserInfo(scn,userChoice);
				 budget.showWeeklyGain();
			 // retirement
			 } 
			 else if(userChoice.equalsIgnoreCase("Retirement Plan")) {
				 System.out.println("Retirement Plan:");
				 System.out.println("");
				 System.out.println("This feature will show a projection of how much you could have saved for retirement,");
				 System.out.println("based on factors such as your current age, retirement age, monthly contributions, and risk tolerance.");
				 System.out.println("");
				 getRetirement(scn);

			 }
			 System.out.println("What would you like to do next?(You can always answer quit to exit!)");
			 userChoice = scn.nextLine();
		}
	}

}
