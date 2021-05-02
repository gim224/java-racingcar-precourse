package judgment;

import java.util.ArrayList;
import java.util.List;

import car.Car;
import car.Cars;

public class Judgment {
	private List<Car> winners = new ArrayList<>();

	public Judgment(Cars cars) {
		judgmentWinners(cars);
	}

	public List<Car> getWinners() {
		return winners;
	}

	private void judgmentWinners(Cars cars) {
		int maxDistance = cars.calcMaxDistance();

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			judgmentWinner(car, maxDistance);
		}
	}

	private void judgmentWinner(Car car, int maxDistance) {
		if (car.getDistance() == maxDistance) {
			winners.add(car);
		}
	}

	@Override
	public String toString() {
		List<String> carNames = new ArrayList<>();

		for (Car car : winners) {
			carNames.add(car.getName());
		}

		return String.join(",", carNames);
	}

}
