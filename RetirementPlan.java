// test
public class RetirementPlan extends Income{
	private int age;
	private double investmentRate;
	private float monthlySavings;
	
	public RetirementPlan() {
		
	}
	
	public RetirementPlan(int age, float savings, double investmentRate) {
		this.age = age;
		this.monthlySavings = savings;
		this.investmentRate = investmentRate;
		
	}
	
	public RetirementPlan(RetirementPlan toCopy) {
		this.age = toCopy.age;
		this.monthlySavings = toCopy.monthlySavings;
		this.investmentRate = toCopy.investmentRate;
	}
	
	public void calculateYearlyGrowth() {
		
		int yearsToRetirement = calculateYearsToRetirement();
		float initialSavings = 10000;
		initialSavings = initialSavings + monthlySavings;
		float yearAmount = growth(initialSavings);
		System.out.println(yearAmount);
		for (int yearCounter = 2; yearCounter <= yearsToRetirement; yearCounter ++ ) {
			if (yearCounter > 2) {
			yearAmount = yearAmount + monthlySavings;}
			yearAmount = growth(yearAmount);
			System.out.println("Year = " + yearCounter + " Amount = $" + yearAmount);
			
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
	/**
	 * This method returns the total amount at the retirement age using a compound interest formula.
	 * @param initialSavings
	 * @return retirementTotal
	 */
	public float totalGrowth(float initialSavings) {
		int yearsToRetirement = calculateYearsToRetirement();
		float retirementTotal = (float) ((initialSavings) * Math.pow((1 + (investmentRate)), yearsToRetirement));
		return retirementTotal;
		
	}
	
	public float growth(float sum) {
		float newAmount =  (float) ((sum) * (1 + (investmentRate)));
		return newAmount;
	}
	
	
	
}
