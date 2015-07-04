package nz.ac.aut.prog2.minesweeper.model;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test framework for the MineWorld class.
 *
 * @author  Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 */
public class MineWorldTest
{
    private MineWorld beginnerWorld;
    private MineWorld intermediateWorld; 
    private MineWorld smallExpertWorld;    
    private MineWorld expertWorld;
    private MineWorld fixedMinesWorld;
    
    /**
     * Default constructor for test class MineWorldTest
     */
    public MineWorldTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        beginnerWorld = new MineWorld(10, 10);
        beginnerWorld.startGame(GameLevel.BEGINNER);
        
        intermediateWorld = new MineWorld(16, 16);
        intermediateWorld.startGame(GameLevel.INTERMEDIATE);
        
        smallExpertWorld = new MineWorld(20, 20);
        smallExpertWorld.startGame(GameLevel.EXPERT);
        
        expertWorld = new MineWorld(30, 16);
        expertWorld.startGame(GameLevel.EXPERT);
        
        fixedMinesWorld = new MineWorld(16, 16);
        fixedMinesWorld.placeFixedMines(getMinePositions());
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        beginnerWorld     = null;
        intermediateWorld = null;
        smallExpertWorld  = null;
        expertWorld       = null;
        fixedMinesWorld   = null;
    }
    
    /**
     * Test of getNumColumns method, of class MineWorld.
     */
    @Test
    public void testGetNumColumns()
    {
        assertEquals(10,beginnerWorld.getNumColumns());
    }

    /**
     * Test of getNumRows method, of class MineWorld.
     */
    @Test
    public void testGetNumRows()
    {
        assertEquals(16, intermediateWorld.getNumRows());
    } 
    
    /**
     * Tests of getMineCount
     */
    @Test
    public void testGetMineCountBeginner()
    {
        assertEquals(12, beginnerWorld.getMineCount());
    }
    
    @Test
    public void testGetMineCountIntermediate()
    {
        assertEquals(40, intermediateWorld.getMineCount());
    }
    
    @Test
    public void testGetMineCountSmallExpert()
    {
        assertEquals(82, smallExpertWorld.getMineCount());
    }
    
    @Test
    public void testGetMineCountExpert()
    {
        assertEquals(99, expertWorld.getMineCount());
    }
    
    /**
     * Test for specific mine neighbour positions and cases.
     */
    @Test
    public void testNumSurroundingMinesOne()
    {
        assertEquals(1, fixedMinesWorld.getNumSurroundingMines(1, 2));
    }
    
    @Test
    public void testNumSurroundingMinesNone()
    {
        assertEquals(0, fixedMinesWorld.getNumSurroundingMines(2, 2));
    }

    @Test
    public void testNumSurroundingMinesMaximum()
    {
        assertEquals(8, fixedMinesWorld.getNumSurroundingMines(2, 9));
    }

    @Test
    public void testNumSurroundingMinesTopLeftCorner()
    {
        assertEquals(1, fixedMinesWorld.getNumSurroundingMines(0, 0));
    }

    @Test
    public void testNumSurroundingMinesBottomRightCorner()
    {
        assertEquals(2, fixedMinesWorld.getNumSurroundingMines(15, 15));
    }
    
    /**
     * Not elegant, but sets up 40 mines in known positions
     * creating a full range of neighbouring relationships. ie from 0-8 surrounding mines.
     * Mines marked 'X'. Digit indicate # mines in surrounding squares.
     * Top row is column numbers, righthand column is row numbers.
     * _0 1_2_3_4_5_6_7_8_9_10
     * |1|X|1|_|_|_|_|1|2|3|2|1|_|_|_|_|0
     * |1|1|1|_|1|2|3|4|X|X|X|2|_|_|_|_|1
     * |_|_|_|_|2|X|X|X|X|8|X|3|_|1|1|1|2
     * |_|_|_|_|3|X|5|4|X|X|X|2|_|1|X|1|3
     * |_|_|_|_|2|X|2|1|2|3|2|1|_|1|1|1|4
     * |1|1|_|_|1|1|1|_|_|_|_|_|_|_|_|_|5
     * |X|2|_|_|_|_|_|_|_|_|_|_|_|_|_|_|6
     * |X|3|_|_|_|_|1|2|3|2|1|_|_|_|_|_|7
     * |X|2|_|_|_|_|1|X|X|X|2|_|1|2|2|1|8
     * |1|1|_|_|_|_|1|3|6|X|3|1|3|X|X|3|9
     * |_|_|_|_|_|_|1|2|X|X|3|1|X|X|X|X|10
     * |_|_|_|_|_|_|2|X|7|X|3|1|3|X|5|3|11
     * |_|_|_|_|_|_|2|X|X|X|2|_|1|2|X|1|12
     * |_|_|_|_|_|_|1|2|3|2|1|_|_|1|2|1|13
     * |_|_|1|2|1|_|_|_|_|_|_|_|_|2|X|2|14
     * |_|_|1|X|1|_|_|_|_|_|_|_|_|2|X|2|15
     * @return array of posiitons for the 40 mines
     */
    private Position[] getMinePositions() 
    {
        Position[] minePositions = new Position[40];
        minePositions[0]  = new Position(fixedMinesWorld, 0, 1);
        minePositions[1]  = new Position(fixedMinesWorld, 1, 8);
        minePositions[2]  = new Position(fixedMinesWorld, 1, 9);
        minePositions[3]  = new Position(fixedMinesWorld, 1, 10);
        minePositions[4]  = new Position(fixedMinesWorld, 2, 5);
        minePositions[5]  = new Position(fixedMinesWorld, 2, 6);
        minePositions[6]  = new Position(fixedMinesWorld, 2, 7);
        minePositions[7]  = new Position(fixedMinesWorld, 2, 8);
        minePositions[8]  = new Position(fixedMinesWorld, 2, 10);
        minePositions[9]  = new Position(fixedMinesWorld, 3, 5);
        minePositions[10] = new Position(fixedMinesWorld, 3, 8);
        minePositions[11] = new Position(fixedMinesWorld, 3, 9);
        minePositions[12] = new Position(fixedMinesWorld, 3, 10);
        minePositions[13] = new Position(fixedMinesWorld, 3, 14);
        minePositions[14] = new Position(fixedMinesWorld, 4, 5);
        minePositions[15] = new Position(fixedMinesWorld, 6, 0);
        minePositions[16] = new Position(fixedMinesWorld, 7, 0);
        minePositions[17] = new Position(fixedMinesWorld, 8, 0);
        minePositions[18] = new Position(fixedMinesWorld, 8, 7);
        minePositions[19] = new Position(fixedMinesWorld, 8, 8);
        minePositions[20] = new Position(fixedMinesWorld, 8, 9);
        minePositions[21] = new Position(fixedMinesWorld, 9, 9);
        minePositions[22] = new Position(fixedMinesWorld, 9, 13);
        minePositions[23] = new Position(fixedMinesWorld, 9, 14);
        minePositions[24] = new Position(fixedMinesWorld, 10, 8);
        minePositions[25] = new Position(fixedMinesWorld, 10, 9);
        minePositions[26] = new Position(fixedMinesWorld, 10, 12);
        minePositions[27] = new Position(fixedMinesWorld, 10, 13);
        minePositions[28] = new Position(fixedMinesWorld, 10, 14);
        minePositions[29] = new Position(fixedMinesWorld, 10, 15);
        minePositions[30] = new Position(fixedMinesWorld, 11, 7);
        minePositions[31] = new Position(fixedMinesWorld, 11, 9);
        minePositions[32] = new Position(fixedMinesWorld, 11, 13);
        minePositions[33] = new Position(fixedMinesWorld, 12, 7);
        minePositions[34] = new Position(fixedMinesWorld, 12, 8);
        minePositions[35] = new Position(fixedMinesWorld, 12, 9);
        minePositions[36] = new Position(fixedMinesWorld, 12, 14);
        minePositions[37] = new Position(fixedMinesWorld, 15, 3);
        minePositions[38] = new Position(fixedMinesWorld, 14, 14);
        minePositions[39] = new Position(fixedMinesWorld, 15, 14);
        return minePositions;
    }    
}
