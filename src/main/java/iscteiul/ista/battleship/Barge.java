package iscteiul.ista.battleship;

/**
 * Represents a Barge ship in the Battleship game.
 * 
 * <p>
 * A Barge is the smallest ship in the fleet and occupies only one position
 * on the board.
 * </p>
 * 
 * <p>
 * The ship is placed according to a given bearing and initial position,
 * although due to its size (1), the bearing does not affect its footprint.
 * </p>
 */
public class Barge extends Ship {

    /**
     * The fixed size of the Barge ship.
     */
    private static final Integer SIZE = 1;

    /**
     * The display name of the ship.
     */
    private static final String NAME = "Barca";

    /**
     * Creates a new Barge.
     *
     * @param bearing the orientation of the ship (not relevant for size 1,
     *                but kept for consistency with other ships)
     * @param pos     the initial position of the ship on the board
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Returns the size of the Barge.
     *
     * @return the size of the ship (always 1)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
