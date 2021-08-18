import java.util.Scanner;

public class Main {
	public static long input;
	public static long current;
	public static long next;
	public static int steps = 0; // Using an int should be fine. I think the longest sequence is only a 5-digit number.
	public static int oddTotal;
	public static int evenTotal;
	public static Scanner scanner = new Scanner(System.in);
	
	public static boolean useEquations;
	public static boolean oddEvenDisplay;
	
	public static void main(String[] args) {
		useEquations = configEquationOutput();
		scanner.nextLine(); // "Clears" Scanner buffer if anything else was entered.
		
		oddEvenDisplay = configOddEven();
		scanner.nextLine();
		
		System.out.print("Enter a positive integer (that is less than 2^63): ");
		String inputString = scanner.next();
		try {
			input = Long.parseLong(inputString);
		} catch(NumberFormatException e) {}
		scanner.close();
		
		if(input > 0) {
			collatz(input);

			System.out.println("\nSteps:        " + String.valueOf(steps));
			System.out.println("Even numbers: " + String.valueOf(evenTotal));
			System.out.println("Odd numbers:  " + String.valueOf(oddTotal));
		} else {
			System.out.println("Please enter a valid positive integer.");
		}
	}

	public static void collatz(long input) {
		current = input;
		System.out.println("\nStarting at " + String.valueOf(current));
		
		while(current > 1) {
			if(current % 2 == 0) {
				next = current / 2;
				evenTotal++;
			} else {
				next = 3 * current + 1;
				oddTotal++;
			}
			printStep();
			current = next;
			steps++;
		}
	}
	
	public static void printStep() {
		String oddEven = "";
		if(oddEvenDisplay) {
			if(current % 2 == 0) {
				oddEven = "Number was even; ";
			} else {
				oddEven = "Number was odd;  ";
			}
		}
		
		if(useEquations) {
			if(current % 2 != 0) {
				System.out.println(oddEven + "3(" + String.valueOf(current) + ") + 1 = " + String.valueOf(next));
			} else {
				System.out.println(oddEven + String.valueOf(current) + " / 2 = " + String.valueOf(next));
			}
		} else {
			System.out.println(oddEven + String.valueOf(next));
		}
	}
	
	public static boolean configEquationOutput() {
		System.out.print("Print equations? [y/n] ");
		String optionInput = scanner.next().toLowerCase();
		if(optionInput.equals("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean configOddEven() {
		System.out.print("Say if a number is odd or even? [y/n] ");
		String optionInput = scanner.next().toLowerCase();
		if(optionInput.equals("y")) {
			return true;
		} else {
			return false;
		}
	}
}