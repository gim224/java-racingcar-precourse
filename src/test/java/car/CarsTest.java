package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	@DisplayName("자동차 이름이 비어있는 경우")
	void carNamesBlank() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Cars("");
		}).withMessage("자동차들의 이름은 비어있을 수 없습니다.");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Cars(null);
		}).withMessage("자동차들의 이름은 비어있을 수 없습니다.");
	}

	@Test
	@DisplayName("자동차 이름이 겹치는 경우")
	void carNamesDuplication() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Cars("gt,gt,aa");
		}).withMessage("자동차들의 이름은 겹칠 수 없습니다.");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Cars("aa,gt,aa");
		}).withMessage("자동차들의 이름은 겹칠 수 없습니다.");
	}

	@Test
	@DisplayName("cars가 잘 생성되었는가?")
	void getCars() {
		assertThat(new Cars("gtkim")).isNotNull();
		assertThat(new Cars("gtkim,abc,123,a, 테스트")).isNotNull();
	}
}
