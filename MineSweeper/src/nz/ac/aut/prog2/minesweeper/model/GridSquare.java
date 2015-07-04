package nz.ac.aut.prog2.minesweeper.model;

/**
 * Class to represent squares in a grid game.
 * 
 * @author Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 */
public class GridSquare
 {
     // the single optional occupant of the grid square
    private Occupant occupant;
    
    /**
     * Creates a new empty grid square.
     */
    public GridSquare() 
    {
        occupant = null;
    }    
    
    /**
     * Checks if the grid square is occupied.
     * 
     * @return true if the grid square is occupied, false if not
     */
    public boolean isOccupied()
    {
        return (occupant != null);
    }
    
    /**
     * Adds an occupant, if there is not already one.
     * 
     * @param newOccupant the new occupant
     * @return true if occupant was added, false if not
     */
    public boolean addOccupant(Occupant newOccupant)
    {
        boolean success = false;
        if ( (newOccupant != null) && !isOccupied() ) 
        {
            occupant = newOccupant;
            success  = true;
        }
        return success;
    }
    
    /**
     * Gets the current occupant.
     * 
     * @return the current occupant
     */
    public Occupant getOccupant()
    {
        return occupant;
    }
    
    /**
     * Removes the occupant.
     * 
     * @return the old occupant
     */
    public Occupant removeOccupant()
    {
        Occupant temp = occupant;
        occupant = null;
        return temp;
    }
    
    /**
     * Checks is the grid square has a mine
     * 
     * @return true if there is a mine in this grid square, false if not
     */
    public boolean hasMine()
    {
        return (occupant instanceof Mine);
    }
    
    /**
     * Gets the string representation of the occupants in this griod square for printing.
     * 
     * @return the string represdentation of the occupant
     */
    public String getOccupantStringRepresentation()
    {
        String ret = "";
        if ( isOccupied() )
        {
            ret = occupant.getStringRepresentation();
        }
        return ret;
    }    
}
