import java.util.Scanner;

class Calculator{
	private static Scanner scanner = new Scanner(System.in);

	static double calculate(double a, double b, int operation){
		// Function that calculate the numbers
		switch(operation){
			case 1: return a+b;

			case 2: return a-b;
				
			case 3: return a*b;
				
			case 4: return a/b;
		}
		return 0;
	}

	static void printMenu(){
		System.out.println("------------------------");
		System.out.println("Select your operation   |");
		System.out.println("------------------------|");
		System.out.println("      1-Add             |");
		System.out.println("      2-Sub             |");
		System.out.println("      3-Multiply        |");
		System.out.println("      4-Divide          |");
		System.out.println("      5-Exit            |");
		System.out.println("------------------------");
	}

	static int getOperation(){
		int operation;
		while(true){
			printMenu();
			operation = scanner.nextInt();
			if (operation >=1 && operation <6 ){
				return operation;
			}
			System.out.println("\n");
		}
	}

	static double get_number(){
		return scanner.nextDouble();
	}

	public static void main(String[] args){
		int operation;
		double a;
		double b;
		while(true){
			operation = getOperation();
			System.out.println("------------------------");
			if (operation == 5){
				break;
			}
			else{
				System.out.print("First number: ");
				a = scanner.nextDouble();
				System.out.println("------------------------");
				System.out.print("Second number: ");
				b = scanner.nextDouble();
				System.out.println("------------------------");
				System.out.println("      " + Double.toString(calculate(a,b,operation)));
				System.out.println("------------------------");
				System.out.println("\n");
			}
		}
	}
}
