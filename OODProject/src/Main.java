import java.util.Scanner;

public class Main {
	
	//public static Scanner s = new Scanner(System.in);
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
			System.out.println("To add an order press 5");
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
				Scanner s = new Scanner(System.in);
				MenuActionCompleteListener listener2 = new MenuActionCompleteListener();
				Product product=null;
				String ID;
				String name;
				String countryDist;
				int productTypeSold;
				int stock;
				double weight;
				int costPrice;
				int sellingPrice;
				System.out.println("Enter the product id");
				ID = s.nextLine();
				// we need to add functionality that checks that every id is unique 
				System.out.println("Enter the product name");
				name = s.nextLine();
				System.out.println("Enter the product cost price");
				costPrice = s.nextInt();
				System.out.println("Enter the product selling price");
				sellingPrice = s.nextInt();
		        //ProductFactoryClass.ProductType type = ProductFactoryClass.ProductType.valueOf(s.nextLine().toUpperCase());
				System.out.println("Enter the quantity");
				stock = s.nextInt();
				System.out.println("Enter the weight of the product");
				weight = s.nextDouble();
				do {
					System.out.println("Enter the product type for your order");
					System.out.println("1-In Store\n2-Sold In Website\n3-Sold To WholeSalers");
					productTypeSold=s.nextInt();
				}while(productTypeSold<1 || productTypeSold>3);
				switch(productTypeSold) {
				case 1:
					product=ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.IN_STORE, name, costPrice, sellingPrice, stock,weight ,ID);
					break;
				case 2:
					System.out.println("To what country do you want to enable the product?");
					s.next();
					countryDist = s.nextLine();
					product=ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WEBSITE, name, costPrice, sellingPrice, stock,weight ,ID,countryDist);
					break;
				case 3:
					product=ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WHOLE_SALERS, name, costPrice, sellingPrice, stock,weight ,ID);
					break;
				}
				store.addProduct(product);
			    break;
			    
			// remove a product from the store
			case Q3:
				Scanner s1 = new Scanner(System.in);
				MenuActionCompleteListener listener3 = new MenuActionCompleteListener();
				String productIdToRemove;
				Product productToRemove;
				System.out.println(Main.store.toString());
				System.out.println("Enter the product's ID that you want to delete:");
				productIdToRemove=s1.nextLine();
				productToRemove = store.findProductById(productIdToRemove);
				store.removeProduct(productToRemove);
				
				break;

				
			case Q4:
				Scanner s2 = new Scanner(System.in);
				MenuActionCompleteListener listener4 = new MenuActionCompleteListener();
				String productIdToUpdate;
				Product productToUpdate;
				int newStock;
				System.out.println(Main.store.toString());
				System.out.println("Enter the product's ID that you want to update it's stock:");
				productIdToUpdate=s2.nextLine();
				productToUpdate = store.findProductById(productIdToUpdate);
				System.out.println("Enter the new quantity/stock of the product:");
				newStock=s2.nextInt();
				productToUpdate.setStock(newStock);
				System.out.println(Main.store.toString());
			    break;
			
			// here the problem with c
			case Q5:
				Scanner s3 = new Scanner(System.in);
				MenuActionCompleteListener listener5 = new MenuActionCompleteListener(); 
				if(store.getProducts().size()<1) 
				{
					System.out.println("Not enough products to create an order");
					break;
				}
				
				Customer c = null;
				int productType;
				System.out.println("Before we create an order, please enter customer details:");
				System.out.println("Enter the customer's name:");
				String cName=s3.nextLine();
				System.out.println("Enter the customer's number:");
				String pNum=s3.nextLine();
				c.setPhone_number(pNum);
				c.setCustomer_name(cName);
				do {
					System.out.println("Enter the product type for your order");
					System.out.println("1-In Store\n2-Sold In Website\n3-Sold To WholeSalers");
					productType=s3.nextInt();
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
				String orderId="";
				int quantity=0;
				boolean legitOId=false,legitPId=false, legitQuantity=false;
				Product p=null;
				while(!legitPId) {
				System.out.println("Enter the product ID you would like to add for your order");
				System.out.println(Main.store.toString());
				productId=s3.nextLine();
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
					//CHECK IF CLEAR BUFFER CAUSES PROBLEMS
					s3.next(); // CLEAR BUFFER
					quantity=s3.nextInt();
					if(quantity>p.getStock())
						legitQuantity=false;
					else {
						legitQuantity=true;	
						p.setStock(p.getStock()-quantity);
					}
					
				}
				Order o=new Order(orderId,quantity,c,p);
				if(!p.getOrders().add(o)) {
					System.out.println("Error adding your product - duplicate");
				}
				else {
					System.out.println("Order added successfully");
				}

				
				break;

			case Q6:
				MenuActionCompleteListener listener6 = new MenuActionCompleteListener(); 

			    break;
			}
		} while (choice != EXIT); // The user want to exit the menu + output
		
	}
}
		
	
