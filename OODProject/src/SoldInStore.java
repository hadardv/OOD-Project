
public class SoldInStore extends Product implements FormatForAccountant,FormatForCustomer{

	public SoldInStore(String product_name, int cost_price, int selling_price, int stock,double weight,String ID) {
		super(product_name, cost_price, selling_price, stock, weight, ID);
	}
	
	public void printForCustomer(Order o) {
		int taxAmount=(int)(o.getTotalPrice()*17)/100;
		System.out.println("Order Number: "+o.getOrderNum());
		System.out.println("The quantity is: "+o.getQuantity());
		System.out.println("---------------------");
		System.out.println("Customer Details:");
		o.getCustomer().toString();
		System.out.println("---------------------");
		System.out.println("Product Details:");
		o.getProduct().toString();
		System.out.println("\nTAX: "+taxAmount);
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
	@Override
	public String toString() {
        StringBuffer str = new StringBuffer (super.toString());
        str.append(" Product type is sold in store");
        return str.toString();
    }
}
