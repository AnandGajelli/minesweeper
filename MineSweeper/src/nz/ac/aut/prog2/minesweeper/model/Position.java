package nz.ac.aut.prog2.minesweeper.model;

/**
 * Represents the location of any item in the game.
 * Positions must always be valid for the particular game.
 *
 * @author Stefan Marks & Anne Philpott
 * @version v1.0 - 2012.06: Created
 */
public class Position
{
    // the row part of this position
    private int row;
    // the column part of this position
    private int column;
     
    /**
     * Constructor for objects of class Position
     * Can only construct valid positions. Invalid arguments result in exceptions.
     * @param row, row value for positions
     * @param column, column value for positions
     * @param world, the world on which the position is
     */
    public Position(MineWorld world, int row, int column)
    {
        if ( world == null )
        {
            throw new IllegalArgumentException(
                    "World parameter cannot be null");
        }
        if ( (row < 0) || (row >= world.getNumRows()) )
        {
            throw new IllegalArgumentException(
                    "Invalid row for position (" + row + ")");
        }
        if ( (column < 0) || (column >= world.getNumColumns()) )
        {
            throw new IllegalArgumentException(
                    "Invalid column for position (" + column + ")");
        }
        // parameters are valid -> save
        this.row    = row;
        this.column = column;
    }

    /**
     * Gets the row part of the position.
     * 
     * @return the row of this position
     */
    public int getRow()
    {
       return this.row;
    }
    
    /**
     * Gets the col part of the position.
     * 
     * @return the col of this position
     */
    public int getColumn()
    {
       return this.column;
    }   
    
}
