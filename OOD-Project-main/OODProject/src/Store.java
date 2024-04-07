import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Store {
	   private LinkedHashSet<Product> products;

	public Store() {
		products = new LinkedHashSet<Product>();
	}
	   
	        
    public  boolean addProduct(Product product) {
        return products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public LinkedHashSet<Product> getProducts() {
        return products;
    }
    
    public Product findProductById(String productId) {
        for (Product product : products) {
            if (product.getID().equals(productId)) {
                return product; // Return the matching product
            }
        }
        return null; // Return null if no matching product is found
    }
    
    @Override
    public String toString() {
	    StringBuilder allTheStore = new StringBuilder("The Store Products are:\n\n");
	    for (Product product : products) {
	        Product p = product;
	        allTheStore.append(p.toString()).append("\n\n");
	    }
	    return allTheStore.toString();
	}
    
   

//Hardcoded Products
public static void loadProducts() {
	Main.store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.IN_STORE, "HP Envy Printer", 120, 180, 10, 6,"100"));
	Main.store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.IN_STORE, "Sony PS5 Console", 450, 500, 30, 14,"101"));
	Main.store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.IN_STORE, "Canon EOS 1500D DSLR Camera", 400, 600, 50, 3,"102"));
	Main.store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WEBSITE, "Apple MacBook Air", 999, 1200, 25, 3,"103","Israle"));
	Main.store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WEBSITE, "Samsung Galaxy Tab S7", 650, 700, 15, 1,"104","USA"));
	Main.store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WEBSITE, "Google Nest Hub Max", 229, 279, 20, 2,"105","Italy"));
	Main.store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WHOLE_SALERS, "Philips Hue Smart Lightbulb", 45, 60, 100, 0.5,"106"));
	Main.store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WHOLE_SALERS, "Xiaomi Mi Smart Band 6", 35, 50, 150, 0.2,"107"));
	Main.store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WHOLE_SALERS, "Logitech MX Master 3 Mouse", 90, 120, 40, 0.8,"108"));
	System.out.println(Main.store.toString());
}

public static void loadOrdersAndCustomers() {
	int counter = 1;
	String orderIdCount =""+ 100000;
	Customer c1 = new Customer("Hadar David","05000003914");
	Customer c2 = new Customer("Ameen Assadi","0501234776");
	Customer c3= new Customer("Gogo Momo","0544442424");
	Customer c4= new Customer("Aviv Bender","0522242242");
	ShippingOption s1= new ShippingOption(new ShippingCompany("DHL",Main.DHL_CONTACT),50,"Express");
	ShippingOption s2= new ShippingOption(new ShippingCompany("DHL",Main.DHL_CONTACT),20,"Standard");
	ShippingOption s3= new ShippingOption(new ShippingCompany("FedEx",Main.FEDEX_CONTACT),100,"Express");
	ShippingOption s4= new ShippingOption(new ShippingCompany("FedEx",Main.FEDEX_CONTACT),75,"Standard");
	Customer[] customers = {c1, c2, c3,c4};
	ShippingOption[] shippingOptions = {s1, s2, s3,s4};
	for(Product p:Main.store.products) {
		for(int i=0;i<4;i++) {
			Order order = new Order(orderIdCount + "" + counter,i+3, customers[i],p, shippingOptions[i]);
			counter++;
			p.addOrder(order);
			}
		
		}
	}
}