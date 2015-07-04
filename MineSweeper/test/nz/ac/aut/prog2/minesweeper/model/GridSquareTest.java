package nz.ac.aut.prog2.minesweeper.model;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test framework for the GridSquare class.
 *
 * @author  Anne Philpott and Stefan Marks
 * @version v1.0 - 2012.06: Created
 * @version v1.1 - 2012.08: Added test case for hasMine
 */
public class GridSquareTest 
{
    private MineWorld   world;
    private Position    position;
    private GridSquare  square;
    private Occupant    testMine;
    private Occupant    testMineNeighbour;
    
    /**
     * Default constructor for the test class.
     */
    public GridSquareTest()
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
        square   = new GridSquare();
        world    = new MineWorld(4, 4);
        position = new Position(world, 1,1);
        testMine = new Mine(position);
        testMineNeighbour = new MineNeighbour(position, 3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        square   = null;
        world    = null;
        position = null;       
        testMine = null;
        testMineNeighbour = null;
    }
    
    /**
     * Tests of occupant related methods of class GridSquare.
     * Uncomment when you finish task 4.
     */
    @Test
    public void testIsOccupied_WhenEmpty()
    {
        assertFalse(square.isOccupied());
    }
 
    @Test
    public void testGetOccupant()
    {
        square.addOccupant(testMine);
        assertEquals(testMine, square.getOccupant());
    }    

    @Test
    public void testAddOccupant()
    {
        assertTrue(square.addOccupant(testMine));
        assertEquals(testMine, square.getOccupant());
        assertTrue(square.isOccupied());
    }
    
    @Test
    public void testAddOccupant_WithNull()
    {
        assertFalse(square.addOccupant(null));
        assertFalse(square.isOccupied());
    }
    
    @Test
    public void testAddOccupant_WhenFull()
    {
        assertTrue(square.addOccupant(testMine));
        assertFalse(square.addOccupant(testMineNeighbour));
        assertEquals(testMine, square.getOccupant());
    }

    @Test
    public void testRemoveOccupant()
    {
        square.addOccupant(testMine);
        assertTrue(square.isOccupied());
        Occupant removedOccupant = square.removeOccupant();
        assertEquals(testMine, removedOccupant);
        assertNull(square.getOccupant());
        assertFalse(square.isOccupied());
    }

    @Test
    public void testHasMine_NoMine() 
    {
        assertFalse(square.hasMine());
    }

    @Test
    public void testHasMine_WithMine()
    {
        square.addOccupant(testMine);
        assertTrue(square.hasMine());
    }

    @Test
    public void testHasMine_WithMineNeighbour()
    {
        square.addOccupant(testMineNeighbour);
        assertFalse(square.hasMine());
    }

    @Test
    public void testGetOccupantStringRepresentation_WhenEmpty()
    {
        assertEquals("", square.getOccupantStringRepresentation());
    }

    @Test
    public void testGetOccupantStringRepresentation_WithMine()
    {
        square.addOccupant(testMine);
        assertEquals("X", square.getOccupantStringRepresentation());
    }
    
    @Test
    public void testGetOccupantStringRepresentation_WithMineNeighbour()
    {
        square.addOccupant(testMineNeighbour);
        assertEquals("3", square.getOccupantStringRepresentation());
    }
}
