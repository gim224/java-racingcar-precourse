package game;

import car.Cars;
import digit.RandomDigit;
import judgment.Judgment;
import ui.InputManager;
import ui.OutputManager;

public class Game {
	private static final int RANDOM_MIN = 0;
	private static final int RANDOM_MAX = 9;

	private static final String RECEIVE_CARS_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String RECEIVE_NUMBERS_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
	private static final String JUDGMENT_WINNERS = "가 최종 우승했습니다.";

	private final InputManager inputManager;
	private final OutputManager outputManager;

	private final RandomDigit randomDigit = new RandomDigit(RANDOM_MIN, RANDOM_MAX);

	public Game(InputManager inputManager, OutputManager outputManager) {
		this.inputManager = inputManager;
		this.outputManager = outputManager;
	}

	public void start() {
		Cars cars = receiveCarsNameInput(); //자동차 이름 입력받아라.
		int input = receiveNumberOfAttempts(); //시도할 횟수 입력받아라.
		moveAll(cars, input); //자동차를 움직여라.
		judgmentWinners(cars); //승자를 판단하라.
	}

	private Cars receiveCarsNameInput() {
		outputManager.println(RECEIVE_CARS_NAME_INPUT);

		try {
			return new Cars(inputManager.nextLine());
		} catch (Exception e) {
			outputManager.println(e.getMessage());
			return receiveCarsNameInput();
		}
	}

	private int receiveNumberOfAttempts() {
		outputManager.println(RECEIVE_NUMBERS_OF_ATTEMPTS);
		return inputManager.nextInt();
	}

	private void moveAll(Cars cars, int input) {
		for (int i = 0; i < input; i++) {
			cars.moveAll(randomDigit);
			outputManager.println(cars);
		}
	}

	private void judgmentWinners(Cars cars) {
		Judgment judgment = new Judgment(cars);
		outputManager.println(judgment.toString() + JUDGMENT_WINNERS);
	}

}
