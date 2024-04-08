
public class SoldThroughWebsite extends Product {
	private static final int dollarEx=4;
	private int priceDollar;
	private String destCountry;
	private String priceWithSymbol;
	public SoldThroughWebsite(String product_name, int cost_price, int selling_price, int stock,double weight,String ID,String destCountry) {
		super(product_name, cost_price, selling_price, stock, weight,ID);
		this.priceDollar = selling_price/dollarEx;
		this.destCountry = destCountry;
		priceWithSymbol="$"+priceDollar;
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
	public static int getDollarex() {
		return dollarEx;
	}
	@Override
	public String toString() {
        StringBuffer str = new StringBuffer (super.toString());
        str.append(" The County is " + destCountry);
        return str.toString();
    }
	
	
	
}
