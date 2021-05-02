package car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import digit.RandomDigit;

public class Cars {
	private static final String SPLIT_REGEX = ",";

	private final List<Car> cars;

	public Cars(String nameBundle) {
		validateBlank(nameBundle);

		String[] names = nameBundle.split(SPLIT_REGEX);
		validateDuplication(names);

		this.cars = mapping(names);
	}

	private void validateDuplication(String[] names) {
		Set<String> nonDuplicate = new HashSet<>(Arrays.asList(names));
		if (nonDuplicate.size() != names.length) {
			throw new IllegalArgumentException("자동차들의 이름은 겹칠 수 없습니다.");
		}

	}

	private void validateBlank(String nameBundle) {
		if (Objects.isNull(nameBundle) || nameBundle.isBlank()) {
			throw new IllegalArgumentException("자동차들의 이름은 비어있을 수 없습니다.");
		}
	}

	private List<Car> mapping(String[] names) {
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

	public Car get(int index) {
		return cars.get(index);
	}

	public int size() {
		return cars.size();
	}

	public int calcMaxDistance() {
		return Collections.max(cars, Comparator.comparingInt(Car::getDistance)).getDistance();
	}

	@Override
	public String toString() {
		String result = "";

		for (Car car : cars) {
			result += car.toString();
			result += "\n";
		}

		return result;
	}

}
