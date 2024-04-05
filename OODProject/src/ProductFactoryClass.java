 
public class ProductFactoryClass {

	public static enum ProductType {
	    WEBSITE, IN_STORE, WHOLE_SALERS;
	}
	
    // This method returns a Product object based on the product type.
    // It takes additional parameters that are necessary to create instances of Product subclasses.
    // The parameters can be adjusted based on your actual constructors.
    public static Product createProduct(ProductType type, String product_name, int cost_price, int selling_price, int stock,double weight,String ID, Object... extraParams) {
        switch (type) {
            case WEBSITE:
                // Assuming extraParams for WEBSITE product are in the order of priceDollar, destCountry, shipping
                int priceDollar = (Integer) extraParams[0];
                String destCountry = (String) extraParams[1];
                return new SoldThroughWebsite(product_name, cost_price, selling_price, stock, priceDollar,ID, destCountry);
 
            case IN_STORE:
                // Assuming no extraParams required for IN_STORE product or you can add as needed
                return new SoldInStore(product_name, cost_price, selling_price, stock,weight,ID);
 
            case WHOLE_SALERS:
                // Assuming no extraParams required for WHOLE_SALERS product or you can add as needed
                return new SoldToWholeSalers(product_name, cost_price, selling_price, stock, weight,ID);
 
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}