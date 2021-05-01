package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	@DisplayName("cars가 잘 생성되었는가?")
	void carNamesIsBlank() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Cars("");
		}).withMessage("자동차들의 이름은 비어있을 수 없습니다.");

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Cars(null);
		}).withMessage("자동차들의 이름은 비어있을 수 없습니다.");

	}

	@Test
	@DisplayName("cars가 잘 생성되었는가?")
	void getCars() {
		assertThat(new Cars("gtkim")).isNotNull();
		assertThat(new Cars("gtkim,abc,123,a, 테스트")).isNotNull();
	}
}
