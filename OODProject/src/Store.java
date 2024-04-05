import java.util.Set;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Store {
	   public static Set<Product> products = new TreeSet<>((p1, p2) -> p1.getID().compareTo(p2.getID()));;
	   
public Store() {

	
}
	//Hardcoded Products
	public static void loadProducts() {
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.IN_STORE, "HP Envy Printer", 120, 180, 10, 6,"100"));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.IN_STORE, "Sony PS5 Console", 450, 500, 30, 14,"101"));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.IN_STORE, "Canon EOS 1500D DSLR Camera", 400, 600, 50, 3,"102"));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WEBSITE, "Apple MacBook Air", 999, 1200, 25, 3,"103"));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WEBSITE, "Samsung Galaxy Tab S7", 650, 700, 15, 1,"104"));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WEBSITE, "Google Nest Hub Max", 229, 279, 20, 2,"105"));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WHOLE_SALERS, "Philips Hue Smart Lightbulb", 45, 60, 100, 0.5,"106"));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WHOLE_SALERS, "Xiaomi Mi Smart Band 6", 35, 50, 150, 0.2,"107"));
		Store.addProduct(ProductFactoryClass.createProduct(ProductFactoryClass.ProductType.WHOLE_SALERS, "Logitech MX Master 3 Mouse", 90, 120, 40, 0.8,"108"));
	}

	public static void loadOrdersAndCustomers() {
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
    
    public Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getProduct_name().equalsIgnoreCase(productName)) {
                return product; // Return the matching product
            }
        }
        return null; // Return null if no matching product is found
    }
    
	@Override
	public String toString() {
		return "Store [getProducts()=" + getProducts() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
    
	
	
}
