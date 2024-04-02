
public class Contact {
	private String name;
	private String whatsappNum;
	private ShippingCompany company;
	public Contact(String name, String whatsappNum, ShippingCompany company) {
		super();
		this.name = name;
		this.whatsappNum = whatsappNum;
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWhatsappNum() {
		return whatsappNum;
	}
	public void setWhatsappNum(String whatsappNum) {
		this.whatsappNum = whatsappNum;
	}
	public ShippingCompany getCompany() {
		return company;
	}
	public void setCompany(ShippingCompany company) {
		this.company = company;
	}
	
}
