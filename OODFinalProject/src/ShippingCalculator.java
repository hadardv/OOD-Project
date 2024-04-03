public class ShippingCalculator {
 
    private static final double IMPORT_TAX = 20.0;
 
    public ShippingOption calcCheapestShipping(Order order, String shippingType) {
        double dhlCost = calcDHLShipping(order, shippingType);
        double fedExCost = calcFedExShipping(order, shippingType);
 
        // Assuming ShippingOption is a class that holds the shipping company name and cost
        return dhlCost < fedExCost ? new ShippingOption("DHL", dhlCost,shippingType) : new ShippingOption("FedEx", fedExCost,shippingType);
    }
 
    private double calcDHLShipping(Order order, String shippingType) {
        // Placeholder for DHL shipping cost calculation logic
        // This should be replaced with actual calculation based on the order details and shippingType
        double baseCost;
        switch (shippingType) {
            case "Express":
                baseCost = 100+IMPORT_TAX; // Example express shipping cost
                break;
            case "Standard":
                baseCost = order.getTotalPrice() * 0.1; // Example: 10% of product price
                break;
            default:
                throw new IllegalArgumentException("Unsupported shipping type: " + shippingType);
        }
        return baseCost;
    }
 
    private double calcFedExShipping(Order order, String shippingType) {
        // Placeholder for FedEx shipping cost calculation logic
        // This should be replaced with actual calculation based on the order details and shippingType
        double baseCost;
        switch (shippingType) {
            case "Express":
                baseCost = 50 * (order.getParcelWeight() / 10)+IMPORT_TAX; // $50 for every 10kg, example
                break;
            case "Standard":
                baseCost = 10 * (order.getParcelWeight() / 10); // $10 for every 10kg, example
                break;
            default:
                throw new IllegalArgumentException("Unsupported shipping type: " + shippingType);
        }
        return baseCost;
    }
}
 