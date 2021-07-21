// test
public class RetirementPlan extends Income{
	private int age;
	private float income;
	private double investmentRate;
	private float monthlySavings;
	
	public RetirementPlan() {
		
	}
	
	public RetirementPlan(float income, int age, float savings, double investmentRate) {
		this.income = income;
		this.age = age;
		this.monthlySavings = savings;
		this.investmentRate = investmentRate;
		
	}
	
	public RetirementPlan(RetirementPlan toCopy) {
		this.income = toCopy.income;
		this.age = toCopy.age;
		this.monthlySavings = toCopy.monthlySavings;
		this.investmentRate = toCopy.investmentRate;
	}
	
	public void calculateYearlyGrowth() {
		int yearsToRetirement = calculateYearsToRetirement();
		float initialSavings = 1000;
		float total = 1000;
		for (int yearCounter = 0; yearCounter <= yearsToRetirement; yearCounter ++ ) {
			initialSavings = initialSavings + monthlySavings;
			total = growth(initialSavings, yearsToRetirement);
			yearsToRetirement --;
			System.out.println("Year = " + yearCounter + "Amount = " + total);
			
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
	
	public float growth(float sum, int yearsToRetirement) {
		float newAmount =  (float) ((sum) * (1 + (investmentRate/1) ));
		return newAmount;
	}
	
	
	
}
