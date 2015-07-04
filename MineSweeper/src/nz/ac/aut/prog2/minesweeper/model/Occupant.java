package nz.ac.aut.prog2.minesweeper.model;

/**
 * A class for any occupant of a grid square.
 * 
 * @author Anne Philpott and Stefan Marks
 * @version Stage 1
 */
public abstract class Occupant
{
    // the position of the occupant
    private Position position;

    /**
     * Constructor for an occupant instance.
     * 
     * @param initialPosition the initial position of the occupant
     */
    public Occupant(Position initialPosition)
    {
        position = initialPosition;
    }

    /**
     * Gets the position of the occupant.
     * 
     * @return the position of the occupant
     */
    public Position getPosition()
    {
        return position;
    }
    
    /**
     * Sets the position of the occupant.
     * 
     * @param newPosition the new position of the occupant
     */
    public void setPosition(Position newPosition)
    {
        position = newPosition;
    }
    
    /**
     * Gets a string representation of the occupant, e.g., for printing to the screen.
     * 
     * @return a string representation of the basic occupant
     */
    public abstract String getStringRepresentation();
}

