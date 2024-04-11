import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public abstract class Product implements Comparable {
	
	protected String ID;
	protected String product_name;
	protected int cost_price;
	protected int selling_price;
	protected int stock;
	protected double weight;
	protected int profitAllOrders;
	protected LinkedHashSet<Order> ordersList;
	private  Memento memento;
	
	public Product(String product_name, int cost_price, int selling_price, int stock,double weight, String ID) {
		this.ID=ID;
		this.product_name = product_name;
		this.cost_price = cost_price;
		this.selling_price = selling_price;
		this.stock = stock;
		this.weight=weight;
		profitAllOrders = 0;
		ordersList = new LinkedHashSet<Order>();
	}

    public void createMemento() {
        this.memento = new Memento(ordersList,profitAllOrders, stock);
    }

    public void setMemento(Memento mem) {
        if (mem == null)
            return;
        ordersList = new LinkedHashSet<>(mem.getAllOrders());
        profitAllOrders= mem.profitAllOrders;
        stock = mem.stock;
    }

    public Memento getMemento() {
        return memento;
    }
	    
    public static class Memento {
        private LinkedHashSet<Order> ordersList = new LinkedHashSet<>();
        private int profitAllOrders;
        private int stock;

        public Memento(Set<Order> ordersList,int profitAllOrders, int stock) {
            this.ordersList = new LinkedHashSet<>(ordersList);
            this.profitAllOrders = profitAllOrders;
            this.stock = stock;
        }

        public Set<Order> getAllOrders() {
            return ordersList;
        }
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
	
	public int calcProfitOrders ()
	{
		int sum = 0;
		for (Order order : ordersList) {
			sum += order.getProfitOrder();
		}
		profitAllOrders = sum;
		return sum;
	}
	
	@Override
	public String toString() {
		return "Product:" + ID + " name: " + product_name + ", cost price: " + cost_price + ", selling price: "
				+ selling_price + ", stock:" + stock + ", Profit from product sales: " + profitAllOrders ;
	}
	public String briefToString() {
		return "Product:" + ID + " Name: " + product_name;
	}
	public void printOrders()
	{
		for (Order order : ordersList) {
			if(order.getProduct() instanceof SoldInStore) {
				order.printForAccountant();
				order.printForCustomer();
			}
			else if(order.getProduct() instanceof SoldToWholeSalers) {
				order.printForAccountant();
			}
			else { // Sold In Website, No Invoice Format At All
				order.briefToString();
			}
	    }
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
    
    @Override
    public int compareTo(Object other) {
        if (this == other)
            return 0;
        if (other == null)
            return 1;  // Consider this object greater than null
        if (!(other instanceof Product))
            throw new ClassCastException();
        Product otherProduct = (Product) other;

        // Compare based on the serial field
        return this.ID.compareTo(otherProduct.ID);
    }
    
    public void addOrder(Order order) {
        ordersList.add(order);
        profitAllOrders+=order.calcProfitOrder();
        order.getCmp().getCompany().sendOrderNotification(order);
    }
    

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
    		System.out.println("Due to unexpected circumstances order"+o.getID()+" has been cancelled");
    		o.toString(); 
    		ordersList.remove(o);
    		int quantity=o.getQuantity();
    		Product p=o.getProduct();
    		p.setStock(p.getStock()+quantity);
    		}
    	
    }
}


