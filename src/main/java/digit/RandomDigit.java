package digit;

import car.ForwardStrategy;
import car.MoveStrategy;
import car.StopStrategy;

public class RandomDigit {
	private static final int STANDARD = 4;

	private int min;
	private int max;

	public RandomDigit(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public MoveStrategy shuffle() {
		return generateRandomDigit() >= STANDARD ? ForwardStrategy.getInstance() : StopStrategy.getInstance();
	}

	private int generateRandomDigit() {
		return (int)(Math.random() * (max + 1 - min)) + min;
	}
}
