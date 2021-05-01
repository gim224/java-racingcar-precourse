package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StopStrategyTest {
	private MoveStrategy stopStrategy;

	@BeforeEach
	void setIp() {
		stopStrategy = StopStrategy.getInstance();
	}

	@Test
	@DisplayName("stop전략")
	void move() {
		assertThat(stopStrategy.move()).isEqualTo(0);
	}
}
