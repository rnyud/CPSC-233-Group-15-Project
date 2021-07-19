import java.util.Scanner;

public class UserInput {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Hello, what would you like to begin with?");
		String userChoice = scn.nextLine();
		while(!userChoice.equals("quit")){
				System.out.println("What would you like to do next?(You can always answer quit to exit!)");
			 userChoice = scn.nextLine();
			 System.out.println(userChoice);
			 
			
		}
	}

}
