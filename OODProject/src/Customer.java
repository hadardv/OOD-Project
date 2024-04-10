
public class Customer {
	private String customer_name;
	private String phone_number;
	public Customer(String customer_name, String phone_number) {
		super();
		this.customer_name = customer_name;
		this.phone_number = phone_number;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "Customer [customer_name=" + customer_name + ", phone_number=" + phone_number + "]";
	}
	
}
