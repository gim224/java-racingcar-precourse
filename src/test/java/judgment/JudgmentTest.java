package judgment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import car.Cars;

public class JudgmentTest {
	private Judgment judgment;

	@BeforeEach
	void setIp() {
		judgment = new Judgment(new Cars("gtkim,123,abc"));
	}

	@Test
	@DisplayName("승자를 판단하는 테스트")
	void getWinners() {
		assertThat(judgment.getWinners().size()).isEqualTo(3);
		assertThat(judgment.getWinners().get(0).getName()).isEqualTo("gtkim");
	}
}
