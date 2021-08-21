public class Config {
	public static boolean configStepPrinting() {
		System.out.print("Show calculation steps? [y/n] ");
		String optionInput = Main.scanner.next().toLowerCase();
		if(optionInput.equals("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean configEquationOutput() {
		System.out.print("Print equations? [y/n] ");
		String optionInput = Main.scanner.next().toLowerCase();
		if(optionInput.equals("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean configOddEven() {
		System.out.print("Say if a number is odd or even? [y/n] ");
		String optionInput = Main.scanner.next().toLowerCase();
		if(optionInput.equals("y")) {
			return true;
		} else {
			return false;
		}
	}
}
