import java.util.Scanner;

public class Main {
	public static long input;
	public static long current;
	public static long next;
	public static int steps = 0;
	public static int oddTotal;
	public static int evenTotal;
	public static Scanner scanner = new Scanner(System.in);
	
	public static boolean useEquations;
	public static boolean oddEvenDisplay;
	public static boolean printSteps;
	
	public static void main(String[] args) {
		printSteps = Config.configStepPrinting();
		scanner.nextLine(); // "Clears" Scanner buffer if anything else was entered.
		
		if(printSteps) {
			useEquations = Config.configEquationOutput();
			scanner.nextLine();
			
			oddEvenDisplay = Config.configOddEven();
			scanner.nextLine();
		}
		
		System.out.print("Enter a positive integer (that is less than 2^63): ");
		String inputString = scanner.next();
		try {
			input = Long.parseLong(inputString);
		} catch(NumberFormatException e) {}
		scanner.close();
		
		if(input > 0) {
			collatz(input);
			
			if(!printSteps) {
				System.out.println("Done!\n\nThe number " + String.valueOf(input) + " ends in the 4,2,1 loop.");
			}

			System.out.println("\nSteps:        " + String.valueOf(steps));
			System.out.println("Even numbers: " + String.valueOf(evenTotal));
			System.out.println("Odd numbers:  " + String.valueOf(oddTotal));
		} else {
			System.out.println("Please enter a valid positive integer.");
		}
	}

	public static void collatz(long input) {
		current = input;
		if(printSteps) {
			System.out.println("\nStarting at " + String.valueOf(current));
		} else {
			System.out.println("\nCalculating...");
		}
		
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
		if(printSteps) {
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
					System.out.println(oddEven + "3 * " + String.valueOf(current) + " + 1 = " + String.valueOf(next));
				} else {
					System.out.println(oddEven + String.valueOf(current) + " / 2 = " + String.valueOf(next));
				}
			} else {
				System.out.println(oddEven + String.valueOf(next));
			}
		}
	}
}
