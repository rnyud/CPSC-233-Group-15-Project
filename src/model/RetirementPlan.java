package model;
/**
 * 
 * @author Rayner
 *
 */
public class RetirementPlan {
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
	
	// Getter for current age
	public int getAge() {
		return age;
	}
	// Setter for current age
	public void setAge(int Age) {
		if (Age >= 1) {
		this.age = Age;
		}
		else {
			this.age = 1;
		}
	}
	// Getter for investment rate of return
	public double getInvestmentRate() {
		return investmentRate;
	}
	//Setter for investment rate of return
	public void setInvestmentRate(double investmentRate) {
		if (investmentRate >= 0) {
		this.investmentRate = investmentRate;
		}
		else {
			this.investmentRate = 0;
		}
	}
	// Getter for yearly savings
	public float getYearlySavings() {
		return yearlySavings;
	}
	// Setter for yearly savings
	public void setYearlySavings(float yearlySavings) {
		if (yearlySavings >= 0) {
		this.yearlySavings = yearlySavings;
		}
		else {
			this.yearlySavings = 0;
		}
	}
	
	// Getter for expected age of retirement
	public int getRetirementage() {
		return retirementage;
	}
	// Setter for expected age of retirement
	public void setRetirementage(int retirementage) {
		if(retirementage > age) {
		this.retirementage = retirementage;
		}
		else {
			this.retirementage = age + 1;
		}
	}
	// Getter for initial savings
	public float getInitialSavings() {
		return initialSavings;
	}
	// Setter for initial savings
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
	 * Prints information to the console for the user to see a year by year breakdown of their savings/investments
	 * Also provides the total amount the user has contributed, and how much interest/growth they have gained
	 */
	public float calculateYearlyGrowth() {
		
		int yearsToRetirement = calculateYearsToRetirement();
		float initialSavings = this.initialSavings;
		// Separate variable that does not get affected by the calculations
		float initialSavingsForDisplay = initialSavings;
		initialSavings = initialSavings + yearlySavings;
		// Use the growth function to do a compounding calculation
		float yearAmount = growth(initialSavings);
		System.out.println("Calculating your money's yearly growth...");
		System.out.println("");
		System.out.println("Year = " + 1 +  " |" + " Amount = $" + yearAmount);
		// This for loop adds the yearly contribution, then uses the growth function to calculate the growth of the money yearly
		// until the retirement age is reached.
		for (int yearCounter = 2; yearCounter <= yearsToRetirement; yearCounter ++ ) {
			if (yearCounter >= 2) {
			yearAmount = yearAmount + yearlySavings;}
			yearAmount = growth(yearAmount);
			System.out.println("Year = " + yearCounter + " |" + " Amount = $" + yearAmount);
			
			// Once the retirement age is reached in the calculation, it will print info to the console
			if (yearCounter == yearsToRetirement) {
				System.out.println("------------------------------------------");
				System.out.println("Your Retirement Breakdown:");
				System.out.println("");
				System.out.println("Based on your chosen risk level and contributions...");
				System.out.println("");
				System.out.println("At age " + (yearCounter + age) + ", you could have a total of $" + yearAmount + " saved for retirement");
				// Use totalContribution function to get the total amount of money the user would invest
				float totalContribution = totalContributions(yearsToRetirement, initialSavingsForDisplay);
				System.out.println("");
				System.out.println("Your total contributions (initial savings and yearly contributions) = $" + totalContribution);
				System.out.println("Total compound interest/growth = $" + (yearAmount - totalContribution));
				System.out.println("");
				System.out.println("Consider contributing more savings for a larger amount saved at retirement.");
				System.out.println("");
				}
			}
		return yearAmount;
			
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
	
}
