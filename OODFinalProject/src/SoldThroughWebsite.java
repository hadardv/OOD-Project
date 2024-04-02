import java.util.LinkedHashSet;

public class SoldThroughWebsite extends Product {
	private static final int dollarEx=4;
	private int priceDollar;
	private String destCountry;
	private Shipments shipping;
	public SoldThroughWebsite(String product_name, int cost_price, int selling_price, int stock,
			LinkedHashSet<Order> hs, int priceDollar, String destCountry, Shipments shipping) {
		super(product_name, cost_price, selling_price, stock, hs);
		this.priceDollar = priceDollar;
		this.destCountry = destCountry;
		this.shipping = shipping;
	}
	public int getPriceDollar() {
		return priceDollar;
	}
	public void setPriceDollar(int priceDollar) {
		this.priceDollar = priceDollar;
	}
	public String getDestCountry() {
		return destCountry;
	}
	public void setDestCountry(String destCountry) {
		this.destCountry = destCountry;
	}
	public Shipments getShipping() {
		return shipping;
	}
	public void setShipping(Shipments shipping) {
		this.shipping = shipping;
	}
	public static int getDollarex() {
		return dollarEx;
	}
	
}
