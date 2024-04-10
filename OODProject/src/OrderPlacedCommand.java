
public class OrderPlacedCommand extends Command{
	@Override
	public void execute() {
        notifyObservers("\nNotifying the companies a new order has been placed\n ");
    }
}
