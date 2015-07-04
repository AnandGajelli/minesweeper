package nz.ac.aut.prog2.minesweeper.model;

/**
 * An occupant representing a mine.
 * 
 * @author Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 */
public class Mine extends Occupant
{
    /**
     * Creates a new mine.
     * 
     * @param initialPosition the initial position of this mine
     */
    public Mine(Position initialPosition)
    {
        super(initialPosition);
    }
    
    /**
     * Gets a string representation of this occupant for printing.
     * 
     * @return an "X" representing a mine
     */
    @Override
    public String getStringRepresentation()
    {
        return "X";
    }
}

