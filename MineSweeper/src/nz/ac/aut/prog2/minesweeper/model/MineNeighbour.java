package nz.ac.aut.prog2.minesweeper.model;

/**
 * An occupant representing a field next to a mine.
 * 
 * @author Anne Philpott and Stefan Marks
 * @version Stage 1
 */
public class MineNeighbour extends Occupant
{
    // the number of mines in the neighbourhood
    private int neighbourMines;
    
    /**
     * Creates a new mine neighbour field.
     * 
     * @param initialPosition the initial position of this mine neighbour
     * @param neighbours the number of mines in the eight neighbouring fields
     */
    public MineNeighbour(Position initialPosition, int neighbourMines)
    {
        super(initialPosition);
        this.neighbourMines = neighbourMines;
    }

    /**
     * Gets the amount of mines in the neighbouring eight fields.
     * 
     * @return the amount of mines in the neighbouring fields
     */
    public int getNumNeighbouringMines()
    {
        return neighbourMines;
    }
    
    /**
     * Gets a string representation of this occupant for printing.
     * 
     * @return a string representation of the number of mines
     */
    @Override
    public String getStringRepresentation()
    {
        return Integer.toString(neighbourMines);
    }
}

