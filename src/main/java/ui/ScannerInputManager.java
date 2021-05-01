package ui;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerInputManager implements InputManager {
	private final OutputManager outputManager = PrintOutputManager.getInstance();
	private static final String REQUIRE_REINPUT = "재입력 : ";

	private static InputManager inputManager = new ScannerInputManager();

	private ScannerInputManager() {}

	public static InputManager getInstance() {
		return inputManager;
	}

	private static final Scanner SCANNER = new Scanner(System.in);

	@Override
	public int nextInt() {
		int result = 0;

		try {
			result = SCANNER.nextInt();
		} catch (InputMismatchException e) {
			requireReinput();
			return nextInt();
		} catch (NoSuchElementException | IllegalStateException e) {
			requireReinput();
			return nextInt();
		}

		return result;
	}

	@Override
	public String next() {
		String result = "";

		try {
			result = SCANNER.next();
		} catch (NoSuchElementException | IllegalStateException e) {
			requireReinput();
			return next();
		}

		return result;
	}

	private void requireReinput() {
		outputManager.print(REQUIRE_REINPUT);
		SCANNER.nextLine();
	}

}
