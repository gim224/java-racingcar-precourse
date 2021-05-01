package car;

import java.util.Objects;

public class Car {
	private static final int MAX_LENGTH = 5;

	private String name;
	private int distance;

	public Car(String name) {
		validateBlank(name);
		validateMaxLength(name);
		this.name = name;
		distance = 0;
	}

	private void validateBlank(String name) {
		if (Objects.isNull(name) || name.isBlank()) {
			throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
		}
	}

	private void validateMaxLength(String name) {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
		}
	}

	public void move(MoveStrategy moveStrategy) {
		distance += moveStrategy.move();
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

}
