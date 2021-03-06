package de.tu_darmstadt.gdi1.gorillas.test.adapter;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import de.tu_darmstadt.gdi1.gorillas.test.setup.TWLTestAppGameContainer;
import de.tu_darmstadt.gdi1.gorillas.test.setup.TWLTestStateBasedGame;
import de.tu_darmstadt.gdi1.gorillas.test.setup.TestGorillas;
import eea.engine.entity.StateBasedEntityManager;

public class GorillasTestAdapterMinimal {

	// erbt von TWLTestStateBasedGame (nur fuer Tests!)
	TestGorillas gorillas;

	// spezielle Variante des AppGameContainer, welche keine UI erzeugt (nur
	// fuer Tests!)
	TWLTestAppGameContainer app;

	public GorillasTestAdapterMinimal() {
		super();
	}

	/* ***************************************************
	 * ********* initialize, run, stop the game **********
	 * ***************************************************
	 */
	public TWLTestStateBasedGame getStateBasedGame() {
		return gorillas;
	}

	/**
	 * Diese Methode initialisiert das Spiel im Debug-Modus, d.h. es wird ein
	 * AppGameContainer gestartet, der keine Fenster erzeugt und aktualisiert.
	 * 
	 * Sie muessen / koennen diese Methode erweitern
	 */
	public void initializeGame() {

		// Set the native library path (depending on the operating system)
		// @formatter:off
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			System.setProperty("org.lwjgl.librarypath",
					System.getProperty("user.dir")
							+ "/lib/lwjgl-2.9.1/native/windows");
		} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			System.setProperty("org.lwjgl.librarypath",
					System.getProperty("user.dir")
							+ "/lib/lwjgl-2.9.1/native/macosx");
		} else {
			System.setProperty("org.lwjgl.librarypath",
					System.getProperty("user.dir") + "/lib/lwjgl-2.9.1/native/"
							+ System.getProperty("os.name").toLowerCase());
		}

		System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL",
				"false");
		System.err.println(System.getProperty("os.name") + ": "
				+ System.getProperty("org.lwjgl.librarypath"));
		// @formatter:on

		// Initialisiere das Spiel Tanks im Debug-Modus (ohne UI-Ausgabe)
		gorillas = new TestGorillas(true);

		// Initialisiere die statische Klasse Map
		try {
			app = new TWLTestAppGameContainer(gorillas, 1000, 600, false);
			app.start(0);

		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Stoppe das im Hintergrund laufende Spiel
	 */
	public void stopGame() {
		if (app != null) {
			app.exit();
			app.destroy();
		}
		StateBasedEntityManager.getInstance().clearAllStates();
		gorillas = null;
	}

	/**
	 * Run the game for a specified duration. Laesst das Spiel fuer eine
	 * angegebene Zeit laufen
	 * 
	 * @param ms
	 *            duration of runtime of the game
	 */
	public void runGame(int ms) {
		if (gorillas != null && app != null) {
			try {
				app.updateGame(ms);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * all the game data is stored. This method is needed to restore the game
	 * data after the testing. The term game data denotes every information,
	 * which the game saves between different runs (like settings and the chosen
	 * player names).
	 */
	public void rememberGameData() {
		// TODO: Implement
	}

	/**
	 * restores the saved game data. This method is called after the tests. It
	 * should make sure that
	 */
	public void restoreGameData() {
		// TODO: Implement
	}

	/**
	 * this method should set the two player names if the gorillas game
	 * currently is in the GameSetupState
	 * 
	 * @param player1Name
	 *            the name of player 1
	 * @param player2Name
	 *            the name of player 2
	 */
	public void setPlayerNames(String player1Name, String player2Name) {
		// TODO: Implement
	}

	/**
	 * if the gorillas game is in the GameSetupState, this method should
	 * simulate a press on a button, which starts the game. If both names are
	 * set and they are not empty and not equal the game should enter the
	 * GamePlayState. Otherwise it should stay in the GameSetupState.
	 */
	public void startGameButtonPressed() {
		// TODO: Implement
	}

	/**
	 * simulates the input of a character in the velocity input field. The
	 * velocity value of the current shot parameterization should be adjusted
	 * according to the input. It should only be possible to insert velocity
	 * values between 0 and 200.
	 * 
	 * @param charac
	 *            the input character
	 */
	public void fillVelocityInput(char charac) {
		// TODO: Implement
	}

	/**
	 * @return the velocity value of the current shot parameterization. If
	 *         nothing was put in the method should return -1.
	 */
	public int getVelocityInput() {
		// TODO: Implement
		return -1;
	}

	/**
	 * simulates the input of a character in the angle input field. The angle
	 * value of the current shot parameterization should be adjusted according
	 * to the input. It should only be possible to insert angle values between 0
	 * and 360.
	 * 
	 * @param charac
	 *            the input character
	 */
	public void fillAngleInput(char charac) {
		// TODO: Implement
	}

	/**
	 * @return the angle value of the current shot parameterization. If nothing
	 *         was put in the method should return -1.
	 */
	public int getAngleInput() {
		// TODO: Implement
		return -1;
	}

	/**
	 * should clear the angle input and the velocity input field of the current
	 * player. Both angle value and velocity value should then be -1.
	 */
	public void resetPlayerWidget() {
		// TODO: Implement
	}

	public void shootButtonPressed() {
		// TODO: Implement
	}

	/**
	 * 
	 * Computes the next position of a throw. Your method has to evaluate the
	 * parameters as defined by the task description. You can choose your own
	 * time scaling factor. The constraint is: The gameplay. This means on one
	 * hand, that the user does not have to wait for minutes till the shot
	 * either collides or leaves the screen (not too slow). On the other hand,
	 * the user has to be able to follow the shot with the eyes (not too fast).
	 * To ensure testability, please provide your time scaling factor via
	 * {@link #getTimeScalingFactor()}.
	 * 
	 * @param startPosition
	 *            the (x,y) start position of the shot. The upper left corner of
	 *            the game screen is (0,0). The lower right corner of the game
	 *            screen is (width of game screen, height of game screen).
	 * @param angle
	 *            the starting angle in degree from 0 to 360
	 * @param speed
	 *            the speed in a range from 0 to 200
	 * @param deltaTime
	 *            the time passed in ms
	 * @param fromLeftToRight
	 *            true if the shot was fired by the left player and thus moves
	 *            from left to right, otherwise false
	 * @return the next position of the shot
	 */
	public Vector2f getNextShotPosition(Vector2f startPosition, int angle,
			int speed, boolean fromLeftToRight, int deltaTime) {

		// TODO: Implement
		return null;
	}

	/**
	 * Ensure that this method returns exactly the same time scaling factor,
	 * which is used within the calculations of the parabolic flight to make it
	 * look more realistic. For example: 1/100.
	 * 
	 * @return the time scaling factor for the parabolic flight calculation
	 */
	public float getTimeScalingFactor() {
		// TODO: Implement
		return -1;
	}

	/**
	 * This method should provide the tests with your custom error message for
	 * the case that a name input field is left empty
	 * 
	 * @return the message your game shows if a player's name input field is
	 *         left empty and the start game button is pressed
	 */
	public String getEmptyError() {
		// TODO: Implement
		return null;
	}

	/**
	 * This method should provide the tests with your custom error message for
	 * the case that player one and player two choose the same name
	 * 
	 * @return the message your game shows if both player names are equals and
	 *         the start game button is pressed
	 * 
	 */
	public String getEqualError() {
		// TODO: Implement
		return null;
	}

	/**
	 * This method should return the name input error message for player one.
	 * 
	 * @return the error message for the name input of player one (empty String
	 *         if the name is ok) or null in case the game is not in the
	 *         GameSetupState
	 */
	public String getPlayer1Error() {
		// TODO: Implement
		return null;
	}

	/**
	 * This method should return the name input error message for player two.
	 * 
	 * @return the error message for the name input of player two (empty String
	 *         if the name is ok) or null in case the game is not in the
	 *         GameSetupState
	 */
	public String getPlayer2Error() {
		// TODO: Implement
		return null;
	}

	/**
	 * This Method should emulate the key pressed event.
	 * 
	 * Diese Methode emuliert das Druecken beliebiger Tasten.
	 * 
	 * @param updatetime
	 *            Zeitdauer bis update-Aufruf
	 * @param input
	 *            z.B. Input.KEY_K, Input.KEY_L
	 */
	public void handleKeyPressed(int updatetime, Integer input) {
		if (gorillas != null && app != null) {
			app.getTestInput().setKeyPressed(input);
			try {
				app.updateGame(updatetime);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This Method should emulate the pressing of the n key. This should start a
	 * new game.
	 * 
	 * Diese Methode emuliert das Druecken der 'n'-Taste. (Dies soll es
	 * ermoeglichen, das Spiel neu zu starten)
	 */
	public void handleKeyPressN() {
		handleKeyPressed(0, Input.KEY_N);
	}
}
