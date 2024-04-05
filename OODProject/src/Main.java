import java.util.Scanner;

public class Main {
	
	public static Scanner s = new Scanner(System.in);
	public static Store store = new Store();
	public static final Contact DHL_CONTACT =new Contact ("Moshe Cohen","0548100189");
	public static final Contact FEDEX_CONTACT = new Contact ("Avi Levi","0543334456");
	
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
			switch (choice) {

			// load hard coded store
			case Q1:
				MenuActionCompleteListener listener1 = new MenuActionCompleteListener();
				Store.loadProducts();
				Store.loadOrdersAndCustomers();
				
				
			    break;
			    
			// add product
			case Q2:
				MenuActionCompleteListener listener2 = new MenuActionCompleteListener();
				Product product;
				String ID;
				String name;
				int stock;
				int weight;
				int costPrice;
				int sellingPrice;
				System.out.println("Enter product id");
				ID = s.nextLine();
				// we need to add functionality that checks that every id is unique 
				System.out.println("Enter product name");
				name = s.nextLine();
				System.out.println("Enter product cost price");
				costPrice = s.nextInt();
				System.out.println("Enter product selling price");
				sellingPrice = s.nextInt();
				System.out.println("Enter where the product type");
		        ProductFactoryClass.ProductType type = ProductFactoryClass.ProductType.valueOf(s.nextLine().toUpperCase());
				System.out.println("Enter how many items there are");
				stock = s.nextInt();
				System.out.println("Enter the weight of the product");
				weight = s.nextInt();
				ProductFactoryClass.createProduct(type, name, costPrice, sellingPrice, stock,weight ,ID);
			    break;
			    
			// remove a product from the store
			case Q3:
				MenuActionCompleteListener listener3 = new MenuActionCompleteListener();
				String productToRemoveName;
				Product productToRemove;
				System.out.println("What product would you like to remove? type it's name");
				Store.products.toString();
				productToRemoveName = s.nextLine();
				productToRemove = store.findProductByName(productToRemoveName);
				Store.removeProduct(productToRemove);
				
				break;

				
			case Q4:
				
				MenuActionCompleteListener listener4 = new MenuActionCompleteListener();

			    break;
			
			case Q5:
				MenuActionCompleteListener listener5 = new MenuActionCompleteListener(); 

				
				break;

			case Q6:
				MenuActionCompleteListener listener6 = new MenuActionCompleteListener(); 

			    break;
			}
		} while (choice != EXIT); // The user want to exit the menu + output
		
	}
}
		
	
