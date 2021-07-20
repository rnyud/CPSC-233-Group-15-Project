import java.util.Scanner;

public class UserInput {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Hello, what would you like to begin with?");
		String userChoice = scn.nextLine();
		while(!userChoice.equalsIgnoreCase("quit")){
			 if(userChoice.equalsIgnoreCase("Budget")) {
				 System.out.println("In Budget");
			 } else if(userChoice.equalsIgnoreCase("Retirement Plan")) {
				 System.out.println("In Retirement Plan");
			 } else {
				 System.out.println("Yet to be implemented...\nTry something else!");
			 }
			 System.out.println("What would you like to do next?(You can always answer quit to exit!)");
			 userChoice = scn.nextLine();
		}
	}

}
