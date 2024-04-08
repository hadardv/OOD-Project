import java.util.Scanner;

public class AddOrderCommand extends Command {
    private Store store; // Assuming Store is a class that holds your products and orders
    private Scanner scanner; // To read input from the user

    // Constructor
    public AddOrderCommand(Store store, Scanner scanner) {
        this.store = store;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        // Your case logic goes here
        if (store.getProducts().size() < 1) {
            System.out.println("Not enough products to create an order");
            return;
        }

        OrderPlacedCommand orderPlacedCommand = new OrderPlacedCommand();
		OrderPlacedListener listener2 = new OrderPlacedListener();
		orderPlacedCommand.registerObserver(listener2);
		orderPlacedCommand.execute();

		if(store.getProducts().size()<1) 
		{
			System.out.println("Not enough products to create an order");
			return;
		}
		Customer c = null;
		int productType;
		System.out.println("Before we create an order, please enter customer details:");
		System.out.println("Enter the customer's name:");
		String cName=scanner.nextLine();
		System.out.println("Enter the customer's number:");
		String pNum=scanner.nextLine();
		c=new Customer(cName,pNum);
		do {
			System.out.println("Enter the product type for your order");
			System.out.println("1-In Store\n2-Sold In Website\n3-Sold To WholeSalers");
			productType=scanner.nextInt();
		}while(productType<1 || productType>3);
		switch(productType) {
		case 1:
			for(Product p:store.getProducts()) {
				if(p instanceof SoldInStore)
					System.out.println(p.toString());
			}
			break;
		case 2:
			for(Product p:store.getProducts()) {
				if(p instanceof SoldThroughWebsite)
					System.out.println(p.toString());
			}
			break;
		case 3:
			for(Product p:store.getProducts()) {
				if(p instanceof SoldToWholeSalers)
					System.out.println(p.toString());
			}
			break;
		}
		String productId="";
		String orderId = null;

		
		int quantity=0;
		boolean legitOId=false,legitPId=false, legitQuantity=false;
		Product p=null;
		scanner.nextLine(); // Clear Buffer
		while(!legitPId) {
		System.out.println("Enter the product ID you would like to add for your order");
		//System.out.println(Main.store.toString());
		productId=scanner.nextLine();
		p=store.findProductById(productId);
		if(productType==1 && p instanceof SoldInStore)
			legitPId=true;
		if(productType==2 && p instanceof SoldThroughWebsite)
			legitPId=true;
		if(productType==3 && p instanceof SoldToWholeSalers)
			legitPId=true;
		}
		while(!legitQuantity) {
			System.out.println("Enter the quantity you want to add for your order("+p.getStock()+")Available!");
			quantity=scanner.nextInt();
			if(quantity>p.getStock()){
				System.out.println("Invalid Quantity!Try again.");
				legitQuantity=false;
			}
			else {
				legitQuantity=true;	
				p.setStock(p.getStock()-quantity);
			}
			
		}
		scanner.nextLine(); // Clear buffer
		while(!legitOId) {
			System.out.println("Enter your desired order ID:");
			orderId=scanner.nextLine();
			if(!p.checkUniqueOrderID(orderId)) {
				System.out.println("This Order ID is alrrady taken, choose another!");
				legitOId=false;
			}
			else
				legitOId=true;
		}
		Order o=new Order(orderId,quantity,c,p);
		if(!p.getOrders().add(o)) {
			System.out.println("Error adding your product - duplicate");
		}
		else {
			System.out.println("Order added successfully");
		}
    }
}
