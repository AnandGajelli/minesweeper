package nz.ac.aut.prog2.minesweeper.model;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test framework for the Mine class.
 *
 * @author  Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 */
public class MineTest
{
    private MineWorld world;     
    private Position  position;
    private Mine      testMine;
    
    /**
     * Default constructor for the test class.
     */
    public MineTest()
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
        position = new Position(world, 4,3);        
        testMine = new Mine(position);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        testMine = null;
        world    = null;
        position = null;       
    }      

    /**
     * Test of getStringRepresentation method, of class Mine.
     */
    @Test
    public void testGetStringRepresentation() 
    {
        assertEquals("X", testMine.getStringRepresentation());
    }    
}
