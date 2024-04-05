public class ShippingOption  {
    private ShippingCompany company;
    private double cost;
    private String type;
 
    public ShippingOption(ShippingCompany company, double cost, String type) {
        this.company = company;
        this.cost = cost;
        this.type = type;
        
    }
 
    // Getter for company name
    public ShippingCompany getCompany() {
        return company;
    }
    
 
    // Setter for company name
    public void setCompany(ShippingCompany company) {
        this.company = company;
    }
 
    // Getter for cost
    public double getCost() {
        return cost;
    }
 
    // Setter for cost
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public String getType() {
        return type;
    }

	@Override
	public String toString() {
		return "ShippingOption [company=" + company + ", cost=" + cost + ", type=" + type + "]";
	}
 

}
 
