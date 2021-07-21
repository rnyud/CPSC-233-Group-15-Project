// test
public class RetirementPlan extends Income{
	private int age;
	private double investmentRate;
	private float yearlySavings;
	
	public RetirementPlan() {
		
	}
	
	public RetirementPlan(int age, float savings, double investmentRate) {
		this.age = age;
		this.yearlySavings = savings;
		this.investmentRate = investmentRate;
		
	}
	
	public RetirementPlan(RetirementPlan toCopy) {
		this.age = toCopy.age;
		this.yearlySavings = toCopy.yearlySavings;
		this.investmentRate = toCopy.investmentRate;
	}
	
	public void calculateYearlyGrowth() {
		
		int yearsToRetirement = calculateYearsToRetirement();
		float initialSavings = 10000;
		float initialSavingsForDisplay = initialSavings;
		initialSavings = initialSavings + yearlySavings;
		float yearAmount = growth(initialSavings);
		System.out.println("Calculating your money's yearly growth...");
		System.out.println("");
		System.out.println("Year = " + 1 +  " |" + " Amount = $" + yearAmount);
		for (int yearCounter = 2; yearCounter <= yearsToRetirement; yearCounter ++ ) {
			if (yearCounter > 2) {
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
		int retirementAge = 65;
		int userChosenAge = 65; // placeholder
		
		if (userChosenAge == retirementAge) {
			int yearsToRetirement = retirementAge - age;
			return yearsToRetirement;
		}
		else {
			int yearsToRetirement = userChosenAge - age;
			return yearsToRetirement;
		}
		
		
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
		return 0;
		
	}
	
	
	
}
