package iscteiul.ista.battleship;

/**
 * Represents a Carrack ship in the Battleship game.
 * <p>
 * A Carrack (Nau) is a ship with a fixed size of 3 positions.
 * Its occupied positions depend on its {@link Compass} bearing:
 * <ul>
 *     <li>If facing {@code NORTH} or {@code SOUTH}, it occupies 3 vertical positions.</li>
 *     <li>If facing {@code EAST} or {@code WEST}, it occupies 3 horizontal positions.</li>
 * </ul>
 * </p>
 *
 * <p>
 * The initial position defines the starting coordinate of the ship.
 * From that position, the remaining coordinates are calculated
 * according to the specified bearing.
 * </p>
 *
 * @see Ship
 * @see Compass
 * @see Position
 */
public class Carrack extends Ship {

    /** The fixed size of the Carrack ship. */
    private static final Integer SIZE = 3;

    /** The name identifier of the Carrack ship. */
    private static final String NAME = "Nau";

    /**
     * Constructs a Carrack with a given bearing and starting position.
     *
     * <p>
     * The ship positions are automatically calculated and stored
     * according to the provided bearing.
     * </p>
     *
     * @param bearing the direction in which the Carrack is oriented
     * @param pos the initial position (starting coordinate) of the Carrack
     *
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;

            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Returns the size of the Carrack.
     *
     * @return the fixed size value (3)
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }
}
