
public class Order {
	protected static int num=1;
	private int orderNum;
	private int quantity;
	private int totalPrice;
	private Customer customer;
	private Product product;
	public Order(int quantity, Customer customer, Product product) {
		super();
		orderNum=num++;
		this.quantity = quantity;
		this.customer = customer;
		this.product = product;
		totalPrice=quantity*product.getSelling_price();
	}
	public int getQuantity() {
		return quantity;
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
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
