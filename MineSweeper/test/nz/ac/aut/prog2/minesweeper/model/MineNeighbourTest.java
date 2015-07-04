package nz.ac.aut.prog2.minesweeper.model;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test framework for the MineNeighbour class.
 *
 * @author  Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 */
public class MineNeighbourTest
{
    private MineWorld world; 
    private Position  position;
    private MineNeighbour neighbour;
    private MineNeighbour bigNeighbour;
	
    /**
     * Default constructor for the test class.
     */
    public MineNeighbourTest()
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
        world    = new MineWorld(6, 6);
        position = new Position(world, 3, 1); 
        // create a field that has 4 mines in the neighbourhood 
        neighbour    = new MineNeighbour(position, 4);
        // create a field that has 8 mines in the neighbourhood
        bigNeighbour = new MineNeighbour(position, 8);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        world        = null;
        position     = null;       
        neighbour    = null;
        bigNeighbour = null;
    }
    

    /**
     * Test of getNeighbouringMines method, of class MineNeighbour.
     */
    @Test
    public void testGetNeighbouringMines() 
    {
        assertEquals(4, neighbour.getNumNeighbouringMines());
        assertEquals(8, bigNeighbour.getNumNeighbouringMines());
    }
    
    
    /**
     * Test of getStringRepresentation method, of class MineNeighbour.
     */
    @Test    
    public void testGetStringRepresentation() 
    {
        assertEquals("4", neighbour.getStringRepresentation());
        assertEquals("8", bigNeighbour.getStringRepresentation());
    }    
    
}
