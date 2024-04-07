import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Stack;

public abstract class Product implements Comparable<Product> {
	
	protected String ID;
	protected String product_name;
	protected int cost_price;
	protected int selling_price;
	protected int stock;
	protected double weight;
	protected LinkedHashSet<Order> ordersList;
	public Product(String product_name, int cost_price, int selling_price, int stock,double weight, String ID) {
		this.ID=ID;
		this.product_name = product_name;
		this.cost_price = cost_price;
		this.selling_price = selling_price;
		this.stock = stock;
		this.weight=weight;
		ordersList = new LinkedHashSet<Order>();
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
	public LinkedHashSet<Order> getOrders() {
		return ordersList;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setHs(LinkedHashSet<Order> ordersList) {
	}
	@Override
	public String toString() {
		return "Product:" + ID + " name: " + product_name + ", cost price: " + cost_price + ", selling price: "
				+ selling_price + ", stock:" + stock + "";
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return this.ID == product.ID &&
               Objects.equals(this.product_name, product.product_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, product_name);
    }
    
    public int compareTo(Product other) {
        // Assuming we're comparing based on the product's ID
        return this.ID.compareTo(other.ID);
    }
    public void addOrder(Order order) {
        ordersList.add(order);
        order.getCmp().getCompany().sendOrderNotification(order);
    }

    // Method to remove an order from the LinkedList
    public boolean removeOrder(Order order) {
        return ordersList.remove(order);
    }
    public boolean checkUniqueOrderID(String id) {
    	Iterator<Order> itr = ordersList.iterator();
    	while(itr.hasNext()) {
    		Order o=itr.next();
    		if(o.getID().equals(id))
    			return false;
    	}
    	return true;
    }
    
    public void undoOrders() {
    	//Creating a tempStack with the orders so we undo it from end to start
    	Stack<Order> tempOrders = new Stack<>();
    	for(Order o:ordersList) {
    		tempOrders.add(o);
    	}
    	while(!tempOrders.isEmpty()) {
    		Order o=tempOrders.pop();
    		System.out.println("Due to unexpected circumstances this order has been canceled");
    		o.toString(); 
    		ordersList.remove(o);
    		int quantity=o.getQuantity();
    		Product p=o.getProduct();
    		p.setStock(p.getStock()+quantity);
    		}
    	
    }
}

