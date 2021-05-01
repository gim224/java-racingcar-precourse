package car;

public class StopStrategy implements MoveStrategy {
	private static MoveStrategy stopStrategy = new StopStrategy();

	private StopStrategy() {}

	public static MoveStrategy getInstance() {
		return stopStrategy;
	}

	@Override
	public int move() {
		return 0;
	}

}
