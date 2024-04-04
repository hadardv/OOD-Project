import java.util.LinkedHashSet;

public class SoldToWholeSalers extends Product implements FormatForAccountant {

	public SoldToWholeSalers(String product_name, int cost_price, int selling_price, int stock,double weight) {
		super(product_name, cost_price, selling_price, stock,weight);
		// TODO Auto-generated constructor stub
	}
	public void printForAccountant(Order o) {
		System.out.println("Order Number: "+o.getOrderNum());
		System.out.println("The quantity is: "+o.getQuantity());
		System.out.println("---------------------");
		System.out.println("Customer Details:");
		o.getCustomer().toString();
		System.out.println("---------------------");
		System.out.println("Product Details:");
		o.getProduct().toString();
		int profit=o.getQuantity() * (o.getProduct().getSelling_price() - o.getProduct().getCost_price());
		System.out.println("Totall Profit is: "+profit);		
	}
	
}
