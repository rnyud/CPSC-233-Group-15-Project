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
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Hello, what would you like to begin with?");
		String userChoice = scn.nextLine();
		while(!userChoice.equalsIgnoreCase("quit")){
			 if(userChoice.equalsIgnoreCase("Budget")) {
				 Budget budget = getUserInfo(scn,userChoice);
				 budget.calculateIfPossible();
				 System.out.println("In Budget");
				 // retirement
			 } 
			 else if(userChoice.equalsIgnoreCase("Retirement Plan")) {
				 System.out.println("In Retirement Plan");
				 System.out.println("What is your current age?");
				 int ageChoice = scn.nextInt();
				 System.out.println("What is your expected retirement age?");
				 int retAgeChoice = scn.nextInt();
				 System.out.println("Enter your current amount of savings:");
				 float initSavings = scn.nextFloat(); 
				 System.out.println("Enter your expected monthly contributions:");
				 float monthlySavings = scn.nextFloat();
				 System.out.println("Low (3% avg. returns), Medium (5% avg. returns), or High? (7% avg. returns)");
				 String riskChoice = scn.next();
				 if (riskChoice.equalsIgnoreCase("low")) {
					 double invRate = 0.03;
					 RetirementPlan lowRisk = new RetirementPlan(ageChoice, (monthlySavings * 12), invRate, retAgeChoice, initSavings);
					 lowRisk.calculateYearlyGrowth();
					 
				 }
				 else if (riskChoice.equalsIgnoreCase("medium")) {
					 double invRate = 0.05;
					 RetirementPlan medRisk = new RetirementPlan(ageChoice, (monthlySavings * 12), invRate, retAgeChoice, initSavings);
					 medRisk.calculateYearlyGrowth();
					 
				 }
				 else if (riskChoice.equalsIgnoreCase("high")) {
					 double invRate = 0.07;
					 RetirementPlan highRisk = new RetirementPlan(ageChoice, (monthlySavings * 12), invRate, retAgeChoice, initSavings);
					 highRisk.calculateYearlyGrowth();
					 
				 }
			 }
			 System.out.println("What would you like to do next?(You can always answer quit to exit!)");
			 userChoice = scn.nextLine();
		}
	}

}
