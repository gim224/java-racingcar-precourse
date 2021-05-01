package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	private Car car;

	@BeforeEach
	void setIp() {
		car = new Car("gtkim");
	}

	@Test
	@DisplayName("자동차이름이 비어있는 경우,")
	void carNameIsBlank() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Car("");
		}).withMessage("자동차의 이름은 비어있을 수 없습니다.");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Car(null);
		}).withMessage("자동차의 이름은 비어있을 수 없습니다.");
	}

	@Test
	@DisplayName("자동차이름이 5를 넘는 경우,")
	void carNameOver5() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Car("123456");
		}).withMessage("자동차의 이름은 5자 이하만 가능합니다.");
	}

	@Test
	@DisplayName("Forward전략의 경우, 차의 이동거리가 1증가하는가?")
	void moveWhenForwardStrategy() {
		assertThat(car.getDistance()).isEqualTo(0);
		car.move(ForwardStrategy.getInstance());
		assertThat(car.getDistance()).isEqualTo(1);
	}

	@Test
	@DisplayName("Stop전략의 경우, 차의 이동거리가 멈춰있는가?")
	void moveWhenStopStrategy() {
		assertThat(car.getDistance()).isEqualTo(0);
		car.move(StopStrategy.getInstance());
		assertThat(car.getDistance()).isEqualTo(0);
	}

	@Test
	@DisplayName("Name 리턴")
	void getName() {
		assertThat(car.getName()).isEqualTo("gtkim");
	}

	@Test
	@DisplayName("Distance 리턴")
	void getDistance() {
		assertThat(car.getDistance()).isEqualTo(0);
	}
}
