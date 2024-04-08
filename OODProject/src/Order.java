import java.util.Scanner;

public class Order {
	private String orderID;
	private int quantity;
	private int totalPrice;
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
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getParcelWeight() {
		return parcelWeight;
	}
	public void setParcelWeight(double parcelWeight) {
		this.parcelWeight = parcelWeight;
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
		return "Order [orderID=" + orderID + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", customer="
				+ customer + ", product=" + product + ", parcelWeight=" + parcelWeight
				+ ", cmp=" + cmp + "]";
	}
	

}
