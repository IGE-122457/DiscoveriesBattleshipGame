package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Battleship game session.
 * <p>
 * A Game manages:
 * <ul>
 *     <li>The player's fleet</li>
 *     <li>The list of fired shots</li>
 *     <li>Game statistics (invalid shots, repeated shots, hits and sunk ships)</li>
 * </ul>
 * </p>
 *
 * The game processes shots fired at given positions and updates the
 * corresponding statistics and fleet state accordingly.
 *
 * @see IGame
 * @see IFleet
 * @see IShip
 * @see IPosition
 */
public class Game implements IGame {

    /** The fleet participating in the game. */
    private IFleet fleet;

    /** List of valid shots fired during the game. */
    private List<IPosition> shots;

    /** Counter for invalid shots (outside board boundaries). */
    private Integer countInvalidShots;

    /** Counter for repeated shots. */
    private Integer countRepeatedShots;

    /** Counter for successful hits. */
    private Integer countHits;

    /** Counter for sunk ships. */
    private Integer countSinks;

    /**
     * Creates a new Game with a given fleet.
     *
     * @param fleet the fleet to be used in the game
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        countHits = 0;
        countSinks = 0;
        this.fleet = fleet;
    }

    /**
     * Fires a shot at the given position.
     * <p>
     * The method performs the following validations:
     * <ul>
     *     <li>If the position is invalid (outside the board), increments invalid shot counter.</li>
     *     <li>If the position was already targeted, increments repeated shot counter.</li>
     *     <li>If the shot is valid and new, checks if a ship exists at that position.</li>
     * </ul>
     * </p>
     *
     * If a ship is hit and sinks as a result of the shot,
     * the sunk ship is returned. Otherwise, {@code null} is returned.
     *
     * @param pos the position being targeted
     * @return the sunk ship if the shot caused a ship to sink; {@code null} otherwise
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else {
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the list of valid shots fired during the game.
     *
     * @return list of fired shot positions
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Returns the number of repeated shots.
     *
     * @return number of repeated shots
     */

    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }


    /**
     * Returns the number of invalid shots.
     *
     * @return number of invalid shots
     */

    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Returns the total number of successful hits.
     *
     * @return number of hits
     */

    public int getHits() {
        return this.countHits;
    }

    /**
     * Returns the number of ships that have been sunk.
     *
     * @return number of sunk ships
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Returns the number of ships still afloat.
     *
     * @return number of remaining ships
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Checks whether a shot is within board boundaries.
     *
     * @param pos the position to validate
     * @return {@code true} if the shot is inside the board; {@code false} otherwise
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE
                && pos.getColumn() >= 0 && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * Checks whether a shot was already fired previously.
     *
     * @param pos the position to check
     * @return {@code true} if the shot was already fired; {@code false} otherwise
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Prints a board representation marking given positions with a specific character.
     *
     * @param positions list of positions to mark
     * @param marker character used to represent those positions
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }
    }

    /**
     * Prints the board showing valid shots that have been fired.
     * Valid shots are represented with the character 'X'.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Prints the board showing the fleet positions.
     * Ship positions are represented with the character '#'.
     */

    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }
}