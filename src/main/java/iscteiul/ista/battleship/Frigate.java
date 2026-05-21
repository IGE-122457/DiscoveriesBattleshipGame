package iscteiul.ista.battleship;

/**
 * Represents a Frigate ship in the Battleship game.
 * <p>
 * A Frigate occupies {@value #SIZE} consecutive positions on the board,
 * either vertically (NORTH/SOUTH) or horizontally (EAST/WEST).
 * </p>
 *
 * @author Nome do aluno
 */
public class Frigate extends Ship {

    /**
     * The fixed size of a Frigate.
     */
    private static final Integer SIZE = 4;

    /**
     * The name of the ship.
     */
    private static final String NAME = "Fragata";

    /**
     * Creates a Frigate with a given bearing and starting position.
     * <p>
     * The ship's occupied positions are calculated based on its bearing:
     * </p>
     * <ul>
     *   <li>NORTH or SOUTH → vertical placement</li>
     *   <li>EAST or WEST → horizontal placement</li>
     * </ul>
     *
     * @param bearing the orientation of the ship
     * @param pos the starting position (topmost or leftmost)
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++) {
                    getPositions().add(
                            new Position(pos.getRow() + r, pos.getColumn())
                    );
                }
                break;

            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++) {
                    getPositions().add(
                            new Position(pos.getRow(), pos.getColumn() + c)
                    );
                }
                break;

            default:
                throw new IllegalArgumentException(
                        "ERROR! Invalid bearing for the frigate"
                );
        }
    }

    /**
     * Returns the size of the Frigate.
     *
     * @return the number of positions occupied by the Frigate
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }
}