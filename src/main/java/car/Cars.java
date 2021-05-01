package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import digit.RandomDigit;

public class Cars {
	private static final String SPLIT_REGEX = ",";

	private final List<Car> cars;

	public Cars(String nameBundle) {
		validateBlank(nameBundle);
		this.cars = mapping(nameBundle);
	}

	private void validateBlank(String nameBundle) {
		if (Objects.isNull(nameBundle) || nameBundle.isBlank()) {
			throw new IllegalArgumentException("자동차들의 이름은 비어있을 수 없습니다.");
		}
	}

	private List<Car> mapping(String nameBundle) {
		String[] names = nameBundle.split(SPLIT_REGEX);
		List<Car> cars = new ArrayList<>();

		for (String name : names) {
			cars.add(new Car(name));
		}

		return cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void moveAll(RandomDigit randomDigit) {
		for (Car car : cars) {
			car.move(randomDigit.shuffle());
		}
	}

}
