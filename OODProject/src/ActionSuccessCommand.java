
public class ActionSuccessCommand extends Command {
    @Override
	public void execute() {
        notifyObservers("\nAction has been completed successfuly\n ");
    }
}
