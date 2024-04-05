public class ShippingCompany implements ShippingNotififaction {
    private String name;
    private Contact contact;
    public ShippingCompany(String name, Contact contact) {
        super();
        this.name = name;
        this.contact = contact;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public void sendOrderNotification(Order order)
    {
        System.out.println("Notifying company about new order: " + order.getOrderNum());
    }

}