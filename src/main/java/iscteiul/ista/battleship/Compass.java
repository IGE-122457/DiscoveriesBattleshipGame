package iscteiul.ista.battleship;

/**
 * Represents the possible compass directions used to define
 * the orientation (bearing) of ships in the Battleship game.
 *
 * <p>
 * Each direction is associated with a character representation:
 * </p>
 * <ul>
 *   <li>'n' - North</li>
 *   <li>'s' - South</li>
 *   <li>'e' - East</li>
 *   <li>'o' - West (Oeste)</li>
 *   <li>'u' - Unknown</li>
 * </ul>
 *
 * <p>
 * The UNKNOWN value is used as a fallback when an invalid character
 * is provided.
 * </p>
 */
public enum Compass {

    NORTH('n'),
    SOUTH('s'),
    EAST('e'),
    WEST('o'),
    UNKNOWN('u');

    /**
     * Character representation of the direction.
     */
    private final char c;

    /**
     * Creates a Compass direction associated with a character.
     *
     * @param c the character representing the direction
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Returns the character representation of the direction.
     *
     * @return the direction as a character
     */
    public char getDirection() {
        return c;
    }

    /**
     * Returns the string representation of the direction.
     *
     * @return the direction character as a String
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converts a character into its corresponding Compass value.
     *
     * @param ch the character to convert
     * @return the corresponding Compass direction, or UNKNOWN if invalid
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
