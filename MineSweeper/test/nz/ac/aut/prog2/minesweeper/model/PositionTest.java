package nz.ac.aut.prog2.minesweeper.model;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test framework for the Position class.
 *
 * @author Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 */
public class PositionTest 
{
    private Position position;
    private MineWorld world;
    
    /**
     * Default constructor for test class.
     */
    public PositionTest()
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
        world = new MineWorld(5, 5);
        position = new Position(world, 1, 2);
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        world = null;
        position = null;      
    }

    // Tests to ensure correct exceptions thrown for invalid arguments
    @Test
    public void testIllegalArgumentNoWorld() throws Exception 
    {
        try 
        {
            Position invalidPosition = new Position(null,0,0);
            fail("No exception thrown when world null.");
        }
        catch (IllegalArgumentException expected) 
        {
            assertTrue("Not expected exception message",expected.getMessage().indexOf("World") >= 0);
        }
        
    }

    @Test
    public void testIllegalArgumentRowNegative() throws Exception 
    {
        try 
        {
            Position invalidPosition = new Position(world,-1,0);
            fail("No exception thrown when row negative.");
        }
        catch (IllegalArgumentException expected) 
        {
            assertTrue("Not expected exception message",expected.getMessage().indexOf("Invalid row") >= 0);
        }
        
    }
    
    @Test
    public void testIllegalArgumentRowTooLarge() throws Exception
    {
        try 
        {
            Position invalidPosition = new Position(world,5,0);
            fail("No exception thrown when row too large.");
        }
        catch (IllegalArgumentException expected) 
        {
            assertTrue("Not expected exception message",expected.getMessage().indexOf("Invalid row") >= 0);
        }
        
    } 
    
    @Test
    public void testIllegalArgumentColumnNegative() throws Exception
    {
        try 
        {
            Position invalidPosition = new Position(world,1,-1);
            fail("No exception thrown when column negative.");
        }
        catch (IllegalArgumentException expected) 
        {
            assertTrue("Not expected exception message",expected.getMessage().indexOf("Invalid column") >= 0);
        }
        
    }
    
    @Test
    public void testIllegalArgumentColumnTooLarge() throws Exception
    {
        try 
        {
            Position invalidPosition = new Position(world,0,5);
            fail("No exception thrown when column too large.");
        }
        catch (IllegalArgumentException expected) 
        {
            assertTrue("Not expected exception message",expected.getMessage().indexOf("Invalid column") >= 0);
        }
        
    }
    
    // Test column accessor
    @Test
    public void testGetColumn()
    {
        assertEquals(2, position.getColumn());
    }    

    // Test row accessor
    @Test
    public void testGetRow()
    {
        assertEquals(1, position.getRow());
    }  

}
