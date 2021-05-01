package car;

public class ForwardStrategy implements MoveStrategy {
	private static MoveStrategy forwardStrategy = new ForwardStrategy();

	private ForwardStrategy() {}

	public static MoveStrategy getInstance() {
		return forwardStrategy;
	}

	@Override
	public int move() {
		return 1;
	}

}
