import java.util.Scanner;

public class AddProductCommand extends Command {
    private Store store;
    private Scanner scanner;

    public AddProductCommand(Store store, Scanner scanner) {
        this.store = store;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        String ID, name, countryDist = "";
        int productTypeSold, stock, costPrice, sellingPrice;
        double weight;

        System.out.println("Enter the product id");
        ID = scanner.nextLine();

        System.out.println("Enter the product name");
        name = scanner.nextLine();

        System.out.println("Enter the product cost price");
        costPrice = scanner.nextInt();

        System.out.println("Enter the product selling price");
        sellingPrice = scanner.nextInt();

        System.out.println("Enter the quantity");
        stock = scanner.nextInt();

        System.out.println("Enter the weight of the product");
        weight = scanner.nextDouble();

        do {
            System.out.println("Enter the product type for your order");
            System.out.println("1-In Store\n2-Sold In Website\n3-Sold To WholeSalers");
            productTypeSold = scanner.nextInt();
        } while (productTypeSold < 1 || productTypeSold > 3);

        Product product = null;
        switch (productTypeSold) {
            case 1:
                product = ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.IN_STORE, name, costPrice, sellingPrice, stock, weight, ID);
                break;
            case 2:
                System.out.println("To what country do you want to enable the product?");
                scanner.nextLine(); // CLEAR BUFFER
                countryDist = scanner.nextLine();
                product = ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WEBSITE, name, costPrice, sellingPrice, stock, weight, ID, countryDist);
                break;
            case 3:
                product = ProductFactoryClass.createProduct(ProductFactoryClass.eProductType.WHOLE_SALERS, name, costPrice, sellingPrice, stock, weight, ID);
                break;
        }

        store.addProduct(product);
    }
}
