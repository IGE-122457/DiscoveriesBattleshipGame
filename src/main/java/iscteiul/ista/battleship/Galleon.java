package iscteiul.ista.battleship;

/**
 * Represents a Galleon ship in the Battleship game.
 * <p>
 * A Galleon occupies {@value #SIZE} positions on the board and has a
 * non-linear shape that depends on its bearing (orientation).
 * </p>
 * <p>
 * The occupied positions are calculated relative to a starting position
 * and vary according to the direction the ship is facing.
 * </p>
 *
 * @author Nome do aluno
 */
public class Galleon extends Ship {

    /**
     * The fixed size of a Galleon.
     */
    private static final Integer SIZE = 5;

    /**
     * The name of the ship.
     */
    private static final String NAME = "Galeao";

    /**
     * Creates a Galleon with a given bearing and starting position.
     * <p>
     * The ship's shape is filled according to its bearing:
     * NORTH, SOUTH, EAST or WEST.
     * </p>
     *
     * @param bearing the orientation of the galleon
     * @param pos the reference starting position of the ship
     * @throws IllegalArgumentException if the bearing is invalid
     * @throws NullPointerException if the bearing is {@code null}
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Returns the size of the Galleon.
     *
     * @return the number of positions occupied by the Galleon
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Fills the positions occupied by the Galleon when facing NORTH.
     *
     * @param pos the reference starting position
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Fills the positions occupied by the Galleon when facing SOUTH.
     *
     * @param pos the reference starting position
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Fills the positions occupied by the Galleon when facing EAST.
     *
     * @param pos the reference starting position
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Fills the positions occupied by the Galleon when facing WEST.
     *
     * @param pos the reference starting position
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }
}