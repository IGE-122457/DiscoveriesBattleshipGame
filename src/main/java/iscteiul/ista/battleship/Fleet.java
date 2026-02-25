package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a fleet of ships in the Battleship game.
 *
 * <p>
 * A Fleet is responsible for storing ships, validating their placement,
 * preventing collisions, and providing information about their state.
 * </p>
 *
 * <p>
 * It ensures that:
 * <ul>
 *   <li>Ships are inside board boundaries</li>
 *   <li>Ships do not collide or overlap</li>
 *   <li>The fleet does not exceed the maximum allowed size</li>
 * </ul>
 * </p>
 */
public class Fleet implements IFleet {

    /**
     * Prints a list of ships to the standard output.
     *
     * @param ships the list of ships to print
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    /**
     * The list of ships belonging to this fleet.
     */
    private List<IShip> ships;

    /**
     * Creates an empty fleet.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Returns all ships in the fleet.
     *
     * @return the list of ships
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adds a ship to the fleet if all placement rules are respected.
     *
     * <p>
     * A ship is added only if:
     * <ul>
     *   <li>The fleet size limit is not exceeded</li>
     *   <li>The ship is inside board boundaries</li>
     *   <li>The ship does not collide with existing ships</li>
     * </ul>
     * </p>
     *
     * @param s the ship to add
     * @return true if the ship was successfully added, false otherwise
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Returns all ships that belong to a given category.
     *
     * @param category the category of ships to filter
     * @return a list of ships matching the given category
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Returns all ships that are still floating (not sunk).
     *
     * @return a list of ships that are still floating
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Returns the ship occupying a given position.
     *
     * @param pos the position to check
     * @return the ship occupying the position, or null if none exists
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Verifies whether a ship is completely inside board boundaries.
     *
     * @param s the ship to validate
     * @return true if the ship is inside the board, false otherwise
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 &&
                s.getRightMostPos() <= BOARD_SIZE - 1 &&
                s.getTopMostPos() >= 0 &&
                s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Checks whether adding a ship would cause a collision
     * or violate minimum distance constraints.
     *
     * @param s the ship to validate
     * @return true if there is a collision risk, false otherwise
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    /**
     * Prints a full status report of the fleet,
     * including all ships and their categories.
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Prints all ships belonging to a given category.
     *
     * @param category the category of ships to display
     */
    public void printShipsByCategory(String category) {
        assert category != null;
        printShips(getShipsLike(category));
    }

    /**
     * Prints all ships that are still floating.
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Prints all ships in the fleet.
     */
    void printAllShips() {
        printShips(ships);
    }
}
