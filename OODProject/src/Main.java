import java.util.Scanner;

public class Main {
	
	//public static Scanner s = new Scanner(System.in);
	 public static Store store = Store.getInstance(); // singleton
	public static final Contact DHL_CONTACT =new Contact ("Moshe Cohen","0548100189");
	public static final Contact FEDEX_CONTACT = new Contact ("Avi Levi","0543334456");
	
	public static Scanner s = new Scanner(System.in);
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
		
		ActionSuccessCommand actionSuccessCommand = new ActionSuccessCommand();
		MenuActionCompleteListener listener = new MenuActionCompleteListener();
		actionSuccessCommand.registerObserver(listener);
		
		int choice;
		
		do {
			System.out.println("To run the system with hardcoded products press 1");
			System.out.println("To add a product to the store press 2");
			System.out.println("To remove a product from the store press 3");
			System.out.println("To update the stock of a product press 4");
			System.out.println("To add an order press 5");
			System.out.println("To undo an order press 6");
			System.out.println("To show the details of a product press 7");
			System.out.println("To preview all the products press 8");
			System.out.println("To preview the orders for a product press 9");
			System.out.println("To backup the system press 10");
			System.out.println("To restore from the last backup press 11");
			System.out.println("To exit press 0");
			choice=s.nextInt();
			switch (choice) {

			// load hard coded store
			case Q1:
				Store.loadProducts();
				Store.loadOrdersAndCustomers();
			    break;
			    
			// add product
			case Q2:
				
				Scanner scanner1 = new Scanner(System.in);
				AddProductCommand addProductCommand = new AddProductCommand(store, scanner1 );
				addProductCommand.execute();
			    break;
			    
			// remove a product from the store
			case Q3:
				store.removeProduct();
				
				break;

			// update stock for a specific product	
			case Q4:
				store.updateStock();
			    break;
			
		// add an order
			case Q5:
				Scanner scanner = new Scanner(System.in);
				AddOrderCommand addOrderCommand = new AddOrderCommand(store, scanner );
				OrderPlacedListener listener2 = new OrderPlacedListener();
				addOrderCommand.registerObserver(listener2);
				addOrderCommand.execute();

				break;
				
			// undo an order
			case Q6:
				Scanner s4=new Scanner(System.in);
				String pChoice;
				System.out.println("Enter The Product's ID that you would like to undo it's orders:");
				pChoice=s4.nextLine();
				Product p4=store.findProductById(pChoice);
				p4.undoOrders();
				
			    break;
			    
			// show data based on product ID
			case Q7:
				Scanner s5=new Scanner(System.in);
				String choiceId;
				Product theProduct;
				System.out.println(store.toString());
				System.out.println("Type product ID to preview:");
				choiceId=s5.nextLine();
				theProduct = store.findProductById(choiceId);
				System.out.println(theProduct.toString());
				break;
				
			// show the data of all the products in the store at the moment
			case Q8:
				System.out.println("The products in the store are: ");
				System.out.println(store.toString());
				break;
				
			// show the orders of specific product
			case Q9:
				Scanner s6=new Scanner(System.in);
				String Id;
				Product chosenProduct;
				System.out.println(store.toString());
				System.out.println("Choose the product you want to preview it's orders, Enter it's ID:");
				Id=s6.nextLine();
				chosenProduct = store.findProductById(Id);
				System.out.println(chosenProduct.getOrders().toString());
				
			case Q10:
				 store.saveToMemento();
                 System.out.println("Store state saved.");
				break;
			case Q11:
				 store.restoreFromMemento(store.getMemento());
                 System.out.println("Store state restored to last saved state.");
				break;
			}
			actionSuccessCommand.execute();
		} while (choice != EXIT); // The user want to exit the menu + output
		
	}
}
		
	
