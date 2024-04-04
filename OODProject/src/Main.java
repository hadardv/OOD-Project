import java.util.Scanner;

public class Main {
	
	public static Scanner input = new Scanner(System.in);
	public static final int EXIT = 0;
	public static final int Q1 = 1;
	public static final int Q2 = 2;
	public static final int Q3 = 3;
	public static final int Q4 = 4;
	public static final int Q5 = 5;
	public static final int Q6=6;
	public static final int Q7=7;
	public static final int Q8=8;
	public static final int Q9=9;
	public static final int Q10=10;
	public static final int Q11=11;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice;
		
		do {
			System.out.println("To run the system with hardcoded products press 1");
			System.out.println("To add a product to the store press 2");
			System.out.println("To remove a product from the store press 3");
			System.out.println("To update the stock of a product press 4");
			System.out.println("To add a order press 5");
			System.out.println("To undo an order press 6");
			System.out.println("To show the details of a product press 7");
			System.out.println("To preview all the products press 8");
			System.out.println("To preview the orders for a product press 9");
			System.out.println("To backup the system press 10");
			System.out.println("To restore from the last backup press 11");
			System.out.println("To exit press 0");
			choice=input.nextInt();

		}while(choice!=EXIT);
		
	}

}
