import java.util.Scanner;

public class Main {
	public static long input;
	public static long current;
	public static long next;
	public static long steps = 0;
	public static Scanner inputScanner = new Scanner(System.in);
	public static boolean useEquations;
	
	public static void main(String[] args) {
		useEquations = configEquationOutput();
		inputScanner.nextLine(); // Effectively "clears" the Scanner buffer, which may have other strings left in it (due to using `.next()`).

		System.out.print("Enter an integer (preferably positive) that is less than 2^63: ");
		input = inputScanner.nextLong();
		
		collatz(input);
		inputScanner.close();
	}

	public static void collatz(long input) {
		current = input;
		System.out.println("Starting at " + String.valueOf(current));
		
		while(current > 4) {
			if(current % 2 == 0) {
				next = current / 2;
			} else {
				next = 3 * current + 1;
			}
			System.out.println(String.valueOf(next));
			current = next;
			steps++;
		}
		System.out.print("Steps: " + String.valueOf(steps));
	}
	
	public static boolean configEquationOutput() {
		while(useEquations == null) {
		System.out.print("Print equations? [y/N] ");
		String equationChoiceString = inputScanner.next().toLowerCase();
		if(equationChoiceString.equals("y")) {
			return true;
		} else if(equationChoiceString.equals("n") || equationChoiceString.equals("")) {
			return false;
		} else {
			
		}
		}
	}
}