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
	
	public RetirementPlan() {
		
	}
	
	public RetirementPlan(int age, float savings, double investmentRate, int retAge, float initSavings) {
		if (age >= 1) {
			this.age = age;
		}
		else {
			this.age = 1;
		}
		
		if (yearlySavings >= 0) {
			this.yearlySavings = savings;}
		else {
			this.yearlySavings = 0;
		}
		
		if (investmentRate >= 0) {
			this.investmentRate = investmentRate;
		}
		else {
			this.investmentRate = 0;
		}
		
		if (retAge > age) {
			this.retirementage = retAge;
		}
		else {
			this.retirementage = age + 1;
		}
		
		if (initSavings >= 0) {
			this.initialSavings = initSavings;
		}
		else {
			this.initialSavings = 0;
		}
	}
	
	public RetirementPlan(RetirementPlan toCopy) {
		this.age = toCopy.age;
		this.yearlySavings = toCopy.yearlySavings;
		this.investmentRate = toCopy.investmentRate;
		this.retirementage = toCopy.retirementage;
		this.initialSavings = toCopy.initialSavings;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int Age) {
		if (Age >= 1) {
		this.age = Age;
		}
		else {
			this.age = 1;
		}
	}

	public double getInvestmentRate() {
		return investmentRate;
	}

	public void setInvestmentRate(double investmentRate) {
		if (investmentRate >= 0) {
		this.investmentRate = investmentRate;
		}
		else {
			this.investmentRate = 0;
			
		}
	}

	public float getYearlySavings() {
		return yearlySavings;
	}

	public void setYearlySavings(float yearlySavings) {
		if (yearlySavings >= 0) {
		this.yearlySavings = yearlySavings;
		}
		else {
			this.yearlySavings = 0;
		}
	}

	public int getRetirementage() {
		return retirementage;
	}

	public void setRetirementage(int retirementage) {
		if(retirementage > age) {
		this.retirementage = retirementage;
		}
		else {
			this.retirementage = age + 1;
		}
	}

	public float getInitialSavings() {
		return initialSavings;
	}

	public void setInitialSavings(float initialSavings) {
		if (initialSavings >= 0) {
		this.initialSavings = initialSavings;
		}
		else {
			this.initialSavings = 0;
		}
	}

	public void calculateYearlyGrowth() {
		
		int yearsToRetirement = calculateYearsToRetirement();
		float initialSavings = this.initialSavings;
		float initialSavingsForDisplay = initialSavings;
		initialSavings = initialSavings + yearlySavings;
		float yearAmount = growth(initialSavings);
		System.out.println("Calculating your money's yearly growth...");
		System.out.println("");
		System.out.println("Year = " + 1 +  " |" + " Amount = $" + yearAmount);
		for (int yearCounter = 2; yearCounter <= yearsToRetirement; yearCounter ++ ) {
			if (yearCounter >= 2) {
			yearAmount = yearAmount + yearlySavings;}
			yearAmount = growth(yearAmount);
			System.out.println("Year = " + yearCounter + " |" + " Amount = $" + yearAmount);
			if (yearCounter == yearsToRetirement) {
				System.out.println("------------------------------------------");
				System.out.println("Based on your chosen risk level and contributions...");
				System.out.println("");
				System.out.println("At age " + (yearCounter + age) + ", you could have a total of $" + yearAmount + " saved for retirement");
				float totalContribution = totalContributions(yearsToRetirement, initialSavingsForDisplay);
				System.out.println("");
				System.out.println("Your total contributions (initial savings and yearly contributions) = $" + totalContribution);
				System.out.println("Total compound interest/growth = $" + (yearAmount - totalContribution));
				System.out.println("");
				System.out.println("Consider contributing more savings for a larger amount saved at retirement.");
				}
				
			}
			
		}
	
	public int calculateYearsToRetirement() {
			int yearsToRetirement = this.retirementage - age;
			return yearsToRetirement;
		}
		
		
	public float growth(float sum) {
		float newAmount =  (float) ((sum) * (1 + (investmentRate)));
		return newAmount;
	}
	
	public float totalContributions(int yearsToRetirement, float initialSavings) {
		float totalContribution = initialSavings + (yearlySavings * yearsToRetirement);
		return totalContribution;
		
		
	}
	
	public float calculateNeededAmountAtRetirement() {
		// not functional yet
		return 0;
		
	}
	
	
	
}
