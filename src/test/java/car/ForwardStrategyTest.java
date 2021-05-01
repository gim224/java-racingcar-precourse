package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ForwardStrategyTest {
	private MoveStrategy forwardStrategy;

	@BeforeEach
	void setIp() {
		forwardStrategy = ForwardStrategy.getInstance();
	}

	@Test
	@DisplayName("forward전략")
	void move() {
		assertThat(forwardStrategy.move()).isEqualTo(1);
	}
}
