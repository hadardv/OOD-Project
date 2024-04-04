import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Store {
	   public static Set<Product> products = new TreeSet<>((p1, p2) -> p1.getID().compareTo(p2.getID()));;
	   
public Store() {

	
}
	//Hardcoded Products
	public static void loadProducts() {
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.IN_STORE, "HP Envy Printer", 120, 180, 10, 6));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.IN_STORE, "Sony PS5 Console", 450, 500, 30, 14));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.IN_STORE, "Canon EOS 1500D DSLR Camera", 400, 600, 50, 3));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WEBSITE, "Apple MacBook Air", 999, 1200, 25, 3));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WEBSITE, "Samsung Galaxy Tab S7", 650, 700, 15, 1));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WEBSITE, "Google Nest Hub Max", 229, 279, 20, 2));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WHOLE_SALERS, "Philips Hue Smart Lightbulb", 45, 60, 100, 0.5));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WHOLE_SALERS, "Xiaomi Mi Smart Band 6", 35, 50, 150, 0.2));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WHOLE_SALERS, "Logitech MX Master 3 Mouse", 90, 120, 40, 0.8));
	}

	public static void loadOrdersAndCustomers() {
		Customer c1 = new Customer("Hadar David","05000003914");
		Customer c2 = new Customer("Ameen Assadi","0501234776");
		Customer c3= new Customer("Gogo Momo","0544442424");
		Customer c4= new Customer("Aviv Bender","0522242242");
		ShippingOption s1= new ShippingOption("DHL",50,"Express");
		ShippingOption s2= new ShippingOption("DHL",20,"Standard");
		ShippingOption s3= new ShippingOption("FedEx",100,"Express");
		ShippingOption s4= new ShippingOption("FedEx",75,"Standard");
		Customer[] customers = {c1, c2, c3};
	    ShippingOption[] shippingOptions = {s1, s2, s3,s4};
		for(Product p:products) {
			for(int i=0;i<4;i++) {
	            Order order = new Order(i+3, customers[i],p, shippingOptions[i]);
	            p.addOrder(order);
			}
			
		}
	}
	        
	
    public static boolean addProduct(Product product) {
        return products.add(product);
    }

    public static boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public Set<Product> getProducts() {
        return products;
    }
	
	
}
