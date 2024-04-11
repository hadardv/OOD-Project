
public class SoldToWholeSalers extends Product {

	public SoldToWholeSalers(String product_name, int cost_price, int selling_price, int stock,double weight,String ID) {
		super(product_name, cost_price, selling_price, stock,weight,ID);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
        StringBuffer str = new StringBuffer (super.toString());
        str.append(" Product type is sold to wholesalers");
        return str.toString();
    }
	
}
