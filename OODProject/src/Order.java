import java.util.Scanner;

public class Order implements FormatForAccountant,FormatForCustomer {
	private String orderID;
	private int quantity;
	private int totalPrice;
	private int totalCostPrice;
	private int profitOrder;
	private Customer customer;
	private Product product;
	private double parcelWeight;
	private ShippingOption cmp;
	
	
	public Order(String orderID,int quantity, Customer customer, Product product) {
		super();
		this.orderID=orderID;
		this.quantity = quantity;
		this.customer = customer;
		this.product = product;
		totalPrice=quantity*product.getSelling_price();
		totalCostPrice = quantity*product.getCost_price();
		profitOrder = totalPrice - totalCostPrice;
		setParcelWeight(product.getWeight()*this.quantity);
		if(product instanceof SoldThroughWebsite) 
		cmp=checkSOption();
		else
			cmp=null;
		
	}
	
	
	public Order(String orderID,int quantity,Customer customer,Product product,ShippingOption opt) {
		super();
		this.orderID=orderID;
		this.quantity = quantity;
		this.customer = customer;
		this.product = product;
		totalPrice=quantity*product.getSelling_price();
		totalCostPrice = quantity*product.getCost_price();
		setParcelWeight(product.getWeight()*this.quantity);
		cmp=opt;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public ShippingOption getCmp() {
		return cmp;
	}
	
	public void setCmp(ShippingOption cmp) {
		this.cmp = cmp;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getOrderNum() {
		return orderID;
	}
	
	public void setOrderNum(String orderNum) {
		this.orderID = orderNum;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public int getTotalCostPrice() {
		return totalCostPrice;
	}
	
	public int getProfitOrder() {
		return profitOrder;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public double getParcelWeight() {
		return parcelWeight;
	}
	
	public void setParcelWeight(double parcelWeight) {
		this.parcelWeight = parcelWeight;
	}
	
	public int calcProfitOrder ()
	{
		int profit = 0;
		profit += getTotalPrice() - getTotalCostPrice();
		this.profitOrder = profit;
		return profit;
	}
	public ShippingOption checkSOption() {
		
		SoldThroughWebsite stw = (SoldThroughWebsite)this.getProduct();
		ShippingOption chosenOption=null;
		ShippingCalculator calc=new ShippingCalculator();
		if(stw.getPriceDollar()<100) {
			System.out.println("Only Standard Shipping Method is available!");
			chosenOption=calc.calcCheapestShipping(this,"Standard");
		}
		else {
			int option;
			Scanner input=new Scanner(System.in);
			do {
				System.out.println("Choose your desired shipping method:");
				System.out.println("1-Standard");
				System.out.println("2-Express");
				option=input.nextInt();
			}while(option!=1 && option!=2);
			
			switch(option){
			case 1:
				chosenOption=calc.calcCheapestShipping(this,"Standard");
				break;
			case 2:
				chosenOption=calc.calcCheapestShipping(this,"Express");
			}
		}
		return chosenOption;
	}
	public String getID() {
		return orderID;
	}
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer ();
		str.append("\n\nOrder ID: " + orderID + " Quantity: " + quantity + " Total price: " + totalPrice
					+ " \n" + customer + " \n" +product.briefToString() + "\nParcel weight: " +parcelWeight +
					" Profit from order: " + profitOrder + "\n\n");
		if (product instanceof SoldThroughWebsite)
		{
			str.append("\nShipping Company: " +cmp.getCompany().getName() + " Delivery:" +cmp.getType().toString() + "\n" );
		}
		return str.toString();
		
	}
	public String briefToString() {
		StringBuffer str=new StringBuffer();
		str.append("Order ID: " + orderID +"\n"+ product.briefToString()+ " Quantity: " + quantity + " Total price: " + totalPrice
				+ " \n" + customer +"\nParcel weight: " +parcelWeight);
		return str.toString();
	}
	public void printForAccountant() {
		System.out.println("\nReciept For Accountant:");
		System.out.println("---------------------");
		System.out.println(this.briefToString());
		int profit=getQuantity() * (product.getSelling_price() - product.getCost_price());
		System.out.println("\nTotall Profit is: "+profit);		
	}
	public void printForCustomer() {
		System.out.println("\nReciept For Customer:");
		System.out.println("---------------------");
		System.out.println(this.briefToString());
		int tax=getQuantity() * ((product.getSelling_price()*17)/100);
		System.out.println("\nTotal Tax Is: "+tax);		
	}
	

}
