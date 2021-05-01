package game;

import car.Cars;
import digit.RandomDigit;
import ui.InputManager;
import ui.OutputManager;
import ui.PrintOutputManager;
import ui.ScannerInputManager;

public class Game {
	private static final int RANDOM_MIN = 0;
	private static final int RANDOM_MAX = 9;

	private final InputManager inputManager = ScannerInputManager.getInstance();
	private final OutputManager outputManager = PrintOutputManager.getInstance();

	private final RandomDigit randomDigit;

	public Game() {
		this.randomDigit = new RandomDigit(RANDOM_MIN, RANDOM_MAX);
	}

	public void start() {
		outputManager.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		Cars cars = new Cars(inputManager.next());

		outputManager.println("시도할 회수는 몇회인가요?");
		int input = inputManager.nextInt();

		for (int i = 0; i < input; i++) {
			cars.moveAll(randomDigit);
		}
	}

}
