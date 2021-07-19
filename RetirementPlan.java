// test
public class RetirementPlan {
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
	
	public void calculateinvestmentReturn() {
		
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
	
}
