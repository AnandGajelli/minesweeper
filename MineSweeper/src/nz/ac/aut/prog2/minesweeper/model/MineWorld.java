package nz.ac.aut.prog2.minesweeper.model;

import java.util.Random;

/**
 * A class to represent the world in which the game is played.
 * 
 * @author Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 */
public class MineWorld
 {
    private int numRows;
    private int numColumns;
    private GridSquare[][] gameGrid;
    private Random randomGenerator;
   

    /**
     * Creates a mine world of a specific size without any mines.
     * 
     * @param numRows the number of rows of this world
     * @param numColumns the number of columns of this world
     */
    public MineWorld(int numRows, int numColumns)
    {
        this.numRows    = numRows;
        this.numColumns = numColumns;
        gameGrid = new GridSquare[this.numRows][this.numColumns];
        initialiseGameGrid();
    }
    
    /**
     * Starts a game with a specific difficulty.
     * 
     * @param level the difficulty for the game
     */
    public void startGame(GameLevel level)
    {
        // important to re-initialise grid in case the game is re-started
        initialiseGameGrid();
        // place number of mines based on level
        int numMines = (int) (this.numRows * this.numColumns * level.getProbability());
        randomGenerator = new Random();
        createAndPlaceMines(numMines);
        createAndPlaceMineNeighbours();
    }

    /**
     * Gets the number of rows of this mine world.
     *
     * @return the number of rows
     */
    public int getNumRows()
    {
        return this.numRows;
    }

    /**
     * Gets the number of columns of this mine world.
     *
     * @return the number of columns
     */
    public int getNumColumns() 
    {
        return this.numColumns;
    }

    /**
     * Gets the actual number of mines of this world.
     * 
     * @return the number of mines in this game
     */
    public int getMineCount()
    {
        int mineCounter = 0;
        for ( GridSquare[] row : gameGrid )
        {
            for ( GridSquare square : row )
            {
                if ( square.hasMine() ) 
                {
                    mineCounter++;
                }
            }
        }
        return mineCounter;
    }

    /**
     * Produces a textual representation of MineWorld on the console.
     * This exists mainly for debugging purposes.
     */
    public void draw() 
    {
        System.out.println(getStringRepresentation());
    }
    
    /**
     * Returns a string with the mine world, e.g., for printing.
     * 
     * @return a string that represents the mine world
     */
    public String getStringRepresentation()
    {
        String output = "";
        final int CELL_SIZE = 3;
        
        // create the horizontal line as a string
        String horizontalLine = "-";
        for ( int col = 0; col < numColumns; col++ )
        {
            for ( int i = 0 ; i < CELL_SIZE ; i++ )
            {
                horizontalLine += "-";
            }            
            horizontalLine += "-";
        }
        
        // print the content
        for ( int row = 0; row < numRows; row++ ) 
        { 
            String rowOccupant = "|";
            for ( int col = 0; col < numColumns; col++ ) 
            {
                GridSquare g = gameGrid[row][col];
                // create string with occupant
                String cellOccupant = " " + g.getOccupantStringRepresentation();
                // pad the output with spaces to a specific size
                for ( int i = cellOccupant.length() ; i < CELL_SIZE ; i++ )
                {
                    cellOccupant += " ";
                }
                rowOccupant += cellOccupant + "|";
            }
            output += horizontalLine + "\n";
            output += rowOccupant + "\n";
        }
        output += horizontalLine;
        
        return output;
    }

    /**
     * Initialises the 2D array holding the grid squares.
     */
    private void initialiseGameGrid() 
    {
        for (int row = 0; row < numRows; row++) 
        {
            for (int column = 0; column < numColumns; column++)
            {
                GridSquare square = new GridSquare();
                gameGrid[row][column] = square;
            }
        }
    }
    
    /**
     * Places mines on random empty squares
     * @param numMines - the number of mines to place
     */
    private void createAndPlaceMines(int numMines)
    {
        Mine mine;
        for (int mineCount = 0; mineCount < numMines; mineCount++)
        {
            Position pos = getRandomEmptySquare();
            //place a mine on this square
            mine = new Mine(pos);
            gameGrid[pos.getRow()][pos.getColumn()].addOccupant(mine);
        }
    }

    /**
     * Finds a random grid square that is empty.
     * 
     * @return a position representing the coordinate of the square
     */
    private Position getRandomEmptySquare() 
    {
        int row, col;
        GridSquare square;
        do
        {
            // look at a random square
            row = randomGenerator.nextInt(this.numRows);
            col = randomGenerator.nextInt(this.numColumns);
            square = gameGrid[row][col];
        } while ( square.isOccupied() );
        // found an empty square: return the position
        return new Position(this, row, col);
    }

    /**
     * Adds mine neighbours to all squares surrounding mines,
     * provided that they are not themselves mines.
     */
    private void createAndPlaceMineNeighbours() 
    {
        for (int row = 0; row < numRows; row++) 
        {
            for (int column = 0; column < numColumns; column++) 
            {
                updateIfMineNeighbour(row, column);
            }
        }
    }

    /**
     * If this square has mines in neighbouring squares
     * a mineNeighbour is added to the square.
     * 
     * @param row in the grid of the square
     * @param col in the grid of the square
     */
    private void updateIfMineNeighbour(int row, int col)
    {
        GridSquare square = gameGrid[row][col];
        if ( !square.hasMine() )
        {
            int neighbouringMines = getNumNeighbouringMines(row, col);
            if (neighbouringMines > 0) 
            {
                //create a mine neighbour to occupy the square
                MineNeighbour neighbour = new MineNeighbour(new Position(this, row, col), neighbouringMines);
                square.addOccupant(neighbour);
            }
        }
    }

    /**
     * Counts the number of neighbouring mines.
     * 
     * @param row in the grid of the square
     * @param col in the grid of the square
     * @return the number of surrounding mines
     */
    private int getNumNeighbouringMines(int row, int col) 
    {
        assert !gameGrid[row][col].hasMine();
        int mineCount = 0;
        //Check the block of 9 squares surrounding and including square
        int startRow = row - 1;
        int endRow   = row + 1;
        int startCol = col - 1;
        int endCol   = col + 1;
        for (int rowToCheck = startRow; rowToCheck <= endRow; rowToCheck++) 
        {
            for (int colToCheck = startCol; colToCheck <= endCol; colToCheck++) 
            {
                mineCount += checkForMine(rowToCheck, colToCheck);
            }
        }
        return mineCount;
    }

    /**
     * If this is a valid square, check it for a mine
     * @param row in the grid of the square
     * @param col in the grid of the square
     * @return 1 if there is a mine at row, col
     */
    private int checkForMine(int row, int col)
    {
        int numMines = 0;
        boolean invalidRow  = (row < 0 || row >= this.numRows);
        boolean invalidCol  = (col < 0 || col >= this.numColumns);
        boolean outOfBounds = invalidRow || invalidCol;
        if ( !outOfBounds )
        {
            if ( gameGrid[row][col].hasMine() ) 
            {
                numMines++;
            }
        }
        return numMines;
    }

    /**
     * Places mines a specific positions.
     * 
     * @param minePositions an array with positions for mines
     */
    public void placeFixedMines(Position[] minePositions)
    {
        for ( Position pos : minePositions )
        {
            Mine mine = new Mine(pos);
            gameGrid[pos.getRow()][pos.getColumn()].addOccupant(mine);
        }
        createAndPlaceMineNeighbours(); // important!!!
    }
    
    /**
     * Retrieves the number of mines surrounding a specific field.
     * 
     * @param row the row to check
     * @param col the column to check
     * @return 0 if the field does not have mine neighbours,
     *         >0 if there are mines in the neighbourhood
     */
    public int getNumSurroundingMines(int row, int col)
    {
        int numNeighbours = 0;
        boolean invalidRow  = (row < 0 || row >= this.numRows);
        boolean invalidCol  = (col < 0 || col >= this.numColumns);
        boolean outOfBounds = invalidRow || invalidCol;
        if ( !outOfBounds )
        {
            // get the grid square and its occupant (if there is one)
            GridSquare gs  = gameGrid[row][col];
            Occupant   occ = gs.getOccupant();
            // is the occupant a mine neighbour?
            if ( occ instanceof MineNeighbour )
            {
                // yes: casting to MineNeighbour possible
                MineNeighbour mn = (MineNeighbour) occ;
                numNeighbours = mn.getNumNeighbouringMines();
            }
        }
        return numNeighbours;
    }
   
}
