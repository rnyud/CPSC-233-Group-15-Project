package model;

import application.MainMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * This class provides the logic for the RetirementController class,
 * and also works for text-based version as well.
 * 
 * @author Rayner
 *
 */
public class RetirementPlan extends MainMenu{
	private int age;
	private double investmentRate;
	private float yearlySavings;
	private int retirementage;
	private float initialSavings;
	
	// Default constructor
	public RetirementPlan() {
		
	}
	/**
	 * Constructor for RetirementPlan, takes 5 parameters:
	 * @param age, current age of the user
	 * @param savings, the users yearly savings
	 * @param investmentRate, the investment rate that is assumed for the computations, chosen by the user:
	 * low, medium or high risk ^
	 * @param retAge, the users expected age of retirement
	 * @param initSavings, the users initial amount of savings, usually grabbed from the Income class 
	 */
	public RetirementPlan(int age, float savings, double investmentRate, int retAge, float initSavings) {
		// Age must be 1 or greater
		if (age >= 1) {
			this.age = age;
		}
		else {
			this.age = 1;
		}
		// Yearly savings cannot be negative for this calculation
		if (yearlySavings >= 0) {
			this.yearlySavings = savings;}
		else {
			this.yearlySavings = 0;
		}
		// Rate of return cannot be negative for this calculation
		if (investmentRate >= 0) {
			this.investmentRate = investmentRate;
		}
		else {
			this.investmentRate = 0;
		}
		// Retirement age must be at least one year from current age
		if (retAge > age) {
			this.retirementage = retAge;
		}
		else {
			this.retirementage = age + 1;
		}
		// Initial savings cannot be negative for this calculation
		if (initSavings >= 0) {
			this.initialSavings = initSavings;
		}
		else {
			this.initialSavings = 0;
		}
	}
	/**
	 * Copy constructor
	 * @param toCopy, another RetirementPlan object to be copied
	 */
	public RetirementPlan(RetirementPlan toCopy) {
		this.age = toCopy.age;
		this.yearlySavings = toCopy.yearlySavings;
		this.investmentRate = toCopy.investmentRate;
		this.retirementage = toCopy.retirementage;
		this.initialSavings = toCopy.initialSavings;
	}
	// The upcoming setters and getters use the same constraints as the constructors
	
	/**
	 * Getter for current age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Setter for current age.
	 * @param Age, curent age.
	 */
	public void setAge(int Age) {
		if (Age >= 1) {
		this.age = Age;
		}
		else {
			this.age = 1;
		}
	}
	
	/**
	 * Getter for investment rate of return.
	 * @return investmentRate
	 */
	public double getInvestmentRate() {
		return investmentRate;
	}
	
	/**
	 * Setter for investment rate of return.
	 * @param investmentRate
	 */
	public void setInvestmentRate(double investmentRate) {
		if (investmentRate >= 0) {
		this.investmentRate = investmentRate;
		}
		else {
			this.investmentRate = 0;
		}
	}
	/**
	 * Getter for yearly savings.
	 * @return yearlySavings
	 */
	public float getYearlySavings() {
		return yearlySavings;
	}
	
	/**
	 * Setter for yearly savings.
	 * @param yearlySavings
	 */
	public void setYearlySavings(float yearlySavings) {
		// Must be greater than 0
		if (yearlySavings >= 0) {
		this.yearlySavings = yearlySavings;
		}
		else {
			this.yearlySavings = 0;
		}
	}
	
	/**
	 * Getter for expected age of retirement.
	 * @return retirementage
	 */
	public int getRetirementage() {
		return retirementage;
	}
	
	/**
	 * Setter for expected age of retirement
	 * @param retirementage
	 */
	public void setRetirementage(int retirementage) {
		if(retirementage > age) {
		this.retirementage = retirementage;
		}
		else {
			this.retirementage = age + 1;
		}
	}
	
	/**
	 * Getter for initial savings.
	 * @return initialSavings
	 */
	public float getInitialSavings() {
		return initialSavings;
	}
	
	/**
	 * Setter for initial savings.
	 * @param initialSavings
	 */
	public void setInitialSavings(float initialSavings) {
		if (initialSavings >= 0) {
		this.initialSavings = initialSavings;
		}
		else {
			this.initialSavings = 0;
		}
	}
	
	/**
	 * Method for calculating the yearly growth using a for loop:
	 * Adds contributions after compounding them, therefore it is not just compounding the initial amount of savings
	 * The code has been refactored to use other methods to do the printing.
	 * Also provides the total amount the user has contributed, and how much interest/growth they have gained
	 * @return yearAmount
	 */
	public float calculateYearlyGrowth() {
		
		int yearsToRetirement = calculateYearsToRetirement();
		float initialSavings = this.initialSavings;
		// Separate variable that does not get affected by the calculations
		float initialSavingsForDisplay = initialSavings;
		initialSavings = initialSavings + yearlySavings;
		// Use the growth function to do a compounding calculation
		float yearAmount = growth(initialSavings);
		// Start with year one
		printYearlyInfo(1, yearAmount);
		// This for loop adds the yearly contribution, then uses the growth function to calculate the growth of the money yearly
		// until the retirement age is reached.
		for (int yearCounter = 2; yearCounter <= yearsToRetirement; yearCounter ++ ) {
			if (yearCounter >= 2) {
			yearAmount = yearAmount + yearlySavings;
			}
			yearAmount = growth(yearAmount);
			printYearlyInfo(yearCounter, yearAmount);
			// Once the retirement age is reached in the calculation, it will print info to the console
			if (yearCounter == yearsToRetirement) {
				// Use totalContribution function to get the total amount of money the user would invest
				float totalContribution = totalContributions(yearsToRetirement, initialSavingsForDisplay);
				printFinal(totalContribution, yearCounter,yearAmount,age);
				
				}
			}
		return yearAmount;
			
		}
	/**
	 * This method prints the yearly info to the console.
	 * @param yearCounter
	 * @param yearAmount
	 */
	public void printYearlyInfo(int yearCounter, float yearAmount) {
		System.out.println("Year = " + yearCounter + " |" + " Amount = $" + yearAmount);
	}
	/**
	 * This method prints the required info to the console after the calculations are finished.
	 * @param totalContribution
	 * @param yearCounter
	 * @param yearAmount
	 * @param age
	 */
	public void printFinal(float totalContribution, int yearCounter, float yearAmount, int age) {
		System.out.println("------------------------------------------");
		System.out.println("Your Retirement Breakdown:");
		System.out.println("");
		System.out.println("Based on your chosen risk level and contributions...");
		System.out.println("");
		System.out.println("At age " + (yearCounter + age) + ", you could have a total of $" + yearAmount + " saved for retirement");
		System.out.println("");
		System.out.println("Your total contributions (initial savings and yearly contributions) = $" + totalContribution);
		System.out.println("Total compound interest/growth = $" + (yearAmount - totalContribution));
		System.out.println("");
		System.out.println("Consider contributing more savings for a larger amount saved at retirement.");
		System.out.println("");
		
	}
	
	/**
	 * This function gets the amount of years left until retirement, so that the for loop in 
	 * calculateYearlyGrowth can work properly
	 * @return yearsToRetirement
	 */
	public int calculateYearsToRetirement() {
			int yearsToRetirement = this.retirementage - age;
			return yearsToRetirement;
		}
		
	/**
	 * This function does a compound interest calculation which is used heavily in calculateYearlyGrowth
	 * @param sum, the total amount of money currently
	 * @return newAmount, the new total amount of money after it has been compounded
	 */
	public float growth(float sum) {
		float newAmount =  (float) ((sum) * (1 + (investmentRate)));
		return newAmount;
	}
	
	/**
	 * This function gets the users total contributions, not including interest gained
	 * @param yearsToRetirement
	 * @param initialSavings
	 * @return totalContribution
	 */
	public float totalContributions(int yearsToRetirement, float initialSavings) {
		float totalContribution = initialSavings + (yearlySavings * yearsToRetirement);
		return totalContribution;
		
		
	}
	/**
	 * This function gives the user a projection based on their income, of how much they might need per year in retirement.
	 * @param annualIncome
	 * @return retirementSpending, expected yearly spending amount
	 */
	public float calculateAmountNeededPerYear(float annualIncome) {
		float retirementSpending = (float) (annualIncome * 0.8);
		return retirementSpending;
		
	}
	/**
	 * This method returns the amount of years the users potential 
	 * retirement savings could last, based on the calculateAmountNeededPerYear function,
	 * and the total amount of potential savings.
	 * @param yearAmount, final retirement savings amount after compounding
	 * @param retirementSpending, projected expenses at retirement
	 * @return yearsLasted, the amount of years the savings could last
	 */
	public float savingsYearsLasted(float yearAmount, float retirementSpending) {
		float yearsLasted = yearAmount / retirementSpending;
		return yearsLasted;
		
	}

}
