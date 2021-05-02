package game;

import car.Cars;
import digit.RandomDigit;
import ui.InputManager;
import ui.OutputManager;

public class Game {
	private static final int RANDOM_MIN = 0;
	private static final int RANDOM_MAX = 9;

	private final InputManager inputManager;
	private final OutputManager outputManager;

	private final RandomDigit randomDigit = new RandomDigit(RANDOM_MIN, RANDOM_MAX);

	public Game(InputManager inputManager, OutputManager outputManager) {
		this.inputManager = inputManager;
		this.outputManager = outputManager;
	}

	public void start() {
		Cars cars = receiveCarsNameInput();
		int input = receiveNumberOfAttempts();

		for (int i = 0; i < input; i++) {
			cars.moveAll(randomDigit);
			outputManager.println(cars);
		}
	}

	private Cars receiveCarsNameInput() {
		outputManager.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		try {
			return new Cars(inputManager.nextLine());
		} catch (Exception e) {
			outputManager.println(e.getMessage());
			return receiveCarsNameInput();
		}
	}

	private int receiveNumberOfAttempts() {
		outputManager.println("시도할 회수는 몇회인가요?");
		return inputManager.nextInt();
	}

}
