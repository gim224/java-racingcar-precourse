import game.Game;
import ui.InputManager;
import ui.OutputManager;
import ui.PrintOutputManager;
import ui.ScannerInputManager;

public class MainApp {

	public static void main(String[] args) {
		InputManager inputManager = ScannerInputManager.getInstance();
		OutputManager outputManager = PrintOutputManager.getInstance();

		Game game = new Game(inputManager, outputManager);
		game.start();
	}

}
