import java.util.LinkedHashSet;

public abstract class Product {
	protected String product_name;
	protected int cost_price;
	protected int selling_price;
	protected int stock;
	protected LinkedHashSet<Order> ordersList;
	public Product(String product_name, int cost_price, int selling_price, int stock, LinkedHashSet<Order> hs) {
	
		this.product_name = product_name;
		this.cost_price = cost_price;
		this.selling_price = selling_price;
		this.stock = stock;
		this.ordersList = ordersList;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getCost_price() {
		return cost_price;
	}
	public void setCost_price(int cost_price) {
		this.cost_price = cost_price;
	}
	public int getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public LinkedHashSet<Order> getHs() {
		return ordersList;
	}
	public void setHs(LinkedHashSet<Order> ordersList) {
	}
	@Override
	public String toString() {
		return "Product [product_name=" + product_name + ", cost_price=" + cost_price + ", selling_price="
				+ selling_price + ", stock=" + stock + "";
	}
	
	

}
